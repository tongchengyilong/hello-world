package com.baiwang.custom.web.service;

import com.baiwang.custom.common.model.MGAccountResponse;
import com.baiwang.custom.common.model.MGAccountResqust;

/**
 * @Description: 发票记账信息同步接口
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-10:14
 */
public interface MGAccountService {
    //发票记账同步
    MGAccountResponse accountSysn(MGAccountResqust mgAccountResqust);
}
