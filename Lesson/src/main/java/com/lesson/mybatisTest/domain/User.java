package com.lesson.mybatisTest.domain;

import java.util.Date;

/**
 * @author:WangHongHao
 * @date:19-10-12创建
 * @date：修改
 * @description：
 */
public class User {
    private Integer userId;
    private String username;
    private Date userBirthday;
    private Date createTime;

    public User() {
    }

    public User(Integer userId, String username, Date userBirthday, Date createTime) {
        this.userId = userId;
        this.username = username;
        this.userBirthday = userBirthday;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
