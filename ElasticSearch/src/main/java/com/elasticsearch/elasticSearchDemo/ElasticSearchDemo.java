package com.elasticsearch.elasticSearchDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 */
public class ElasticSearchDemo {
    public static void main(String[] args) {
        String s = "@1@2@3@4@";
        String[] split = s.split("@");
        int length = split.length;
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(split[i]+"  sdfsk");
        }
        String gg = "123";
        System.out.println(gg.hashCode());
        List<String> list = new ArrayList<>();
        list.add(gg);
        gg = "23123";
        System.out.println(gg.hashCode());
        System.out.println(list.get(0));
        System.out.println(gg);
    }
}
