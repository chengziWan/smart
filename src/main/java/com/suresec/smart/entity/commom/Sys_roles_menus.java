package com.suresec.smart.entity.commom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_roles_menus ʵ����
* 2019-10-17 10:20:18 wcc
*/ 
@Entity
@Table(name="sys_roles_menus")
@Data
public class Sys_roles_menus{
	/**
	*����
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	*��ɫ���
	*/
	@Column(name = "role_id")
	private String role;
	/**
	*���ܱ��
	*/
	private String menu_id;
}
