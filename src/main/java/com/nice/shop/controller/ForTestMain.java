package com.nice.shop.controller;

import java.util.ArrayList;
import java.util.List;

public class ForTestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("나는1번");
        list.add("나는2번");
        list.add("나는3번");

        // 기본 for문
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        for(String str : list) {
            System.out.println(str);
        }


    }
}
