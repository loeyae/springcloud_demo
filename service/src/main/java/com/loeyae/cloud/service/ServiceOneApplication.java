package com.loeyae.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @date 2020-04-24 17:49
 * @version 0.0.1
 * @author ZhangYi<loeyae@gmaol.com>
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

}
