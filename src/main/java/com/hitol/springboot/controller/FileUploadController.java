package com.hitol.springboot.controller;

import com.hitol.springboot.manager.trainTime.StationManage;
import com.hitol.springboot.model.trainTime.StationDO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "file")
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StationManage stationManage;

    @RequestMapping(value = "/stationUpload", method = RequestMethod.POST)
    @ResponseBody
    public String stationUpload(@RequestParam("file") MultipartFile file) {
        logger.info("文件接收成功！");
        if (checkFileIsEmpty(file)) return "";
        XSSFWorkbook data = null;
        List<StationDO> stationDOList = new ArrayList<>();
        try {
            data = getSheets(file);
            XSSFSheet sheet = data.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String trainNo = row.getCell(0).getStringCellValue();
                String type = row.getCell(1).getStringCellValue();
                String station = row.getCell(2).getStringCellValue();
                String sequenceNo = row.getCell(3).getStringCellValue();
                String day = row.getCell(4).getStringCellValue();
                String arrivalTime = row.getCell(5).getStringCellValue();
                String departureTime = row.getCell(6).getStringCellValue();
                String costTime = row.getCell(7).getStringCellValue();
                String distance = row.getCell(8).getStringCellValue();

                StationDO stationDO = new StationDO();
                stationDO.setTrainNo(trainNo);
                stationDO.setType(type);
                stationDO.setStation(station);
                stationDO.setSequenceNo(sequenceNo);
                stationDO.setDay(day);
                stationDO.setArrivalTime(arrivalTime);
                stationDO.setDepartureTime(departureTime);
                stationDO.setCostTime(costTime);
                stationDO.setDistance(distance);

                stationDOList.add(stationDO);
            }
            stationManage.save(stationDOList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("上传成功!");
        return "上传成功";
    }

    private XSSFWorkbook getSheets(@RequestParam("file") MultipartFile file) throws IOException {
        XSSFWorkbook data;
        data = new XSSFWorkbook(file.getInputStream());
        return data;
    }

    private boolean checkFileIsEmpty(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/trainListUpload", method = RequestMethod.POST)
    @ResponseBody
    public String trainListUpload(@RequestParam("file") MultipartFile file) {
        if (checkFileIsEmpty(file)) return "";
        logger.info("文件接收成功！");
        XSSFWorkbook data = null;
        try {
            data = getSheets(file);

            XSSFSheet sheet = data.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
//               logger.info(row.toString());
                logger.info(name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("上传成功!");
        return "上传成功";
    }
}
