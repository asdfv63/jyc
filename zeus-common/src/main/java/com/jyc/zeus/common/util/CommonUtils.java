package com.jyc.zeus.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName : CommonUtils
 * @Description : 公用工具类
 * @Author : jyc
 * @Date: 2020-05-26 19:30
 */
public class CommonUtils {

    /**
     * 生成业务id
     * @return
     */
    public static String createBathCode(){
        return createTimeStamp();
    }

    /**
     * 生成uuid
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    // 复制输入流
    public static ByteArrayOutputStream cloneInputStream(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String createExcelFileName(String fileName){
        return  fileName + "_" + createTimeStamp()+".xlsx";
    }

    private static String createTimeStamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        return simpleDateFormat.format(new Date());
    }
    /**
     * 保留两位小数  1.00
     * @param text
     * @return
     */
    public static String fmtTwo(String text){
        if(StringUtils.isBlank(text)){
            return StringUtils.EMPTY;
        }
        double d = Double.parseDouble(text);
        return new DecimalFormat("0.00").format(d);
    }

    /**
     * 千分位方法
     * @param text
     * @return
     */
    public static String fmtMicrometer(String text)
    {
        if(StringUtils.isBlank(text)){
            return StringUtils.EMPTY;
        }
        DecimalFormat df = null;
        if(text.indexOf(".") > 0)
        {
            if(text.length() - text.indexOf(".")-1 == 0)
            {
                df = new DecimalFormat("###,##0.");
            }else if(text.length() - text.indexOf(".")-1 == 1)
            {
                df = new DecimalFormat("###,##0.0");
            }else
            {
                df = new DecimalFormat("###,##0.00");
            }
        }else
        {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }

    public static BigDecimal getFileSizeMB(Integer size){
        return new BigDecimal(size).divide(new BigDecimal(1024*1024),2,BigDecimal.ROUND_HALF_UP);
    }
}
