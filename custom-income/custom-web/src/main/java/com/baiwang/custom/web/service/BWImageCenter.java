package com.baiwang.custom.web.service;

import com.baiwang.custom.common.base.BaseWebServiceInfo;
import com.baiwang.custom.common.base.WebServiceResult;
import com.baiwang.custom.common.model.MGAccountCopyModel;
import com.baiwang.custom.common.model.MGAccountModel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

 /**
 * @Author: gankunjian
 * @Description: 影像平台 webservice 服务端接口
 * @Date: Created in 15:14 2018/6/4
 * @Modified By:
 */
@WebService(serviceName = "BWImageCenter",
        targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE,
        endpointInterface = BaseWebServiceInfo.BASE_ENDPOINT_INTERFACE + "BWImageCenter")
public interface BWImageCenter {

     /**
      * @param paramXml
      * @return
      * @Description: 业务系统通过【发票扫描接口】提交影像扫描申请单，影像平台启动影像处理流程。
      */
     @WebMethod
     @WebResult(name = "resultXml", partName = "resultXml")
     public String startWorkFlow(@WebParam(name = "paramXml", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) String paramXml);

     /**
      * @param paramXml
      * @return
      * @Description: 业务系统通过【发票退单接口】，可以撤销影像扫描申请单，终止影像处理流程。
      */
     @WebMethod
     @WebResult(name = "resultXml", partName = "resultXml")
     public String rejectBill(@WebParam(name = "paramXml", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) String paramXml);


     /**
      * @param paramXml
      * @return
      * @Description: 业务系统审核处理过程中，如发现单据关联的影像扫描件不满足业务要求，
      * 可以通过【发票重扫接口】启动影像重新扫描处理流程。
      */
     @WebMethod
     @WebResult(name = "resultXml", partName = "resultXml")
     public String rescan(@WebParam(name = "paramXml", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) String paramXml);

     /**
      * @param paramXml
      * @return
      * @Description: 业务系统在审核处理影像及关联单据完成后，通过【影像归档接口】通知影像平台进行影像归档。
      */
     @WebMethod
     @WebResult(name = "resultXml", partName = "resultXml")
     public String lockedBillcode(@WebParam(name = "paramXml", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) String paramXml);

     /**
      * @param paramXml
      * @return
      * @Description:  业务系统通过传参获取影像调阅界面的url
      */
     @WebMethod
     @WebResult(name = "resultXml", partName = "resultXml")
     public String createImagePath(@WebParam(name = "paramXml", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) String paramXml);

     /**
        * @Date 2018/10/16 10:12
        * @Description 转换报账单据信息格式
        * @Param [mgAccountModel]
        * @return com.baiwang.custom.common.base.WebServiceResult<?>
        **/
     @WebMethod
     @WebResult(name = "MgImageAccountResponse")
     public WebServiceResult<?> mgAccountInfoPush(@WebParam(name = "MgImageAccountRequest", targetNamespace = BaseWebServiceInfo.TARGET_NAMESPACE) MGAccountCopyModel mgAccountCopyModel);

}
