/**
 * <p>Title: BaseException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: www.zto.com</p>
 */
package com.jyc.zeus.common.exception;
/**
 * <p>Class: BaseException</p>
 * <p>Description: 基础的异常信息类</p>
 * @author xiaowenke@zto.cn
 * @date 2017-08-16
 * @version 1.0
 */
public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = -3778081859201646996L;

	private String code;
	
	private String msg;

	protected BaseException() {
	}

	protected BaseException(String code, String msg) {
		super(code+"="+msg);
		this.code = code;
		this.msg = msg;
	}

	protected BaseException(String code, String msg,Throwable e) {
		super(msg,e);
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
