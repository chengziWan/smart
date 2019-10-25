package com.suresec.system.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_menus 实体类
* 2019-10-23 15:54:19 wcc
*/ 
@Entity
@Table(name="sys_menus")
@Data
public class Sys_menus{
	/**
	*菜单编号
	*/
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	//path
	private String path;
	//redirect
	private String redirect;
	//component
	private String component;
	//name
	private String name;
	//title
	private String title;
	//icon
	private String icon;
	//parentId
	//@ManyToOne(targetEntity = Sys_menus.class)
	//@JoinColumn(name="parnet_id")
	private String parent_id;
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
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="parent_id",targetEntity = Sys_menus.class)
	private Set<Sys_menus> children = new HashSet<Sys_menus>(0);
}
