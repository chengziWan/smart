package com.suresec.smart.dao;

import org.springframework.data.repository.CrudRepository;

import com.suresec.smart.entity.commom.Sys_logs;

/**
 * ע�⣺
 * 1.����������interface������class
 * 
 * 2.CrudRepository����ķ��ͣ���һ����ʵ���࣬�ڶ���������������
 * 
 * 3.����crudRepository �����Ѿ���һЩ�ӿ��ˣ���deleteAll��findOne�ȣ� ����ֱ�ӵ��ü���
 * 
 * 4.��Ȼ������Ҳ���Ը����Լ��������ʵ���Լ��Ľӿ�,�������getUser()������jpql����hql�����
 * 
 * */
public interface Sys_logsDao extends CrudRepository<Sys_logs,String>{
	/**
     * ��������ֻ��Ҫд�ӿڣ�����Ҫдʵ�֣�spring boot���æ�Զ�ʵ��
     * 
     * */
    
//    @Query("from Sys_users where id =:id ")
//    public Sys_users getUser(@Param("id") String id);

}
