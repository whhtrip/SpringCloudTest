package com.interworking.mybatisTest.mapper;

import com.interworking.DemoApplication;
import com.interworking.mybatisTest.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}