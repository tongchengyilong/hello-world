package com.baiwang.custom.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baiwang.custom.common.base.WebServiceResult;
import com.baiwang.custom.common.entity.*;
import com.baiwang.custom.common.model.*;
import com.baiwang.custom.common.util.HttpRequestUtil;
import com.baiwang.custom.common.util.StringUtil;
import com.baiwang.custom.common.base.BaseWebServiceInfo;
import com.baiwang.custom.web.service.BWImageCenter;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import com.baiwang.platform.custom.common.util.FinValidUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(basePackages = "com.baiwang.custom.web.service")
public class BWImageCenterImpl implements BWImageCenter {

    private final Logger logger = LoggerFactory.getLogger(BWImageCenterImpl.class);

    @Value(value = "${imageCenter.startWorkFlowUrl}")
    private String startWorkFlowUrl;
    @Value(value = "${imageCenter.rejectBillUrl}")
    private String rejectBillUrl;
    @Value(value = "${imageCenter.rescanUrl}")
    private String rescanUrl;
    @Value(value = "${imageCenter.lockedBillcodeUrl}")
    private String lockedBillcodeUrl;
    @Value(value = "${imageCenter.imagePreviewUrl}")
    private String imagePreviewUrl;

    @Value(value = "${imageCenter.mgAccountInfoUrl}")
    private String mgAccountInfoUrl;

    @Override
    public String startWorkFlow(String paramXml) {
        logger.info("BWImageCenterImpl startWorkFlow 请求开始,入参:{}", paramXml);
        String result;
        //传入service对应的具体参数类型
        XStream xStream = getXStreamInstance(InvoiceScanEntity.class);
        //判断输入参数是否为空
        if (StringUtil.isEmpty(paramXml)) {
            return getErrorResult(xStream, BaseWebServiceInfo.PARAM_NULL);
        }
        //paramXml字符串前面可能带有空格，导致XStream转javabean失败，做去空格处理
        paramXml = paramXml.trim();
        try {
            //将XML字符串转为请求参数对象
            WSRequestParamModel<InvoiceScanEntity> model = parseObjectParam(InvoiceScanEntity.class, xStream, paramXml);
            //请求参数内容具体校验
            result = model.requestParamCheck(xStream);
            if (result != null) {
                logger.info("BWImageCenterImpl startWorkFlow 请求参数校验失败:{}", result);
                return result;
            }
            //存放消息体serviceid集合
            List<String> serviceIdList = new ArrayList<>();
            //从请求数据中获取serviceid放入集合中
            model.getServerBodyModel().getServices().forEach(n -> {
                serviceIdList.add(n.getServiceId());
                //使用type字段值当作影像系统billType
                n.setBillType(n.getType());
            });
            //将请求数据转换成json字符串
            String httpJsonParam = JSON.toJSONString(model.getServerBodyModel().getServices());
            //调用http请求，请求业务接口
            return returnHttpResult(xStream, httpJsonParam, serviceIdList, startWorkFlowUrl);
        } catch (Exception e) {
            logger.error("BWImageCenterImpl startWorkFlow 请求参数转型错误:{}", e.getMessage());
            return getErrorResult(xStream, e.getMessage());
        }
    }



    @Override
    public String rejectBill(String paramXml) {
        logger.info("BWImageCenterImpl rejectBill 请求开始,入参:{}", paramXml);
        String result;
        //传入service对应的具体参数类型
        XStream xStream = getXStreamInstance(ImageChargebackEntity.class);
        //判断输入参数是否为空
        if (StringUtil.isEmpty(paramXml)) {
            return getErrorResult(xStream, BaseWebServiceInfo.PARAM_NULL);
        }
        //paramXml字符串前面可能带有空格，导致XStream转javabean失败，做去空格处理
        paramXml = paramXml.trim();
        try {
            //将XML字符串转为请求参数对象
            WSRequestParamModel<ImageChargebackEntity> model = parseObjectParam(ImageChargebackEntity.class, xStream, paramXml);
            //请求参数内容具体校验
            result = model.requestParamCheck(xStream);
            if (result != null) {
                logger.info("BWImageCenterImpl rejectBill 请求参数校验失败:{}", result);
                return result;
            }
            //存放消息体serviceid集合
            List<String> serviceIdList = new ArrayList<>();
            //从请求数据中获取serviceid放入集合中
            model.getServerBodyModel().getServices().forEach(n -> {
                serviceIdList.add(n.getServiceId());
                //使用type字段值当作影像系统billType
                n.setBillType(n.getType());
            });
            //将请求数据转换成json字符串
            String httpJsonParam = JSON.toJSONString(model.getServerBodyModel().getServices());
            //调用http请求，请求业务接口
            return returnHttpResult(xStream, httpJsonParam, serviceIdList, rejectBillUrl);
        } catch (Exception e) {
            logger.error("BWImageCenterImpl rejectBill 请求参数转型错误:{}", e.getMessage());
            return getErrorResult(xStream, e.getMessage());
        }
    }

