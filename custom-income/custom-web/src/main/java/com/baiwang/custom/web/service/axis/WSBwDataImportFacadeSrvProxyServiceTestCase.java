/**
 * WSBwDataImportFacadeSrvProxyServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.baiwang.custom.web.service.axis;

public class WSBwDataImportFacadeSrvProxyServiceTestCase extends junit.framework.TestCase {
    public WSBwDataImportFacadeSrvProxyServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testWSBwDataImportFacadeWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new WSBwDataImportFacadeSrvProxyServiceLocator().getWSBwDataImportFacadeAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new WSBwDataImportFacadeSrvProxyServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1WSBwDataImportFacadeImportData() throws Exception {
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
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        try {
            java.lang.String value = null;
            value = binding.importData(new java.lang.String());
        }
        catch (WSInvokeException e1) {
            throw new junit.framework.AssertionFailedError("WSInvokeException Exception caught: " + e1);
        }
            // TBD - validate results
    }

}
