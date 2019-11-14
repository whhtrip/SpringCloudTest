/*
package com.elasticsearch.domain;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

*/
/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 *//*

@Document(indexName = "whh", type = "user")
public class User {
    // 主键 @Id
    private String id;
    private String name;
    private String realname;
    private Integer age;
    private Double salary;
    private Date birthday;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }// 从es中恢复数据时使用的构造方法

    @PersistenceConstructor
    public User(String id, String name, String realname, Integer age, Double salary, Date birthday, String address) {
        this.id = id;
        this.name = name;
        this.realname = realname;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
*/
