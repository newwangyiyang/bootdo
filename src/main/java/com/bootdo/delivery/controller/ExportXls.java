package com.bootdo.delivery.controller;

import com.bootdo.common.utils.DownloadUtil;
import com.bootdo.common.utils.ExcelExportUtil4DIY;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.JUtils.excel.ExcelReadHelper;
import com.bootdo.common.utils.JUtils.file.FileUtils;
import com.bootdo.common.utils.UploadUtils;
import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import com.bootdo.delivery.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
@CrossOrigin
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

    @ResponseBody
    @RequestMapping(value = "/getExcelData", method = RequestMethod.POST)
    public List<Object> getExcelData(@RequestParam MultipartFile file, HttpServletRequest request) throws Exception {
        String url = UploadUtils.upload(file, request);
        String s = request.getSession().getServletContext().getRealPath("/") + url;
        logger.info(s);
        List<Object> UserInfoVo = ExcelReadHelper.excelRead(new File(s), new String[]{"name", "age", "sex"}, UserInfoVo.class);

        return UserInfoVo;
    }

    @GetMapping("/getListMapTest")
    @ResponseBody
    public void getListMapTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = "http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg";
        String n = FileUtil.renameToUUID(s);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s1 = format.format(new Date());
        logger.info(s1);


        DownloadUtil.downFileByUrl(request, response, s, n);
    }
}
