/*
package com.elasticsearch.dao;

import com.elasticsearch.domain.User;


import java.util.List;

*/
/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 *//*

public interface ElasticSearchDao extends ElasticsearchRepository<User, String> {
    */
/*** 根据年龄区间查询数据 并根据年龄降序排列 *//*

    public List<User> findByAgeBetweenOrderByAgeDesc(int start, int end);

    */
/*** 查询真实姓名已“王”开头的数据 *//*

    public List<User> findByRealnameStartingWith(String startStr);

    */
/*** 通过Query注解自定义查询表达式 *//*

    @Query("{\"bool\" : {\"must\" : {\"fuzzy\" : {\"name\" : \"?0\"}}}}")
    public List<User> findByNameLike(String name);
}*/
