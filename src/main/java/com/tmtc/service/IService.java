package com.tmtc.service;

import java.util.List;

/**
 * base service
 * Created by hbwhypw on 2015/6/22.
 * @param <T> entity
 * @param <E> query parameter
 */
public interface IService<T, E> {
    int count(E example);

    int delete(String id);

    int delete(E example);

    int insert(T record);

    List<T> select(E example);

    T selectByPrimaryKey(String id);

    int update(T record);

    int update(T record, E example);
}
