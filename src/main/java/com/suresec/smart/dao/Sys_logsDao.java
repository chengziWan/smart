package com.suresec.smart.dao;

import org.springframework.data.repository.CrudRepository;

import com.suresec.smart.entity.commom.Sys_logs;

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
public interface Sys_logsDao extends CrudRepository<Sys_logs,String>{
	/**
     * 我们这里只需要写接口，不需要写实现，spring boot会帮忙自动实现
     * 
     * */
    
//    @Query("from Sys_users where id =:id ")
//    public Sys_users getUser(@Param("id") String id);

}
