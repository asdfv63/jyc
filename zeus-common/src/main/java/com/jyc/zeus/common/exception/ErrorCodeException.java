/**
 * <p>Title: ErrorCodeException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: www.zto.com</p>
 */
package com.jyc.zeus.common.exception;

import com.jyc.zeus.common.model.Itemable;

import java.text.MessageFormat;

/**
 * <p>Class: ErrorCodeException</p>
 * <p>Description: 提供一个传入ErrorCode来构建异常的类,ErrorCode实现参考ExceptionEnum</p>
 * @author xiaowenke@zto.cn
 * @date 2017-05-26
 * @version 1.0
 */
public class ErrorCodeException extends BaseException {
    public ErrorCodeException(Itemable code, Object... args) {
        super(code.getKey().toString(), MessageFormat.format(code.getLabel(),args));
    }


    public ErrorCodeException(Throwable e,Itemable code, Object... args) {
        super(code.getKey().toString(), MessageFormat.format(code.getLabel(),args),e);
    }
}
