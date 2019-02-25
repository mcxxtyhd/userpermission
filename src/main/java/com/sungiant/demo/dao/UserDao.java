package com.sungiant.demo.dao;

import com.sungiant.demo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();

    Boolean deleteUserById(int Id);
}