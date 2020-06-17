package com.baiwang.custom.web.base;

public class RequestThreadLocal {
    private static ThreadLocal<RequestBean> threadLocal = new ThreadLocal<RequestBean>();
    /**
     * 放入请求对象
     * @param req
     */
    public static void setRequest(RequestBean req){
        threadLocal.set(req);
    }

    /**
     * 返回请求对象
     * @return
     */
    public static RequestBean getRequest(){
        return threadLocal.get();
    }

    /**
     * 清空threadLocal
     */
    public static void clearRequest() {
        threadLocal.remove();
    }

    /**
     * 返回uuid
     * @return
     */
    public static String getUuid(){
        if(threadLocal.get()==null){
            return null;
        }
        return threadLocal.get().getUuid();
    }
}
