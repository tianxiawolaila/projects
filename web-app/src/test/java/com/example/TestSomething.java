package com.example;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class TestSomething {

    private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return null;
        }
    };

    public static Integer get(){

        return tl.get();
    }

    public static void set(Integer i){
         tl.set(i);
    }

    public static void main(String[] args) {
        System.out.println(tl.get());
        tl.set(100);
        System.out.println(tl.get());
        System.out.println(tl.get());
    }
}
