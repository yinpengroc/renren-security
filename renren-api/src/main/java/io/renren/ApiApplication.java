package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import io.renren.config.ApiYmlConfig;


@SpringBootApplication
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
