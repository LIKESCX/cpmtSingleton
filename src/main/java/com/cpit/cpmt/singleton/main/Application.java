package com.cpit.cpmt.singleton.main;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//只能启动单例模式
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableHystrix
@EnableScheduling
@MapperScan(basePackages = "com.cpit.cpmt", annotationClass = com.cpit.common.MyBatisDao.class)
@ComponentScan(basePackages = { "com.cpit" })
public class Application {
	private final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "true");
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		System.out.println("start cpmt singleton docker processing job...");
		logger.info("start cpmt singleton docker processing job...");
	}

}
