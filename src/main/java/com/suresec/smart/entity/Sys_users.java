package com.suresec.smart.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_users ʵ����
* 2019-10-14 14:22:17 wcc
*/ 
@Entity
@Table(name="sys_users")
@Data
public class Sys_users{
	/**
	*�˺�
	*/
	@Id
	private String id;
	/**
	*����
	*/
	private String name;
	/**
	*��������
	*/
	private String companyid;
	/**
	*����
	*/
	private String pwd;
	/**
	*���÷�(1:����;0:����)
	*/
	private String status;
	/**
	*������
	*/
	private String create_usr;
	/**
	*����ʱ��
	*/
	private String timestamp;
}
