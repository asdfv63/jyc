package com.jyc.zeus.common.exception;


import com.jyc.zeus.common.enums.StatusCodeEnum;

import java.text.MessageFormat;

public class BusinessException extends BaseException {

    /**
     * 传入code 和Msg 构建BusinessException对象
     * @param code
     * @param msg
     */
    public BusinessException(String code, String msg) {
        super(code,msg);
    }

    public BusinessException(StatusCodeEnum codeEnum) {
        super(codeEnum.getKey(),codeEnum.getLabel());
    }

    public BusinessException(StatusCodeEnum codeEnum, Object... arguments) {
        this.setCode(codeEnum.getKey());
        this.setMsg(MessageFormat.format(codeEnum.getLabel(), arguments));
    }

}
