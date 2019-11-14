package com.lesson.mybatisTest.mapper;


import com.lesson.mybatisTest.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserMapper {
    List<User> selectAllUser();
    Integer inserUser(User user);
    Integer insertUserWithId(User user);
}
