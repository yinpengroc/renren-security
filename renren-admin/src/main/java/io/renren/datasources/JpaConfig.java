package io.renren.datasources;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
//@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class JpaConfig extends HikariConfig {

//    @Bean
//    public DataSource dataSource() throws SQLException {
//        return  new HikariDataSource(this);
//    }
    
	@Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public DataSource dataSource(DataSourceProperties properties){
        return DataSourceBuilder.create(properties.getClassLoader()).type(HikariDataSource.class)
                        .driverClassName(properties.determineDriverClassName())
                        .url(properties.determineUrl()).username(properties.determineUsername()).password(properties.determinePassword()).build();
    }

}