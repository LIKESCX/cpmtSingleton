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
public class ExcQueryTask {
	private final static Logger logger = LoggerFactory.getLogger(ExcQueryTask.class);
	  @Value("${cpmt.biz.url}")
	    private String URL;
	  @Autowired
	    private RestTemplate bizTemplate;
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	    //@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	    //@Scheduled(cron = "0 0 1 ? * MON")//表示每周一凌晨1点执行作业
	    @Scheduled(cron = "0 0 0 ? * MON")//表示每周一凌晨零点执行作业
	  	//1.充电站信息查询
	    public void queryStationInfo() {
	    	 String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	    	 try {
	    		int pageNo =1;
	    		int pageSize =10;
	    	
	             String url = URL+"/exchange/collect/query_stations_info_task?lastQueryTime=&pageNo="+pageNo+"&pageSize="+pageSize;
	          
	             logger.info("***** "+url);
	             new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	             logger.info("query_stations_info_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	         } catch (Exception e) {
	             logger.error("queryStationInfo===>>>task monStatusHourStat： "+taskTime,e);
	         }
	    }
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	//@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	  	//2.充电设备状态查询
	  	public void queryStationStatus() {
	  		String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_station_status_task";
	  			logger.info("***** "+url);
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("query_station_status_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryStationStatus===>>>task monStatusHourStat： "+taskTime,e);
	  		}
	  	}
	  	/**
	  	 *3.查询充电站充电记录
	  	 */
	  	//@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	@Scheduled(cron = "0 0 1 * * ? ")//每天凌晨一点执行
	   	public void queryStationChargeStat() {
	  		  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_station_charge_stats_task";
	  			 
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("queryStationChargeStat 任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryStationChargeStat===>>>task queryStationChargeStat： " ,e);
	  		}
	  	}
	  	
	  	/**
	  	 *4.查询充电站放电记录
	  	 */
	   	//@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	@Scheduled(cron = "0 0 1 * * ? ")//每天凌晨一点执行
	  	public void queryStationDisChargeStat() {
	  		  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_station_disCharge_stats_task";
	  			 
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("queryStationDisChargeStat 任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryStationDisChargeStat===>>>task queryStationDisChargeStat： " ,e);
	  		}
	  	}
	  	
	  	/**
	  	 *5.过程信息查询
	  	 */
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	//(cron = "0 0 */1 * * ? ")//每一小时执行一次
	  	public void queryBmsInfo() {
	  		String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);	  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_bms_info_task";
	  			logger.info("***** "+url);
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("query_bms_info_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryBmsInfo===>>>task monStatusHourStat： "+taskTime,e);
	  		}
	  	}
	  	
	  	/**
	  	 *6.告警信息查询
	  	 */
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	//@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	  	public void queryAlarmInfo() {
	  		String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);	  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_alarm_info_task";
	  			logger.info("***** "+url);
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("query_alarm_info_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryAlarmInfo===>>>task monStatusHourStat： "+taskTime,e);
	  		}
	  	}
	  	
	  	/**
	  	 *7.事件信息查询
	  	 */
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	//@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	  	public void queryEventInfo() {
	  		String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);	  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_event_info_task";
	  			logger.info("***** "+url);
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("query_event_info_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryEventInfo===>>>task monStatusHourStat： "+taskTime,e);
	  		}
	  	}
	  	
	  	/**
	  	 *8.配电信息查询
	  	 */
	    //@Scheduled(cron = "*/30 * * * * ?")//每隔30秒执行一次 测试
	  	//@Scheduled(cron = "0 0 */1 * * ? ")//每一小时执行一次
	  	public void queryDisequipmentstatusInfo() {
	  		String taskTime = TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR);	  		
	  		try {	  			
	  			String url = URL+"/exchange/collect/query_disequipmentstatus_info_task";
	  			logger.info("***** "+url);
	  			new Dispatcher(bizTemplate).doPost(url, Object.class, "");
	  			logger.info("query_disequipmentstatus_infoo_task任务调度成功，时间是："+TimeConvertor.getDate(TimeConvertor.FORMAT_MINUS_24HOUR));
	  		} catch (Exception e) {
	  			logger.error("queryDisequipmentstatusInfo===>>>task monStatusHourStat： "+taskTime,e);
	  		}
	  	}
}