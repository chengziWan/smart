package com.suresec.smart.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.suresec.smart.entity.commom.Sys_menus;

/**
 * 注意：
 * 1.这里这里是interface，不是class
 * 
 * 2.CrudRepository里面的泛型，第一个是实体类，第二个是主键的类型
 * 
 * 3.由于crudRepository 里面已经有一些接口了，如deleteAll，findOne等， 我们直接调用即可
 * 
 * 4.当然，我们也可以根据自己的情况来实现自己的接口,如下面的getUser()方法，jpql语句和hql语句差不多
 * 
 * */
public interface Sys_menusDao extends CrudRepository<Sys_menus,String>{
	@Query("from Sys_menus where parent_id =:parent_id ")
	public Iterable<Sys_menus> findByParentId(@Param("parent_id") String parent_id);

}
