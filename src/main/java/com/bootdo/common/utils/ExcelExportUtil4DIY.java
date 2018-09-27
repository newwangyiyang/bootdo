package com.bootdo.common.utils;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xuxueli.poi.excel.ExcelExportUtil;

/**
 * @ClassName ExcelExportUtil4DIY
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/27 8:58
 * @Version 1.0
 **/
public class ExcelExportUtil4DIY extends ExcelExportUtil{
    private static Logger logger = LoggerFactory.getLogger(ExcelExportUtil.class);
    /**
     * 导出Excel文件到磁盘
     * @param dataList
     * @param outputStream
     */
    public static void exportToFile(List<?> dataList, OutputStream outputStream){
        // workbook
        Workbook workbook = exportWorkbook(dataList);
        try {
            // workbook 2 FileOutputStream
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);

            row.getCell(0).setCellValue("用户Id");
            row.getCell(1).setCellValue("用户昵称");
            row.getCell(2).setCellValue("用户姓名");
            row.getCell(3).setCellValue("密码");
            row.getCell(4).setCellValue("部门编号");


            workbook.write(outputStream);
            // flush
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream!=null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
}

