package com.example.common;

import com.example.pojo.User;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class UserLocal {
    private static ThreadLocal<User> tl = new ThreadLocal<User>(){
        @Override
        protected User initialValue() {
            return null;
        }
    };

    public static User get(){
        return tl.get();
    }

    public static void set(User user){
        tl.set(user);
    }

    public static void release(){
        tl.remove();
    }
}
