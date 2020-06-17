package com.baiwang.custom.web.client;

import java.util.List;

import com.baiwang.custom.common.model.MGAccountResponse;
import com.baiwang.custom.common.model.MGSynchronizationModel;
import com.baiwang.custom.common.model.MGrecAndCheckModel;

/**
 * 影像识别及发票校验同步接口
 * @author 18734
 *
 */
public interface RecognitionAndCheckService {

	MGrecAndCheckModel recAndCheck(List<MGSynchronizationModel> billInvoiceList);
	
}
