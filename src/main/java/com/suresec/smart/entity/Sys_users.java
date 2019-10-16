package com.suresec.smart.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_users 实体类
* 2019-10-14 14:22:17 wcc
*/ 
@Entity
@Table(name="sys_users")
@Data
public class Sys_users{
	/**
	*账号
	*/
	@Id
	private String id;
	/**
	*名称
	*/
	private String name;
	/**
	*所属机构
	*/
	private String companyid;
	/**
	*密码
	*/
	private String pwd;
	/**
	*禁用否(1:禁用;0:启用)
	*/
	private String status;
	/**
	*创建人
	*/
	private String create_usr;
	/**
	*创建时间
	*/
	private String timestamp;
}
