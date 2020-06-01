package com.jyc.zeus.common.util;

import com.jyc.zeus.common.model.EnumItemable;
import com.jyc.zeus.common.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EnumUtils
 * @Author jyc
 * @Date 2020/05/26 0025 上午 11:04
 * @Version 1.0
 **/
public class EnumUtils {
    public static <E extends EnumItemable<?>> E get(Class<E> enumType, String label) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getLabel().equals(label)) {
                return e;
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> String getValue(Class<E> enumType, String label) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getLabel().equals(label)) {
                return e.getKey().toString();
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> boolean blExistsByValue(Class<E> enumType, Object value) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getKey().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends EnumItemable<?>> boolean blExistsByLabel(Class<E> enumType, String label) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends EnumItemable<?>> String getLabel(Class<E> enumType, Object value) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getKey().equals(value)) {
                return e.getLabel();
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> List<Item> getSelectItemList(Class<E> enumType) {
        List<Item> list = new ArrayList<>();
        for (E e : enumType.getEnumConstants()) {
            list.add(new Item(e.getKey(),e.getLabel()));
        }
        return list;
    }
}
