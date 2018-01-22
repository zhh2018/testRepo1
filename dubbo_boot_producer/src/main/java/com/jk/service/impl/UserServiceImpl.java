package com.jk.service.impl;/*
 * 创建人：张慧慧zhh_java
 */

import com.alibaba.dubbo.common.json.JSON;
import com.jk.dao.UserMapper;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService{
     @Autowired
     private   UserMapper   userMapper;

     @Override
     public  Map<String,Object> queryUserdata(Integer pageSize, Integer start, User user) {
          long count = userMapper.queryCount(user);
          List<User> list = userMapper.queryUserdata(pageSize,start,user);
          Map<String,Object> map=new HashMap<>();
          map.put("total",count);
          map.put("rows",list);

          return map;
     }

     @Override
     public List<Tree> findTree(int i) {
          return userMapper.findTree(i);
     }
}
