package com.bootdo.delivery.controller;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.common.utils.ResultBean;
import com.bootdo.common.utils.UploadUtils;
import com.bootdo.delivery.service.DeliveryService;
import com.bootdo.delivery.vo.DeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName DeliveryController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 17:25
 * @Version 1.0
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/delivery", method = RequestMethod.GET)
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/getDeliveryById")
    public ResultBean getDeliveryById(@RequestParam("id") String id) {
        return ResultBean.success(deliveryService.getDeliveryById(id));
    }

    @PostMapping("/uploadFile")
    public ResultBean uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        String path = UploadUtils.upload(file, request);
        file.getOriginalFilename();

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        deliveryService.SaveUploadFile(id, path);
        return ResultBean.success(null);
    }


}
