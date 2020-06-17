package com.baiwang.custom.common.base;

import com.baiwang.platform.custom.common.util.DateUtils;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 14:30 2018/6/14
 * @Modified By:
 */
public class XStreamDateConverter extends AbstractSingleValueConverter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    @Override
    public Object fromString(String str) {
        try {
            return DateUtils.date_sdf.parseObject(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new ConversionException("日期格式转换异常：" + str);
    }
}
