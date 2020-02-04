package com.cpit.cpmt.singleton.task;

import com.cpit.common.Dispatcher;
import com.cpit.common.TimeConvertor;
import com.cpit.cpmt.dto.common.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.cpit.common.TimeConvertor.FORMAT_MINUS_24HOUR;

/*
* 安全监控定时任务
* */
@Service
public class SecurityMonitorTask {
    private final static Logger logger = LoggerFactory.getLogger(SecurityMonitorTask.class);

    @Value("${cpmt.biz.url}")
    private String URL;

    @Autowired
    private RestTemplate bizTemplate;

    @Scheduled(cron = "0 0 */1 * * * ")//每一小时执行一次
    //@Scheduled(cron = "0 */1 * * * * ")
    //1.统计过程信息参数阈值
    public void queryBmsInfo() {
        String date = TimeConvertor.getDate(FORMAT_MINUS_24HOUR);
        try {
            String url = URL+"/monitor/queryBmsAverageList";
            new Dispatcher(bizTemplate).doPost(url, Object.class, "");
            logger.info("queryBmsInfo-task successful :"+date);
        } catch (Exception e) {
            logger.error("queryBmsInfo-task error :"+date,e);
        }
    }

    //@Scheduled(cron = "0 0 */1 * * * ")//每一小时执行一次
    //@Scheduled(cron = "0 */1 * * * * ")
    //月初取最新的四条 定时生效阈值范围
    public void updateThresholdRange() {
        String date = TimeConvertor.getDate(FORMAT_MINUS_24HOUR);
        try {
            String url = URL+"/monitor/updateThresholdRange";
            new Dispatcher(bizTemplate).doGet(url, ResultInfo.class, null);
            logger.info("updateThresholdRange-task successful :"+date);
        } catch (Exception e) {
            logger.error("updateThresholdRange-task error :"+date,e);
        }
    }

}