    @Override
    public String rescan(String paramXml) {
        logger.info("BWImageCenterImpl rescan 请求开始,入参:" + paramXml);
        String result;
        //传入service对应的具体参数类型
        XStream xStream = getXStreamInstance(ImageRescanEntity.class);
        //判断输入参数是否为空
        if (StringUtil.isEmpty(paramXml)) {
            return getErrorResult(xStream, BaseWebServiceInfo.PARAM_NULL);
        }
        //paramXml字符串前面可能带有空格，导致XStream转javabean失败，做去空格处理
        paramXml = paramXml.trim();
        try {
            //将XML字符串转为请求参数对象
            WSRequestParamModel<ImageRescanEntity> model = parseObjectParam(ImageRescanEntity.class, xStream, paramXml);
            //请求参数内容具体校验
            result = model.requestParamCheck(xStream);
            if (result != null) {
                logger.info("BWImageCenterImpl rescan 请求参数校验失败:{}", result);
                return result;
            }
            //存放消息体serviceid集合
            List<String> serviceIdList = new ArrayList<>();
            //从请求数据中获取serviceid放入集合中
            model.getServerBodyModel().getServices().forEach(n -> serviceIdList.add(n.getServiceId()));
            //将请求数据转换成json字符串
            String httpJsonParam = JSON.toJSONString(model.getServerBodyModel().getServices());
            //调用http请求，请求业务接口
            return returnHttpResult(xStream, httpJsonParam, serviceIdList,rescanUrl);
        } catch (Exception e) {
            logger.error("BWImageCenterImpl rescan 请求参数转型错误:{}", e.getMessage());
            return getErrorResult(xStream, e.getMessage());
        }
    }

    @Override
    public String lockedBillcode(String paramXml) {
        logger.info("BWImageCenterImpl lockedBillcode 请求开始,入参:{}", paramXml);
        String result;
        //传入service对应的具体参数类型
        XStream xStream = getXStreamInstance(ImageArchiveEntity.class);
        //判断输入参数是否为空
        if (StringUtil.isEmpty(paramXml)) {
            return getErrorResult(xStream, BaseWebServiceInfo.PARAM_NULL);
        }
        //paramXml字符串前面可能带有空格，导致XStream转javabean失败，做去空格处理
        paramXml = paramXml.trim();
        try {
            //将XML字符串转为请求参数对象
            WSRequestParamModel<ImageArchiveEntity> model = parseObjectParam(ImageArchiveEntity.class, xStream, paramXml);
            //请求参数内容具体校验
            result = model.requestParamCheck(xStream);
            if (result != null) {
                logger.info("BWImageCenterImpl lockedBillcode 请求参数校验失败:{}", result);
                return result;
            }
            //存放消息体serviceid集合
            List<String> serviceIdList = new ArrayList<>();
            //从请求数据中获取serviceid放入集合中
            model.getServerBodyModel().getServices().forEach(n -> serviceIdList.add(n.getServiceId()));
            //将请求数据转换成json字符串
            String httpJsonParam = JSON.toJSONString(model.getServerBodyModel().getServices());
            //调用http请求，请求业务接口
            return returnHttpResult(xStream, httpJsonParam, serviceIdList,lockedBillcodeUrl);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("BWImageCenterImpl lockedBillcode 请求参数转型错误:{}", e);
            return getErrorResult(xStream, e.getMessage());
        }
    }

