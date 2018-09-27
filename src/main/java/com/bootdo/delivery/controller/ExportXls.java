package com.bootdo.delivery.controller;

import com.bootdo.common.utils.ExcelExportUtil4DIY;
import com.bootdo.common.utils.Query;
import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExportXls
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/27 11:49
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "/exportDemo", method = RequestMethod.GET)
public class ExportXls {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value="/exportExcel")
    public void exportExcel(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String filename = "测试导出功能"+format.format(new Date().getTime())+".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
        OutputStream out = response.getOutputStream();
        try {
            List<UserInfo> list = userInfoService.getUserInfoListSp();
            ExcelExportUtil4DIY.exportToFile(list,out);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("exportExcel出错"+e.getMessage());
        }finally{
            out.close();
        }
    }

}
