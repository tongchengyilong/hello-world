package com.baiwang.custom.web.base;

import com.baiwang.custom.common.base.BaseWebServiceInfo;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import javax.xml.namespace.QName;

/**
 * @Author: gankunjian
 * @Description: webservice 客户端
 * @Date: Created in 10:43 2018/6/6
 * @Modified By:
 */
public class WebServiceClient {


    /**
     * WSDL地址定义
     */
    private String WSDL;

    /**
     * Namespace是命名空间，WSDL-xmlns:ns1
     */
    private String namespace;

    /**
     * methodName是方法名
     */
    private String methodName;

    private int receiveTimeout = 30000;

    private int connectionTimeout = 30000;

    public static WebServiceClient getInstance() {
        return new WebServiceClient();
    }

    public String getWSDL() {
        return WSDL;
    }

    public void setWSDL(String WSDL) {
        this.WSDL = WSDL;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getReceiveTimeout() {
        return receiveTimeout;
    }

    public void setReceiveTimeout(int receiveTimeout) {
        this.receiveTimeout = receiveTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * @param xmlData
     * @return
     * @throws Exception
     */
    public String doInvoke(Object xmlData) throws Exception {
        //用CXF客户端访问CXF部署的WebService服务
        //千万记住，访问CXF的WebService必须加上NameSpace, 否则通不过
        JaxWsDynamicClientFactory wsClientFactory = JaxWsDynamicClientFactory.newInstance();
        //URL为调用WebService的WSDL地址
        Client iWSClient = wsClientFactory.createClient(this.getWSDL());
        HTTPConduit iHTTPConduit = (HTTPConduit) iWSClient.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        //连接超时，单位为毫秒
        httpClientPolicy.setConnectionTimeout(this.getConnectionTimeout());
        //响应超时，单位为毫秒
        httpClientPolicy.setReceiveTimeout(this.getReceiveTimeout());
        //取消块编码
        httpClientPolicy.setAllowChunking(false);
        iHTTPConduit.setClient(httpClientPolicy);
        //Namespace是命名空间，methodName是方法名-WSDL-xmlns:ns1
        QName name = new QName(this.getNamespace(), this.getMethodName());
        Object[] objects = iWSClient.invoke(name, BaseWebServiceInfo.RESPONSE_HEADER + xmlData); //ParamValue为参数值
        return objects[0].toString(); //调用WebService输出调用结果
    }
    public String doInvokes(Object xmlData) throws Exception {
        //用CXF客户端访问CXF部署的WebService服务
        //千万记住，访问CXF的WebService必须加上NameSpace, 否则通不过
        JaxWsDynamicClientFactory wsClientFactory = JaxWsDynamicClientFactory.newInstance();
        //URL为调用WebService的WSDL地址
        Client iWSClient = wsClientFactory.createClient(this.getWSDL());
        HTTPConduit iHTTPConduit = (HTTPConduit) iWSClient.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        //连接超时，单位为毫秒
        httpClientPolicy.setConnectionTimeout(this.getConnectionTimeout());
        //响应超时，单位为毫秒
        httpClientPolicy.setReceiveTimeout(this.getReceiveTimeout());
        //取消块编码
        httpClientPolicy.setAllowChunking(false);
        iHTTPConduit.setClient(httpClientPolicy);
        //Namespace是命名空间，methodName是方法名-WSDL-xmlns:ns1
        QName name = new QName(this.getNamespace(), this.getMethodName());
        Object[] objects = iWSClient.invoke(name,  xmlData); //ParamValue为参数值
        return objects[0].toString(); //调用WebService输出调用结果
    }

}
