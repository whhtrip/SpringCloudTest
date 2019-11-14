package com.lesson.mapper;

import com.lesson.DemoApplication;
import com.lesson.mybatisTest.domain.User;
import com.lesson.mybatisTest.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testGetAllUser() {
        System.out.println(userMapper);
        List<User> users = userMapper.selectAllUser();
        int userLength = users.size();
        for (int i = 0; i < userLength; i++) {
            System.out.println(users.get(i).getUsername()+"  "+users.get(i).getUserBirthday()+"  "+users.get(i).getCreateTime());
        }
        System.out.println(users);
    }
    @Test
    public void insertUser(){
        Date date = new Date();
        User user = new User(1,"",date,date);
        Integer integer = userMapper.inserUser(user);
        System.out.println(integer);

    }
}