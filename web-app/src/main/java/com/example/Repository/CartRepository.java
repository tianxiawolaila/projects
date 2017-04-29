package com.example.Repository;

import com.example.pojo.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
@Repository
public interface CartRepository extends JpaRepository<CartItem,Integer>{

    public List<CartItem> findAllByOwnerIdOrderById(Integer id);

    public CartItem findFirstByOwnerIdAndGoodId(Integer ownerId,Integer goodId);

}
