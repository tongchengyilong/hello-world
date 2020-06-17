package com.baiwang.custom.web.client;

import com.baiwang.custom.common.model.WSImageRequestParamModel;

/**
 *  WebService客户端通知接口
 */
public interface ImageInterface {

    /**
     * 影像识别及发票查验同步接口--马钢
     * --影像状态变更通知接口
     * @param modelList
     */
    public String ImageSystemCallBack(WSImageRequestParamModel models) throws Exception;

}
