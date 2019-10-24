package com.suresec.smart.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.suresec.smart.entity.commom.Sys_users;

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
public interface Sys_usersDao extends CrudRepository<Sys_users,String>{
	/**
     * ��������ֻ��Ҫд�ӿڣ�����Ҫдʵ�֣�spring boot���æ�Զ�ʵ��
     * 
     * */
    
    @Query("from Sys_users where id =:id ")
    public Sys_users getUser(@Param("id") String id);

}
