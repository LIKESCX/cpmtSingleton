package com.cpit.cpmt.singleton.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cpit.common.Dispatcher;
import com.cpit.common.TimeConvertor;

@Service
public class OperatorStatusTask {
	
	private final static Logger logger = LoggerFactory.getLogger(OperatorStatusTask.class);
	
	@Value("${cpmt.biz.url}")
	private String URL;
	
	@Autowired
	private RestTemplate bizTemplate;
	  
	@Scheduled(cron = "0 03 0 1 * ?")
	public void updateOperatorStatusByFixedCycle() {
		try {
			String url = URL+"/exchange/operator/updateOperatorStatusByFixedCycle";
			new Dispatcher(bizTemplate).doGet(url, Boolean.class,null);
		} catch (Exception e) {
			logger.error("updateOperatorStatusByFixedCycle error:"+e);
		}
	}
	 
}
