package com.baiwang.custom.common.model;

import com.baiwang.custom.common.base.BaseWebServiceInfo;
import com.baiwang.custom.common.entity.BaseEntity;
import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author: gankunjian
 * @Description: webService 服务端请求参数实体
 * @Date: Created in 15:26 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "params")
public class WSRequestParamModel<T extends BaseEntity> {

    @XStreamAlias(value = "safety")
    private SafetyModel safetyModel;

    @XStreamAlias(value = "serverbody")
    private ServerBodyModel<T> serverBodyModel;

    public String requestParamCheck(XStream xStream) {
        if (this.safetyModel == null) {
            return getErrorResult(xStream, "参数列表safety不能为空");
        }
        if (this.serverBodyModel == null) {
            return getErrorResult(xStream, "消息体不能为空");
        }
        if (StringUtil.isEmpty(this.safetyModel.getClientcode())) {
            return getErrorResult(xStream, "客户端编码不能为空");
        }
        if (StringUtil.isEmpty(this.safetyModel.getTime())) {
            return getErrorResult(xStream, "请求时间不能为空");
        }
        if (StringUtil.isEmpty(this.safetyModel.getServicecode())) {
            return getErrorResult(xStream, "服务端编码不能为空");
        }
        if (StringUtil.isEmpty(this.safetyModel.getTicket())) {
            return getErrorResult(xStream, "请求包编号不能为空");
        }
//        if (StringUtil.isEmpty(this.serverBodyModel.getServertype())) {
//            return getErrorResult(xStream, "请求类型不能为空");
//        }
        if (this.serverBodyModel.getServices() == null || this.serverBodyModel.getServices().size() == 0) {
            return getErrorResult(xStream, "数据列表不能为空");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        if (this.safetyModel.getTime().length() != 14 || !pattern.matcher(this.safetyModel.getTime()).matches()) {
            //非数字
            return getErrorResult(xStream, "请求时间格式不正确");
        }
        try {
            format.parse(this.safetyModel.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorResult(xStream, "请求时间格式不正确");
        }

        for (T t : this.serverBodyModel.getServices()) {
            String result = t.requestParamCheck(xStream);
            if (StringUtil.isNotEmpty(result)) {
                return result;
            }
        }
        return null;
    }

    private String getErrorResult(XStream xStream, String msg) {
        return BaseWebServiceInfo.RESPONSE_HEADER +
                xStream.toXML(new WSResponseParamModel("-1", false, msg, null));
    }

    public WSRequestParamModel() {
    }

    public WSRequestParamModel(SafetyModel safetyModel, ServerBodyModel<T> serverBodyModel) {
        this.safetyModel = safetyModel;
        this.serverBodyModel = serverBodyModel;
    }

    public SafetyModel getSafetyModel() {
        return safetyModel;
    }

    public void setSafetyModel(SafetyModel safetyModel) {
        this.safetyModel = safetyModel;
    }

    public ServerBodyModel<T> getServerBodyModel() {
        return serverBodyModel;
    }

    public void setServerBodyModel(ServerBodyModel<T> serverBodyModel) {
        this.serverBodyModel = serverBodyModel;
    }

    @Override
    public String toString() {
        return "WSRequestParamModel{" +
                "safetyModel=" + safetyModel.toString() +
                ", serverBodyModel=" + serverBodyModel.toString() +
                '}';
    }
}
