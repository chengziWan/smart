package com.suresec.smart.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.suresec.smart.entity.commom.Sys_menus;

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
public interface Sys_menusDao extends CrudRepository<Sys_menus,String>{
	@Query("from Sys_menus where parent_id =:parent_id ")
	public Iterable<Sys_menus> findByParentId(@Param("parent_id") String parent_id);

}
