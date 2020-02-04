package com.cpit.cpmt.singleton.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 用于调用其他微服务，参考注释
 *
 */
@Configuration
public class LoadBalance {


	@Bean
	@LoadBalanced
	public RestTemplate bizTemplate() {
		return new RestTemplate();
	}

}
