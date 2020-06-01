package com.jyc.zeus.common.enums;

import com.jyc.zeus.common.model.EnumItemable;

/**
 * 是否枚举
 */
public enum TrueFalseEnum implements EnumItemable<TrueFalseEnum> {
    /**
     * 是
     */
    TRUE(true,"是"),
    /**
     * 否
     */
    FALSE(false,"否");


    private Boolean key;
    private String label;


    TrueFalseEnum(Boolean key,String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public Boolean getKey() {
        return this.key;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
