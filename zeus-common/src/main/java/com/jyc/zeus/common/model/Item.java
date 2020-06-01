package com.jyc.zeus.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName : Item
 * @Description : 基础键值对
 * @Author : jyc
 * @Date: 2020-06-01 15:31
 */
@Data
@AllArgsConstructor
public class Item implements Itemable {
    private Object key;
    private String label;
}