    @Override
    public String createImagePath(String paramXml) {
        logger.info("BWImageCenterImpl createImagePath 请求开始,入参:{}", paramXml);
        String result;
        //传入service对应的具体参数类型
        XStream xStream = getXStreamInstance(ImagePreviewEntity.class);
        //判断输入参数是否为空
        if (StringUtil.isEmpty(paramXml)) {
            return getErrorResult(xStream, BaseWebServiceInfo.PARAM_NULL);
        }
        //paramXml字符串前面可能带有空格，导致XStream转javabean失败，做去空格处理
        paramXml = paramXml.trim();
        try {
            //将XML字符串转为请求参数对象
            WSRequestParamModel<ImagePreviewEntity> model = parseObjectParam(ImagePreviewEntity.class, xStream, paramXml);
            //请求参数内容具体校验
            result = model.requestParamCheck(xStream);
            if (result != null) {
                logger.info("BWImageCenterImpl createImagePath 请求参数校验失败:{}", result);
                return result;
            }
            //存放消息体serviceid集合
            List<String> serviceIdList = new ArrayList<>();
            //从请求数据中获取serviceid放入集合中
            model.getServerBodyModel().getServices().forEach(n -> serviceIdList.add(n.getServiceId()));
            //将请求数据转换成json字符串
            ImagePreviewEntity entity = model.getServerBodyModel().getServices().get(0);
            //返回结果添加getViewSource
            RejectStatusModel statusModel = new RejectStatusModel(
                    entity.getUserAccount(), entity.getBillCode(), "1".equals(entity.getEvaluation()),entity.getViewSource());
            String httpJsonParam = JSON.toJSONString(statusModel);
            //调用http请求，请求业务接口
            return returnHttpResult(xStream, httpJsonParam, serviceIdList, imagePreviewUrl);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("BWImageCenterImpl createImagePath 请求参数转型错误:{}", e);
            return getErrorResult(xStream, e.getMessage());
        }
    }

    @Override
    public WebServiceResult<?> mgAccountInfoPush(MGAccountCopyModel mgAccountCopyModel) {
        MGAccountModel mgAccountModel = new MGAccountModel();
        logger.info("BWImageCenterImpl.mgAccountInfoPush:[{}]",JSON.toJSON(mgAccountCopyModel));
        if (null == mgAccountCopyModel){
            return new WebServiceResult<>(RestFulApiContants.REQ_JSON_ERROR,RestFulApiContants.REQ_JSON_ERROR_CN);
        }else{
            mgAccountModel.setBillCode(mgAccountCopyModel.getBILL_CODE() != null ? mgAccountCopyModel.getBILL_CODE():" ");
            mgAccountModel.setFinslVoucherNo(mgAccountCopyModel.getFINAL_VOUCHER_NO() != null ? mgAccountCopyModel.getFINAL_VOUCHER_NO():" ");
            mgAccountModel.setVoucherDate(mgAccountCopyModel.getVOUCHER_DATE() != null ? mgAccountCopyModel.getVOUCHER_DATE():" ");
            mgAccountModel.setFoucherPeriod(mgAccountCopyModel.getVOUCHER_PERIOD() != null ? mgAccountCopyModel.getVOUCHER_PERIOD():" ");
            mgAccountModel.setVoucherTax(mgAccountCopyModel.getVOUCHER_TAX() != null ? mgAccountCopyModel.getVOUCHER_TAX():" ");
            //TODO:可能后续还会需要五个拓展字段赋值
            if (StringUtil.isEmpty(mgAccountModel.getBillCode())){
                return new WebServiceResult<>(RestFulApiContants.REQ_PARAMS_ERROR,"单据编号不能为空，请检查！");
            } else if (StringUtil.isEmpty(mgAccountModel.getFinslVoucherNo())) {
                return new WebServiceResult<>(RestFulApiContants.REQ_PARAMS_ERROR,"凭证号不能为空，请检查！");
            }else if (StringUtil.isEmpty(mgAccountModel.getVoucherDate())) {
                return new WebServiceResult<>(RestFulApiContants.REQ_PARAMS_ERROR,"记账日期不能为空，请检查！");
            }else{
                //调用影像服务
                String requestParam = JSON.toJSONString(mgAccountModel);
                String responseParam = HttpRequestUtil.HttpPostWithJson(mgAccountInfoUrl,requestParam);
                WebServiceResult webServiceResult = JSON.parseObject(responseParam,WebServiceResult.class);
                if (webServiceResult == null){
                    return new WebServiceResult<>("-1","记账同步执行失败",false);
                }else{
                    return new WebServiceResult<>(webServiceResult.getErrorCode(),webServiceResult.getMessage(),webServiceResult.isSuccess());
                }
            }
        }
    }

