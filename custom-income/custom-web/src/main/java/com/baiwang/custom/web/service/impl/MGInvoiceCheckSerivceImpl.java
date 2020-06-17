package com.baiwang.custom.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.baiwang.custom.common.dao.MGTScmVatMainMapper;
import com.baiwang.custom.common.model.MGQueryInvModel;
import com.baiwang.custom.common.model.QueryInvModel;
import com.baiwang.custom.common.model.QueryInvRequest;
import com.baiwang.custom.common.model.QueryInvRequestModel;
import com.baiwang.custom.web.service.MGInvoiceCheckService;
import com.baiwang.platform.custom.common.util.MyBeanUtils;
import com.baiwang.platform.custom.dao.redis.RedisDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
@ComponentScan(basePackages = {"com.baiwang.custom"})
public class MGInvoiceCheckSerivceImpl implements MGInvoiceCheckService {
    private static Logger logger = LoggerFactory.getLogger(MGInvoiceCheckSerivceImpl.class);

    @Autowired
    private MGTScmVatMainMapper tScmVatMainMapper;
    @Autowired
    private RedisDao redisDao;

    /**
     * 分页查询已入库发票
     * @param queryInvRequestModel
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<MGQueryInvModel> getQueryInvModelListPage(QueryInvRequestModel queryInvRequestModel, int pageNum, int pageSize) {
        Page<MGQueryInvModel> page = PageHelper.startPage(pageNum, pageSize);
        //PageHelper会自动拦截到下面这查询sql
        tScmVatMainMapper.queryInvList(queryInvRequestModel);
        return page.toPageInfo();
    }



    @Override
    public List<Map<String, Object>> getFormartVatList(List<MGQueryInvModel> results) {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        if(results!=null && results.size()>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(MGQueryInvModel model : results){
                model.setInvoiceType(redisDao.getNameByCode("finInvTyN", model.getInvoiceType()));
                model.setCollectType(redisDao.getNameByCode("collectType", model.getCollectType()));
                model.setCollectSource(redisDao.getNameByCode("collectSource", model.getCollectSource()));
                model.setBusinessType(redisDao.getNameByCode("businessType", model.getBusinessType()));
                model.setStorageStatus(redisDao.getNameByCode("storageStatus", model.getStorageStatus()));
                model.setCheckStatus(redisDao.getNameByCode("checkStatus", model.getCheckStatus()));
                model.setDeductStatus(redisDao.getNameByCode("deductStatus", model.getDeductStatus()));
                model.setInvoiceStatus(redisDao.getNameByCode("finInvSt", model.getInvoiceStatus()));
                model.setInvoiceStatus(redisDao.getNameByCode("billCode", model.getInvoiceStatus()));

                Map<String, Object> maps = MyBeanUtils.beanToMap(model);
                list.add(maps);
            }
        }
        return list;
    }


	   /**
     * 分页查询已入库发票全票面信息 20180910版新增
     * @param queryInvRequestModel
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<MGQueryInvModel> getQueryInvModelFullListPage(QueryInvRequestModel queryInvRequestModel, int pageNum, int pageSize){
        Page<MGQueryInvModel> page = PageHelper.startPage(pageNum, pageSize);
        //PageHelper会自动拦截到下面这查询sql
        tScmVatMainMapper.queryInvFullList(queryInvRequestModel);
        return page.toPageInfo();
    }
}

