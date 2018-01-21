/** 
 * <pre>项目名称:dubbo_producer 
 * 文件名称:User.java 
 * 包名:com.jk.model 
 * 创建日期:2018年1月17日下午6:48:39 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * <pre>项目名称：dubbo_producer    
 * 类名称：User    
 * 类描述：    
 * 创建人：张慧慧cht_java@126.com    
 * 创建时间：2018年1月17日 下午6:48:39    
 * 修改人：张慧慧 cht_java@126.com  
 * 修改时间：2018年1月17日 下午6:48:39    
 * 修改备注：       
 * @version </pre>    
 */
public class User implements Serializable{
   
	private static final long serialVersionUID = -9132444526063476819L;

	private Integer userid;

    private String username;

    private String userpwd;

    private String usernike;

    private Integer usersex;

    private  String  ids;
    
    private  List<User> list;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date   usercdate;
    
    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
    private  String  showcreatTime;  
    
    public String getShowcreatTime() {
    	return usercdate!=null?sim.format(usercdate):"";
	}

	public void setShowcreatTime(String showcreatTime) {
		this.showcreatTime = showcreatTime;
	}
    public Date getUsercdate() {
		return usercdate;
	}

	public void setUsercdate(Date usercdate) {
		this.usercdate = usercdate;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUsernike() {
        return usernike;
    }

    public void setUsernike(String usernike) {
        this.usernike = usernike == null ? null : usernike.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }
}
