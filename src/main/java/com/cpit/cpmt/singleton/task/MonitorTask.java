package com.cpit.cpmt.singleton.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 **/
@Service
public class MonitorTask {

    private final static Logger logger = LoggerFactory.getLogger(MonitorTask.class);

    @Value("${cpmt.biz.url}")
    private String URL;

    @Autowired
    private RestTemplate bizTemplate;

    @Scheduled(cron = "0 0 1 * * ?")
    public void job(){

    }
    
}
