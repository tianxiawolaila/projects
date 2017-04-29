package com.example.controller;

import com.example.pojo.CartItem;
import com.example.pojo.Good;
import com.example.pojo.User;
import com.example.service.CartService;
import com.example.service.GoodService;
import com.example.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/{index}")
    private String register(@PathVariable String index,Model model,HttpSession session){
        if("index".equals(index)){
            model.addAttribute("dataList",goodService.getAll());
        }
        model.addAttribute("user",session.getAttribute("user"));
        return index;
    }

    @RequestMapping("/toRegist")
    private String toRegist(User user, Model model, HttpSession session){
        try {
            registerService.regist(user);
            session.setAttribute("user",user);
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("message",e.getMessage());
            return "zhuce";
        }
        model.addAttribute("user",user);
        model.addAttribute("dataList",goodService.getAll());
        return "index";
    }

    @RequestMapping("/toLoginIn")
    private String toLoginIn(User user, Model model, HttpSession session){

        session.setAttribute("user",registerService.loginIn(user));
        model.addAttribute("user",registerService.loginIn(user));
        return "forward:/index";
    }

    @RequestMapping("/toShowGood")
    private String toShowGood(Integer id,Model model){
        Good good = goodService.getOne(id);
        model.addAttribute("g",good);
        return "chanpin2";
    }

    //添加购物车并跳转
    @RequestMapping("/toCart")
    private String toCart(Integer id,Integer num,Model model,HttpSession session){
        List<CartItem> carts = cartService.addInfo(id, num, (User)session.getAttribute("user"));
        Map<Good,Integer> map = new HashMap<Good,Integer>(carts.size());
        for (CartItem cartItem : carts) {
            Good one = goodService.getOne(cartItem.getGoodId());
            map.put(one,cartItem.getNum());
        }
        model.addAttribute("carts",map);
        return "cart";
    }

    //回到我的购物车
    @RequestMapping("/toMyCart")
    private String toMyCart(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        List<CartItem> carts = cartService.findByUserId(user.getId());
        Map<Good,Integer> map = new HashMap<Good,Integer>(carts.size());
        for (CartItem cartItem : carts) {
            Good one = goodService.getOne(cartItem.getGoodId());
            map.put(one,cartItem.getNum());
        }
        model.addAttribute("carts",map);
        return "cart";
    }

    @RequestMapping("toupdateNum")
    private String toUpdateItemNum(int id, int buyNum, HttpSession session){
        User user = (User)session.getAttribute("user");
        cartService.updateNum(id,buyNum,user.getId());
        return "forward:/toMyCart";
    }
}

