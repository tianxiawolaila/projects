package com.example.service;

import com.example.Repository.RegisterRepository;
import com.example.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;


    public List<User> getAll(){
        return registerRepository.findAll();
    }

    public void regist(User user) {
//        ExampleMatcher matcher = ExampleMatcher.matching();
//        Example condition = Example.of(new User(){{setUsername(user.getUsername());
//        setPassword(user.getPassword());}},matcher);
        int count = registerRepository.countByUsername(user.getUsername());

        if(count > 0){
            throw new RuntimeException("该用户名密码已经存在！");
        }
        user.setCreateAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        registerRepository.save(user);
    }

    public User loginIn(User user) {
        User loginUser = registerRepository.findFirstByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(loginUser == null){
            throw new RuntimeException("用户名或者密码不存在");
        }
        return loginUser;
    }
}
