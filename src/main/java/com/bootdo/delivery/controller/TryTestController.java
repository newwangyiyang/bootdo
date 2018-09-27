package com.bootdo.delivery.controller;

import com.bootdo.common.exception.BDException;
import com.bootdo.common.utils.ResultBean;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.delivery.service.TryTestService;
import com.bootdo.delivery.vo.DeliveryListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName TryTestController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 13:16
 * @Version 1.0
 **/

@RestController
@RequestMapping(value = "/tryTest", method = RequestMethod.GET)
@CrossOrigin
public class TryTestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TryTestService tryTestService;

    @PostMapping("/lambdaTest")
    public ResultBean lambdaTest(@RequestBody List<Map<String, String>> list) {
//        list.forEach(v -> {
//            System.out.println(v);
//        });
//        list.stream().map(v -> {
//            Integer age = (Integer) v.get("age");
//            v.put("age", String.valueOf(age + 1));
//            return v;
//        }).collect(Collectors.toList());
        logger.info(list.toString());
        Collections.sort(list, (Map<String, String> s1, Map<String, String> s2) -> {
            String age1 = s1.get("age");
            Integer i1 = Integer.parseInt(age1);
            String age2 = s2.get("age");
            int i2 = Integer.parseInt(age2);
            return i1 - i2;
        });
        return ResultBean.success(list);
    }

    @GetMapping("/getExceptionTest")
    public ResultBean getExceptionTest() {
        throw new BDException("请求异常测试");
    }

    @GetMapping("/getDeliveryListAndUserByUserInfo")
    public ResultBean getDeliveryListAndUserByUserInfo(@RequestParam Integer userId,@RequestParam(defaultValue = "3", required = false) Integer pageSize,@RequestParam(defaultValue = "1", required = false) Integer pageNum) {
        DeliveryListVo deliveryListAndUserByUserInfo = tryTestService.getDeliveryListAndUserByUserInfo(userId, pageSize, pageNum);
        return ResultBean.success(deliveryListAndUserByUserInfo);
    }
}
