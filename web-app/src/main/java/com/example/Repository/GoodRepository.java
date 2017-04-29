package com.example.Repository;

import com.example.pojo.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Repository
public interface GoodRepository extends JpaRepository<Good,Integer>{

    List<Good> findByType(short type);

    List<Good> findByGoodNameLike(String keyword);

}
