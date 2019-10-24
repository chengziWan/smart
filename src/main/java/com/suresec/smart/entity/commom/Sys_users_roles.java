package com.suresec.smart.entity.commom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_users_roles ʵ����
* 2019-10-17 10:20:19 wcc
*/ 
@Entity
@Table(name="sys_users_roles")
@Data
public class Sys_users_roles{
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
	*��Ա���
	*/
	private String username;
}
