package com.suresec.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suresec.system.dao.Sys_logsDao;
import com.suresec.system.entity.Sys_logs;
import com.suresec.system.service.LogManageService;
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
