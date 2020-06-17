
package com.baiwang.custom.common.util;

import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字符串对象是否为空判断工具类
 * Created by LiaoJS on 2016/8/13.
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判定原字符串是否为空，为空则返回空串""，否则返回字符串本身
     * 20171103之前，返回Object，有点多余，特修改为直接反馈字符串
     *
     * @param str
     * @return
     */
    public static String isNull(String str) {
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return "";
        }
        return str;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字串的真实长度(含中文)
     *
     * @param s
     * @return
     */
    public static int String_length(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    /**
     * 获取指定字符串之间的字串
     *
     * @param source
     * @param priStr
     * @param fromIndex
     * @param suxStr
     * @return
     */
    public static String getIntervalValue(String source, String priStr, int fromIndex, String suxStr) {
        if (source == null)
            return "";
        int iFirst = source.indexOf(priStr, fromIndex);
        int iLast = source.indexOf(suxStr, fromIndex);
        if (iFirst < 0 || iLast < 0)
            return "";
        int beginIndex = iFirst + priStr.length();
        return source.substring(beginIndex, iLast);
    }

    public static String getIntervalValue(String source, String priStr, String suxStr) {
        return getIntervalValue(source, priStr, 0, suxStr);
    }


    /**
     * base64转inputStream
     *
     * @param base64string
     * @return
     */
    public static InputStream baseToInputStream(String base64string) {
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes1 = decoder.decodeBuffer(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}
