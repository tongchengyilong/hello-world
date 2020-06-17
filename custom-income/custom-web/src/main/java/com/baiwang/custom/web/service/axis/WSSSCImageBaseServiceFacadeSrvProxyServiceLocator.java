/**
 * WSSSCImageBaseServiceFacadeSrvProxyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.baiwang.custom.web.service.axis;

public class WSSSCImageBaseServiceFacadeSrvProxyServiceLocator extends org.apache.axis.client.Service implements WSSSCImageBaseServiceFacadeSrvProxyService {

    public WSSSCImageBaseServiceFacadeSrvProxyServiceLocator() {
    }


    public WSSSCImageBaseServiceFacadeSrvProxyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSSSCImageBaseServiceFacadeSrvProxyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSSSCImageBaseServiceFacade
    private java.lang.String WSSSCImageBaseServiceFacade_address = "http://172.27.21.63:6890/ormrpc/services/WSSSCImageBaseServiceFacade";

    public java.lang.String getWSSSCImageBaseServiceFacadeAddress() {
        return WSSSCImageBaseServiceFacade_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSSSCImageBaseServiceFacadeWSDDServiceName = "WSSSCImageBaseServiceFacade";

    public java.lang.String getWSSSCImageBaseServiceFacadeWSDDServiceName() {
        return WSSSCImageBaseServiceFacadeWSDDServiceName;
    }

    public void setWSSSCImageBaseServiceFacadeWSDDServiceName(java.lang.String name) {
        WSSSCImageBaseServiceFacadeWSDDServiceName = name;
    }

    public WSSSCImageBaseServiceFacadeSrvProxy getWSSSCImageBaseServiceFacade() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSSSCImageBaseServiceFacade_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSSSCImageBaseServiceFacade(endpoint);
    }

    public WSSSCImageBaseServiceFacadeSrvProxy getWSSSCImageBaseServiceFacade(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WSSSCImageBaseServiceFacadeSoapBindingStub _stub = new WSSSCImageBaseServiceFacadeSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSSSCImageBaseServiceFacadeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSSSCImageBaseServiceFacadeEndpointAddress(java.lang.String address) {
        WSSSCImageBaseServiceFacade_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WSSSCImageBaseServiceFacadeSrvProxy.class.isAssignableFrom(serviceEndpointInterface)) {
                WSSSCImageBaseServiceFacadeSoapBindingStub _stub = new WSSSCImageBaseServiceFacadeSoapBindingStub(new java.net.URL(WSSSCImageBaseServiceFacade_address), this);
                _stub.setPortName(getWSSSCImageBaseServiceFacadeWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSSSCImageBaseServiceFacade".equals(inputPortName)) {
            return getWSSSCImageBaseServiceFacade();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.27.21.63:6890/ormrpc/services/WSSSCImageBaseServiceFacade", "WSSSCImageBaseServiceFacadeSrvProxyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.27.21.63:6890/ormrpc/services/WSSSCImageBaseServiceFacade", "WSSSCImageBaseServiceFacade"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSSSCImageBaseServiceFacade".equals(portName)) {
            setWSSSCImageBaseServiceFacadeEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
