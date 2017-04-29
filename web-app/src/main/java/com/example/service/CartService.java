package com.example.service;

import com.example.Repository.CartRepository;
import com.example.common.UserLocal;
import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<CartItem> addInfo(Integer id, Integer num,User user) {
        CartItem cart = cartRepository.findFirstByOwnerIdAndGoodId(user.getId(),id);
        if(cart == null){
            cart = new CartItem();
            cart.setOwnerId(user.getId());
            cart.setCreatedAt(LocalDateTime.now());
            cart.setGoodId(id);
        }
        cart.setNum(num);
        cart.setUpdateAt(LocalDateTime.now());
        cartRepository.save(cart);
        List<CartItem> carts = cartRepository.findAllByOwnerIdOrderById(user.getId());
        return carts;
    }

    public void updateNum(int id, int buyNum, int userId) {

        CartItem cartItem = cartRepository.findFirstByOwnerIdAndGoodId(userId, id);
        cartItem.setNum(buyNum);
        cartRepository.save(cartItem);
    }

    public List<CartItem> findByUserId(int userId) {
       return cartRepository.findAllByOwnerIdOrderById(userId);

    }
}
