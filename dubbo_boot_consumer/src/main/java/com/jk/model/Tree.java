/** 
 * <pre>项目名称:ssm_demo 
 * 文件名称:Tree.java 
 * 包名:com.baidu.pojo 
 * 创建日期:2017年11月17日下午8:52:14 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.List;


/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 18:55 2018/1/21
 * @Modified By：
 */
public class Tree implements Serializable {

	private static final long serialVersionUID = 1745183569533161116L;

	private  Integer  id;
	
	private   String  text;
	
	private   String  url;
	
	private   Integer  pid;
	
	private  List<Tree>  nodes;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}
	
}
