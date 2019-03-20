package com.springbootmybatisstater.web;

import com.springbootmybatisstater.mapper.UserMapper;
import com.springbootmybatisstater.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户管理
 *
 * @author WangLonglong
 * @email caption1215@gmail.com
 * @date 2019/3/20 15:14
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getUsers")
    public List<User> getUsers(){
        return userMapper.getAll();
    }

    @RequestMapping("getUserById")
    public User getUserById(Long id ){
        return userMapper.getOne(id);
    }

    @RequestMapping("add")
    public void save(User user){
        userMapper.insert(user);
    }

    @RequestMapping("update")
    public void update(User user){
        userMapper.update(user);
    }

    @RequestMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userMapper.delete(id);
    }
}
