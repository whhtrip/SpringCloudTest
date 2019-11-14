package com.elasticsearch;

import java.net.UnknownHostException;

/**
 * @author:WangHongHao
 * @date:19-10-22创建
 * @date：修改
 * @description：
 */
public class ElasticSearchMain {
    public static void main(String[] args) {
        try {
            //ElasticSearchTest.createIndex();
            //ElasticSearchTest.getMessage();
            ElasticSearchTest.searchMessage();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
