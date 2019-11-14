package com.interworking.mybatisTest.mapper;

import com.interworking.DemoApplication;
import com.interworking.mybatisTest.domain.User;
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
            System.out.println(users.get(i).getUsername() + "  " + users.get(i).getUserBirthday() + "  " + users.get(i).getCreateTime());
        }
        System.out.println(users);
    }

    @Test
    public void insertUser() {
        Date date = new Date();
        User user = new User("王宏豪", date, date);
        Integer integer = userMapper.inserUser(user);
        System.out.println(integer);
        System.out.println("插入数据之后：" + user.getUserId());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserId(3);
        Integer integer = userMapper.updateUser(user);
        System.out.println(integer);
        System.out.println("插入之后的数据变化：" + user);
    }
}