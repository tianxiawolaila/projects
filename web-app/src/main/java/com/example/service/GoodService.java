package com.example.service;

import com.example.Repository.GoodRepository;
import com.example.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GoodService implements GoodServiceInterface{
    @Autowired
    private GoodRepository goodRepository;

    public List<Good> getAll() {
        return goodRepository.findAll();
    }

    public Good getOne(Integer id) {

        return  goodRepository.findOne(id);
    }

    public List<Good> findByType(short type) {
      return goodRepository.findByType(type);

    }
}
