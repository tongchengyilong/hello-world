package com.baiwang.custom.web.client.impl;

import com.alibaba.fastjson.JSON;
import com.baiwang.custom.common.entity.ImageCallBackEntity;
import com.baiwang.custom.common.entity.InvoiceInfoEntity;
import com.baiwang.custom.common.model.*;
import com.baiwang.custom.common.util.KFBillUtil;
import com.baiwang.custom.common.util.StringUtil;
import com.baiwang.custom.web.base.WebServiceClient;
import com.baiwang.custom.web.client.ImageInterface;
import com.baiwang.custom.web.service.axis.WSInvokeException;
import com.baiwang.custom.web.service.axis.WSSSCImageBaseServiceFacadeSoapBindingStub;
import com.baiwang.custom.web.service.axis.WSSSCImageBaseServiceFacadeSrvProxyServiceLocator;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageInterfaceImpl implements ImageInterface {

    private final Logger logger = LoggerFactory.getLogger(ImageInterfaceImpl.class);

    private final static String START_STR = "&amp;lt;ReCode&amp;gt;";
    private final static String END_STR = "&amp;lt;/ReCode&amp;gt;";

    @Value(value = "${magang.WSDL}")
    private String WSDL;
    @Value(value = "${magang.namespace}")
    private String namespace;
    @Value(value = "${imageCenter.startWorkFlowUrl}")
    private String startWorkFlowUrl;
    @Value(value = "${magang.connectionTimeout}")
    private int ConnectionTimeout;
    @Value(value = "${magang.receiveTimeout}")
    private int ReceiveTimeout;

    @Override
    public String ImageSystemCallBack(WSImageRequestParamModel model) throws Exception {
        logger.info("ImageInterfaceImpl  ImageSystemCallBack  影像状态变更通知入参：{}", model.toString());
        WebServiceClient client = WebServiceClient.getInstance();
        client.setConnectionTimeout(ConnectionTimeout);
        client.setReceiveTimeout(ReceiveTimeout);
        //设置WSDL及调用的命名空间和方法
       // client.setMethodName("ImageSystemCallBack");
         client.setMethodName("updateImageStateNew");
        client.setNamespace(namespace);
        client.setWSDL(WSDL);
        
        //将影响传送过来的信息做转换
        WSRequestParamModels models = new WSRequestParamModels();
        ArrayList<BarCodeInfoModel> blist = new ArrayList<BarCodeInfoModel>();
        BarCodeInfoModel b = new BarCodeInfoModel();
        b.setBarCode(model.getBillCode());
        b.setImageCount(model.getImageCount());
        blist.add(b);
        models.setBarCodeList(blist);
        models.setImageState(model.getBillStatus());
        models.setUpdaterID(model.getBillUser());
        models.setUpdReason("影像已就绪，回传信息");
        
        XStream xStream = getXStreamInstance(WSRequestParamModels.class);
        String xml = xStream.toXML(models);
        logger.info("ImageInterfaceImpl  ImageSystemCallBack  影像状态变更通知入参:{}", xml);
        // String result = client.doInvoke(xml);
        String result = wsSSCImageBaseServiceFacadeUpdateImageStateNew(xml);
        logger.info("ImageInterfaceImpl  ImageSystemCallBack  影像状态变更通知出参:{}", result);
        //TODO: 返回值result处理
        if (StringUtil.isEmpty(result)) {
            return JSON.toJSONString(new HttpResponseModel(false, "-1", "影像状态变更通知失败"));
        }
        XStream xStream2 = getXStreamInstance2(HttpResponseModels.class);
        HttpResponseModels responseModel = (HttpResponseModels) xStream2.fromXML(result);
        if (responseModel == null) {
            return JSON.toJSONString(new HttpResponseModel(false, "-1", "影像状态变更通知失败"));
        }
        HttpResponseModel resultModel = new HttpResponseModel();
        resultModel.setErrorCode(responseModel.getRetCode());
        
        resultModel.setSuccess(responseModel.getRetCode() != null && "0".equals(responseModel.getRetCode()));
       
        resultModel.setMessage(responseModel.getRetMsg());

        logger.info("ImageInterfaceImpl  ImageSystemCallBack  影像状态变更通知 结束");
        return JSON.toJSONString(resultModel);
    }

    public String wsSSCImageBaseServiceFacadeUpdateImageStateNew(String value) throws Exception {
        WSSSCImageBaseServiceFacadeSoapBindingStub binding;
        try {
            binding = (WSSSCImageBaseServiceFacadeSoapBindingStub)
                          new WSSSCImageBaseServiceFacadeSrvProxyServiceLocator().getWSSSCImageBaseServiceFacade();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            value = binding.updateImageStateNew(value);
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
        return value;
    }
    
    /**
     * 获取  XStream 对象实例
     * @return
     */
    private XStream getXStreamInstance(Class entityClass){

        XStream xStream = new XStream(new DomDriver("UTF-8"));
        //对指定的类使用Annotations 进行序列化
        xStream.processAnnotations(new Class[]{WSRequestParamModels.class,
                 entityClass});
      //去掉class属性
        xStream.aliasSystemAttribute(null, "class");
        return xStream;
    }
    /**
     * 获取  XStream 对象实例
     * @return
     */
    private XStream getXStreamInstance2(Class entityClass){

        XStream xStream = new XStream(new DomDriver("UTF-8"));
        //对指定的类使用Annotations 进行序列化
        xStream.processAnnotations(new Class[]{
        		HttpResponseModels.class, entityClass});
      //去掉class属性
        xStream.aliasSystemAttribute(null, "class");
        return xStream;
    }
}
