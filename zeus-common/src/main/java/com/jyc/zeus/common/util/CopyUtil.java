package com.jyc.zeus.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-03-26
 * Time: 上午9:12
 */
@Slf4j
public class CopyUtil {


    public static <T> T copy(Object from, T infoTo) {
        if (from == null) {
            return null;
        }

        try {
            BeanUtils.copyProperties(from, infoTo);
            return infoTo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static <T> T copy(Object from, Class<T> clazz) {
        if (from == null) {
            return null;
        }

        try {
            T infoTo = clazz.newInstance();
            BeanUtils.copyProperties(from, infoTo);
            return infoTo;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static <S, T> List<T> copy(List<S> from, Class<T> toClazz) {
        if (CollectionUtils.isEmpty(from)) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>(from.size());
        for (S src : from) {
            try {
                T infoTo = toClazz.newInstance();
                BeanUtils.copyProperties(src, infoTo);
                result.add(infoTo);
            } catch (InstantiationException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }

        return result;
    }
}
