package com.example.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class StringUtil {
    public static List<String> splitString(String str){
        String[] strings = str.split(",");
        List<String> list = Arrays.asList(strings);
        return list;
    }
}
