package com.baiwang.custom.web.client.impl;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baiwang.custom.common.model.MGSynchronizationModel;
import com.baiwang.custom.common.model.MGrecAndCheckModel;
import com.baiwang.custom.web.client.RecognitionAndCheckService;
import com.baiwang.custom.web.service.axis.WSBwDataImportFacadeSoapBindingStub;
import com.baiwang.custom.web.service.axis.WSBwDataImportFacadeSrvProxyServiceLocator;
import com.baiwang.custom.web.service.axis.WSInvokeException;
import com.google.gson.Gson;
@Service
public class MGRecognitionAndCheckServiceImpl implements  RecognitionAndCheckService{

	
	private final Logger logger = LoggerFactory.getLogger(ImageInterfaceImpl.class);
	//获取配置文件中，客户地址以及其他信息
    /*@Value(value = "${magangs.WSDL}")
    private String WSDL;
    @Value(value = "${magangs.namespace}")
    private String namespace;
    @Value(value = "${imageCenter.startWorkFlowUrl}")
    private String startWorkFlowUrl;
    @Value(value = "${magangs.connectionTimeout}")
    private int ConnectionTimeout;
    @Value(value = "${magangs.receiveTimeout}")
    private int ReceiveTimeout;*/
	@Override
	public MGrecAndCheckModel recAndCheck(List<MGSynchronizationModel> billInvoiceList) {
		Gson gson = new Gson();
		String json = gson.toJson(billInvoiceList);
		try {
		
			String response = wsBwDataImportFacadeImportData(json);
			MGrecAndCheckModel result = JSON.parseObject(response,MGrecAndCheckModel.class);
			
			if("0".equals(result.getReturnCode())) {
				return result;
			}else {
				MGrecAndCheckModel err = new MGrecAndCheckModel();
				err.setReturnCode("-1");
				err.setReturnMessage("未能同步成功");
				return err;
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (WSInvokeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MGrecAndCheckModel results = new MGrecAndCheckModel();
		results.setReturnCode("-1");
		results.setReturnMessage("同步失败");
		return results;
		
//		logger.info("ImageInterfaceImpl  ImageSystemCallBack  影像推送金蝶全票面入参：{}", json);
//		WebServiceClient client = WebServiceClient.getInstance();
//        client.setConnectionTimeout(ConnectionTimeout);
//        client.setReceiveTimeout(ReceiveTimeout);
//        //设置WSDL及调用的命名空间和方法
//        client.setMethodName("importData");
//        client.setNamespace(namespace);
//        client.setWSDL(WSDL);
//        try {
//        	String response = client.doInvokes(toSoapString(json));
//        	logger.info("金蝶响应全票面入参：{}", response);
//			MGrecAndCheckModel result = JSON.parseObject(response,MGrecAndCheckModel.class);
//			
//			if("0".equals(result.getReturnCode())) {
//				return result;
//			}else {
//				MGrecAndCheckModel err = new MGrecAndCheckModel();
//				err.setReturnCode("-1");
//				err.setReturnMessage("未能同步成功");
//				return err;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				MGrecAndCheckModel results = new MGrecAndCheckModel();
//				results.setReturnCode("-1");
//				results.setReturnMessage("同步失败");
//				return results;

	}
	
	
    public String wsBwDataImportFacadeImportData(String value) throws Exception {
        WSBwDataImportFacadeSoapBindingStub binding;
        try {
            binding = (WSBwDataImportFacadeSoapBindingStub)
                          new WSBwDataImportFacadeSrvProxyServiceLocator().getWSBwDataImportFacade();
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
            value = binding.importData(value);
        }
        catch (WSInvokeException e1) {
        	e1.printStackTrace();
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
        return value;
    }

}
