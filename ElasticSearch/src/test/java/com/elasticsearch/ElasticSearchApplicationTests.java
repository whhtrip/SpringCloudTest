/*
package com.elasticsearch;

import com.elasticsearch.dao.ElasticSearchDao;
import com.elasticsearch.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:elasticSearch/elasticSearch.xml")
//@SpringBootTest(classes = ElasticSearchApplication.class)
class ElasticSearchApplicationTests {
    @Autowired
    private ElasticSearchDao userRepository;
    @Test
    void contextLoads() {
    }
    @Test
    public void testAdd(){
        User user1 = new User();
        user1.setId("1");
        user1.setName("whh");
        user1.setRealname("王宏豪");
        user1.setAddress("北京房山");
        user1.setAge(123);
        user1.setBirthday(new Date());
        user1.setSalary(123123d);
        if (userRepository == null){
            System.out.println("为空");
        }
        User user = userRepository.save(user1);
                System.out.println(user);
    }

}
*/
