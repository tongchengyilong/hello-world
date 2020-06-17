package com.baiwang.custom.web.base;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.web.bean.DateConvertEditor;

/**
 *
 * 所有的控制器需要继承此类<br>
 * 实现异常统一处理，相关方法
 * @author  qn
 * @revision 1.0
 * @see  [相关类/方法]
 */
public class BaseController
{
    private static final String X_REQUESTED_WITH = "X-Requested-With";

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

    private static final Logger logger = LoggerFactory
            .getLogger(BaseController.class);


    public RequestBean getRequestBean() {
        RequestBean requestBean = RequestThreadLocal.getRequest();
        return requestBean;
    }

    /**
     * session赋值
     * @param key
     * @param value
     */
    public void setAttribute(String key, Object value) {
        WebContext.getSession().setAttribute(key, value);
    }

    /**
     * session取值
     * @param key
     * @return
     */
    public Object getAttribute(String key) {
        return WebContext.getSession().getAttribute(key);
    }

    /**
     * 清空session属性
     * @param key
     */
    public void removeAttribute(String key) {
        WebContext.getSession().removeAttribute(key);
    }
    
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
    }

    public CrRpcResult result(String code, String message, Object data){
        CrRpcResult result = new CrRpcResult();
        if(result != null){
            result.setCode(code);
            result.setMessage(message);
            result.setData(data);
        }
        return result;
    }

}