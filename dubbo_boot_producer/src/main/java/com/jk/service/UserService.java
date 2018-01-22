package com.jk.service;
/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 18:55 2018/1/21
 * @Modified By：
 */

import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String,Object> queryUserdata(Integer pageSize, Integer start, User user);
    List<Tree> findTree(int i);
}
