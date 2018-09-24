package com.hitol.springboot.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.*;
import java.util.*;

/**
 * Excel读取工具
 *
 * @author hitol
 * @date 2018/9/8 下午7:42
 */
public class ExcelUtil {

    Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private final int DEFAULT_SHEET_INDEX = 0;
    private final int DEFAULT_SHEET_NUM = 0;
    private String inFilePath;
    private String outFilePath;
    private File inFile;
    private File outFile;
    private String inFileName;
    private String outFileName;
    private InputStream inputStream;
    private OutputStream outputStream;
    private int sheetNum;

    private XSSFSheetXMLHandler.SheetContentsHandler handler;


    public ExcelUtil(String inFilePath) throws Exception {
        if (StringUtils.isEmpty(inFilePath)) {
            throw new Exception("inFilePath is empty!");
        }
        this.inFilePath = inFilePath;
        this.inFile = new File(inFilePath);

    }

    public ExcelUtil(File inFile) {
        this.inFile = inFile;
    }

    public void setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
    }

    public void setOutFile(File outFile) {
        this.outFile = outFile;
        try {
            this.outputStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void parseExcelBigData() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("-------start-------");

        inputStream = new FileInputStream(inFile);
        OPCPackage pkg = OPCPackage.open(inFile, PackageAccess.READ);
        XSSFReader xssfReader = new XSSFReader(pkg);

        StylesTable styles = xssfReader.getStylesTable();
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
        InputStream sheetInputStream = xssfReader.getSheetsData().next();

        processSheet(styles, strings, sheetInputStream);

        logger.info("success! 用时:" + (System.currentTimeMillis() - start));
    }

    private void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream) throws Exception {
        XMLReader sheetParser = SAXHelper.newXMLReader();
        if (handler != null) {
            sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, handler, false));
        } else {
            sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, new SimpleSheetContentsHandler(), false));
        }

        sheetParser.parse(new InputSource(sheetInputStream));
    }

    //INSERT INTO tm_white_list_info(ORG,CUST_NAME,ID_NO,ID_TYPE,CURRENT_LIMIT) VALUES('9982','16',x,'xk',y);
    private String sql = "INSERT INTO tm_white_list_info(ORG,CUST_NAME,ID_NO,ID_TYPE,CURRENT_LIMIT) VALUES('9982',";

    private class SimpleSheetContentsHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
        protected List<String> row = new LinkedList<>();

        @Override
        public void startRow(int rowNum) {
            row.clear();
        }

        @Override
        public void endRow(int rowNum) {
            String data = parseRowReturnString(row);
            System.err.println(rowNum + " : " + data);
            writeToFile(data);
        }


        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            row.add(formattedValue);
        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {

        }
    }

    private String parseRowReturnString(List<String> row) {
        StringBuffer sb = new StringBuffer();
        sb.append(sql).append("\'").append(row.get(0)).append("\'");
        sb.append("\'").append(row.get(2)).append("\',");
        sb.append("\'").append(row.get(1)).append("\',");
        sb.append(row.get(3)).append("); \n");
//            System.err.println(rowNum + " : " + row);
        return sb.toString();
    }

    private void writeToFile(String data) {
        if (outputStream != null) {
            byte[] byteData = data.getBytes();
            try {
                outputStream.write(byteData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 适用于数据量较小
     */
    public void parseExcel() throws Exception {
        if (!inFile.exists()) {
            throw new Exception(" file is not exist!");
        }

        inputStream = new FileInputStream(inFile);
        Workbook workbook = new XSSFWorkbook(inFile);
        parseWorkBook(workbook);

    }

    private void parseWorkBook(Workbook workbook) {
        if (sheetNum == 0) {
            parseSheetOnce(workbook, DEFAULT_SHEET_INDEX);
        } else {
            parseSheet(workbook);
        }
    }

    private void parseSheet(Workbook workbook) {
        for (int i = 0; i < sheetNum; i++) {
            parseSheetOnce(workbook, i);
        }
    }

    private List<String> orgList = new ArrayList<>();
    private Map<String, String> orgCodeNameMap = new HashMap<>();

    private void initCodeMap() {
        orgCodeNameMap.put("99820001", "区域事业部－华东");
        orgCodeNameMap.put("99820002", "区域事业部－华北");
        orgCodeNameMap.put("99820003", "区域事业部－华中");
        orgCodeNameMap.put("99820004", "区域事业部－西北");
        orgCodeNameMap.put("99820005", "区域事业部－东南");
        orgCodeNameMap.put("99820006", "区域事业部－华南");
        orgCodeNameMap.put("99820007", "互联网事业部");
        orgCodeNameMap.put("99820008", "创新业务部");
        orgCodeNameMap.put("99820009", "金融合作部");
        orgCodeNameMap.put("99820010", "市场拓展部");
        orgCodeNameMap.put("99821001", "玖康");
        orgCodeNameMap.put("99821002", "分蛋");
        orgCodeNameMap.put("99821003", "嘉和");
        orgCodeNameMap.put("99821050", "网商保理");
        orgCodeNameMap.put("99829999", "区域事业部-测试");
    }

    private void parseSheetOnce(Workbook workbook, int sheetIndex) {
        initCodeMap();
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Cell cell62 = row.getCell(60);
            Cell cell2 = row.getCell(1);
//            System.out.println(cell62.getStringCellValue());
//            System.out.print(cell2.getStringCellValue() + " ");
            if (cell62 != null) {
                validateCodeAndName(cell62.getStringCellValue());
            }else{
                System.out.println(" ");
            }
            List<String> rowList = new LinkedList<>();
            Iterator<Cell> cellIterator = row.iterator();
            int rowIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                rowIndex = cell.getRowIndex();
                switch (cell.getCellType()) {
                    case STRING:
                        rowList.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowList.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        rowList.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    case ERROR:
                        rowList.add(String.valueOf(cell.getErrorCellValue()));
                        break;
                    case BLANK:
                        break;
                    default:
                        break;
                }
            }
//            System.err.println(rowIndex + ":" + rowList);

//            validateCodeAndName(rowList);
        }

    }

    private void validateCodeAndName(String code) {
        if (StringUtils.isBlank(code)) {
            System.out.println("");
        } else {
            System.out.println(orgCodeNameMap.get(code.substring(0, 8)));
        }
    }
}
