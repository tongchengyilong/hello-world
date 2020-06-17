/**
 * WSSSCImageBaseServiceFacadeSrvProxy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.baiwang.custom.web.service.axis;

public interface WSSSCImageBaseServiceFacadeSrvProxy extends java.rmi.Remote {
    public void reverse(java.lang.String inputXml) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String imageReady(java.lang.String inputXml) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getImageUrl(java.lang.String imageNumber) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getImageState(java.lang.String imageNumber) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getImageNumberForErp(java.lang.String billTypeCode, java.lang.String billNumber) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String updateImageStateNew(java.lang.String inputXML) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getRescanningImageByPerson(java.lang.String personID) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getRescanningImageNoList(java.lang.String scanUserID) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String getImageInfo(java.lang.String inputXml) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String snchronyUser(java.lang.String inputXML) throws java.rmi.RemoteException, WSInvokeException;
    public java.lang.String snchronyOrg(java.lang.String inputXML) throws java.rmi.RemoteException, WSInvokeException;
    public void updateImageState(java.lang.String inputXml) throws java.rmi.RemoteException, WSInvokeException;
}
