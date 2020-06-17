/**
 * WSSSCImageBaseServiceFacadeSrvProxyServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.baiwang.custom.web.service.axis;

public class WSSSCImageBaseServiceFacadeSrvProxyServiceTestCase extends junit.framework.TestCase {
    public WSSSCImageBaseServiceFacadeSrvProxyServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testWSSSCImageBaseServiceFacadeWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new WSSSCImageBaseServiceFacadeSrvProxyServiceLocator().getWSSSCImageBaseServiceFacadeAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new WSSSCImageBaseServiceFacadeSrvProxyServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1WSSSCImageBaseServiceFacadeReverse() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            binding.reverse(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2WSSSCImageBaseServiceFacadeImageReady() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.imageReady(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3WSSSCImageBaseServiceFacadeGetImageUrl() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getImageUrl(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test4WSSSCImageBaseServiceFacadeGetImageState() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getImageState(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test5WSSSCImageBaseServiceFacadeGetImageNumberForErp() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getImageNumberForErp(new java.lang.String(), new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test6WSSSCImageBaseServiceFacadeUpdateImageStateNew() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.updateImageStateNew(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test7WSSSCImageBaseServiceFacadeGetRescanningImageByPerson() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getRescanningImageByPerson(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test8WSSSCImageBaseServiceFacadeGetRescanningImageNoList() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getRescanningImageNoList(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test9WSSSCImageBaseServiceFacadeGetImageInfo() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.getImageInfo(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test10WSSSCImageBaseServiceFacadeSnchronyUser() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.snchronyUser(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test11WSSSCImageBaseServiceFacadeSnchronyOrg() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.snchronyOrg(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test12WSSSCImageBaseServiceFacadeUpdateImageState() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            binding.updateImageState(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
