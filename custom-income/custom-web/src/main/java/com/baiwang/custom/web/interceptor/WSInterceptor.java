package com.baiwang.custom.web.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 15:56 2018/7/18
 * @Modified By:
 */
@Service
public class WSInterceptor {

    @Value(value = "#{'${imageCenter.whiteList}'.split(',')}")
    private List<String> whiteList;
    @Value(value = "#{'${imageCenter.blackList}'.split(',')}")
    private List<String> blackList;

    /**
     * <p>Discription:[允许访问的IP地址]</p>
     *
     * @return
     */
    public List<String> getAllowedIPList() {
        List<String> allowedIPList = new ArrayList<String>();
        List<String> dealList = dealListMenu(whiteList);
        if (dealList != null) {
            allowedIPList.addAll(dealList);
        }
        return allowedIPList;
    }

    /**
     * <p>Discription:[拒绝访问的IP地址]</p>
     *
     * @return
     */
    public List<String> getDeniedIPList() {
        List<String> deniedIPList = new ArrayList<String>();
        List<String> dealList = dealListMenu(blackList);
        if (dealList != null) {
            deniedIPList.addAll(dealList);
        }
        return deniedIPList;
    }

    private List<String> dealListMenu(List<String> param) {
        if (param != null && param.size() > 0) {
            if (param.size() == 1 && "".equals(param.get(0))) {
                return null;
            }
        }
        return param;
    }

}
