package com.suresec.smart.entity.commom;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
* sys_roles ʵ����
* 2019-10-17 10:20:18 wcc
*/ 
@Entity
@Table(name="sys_roles")
@Data
public class Sys_roles{
	/**
	*��ɫ���
	*/
	@Id
	private String id;
	/**
	*��ɫ����
	*/
	private String name;
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
