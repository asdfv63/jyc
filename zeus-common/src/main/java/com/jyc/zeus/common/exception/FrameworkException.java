/**
 * <p>Title: FrameworkException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: www.zto.com</p>
 */
package com.jyc.zeus.common.exception;


public class FrameworkException extends BaseException{
    public static final String ERR_DEF="S500";

    /**
     * 传入code 和Msg 构建BusinessException对象
     * @param code
     * @param msg
     */
    public FrameworkException(String code, String msg) {
        super(code,msg);
    }

    /***
     * 提供一个简便的构建BusinessException对象方法
     * @param patterm  异常信息模板 如 xxxx {} xxxx
     * @param args  传入模板所需要的参数
     * @return
     */
    public static FrameworkException getInstance(String patterm, Object... args) {
        String msg = java.text.MessageFormat.format(patterm,args);
        return new FrameworkException(ERR_DEF,msg);
    }

    /***
     * 提供一个简便的构建BusinessException带Exception的对象方法
     * @param e    异常参数
     * @param pattern  异常信息模板 如 xxxx {} xxxx
     * @param args 传入模板所需要的参数
     * @return
     */
    public static FrameworkException getInstance(Throwable e,String pattern, Object... args) {
        String msg = java.text.MessageFormat.format(pattern,args);
        return new FrameworkException(ERR_DEF,msg,e);
    }

    public FrameworkException(String code, String msg,Throwable e) {
        super(code,msg,e);
    }
    public FrameworkException(Throwable e,String msg) {
        super(ERR_DEF,msg,e);
    }
    public FrameworkException(Throwable e,String msg,Object... objects) {

        super(ERR_DEF,msg,e);
    }
}
