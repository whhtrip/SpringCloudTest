package com.interworking.mybatisTest.mapper;

import com.interworking.mybatisTest.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectAllUser();
}
