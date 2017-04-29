package com.example.controller;

import com.example.common.StringUtil;
import com.example.pojo.Good;
import com.example.service.GoodService;
import com.example.service.GoodServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GoodController {

    @Autowired
    private GoodServiceInterface goodService;

    @RequestMapping("/toGoodList")
    public String toGoodList(Model model, @RequestParam("type") short type){
        List<Good> dataList = goodService.findByType(type);
        model.addAttribute("dataList",dataList);
        return "chanpin1";
    }
}
