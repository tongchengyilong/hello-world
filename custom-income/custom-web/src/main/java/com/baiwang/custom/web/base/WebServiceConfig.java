package com.baiwang.custom.web.base;

import com.baiwang.custom.web.interceptor.IPAddressInterceptor;
import com.baiwang.custom.web.interceptor.WSInterceptor;
import com.baiwang.custom.web.service.BWImageCenter;
import com.baiwang.custom.web.service.impl.BWImageCenterImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Value(value = "${WebServicePublishPath}")
    private String WebServicePublishPath;

    @Autowired
    private BWImageCenter bwImageCenter;

    @Autowired
    private WSInterceptor wsInterceptor;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, bwImageCenter);
        endpoint.getInInterceptors().add(new IPAddressInterceptor(wsInterceptor));
        endpoint.publish(WebServicePublishPath);
        return endpoint;
    }
}
