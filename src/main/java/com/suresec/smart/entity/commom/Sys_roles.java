package com.suresec.smart.entity.commom;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_roles 实体类
* 2019-10-17 10:20:18 wcc
*/ 
@Entity
@Table(name="sys_roles")
@Data
public class Sys_roles{
	/**
	*角色编号
	*/
	@Id
	private String id;
	/**
	*角色名称
	*/
	private String name;
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
