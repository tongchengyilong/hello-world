package com.baiwang.custom.web.controller;

import com.alibaba.fastjson.JSON;
import com.baiwang.custom.common.model.HttpResponseModel;
import com.baiwang.custom.common.model.WSImageRequestParamModel;
import com.baiwang.custom.web.base.BaseController;
import com.baiwang.custom.web.client.ImageInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: gankunjian
 * @Description: 影像状态变更通知接口
 * @Date: Created in 12:00 2018/6/5
 * @Modified By:
 */
@RestController
@RequestMapping("/imageCenterFn/api")
public class ImageCallBackController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(ImageCallBackController.class);

    @Autowired
    private ImageInterface imageInterface;

    @RequestMapping(value = "/callBack", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String ImageSystemCallBack(@RequestBody WSImageRequestParamModel models) {
        logger.info("ImageCallBackController  ImageSystemCallBack 影像状态变更通知请求开始");
        try {
            return imageInterface.ImageSystemCallBack(models);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ImageCallBackController  ImageSystemCallBack  影响状态变更通知接口调用异常：{}", e.getMessage());
            return JSON.toJSONString(new HttpResponseModel(false, "-1", e.getMessage()));
        }
    }

}
