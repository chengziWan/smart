package com.suresec.smart.entity.commom;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
* sys_logs ʵ����
* 2019-10-17 10:20:18 wcc
*/ 
@Entity
@Table(name="sys_logs")
@Data
public class Sys_logs{
	/**
	*��־���
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	*�����û�
	*/
	private String username;
	/**
	*��������
	*/
	private String description;
	/**
	*����ʱ��
	*/
	private String start_Time;
	/**
	*����ʱ��
	*/
	private String spend_Time;
	/**
	*��·��
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
	*��������
	*/
	private String method;
	/**
	*IP��ַ
	*/
	private String ip;
	/**
	*�������
	*/
	private String parameter;
	/**
	*���󷵻صĽ��
	*/
	private String result;
}
