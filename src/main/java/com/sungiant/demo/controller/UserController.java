package com.sungiant.demo.controller;

import com.sungiant.demo.dao.UserMapper;
import com.sungiant.demo.entity.User;
import com.sungiant.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/try")
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user")
    public List<User> getUsers(){
        return userMapper.selectAll();
    }

    @RequestMapping(value = "/newuser",method = RequestMethod.POST)
    public int newUser(@RequestBody User record){
        return userMapper.insert(record);
    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.PUT)
    public int updateUser(@RequestBody User record){
        return userMapper.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/deluser/{id}",method = RequestMethod.DELETE)
    public int delUser(@PathVariable(name = "id") int id){
        return userMapper.deleteByPrimaryKey(id);
    }

}
