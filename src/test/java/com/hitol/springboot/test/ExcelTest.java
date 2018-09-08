package com.hitol.springboot.test;

import com.hitol.springboot.test.sb.BaseTest;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ExcelTest {
    private static File file = new File("aaa.xlsx");
    private static File out = new File("test.txt");

    public static void main(String[] args) throws Exception {
        ExcelUtil excelUtil = new ExcelUtil(file);
        excelUtil.setOutFile(out);
        excelUtil.parseExcelBigData();
    }

    private static void writeFile() throws Exception {
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 1000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }

        // Rows with rownum < 900 are flushed and not accessible
        for (int rownum = 0; rownum < 900; rownum++) {
            Assert.assertNull(sh.getRow(rownum));
        }

        // ther last 100 rows are still in memory
        for (int rownum = 900; rownum < 1000; rownum++) {
            Assert.assertNotNull(sh.getRow(rownum));
        }

        FileOutputStream out = new FileOutputStream("sxssf.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }


    private static void readFileBigData() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("-------begin-------");

        FileInputStream fileInputStream = new FileInputStream(file);

//        OPCPackage pkg = OPCPackage.open(fileInputStream);
//        /**
//         *  创建表阅读器
//         */
//        XSSFReader reader = new XSSFReader(pkg);
//
//        /**
//         *  转换指定单元表
//         */
//        InputStream sheet = reader.getSheet("rId" + 0);
//        InputSource sheetSource = new InputSource(sheet);
//        StylesTable stylesTable = reader.getStylesTable();
//        ReadOnlySharedStringsTable stringsTable= new ReadOnlySharedStringsTable(pkg);

        OPCPackage pkg = OPCPackage.open(file, PackageAccess.READ);
        XSSFReader xssfReader = new XSSFReader(pkg);

        StylesTable styles = xssfReader.getStylesTable();
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
        InputStream sheetInputStream = xssfReader.getSheetsData().next();

        processSheet(styles, strings, sheetInputStream);

        System.out.println("success! 用时:" + (System.currentTimeMillis() - start));

    }

    private static XSSFSheetXMLHandler.SheetContentsHandler handler;

    private static void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream) throws Exception {
        XMLReader sheetParser = SAXHelper.newXMLReader();
        if (handler != null) {
            sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, handler, false));
        } else {
            sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, new SimpleSheetContentsHandler(), false));
        }

        sheetParser.parse(new InputSource(sheetInputStream));
    }

    public static class SimpleSheetContentsHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
        protected List<String> row = new LinkedList<>();

        @Override
        public void startRow(int rowNum) {
            row.clear();
        }

        @Override
        public void endRow(int rowNum) {
            System.err.println(rowNum + " : " + row);
        }

        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            row.add(formattedValue);
        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {

        }
    }


    public static void testReadFile() throws Exception {


//        OutputStream outputStream = new FileOutputStream(out);

        System.out.println(file.exists());
        InputStream stream = new FileInputStream(file);
        Workbook xssfWorkbook = new XSSFWorkbook(stream);
        Sheet sheet = xssfWorkbook.getSheetAt(0);

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
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
//            outputStream.write(byteData);
            System.out.println(i);
        }
        System.out.println("success!");
    }
}
