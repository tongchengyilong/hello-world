/**
 * WSBwDataImportFacadeSrvProxyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.baiwang.custom.web.service.axis;

public class WSBwDataImportFacadeSrvProxyServiceLocator extends org.apache.axis.client.Service implements WSBwDataImportFacadeSrvProxyService {

    public WSBwDataImportFacadeSrvProxyServiceLocator() {
    }


    public WSBwDataImportFacadeSrvProxyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSBwDataImportFacadeSrvProxyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSBwDataImportFacade
    private java.lang.String WSBwDataImportFacade_address = "http://172.27.21.63:6890/ormrpc/services/WSBwDataImportFacade";

    public java.lang.String getWSBwDataImportFacadeAddress() {
        return WSBwDataImportFacade_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSBwDataImportFacadeWSDDServiceName = "WSBwDataImportFacade";

    public java.lang.String getWSBwDataImportFacadeWSDDServiceName() {
        return WSBwDataImportFacadeWSDDServiceName;
    }

    public void setWSBwDataImportFacadeWSDDServiceName(java.lang.String name) {
        WSBwDataImportFacadeWSDDServiceName = name;
    }

    public WSBwDataImportFacadeSrvProxy getWSBwDataImportFacade() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSBwDataImportFacade_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSBwDataImportFacade(endpoint);
    }

    public WSBwDataImportFacadeSrvProxy getWSBwDataImportFacade(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WSBwDataImportFacadeSoapBindingStub _stub = new WSBwDataImportFacadeSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSBwDataImportFacadeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSBwDataImportFacadeEndpointAddress(java.lang.String address) {
        WSBwDataImportFacade_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WSBwDataImportFacadeSrvProxy.class.isAssignableFrom(serviceEndpointInterface)) {
                WSBwDataImportFacadeSoapBindingStub _stub = new WSBwDataImportFacadeSoapBindingStub(new java.net.URL(WSBwDataImportFacade_address), this);
                _stub.setPortName(getWSBwDataImportFacadeWSDDServiceName());
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
        if ("WSBwDataImportFacade".equals(inputPortName)) {
            return getWSBwDataImportFacade();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://172.27.21.63:6890/ormrpc/services/WSBwDataImportFacade", "WSBwDataImportFacadeSrvProxyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://172.27.21.63:6890/ormrpc/services/WSBwDataImportFacade", "WSBwDataImportFacade"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSBwDataImportFacade".equals(portName)) {
            setWSBwDataImportFacadeEndpointAddress(address);
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
