package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jk.model.User;
@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	/** <pre>queryCount(这里用一句话描述这个方法的作用)   
	 * 创建人：张慧慧cht_java@126.com     
	 * 创建时间：2018年1月18日 下午9:18:44    
	 * 修改人：张慧慧cht_java@126.com      
	 * 修改时间：2018年1月18日 下午9:18:44    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
    @Select("select count(0) from a_testuser")
	long queryCount(User user);

	/** <pre>queryUserdata(这里用一句话描述这个方法的作用)   
	 * 创建人：张慧慧cht_java@126.com     
	 * 创建时间：2018年1月18日 下午9:18:52    
	 * 修改人：张慧慧cht_java@126.com      
	 * 修改时间：2018年1月18日 下午9:18:52    
	 * 修改备注： 
	 * @param pageSize
	 * @param start
	 * @param user
	 * @return</pre>    
	 */
    @Select("select * from a_testuser limit #{start},#{pageSize}")
	List<User> queryUserdata(@Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("user") User user);
}