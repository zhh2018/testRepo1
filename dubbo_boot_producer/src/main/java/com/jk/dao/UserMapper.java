package com.jk.dao;

import java.util.List;

import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jk.model.User;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select count(0) from a_testuser")
	long queryCount(User user);

    @Select("select * from a_testuser limit #{start},#{pageSize}")
	List<User> queryUserdata(@Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("user") User user);

	@Select("select tree_id as id,"
			+ "tree_text as text,"
			+ "tree_href as url,"
			+ "tree_pid as pid"
			+ " from a_tree"
			+ " where tree_pid = #{i}")
    List<Tree> findTree(int i);
}