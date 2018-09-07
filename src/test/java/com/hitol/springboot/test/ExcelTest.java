package com.hitol.springboot.test;

import com.hitol.springboot.test.sb.BaseTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;

public class ExcelTest extends BaseTest {

    public static void main(String[] args) {
        try {
            testReadFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void testReadFile() throws Exception {
        File file = new File("D:\\bbb.xlsx");
        System.out.println(file.exists());
        InputStream stream = new FileInputStream(file);
        Workbook xssfWorkbook = new XSSFWorkbook(stream);
        Sheet sheet = xssfWorkbook.getSheetAt(0);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
//
//        String line = "";
//        while ((line = reader.readLine()) != null){
//            System.out.println(new String(line.getBytes("GB2312"),"UTF-8"));
//        }


        File out = new File("D:\\test.txt");
        OutputStream outputStream = new FileOutputStream(out);


        for (int i = 1; i < 681254; i++) {
            Row row = sheet.getRow(i);
            int name = (int) row.getCell(0).getNumericCellValue();
            String type = row.getCell(2).getStringCellValue();
            String number = row.getCell(3).getStringCellValue();
            int edu = (int) row.getCell(5).getNumericCellValue();

            StringBuffer sb = new StringBuffer();
//            INSERT INTO tm_white_list_info(ORG,CUST_NAME,ID_NO,ID_TYPE,CURRENT_LIMIT) VALUES('9982','16',x,'xk',y);

            sb.append("INSERT INTO tm_white_list_info(ORG,CUST_NAME,ID_NO,ID_TYPE,CURRENT_LIMIT) VALUES(");
            sb.append("\'").append(9982).append("\',");
            sb.append("\'").append(name).append("\',");
            sb.append("\'").append(number).append("\',");
            sb.append("\'").append(type).append("\',");

            sb.append("\'").append(edu).append("\'");
            sb.append(");");

            sb.append("\n");
            String data = sb.toString();
            byte[] byteData = data.getBytes();
            outputStream.write(byteData);
            System.out.println(i);
        }

        System.out.println("success!");

    }

}