    /**
     * 公共的http请求部分
     * @param xStream  javabean  与  xml转换对象
     * @param httpJsonParam  请求参数字符串对象
     * @param serviceIds  webservice请求中请求参数消息体的 serviceid集合
     * @return
     */
    private String returnHttpResult(XStream xStream, String httpJsonParam, List<String> serviceIds, String httpUrl) {
        logger.info(" 请求影像平台报文:{}", httpJsonParam);
        String httpResult = HttpRequestUtil.HttpPostWithJson(httpUrl, httpJsonParam);
        if (StringUtil.isEmpty(httpResult)) {
            return getErrorResult(xStream, "影像平台异常!");
        }
        HttpResponseModel responseModel = JSON.parseObject(httpResult, HttpResponseModel.class);
        if (responseModel == null) {
            return getErrorResult(xStream, "影像平台返回参数异常!");
        }
        logger.info(" 请求影像平台结果:{}", httpResult);
        //处理返回结果值
        WSResponseParamModel resultModel = new WSResponseParamModel(responseModel.getSuccess() ? "0" : "1",
                responseModel.getSuccess(), responseModel.getMessage(), new ArrayList<>());
        String massage = null;
        JSONArray arr = (JSONArray) responseModel.getData();
        if (arr != null && arr.size() > 0) {
            massage = arr.get(0).toString();
        }
        String result = massage;
        serviceIds.forEach(n -> resultModel.getItems().add(new ItemModel(n, responseModel.getSuccess() ? "0" : "1",
                "", result)));
        //将结果转为xml
        return BaseWebServiceInfo.RESPONSE_HEADER + xStream.toXML(resultModel);
    }



    /**
     * 传入参数 转 具体类型
     *
     * @param xStream
     * @param paramXml
     * @param entityClass 泛型对应的具体类型
     * @return
     */
    private <T extends BaseEntity> WSRequestParamModel<T> parseObjectParam(Class<T> entityClass,
                                                                           XStream xStream, String paramXml) throws Exception {
        try {
            //先将paramXML使用XStream转为 object类型，在使用JSON转为JSON字符串，再使用JSON将其转为WSRequestParamModel类型
            WSRequestParamModel model = JSON.parseObject(JSON.toJSONString(JSON.toJSON(xStream.fromXML(paramXml))),
                    WSRequestParamModel.class);
            WSRequestParamModel<T> result = new WSRequestParamModel<>();
            //由于WSRequestParamModel使用了泛型，因此WSRequestParamModel.serverBodyModel.services还是JSONObject类型
            List list = model.getServerBodyModel().getServices();
            List<T> resultList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (Object ob : list) {
                    //需要将其转为具体的泛型对应的类型。
                    T t = JSONObject.toJavaObject((JSONObject) ob, entityClass);
                    resultList.add(t);
                }
            }
            //将其他数据值传递给result引用的对象
            result.setSafetyModel(model.getSafetyModel());
            result.setServerBodyModel(new ServerBodyModel<T>(model.getServerBodyModel().getServername(),
                    model.getServerBodyModel().getServertype(), resultList));
            return result;
        } catch (Exception e) {
            logger.error("请求参数转型发生异常：{}", e);
            throw new RuntimeException("解析xml参数失败:" + paramXml, e);
        }
    }

    /**
     * 获取  XStream 对象实例
     * @return
     */
    private XStream getXStreamInstance(Class entityClass){
        //设置xml解析时的字符格式,忽略未定义的属性字段
        XStream xStream = new XStream(){
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
        //对指定的类使用Annotations 进行序列化
        xStream.processAnnotations(new Class[]{SafetyModel.class, ServerBodyModel.class, WSRequestParamModel.class,
                WSResponseParamModel.class, ItemModel.class, List.class, entityClass});
        return xStream;
    }

    private String getErrorResult(XStream xStream, String msg) {
        return BaseWebServiceInfo.RESPONSE_HEADER +
                xStream.toXML(new WSResponseParamModel(BaseWebServiceInfo.ERROR_CODE, false, msg, null));
    }



}
