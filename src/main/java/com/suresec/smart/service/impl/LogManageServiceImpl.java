package com.suresec.smart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresec.smart.dao.Sys_logsDao;
import com.suresec.smart.entity.commom.Sys_logs;
import com.suresec.smart.service.LogManageService;
/**
 * 
 * @author wcc
 * @time 2019-10-10 14:04
 * @description
 */

@Service
public class LogManageServiceImpl implements LogManageService {
	@Autowired
    private Sys_logsDao logManageDao;
	
	/**
	 * 
	 * @author wcc
	 * @time 2019-10-14 14:25
	 * @description 插入
	 */
	@Transactional
	public void inserLog(Sys_logs log) {
		logManageDao.save(log);
	}

}
