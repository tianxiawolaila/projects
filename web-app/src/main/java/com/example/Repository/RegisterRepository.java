package com.example.Repository;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Repository
public interface RegisterRepository extends JpaRepository<User,Integer>{

    public int countByUsernameAndPassword(String username, String password);

    public int countByUsername(String username);

    public User findFirstByUsernameAndPassword(String username,String password);
}
