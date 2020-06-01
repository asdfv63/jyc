package com.jyc.zeus.common.enums;


import com.jyc.zeus.common.model.EnumItemable;

public enum StatusCodeEnum implements EnumItemable<StatusCodeEnum> {
    /**
     * 请求成功
     */
    SUCCESS("S200","请求成功"),
    /**
     * 请求失败
     */
    ERROR("S500","请求失败"),
    /**
     * 参数验证失败
     */
    PARAMETERS_VALID("S501","{0}"),
    /**
     * 数据库更新异常
     */
    UPDATE_VALID("S502","{0}"),
    /**
     * 插入更新异常
     */
    INSERT_VALID("S503","{0}"),
    /**
     * 文件无效
     */
    FILE_VALID("S504","{0}"),
    /**
     * 数据重复
     */
    DATA_REPEAT("S505","{0}"),
    /**
     * 不满足操作条件
     */
    OP_UNQUALIFIED("S506","{0}"),
    /**
     * 获取用户信息失败
     */
    USERINFO_ERROR("S507","获取用户信息失败"),
    /**
     * 上传文件服务器失败
     */
    UPLOAD_EXCEPTION("上传文件服务器失败","S509");

    private String label;
    private String key;

    StatusCodeEnum(String label, String key) {
        this.label = label;
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
