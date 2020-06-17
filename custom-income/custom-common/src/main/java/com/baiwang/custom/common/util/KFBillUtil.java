package com.baiwang.custom.common.util;

import com.baiwang.platform.custom.common.util.FinValidUtils;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 9:03 2018/7/17
 * @Modified By:
 */
public class KFBillUtil {



    /**
     * 百望影像平台单据状态 转 垦丰单据状态
     * @param BWBillState
     * @return
     */
    public static String getKFBillState(String BWBillState){
        if (StringUtil.isEmpty(BWBillState)) {
            return "";
        }
        if ("1".equals(BWBillState)) {
            return "2";
        }
        if ("2".equals(BWBillState)) {
            return "3";
        }
        if ("3".equals(BWBillState)) {
            return "4";
        }
        return "";
    }


    /**
     * 获取垦丰发票类型
     *
     * @param InvoiceCode  发票代码
     * @return
     */
    public static String getKFInvoiceType(String InvoiceCode) {
        if (StringUtil.isEmpty(InvoiceCode)) {
            return "";
        }
        String BWType = FinValidUtils.generateType(InvoiceCode);
        if ("01".equals(BWType)) {
            return "2";
        }
        if ("04".equals(BWType)) {
            return "1";
        }
        if ("10".equals(BWType)) {
            return "51";
        }
        if ("11".equals(BWType)) {
            return "11";
        }
        if ("14".equals(BWType)) {
            return "14";
        }
        return "99";
    }

    public static String subString(String str, String strStart, String strEnd) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);
        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return null;
        }
        if (strEndIndex < 0) {
            return null;
        }
        /* 开始截取 */
        return str.substring(strStartIndex, strEndIndex).substring(strStart.length());

    }

}
