package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.base.BaseWebServiceInfo;
import com.baiwang.custom.common.model.WSResponseParamModel;
import com.thoughtworks.xstream.XStream;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 19:58 2018/6/4
 * @Modified By:
 */
public abstract class BaseEntity {

    public abstract String requestParamCheck(XStream xStream);

    protected String getErrorResult(XStream xStream, String msg) {
        return BaseWebServiceInfo.RESPONSE_HEADER +
                xStream.toXML(new WSResponseParamModel("-1", false, msg, null));
    }
}
