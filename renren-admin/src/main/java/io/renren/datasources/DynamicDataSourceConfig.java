package io.renren.datasources;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 配置多数据源
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017/8/19 0:41
 */
@Configuration
public class DynamicDataSourceConfig {

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.first")
//    public DataSource firstDataSource(){
//    	return DruidDataSourceBuilder.create().build();
//    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource secondDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
	
	
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public DataSource firstDataSource() throws SQLException {
//        return  new HikariDataSource();
//    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}
