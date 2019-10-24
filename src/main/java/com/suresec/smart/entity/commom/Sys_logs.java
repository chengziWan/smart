package com.suresec.smart.entity.commom;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
* sys_logs 实体类
* 2019-10-17 10:20:18 wcc
*/ 
@Entity
@Table(name="sys_logs")
@Data
public class Sys_logs{
	/**
	*日志编号
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	*操作用户
	*/
	private String username;
	/**
	*操作描述
	*/
	private String description;
	/**
	*操作时间
	*/
	private String start_Time;
	/**
	*消耗时间
	*/
	private String spend_Time;
	/**
	*根路径
	*/
	private String base_Path;
	/**
	*URI
	*/
	private String uri;
	/**
	*URL
	*/
	private String url;
	/**
	*请求类型
	*/
	private String method;
	/**
	*IP地址
	*/
	private String ip;
	/**
	*请求参数
	*/
	private String parameter;
	/**
	*请求返回的结果
	*/
	private String result;
}
