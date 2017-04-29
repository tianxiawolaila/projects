package com.example.service;

import com.example.pojo.Good;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public interface GoodServiceInterface {
    public List<Good> findByType(short type);
}
