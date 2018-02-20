package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.renren.config.ApiYmlConfig;


@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"io.renren.dao"})
@EnableConfigurationProperties({ApiYmlConfig.class}) 
public class ApiApplication extends SpringBootServletInitializer {
 
    

	public static void main(String[] args) {

		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiApplication.class);
	}
}
