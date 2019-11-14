package com.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.profile.ProfileShardResult;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 */
public class ElasticSearchTest {
    private static TransportClient client;
    private static IndexResponse response;

    /**
     * 主方法执行
     *
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        getMessage();
    }

    /**
     * 获取连接
     *
     * @return
     * @throws UnknownHostException
     */
    public static TransportClient getClient() throws UnknownHostException {
        /*Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticSearch") //设置ES实例的名称
                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
        TransportClient client = new PreBuiltTransportClient(esSettings);*///初始化client较老版本发生了变化，此方法有几个重载方法，初始化插件等。
        //此步骤添加IP，至少一个，其实一个就够了，因为添加了自动嗅探配置
        if (client !=null){
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.179.131"), 9300));
        }
        return client;
    }

    /**
     * 创建索引
     *
     * @throws UnknownHostException
     */
    public static void createIndex() throws UnknownHostException {
        TransportClient client = getClient();
        try {
            /*IndexResponse response = client.prepareIndex("twitter", "whhdoc", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elasticsearch")
                            .endObject()
                    )
                    .get();*/
            for (int i =0;i<100;i++){
                response = client.prepareIndex("twitter", "whhdoc")
                        .setSource(jsonBuilder()
                                .startObject()
                                .field("user", "kimchy"+i)
                                .field("postDate", new Date())
                                .field("message", "trying out Elasticsearch "+i)
                                .endObject()
                        )
                        .get();
            }
            // Index name
            responseOut(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();
    }

    /**
     * 输出响应
     *
     * @param response
     */
    public static void responseOut(IndexResponse response) {
        String _index = response.getIndex();
        // Type name
        String _type = response.getType();
        // Document ID (generated or not)
        String _id = response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        // status has stored current instance statement.
        RestStatus status = response.status();
        System.out.println(_index + "  " + _type + "  " + _id + "  " + _version + "  " + status);
    }

    public static void getMessage() throws UnknownHostException {
        client = getClient();
        GetResponse getFields = client.prepareGet("twitter", "whhdoc", "1").setFetchSource(false).get();
        boolean exists = getFields.isExists();
        System.out.println(getFields);
        String id = getFields.getId();
        String index = getFields.getIndex();
        String type = getFields.getType();
        long version = getFields.getVersion();
        Map<String, Object> source = getFields.getSource();
        System.out.println(exists + "  " + id + "  " + index + "  " + type + "  " + version + "  " + source);
    }

    public static void searchMessage() throws UnknownHostException {
        client = getClient();
        SearchResponse response = client.prepareSearch("twitter")
                //.setFetchSource(true)
                .setTypes("whhdoc")
                //.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("message", "c"))// Query
                .highlighter(new HighlightBuilder().field("message").field("user"))
                //.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .get();
        System.out.println(response);
        String s = response.toString();
        System.out.println(s);
        SearchHits hits1 = response.getHits();
        System.out.println(hits1);
        long totalHits = hits1.totalHits;
        System.out.println("查中数量" + totalHits);
        for (int i = 0; i<totalHits;i++){
            SearchHit at = hits1.getAt(i);
            Map<String, Object> source = at.getSource();
            System.out.println(source);
        }
    }
}
