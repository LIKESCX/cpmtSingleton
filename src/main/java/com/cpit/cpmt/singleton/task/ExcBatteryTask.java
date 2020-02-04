package com.cpit.cpmt.singleton.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cpit.common.Dispatcher;
import com.cpit.common.TimeConvertor;

/**
 * 定时查询任务
 * @author admin
 *
 */
@Service
public class ExcBatteryTask {
	private final static Logger logger = LoggerFactory.getLogger(ExcBatteryTask.class);
	  @Value("${cpmt.biz.url}")
	    private String URL;
	  @Autowired
	    private RestTemplate bizTemplate;
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	    //@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	    //@Scheduled(cron = "0 0 1 ? * MON")//表示每周一凌晨1点执行作业
	    @Scheduled(cron = "0 0 0 ? * MON")//表示每周一凌晨零点执行作业
	  	//1.执行天的任务
	    public void excBatteryDayTask() {
	    	 String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	 try {
	    	
	             String url = URL+"/battery/excBatteryDayTask";
	          
	             logger.info("***** "+url);
	             new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	             logger.info("excBatteryDayTask任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	         } catch (Exception e) {
	             logger.error("excBatteryDayTask===>>>:"+taskTime,e);
	         }
	    }
	    //2.执行周的任务
	    public void excBatteryWeekTask() {
	    	String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	try {
	    		
	    		String url = URL+"/battery/excBatteryWeekTask";
	    		
	    		logger.info("***** "+url);
	    		new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	    		logger.info("excBatteryWeekTask任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	    	} catch (Exception e) {
	    		logger.error("excBatteryWeekTask===>>>:"+taskTime,e);
	    	}
	    }
	    
	    //3.执行月的任务
	    public void excBatteryMonthTask() {
	    	String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	try {

	    		String url = URL+"/battery/excBatteryMonthTask";
	    		
	    		logger.info("***** "+url);
	    		new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	    		logger.info("excBatteryMonthTask任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	    	} catch (Exception e) {
	    		logger.error("excBatteryMonthTask===>>>:"+taskTime,e);
	    	}
	    }
	    //4.执行季度的任务
	    public void excBatterySeasonTask() {
	    	String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	try {	
	    		
	    		String url = URL+"/battery/excBatterySeasonTask";
	    		
	    		logger.info("***** "+url);
	    		new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	    		logger.info("excBatterySeasonTask任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	    	} catch (Exception e) {
	    		logger.error("excBatterySeasonTask===>>>:"+taskTime,e);
	    	}
	    }
	    //1.执行年的任务
	    public void excBatteryYearTask() {
	    	String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	try {
	    		
	    		String url = URL+"/battery/excBatteryYearTask";
	    		
	    		logger.info("***** "+url);
	    		new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	    		logger.info("excBatteryYearTask任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	    	} catch (Exception e) {
	    		logger.error("excBatteryYearTask===>>>:"+taskTime,e);
	    	}
	    }

}