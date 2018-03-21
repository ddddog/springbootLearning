package com.github.ddddog.springbootLearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ddddog.springbootLearning.common.entity.Log;
import com.github.ddddog.springbootLearning.mapper.common.LogMapper;

@Service  
public class LogService {
	@Autowired
	private LogMapper logMapper;
	
	public void info(String message){
		Log log =new Log();
		log.setMessage(message);
		this.logMapper.insert(log);
	}

}
