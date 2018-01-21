package com.jk.service;/*
 * 创建人：张慧慧zhh_java
 */

import com.jk.model.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> queryUserdata(Integer pageSize, Integer start, User user);
}
