package com.elasticsearch.controller;

import com.elasticsearch.ElasticSearchTest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:WangHongHao
 * @date:19-10-24创建
 * @date：修改
 * @description：
 */
@RestController
@RequestMapping("elasticSearch")
public class ElasticSearchController {
    @RequestMapping("getData")
    public Map<String,String> getElasticData(){
        Map<String, String> map = new HashMap<>();
        try {
            TransportClient client = ElasticSearchTest.getClient();
            SearchResponse response = client.prepareSearch("twitter")
                    //.setFetchSource(true)
                    .setTypes("nginxLog")
                    //.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    //.setQuery(QueryBuilders.termQuery("message", "c"))// Query
                    //.highlighter(new HighlightBuilder().field("message").field("user"))
                    //.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                    //.setFrom(0).setSize(60).setExplain(true)
                    .get();
            System.out.println(response);
            String s = response.toString();
            System.out.println(s);
            SearchHits hits1 = response.getHits();
            System.out.println(hits1);
            long totalHits = hits1.totalHits;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return map;
    }
}
