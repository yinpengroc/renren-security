package io.renren.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;



@PropertySource(value = { "config/api.properties" })
@ConfigurationProperties(prefix = "db")

public class ApiYmlConfig implements ApplicationListener<ApplicationEvent> {
	
	//@Value("${db.username}")
    private String username;

    //@Value("${db.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public void onApplicationEvent(ApplicationEvent event) {
        // 打印属性
		System.out.println("============= redisConnect ================");
		System.out.println(this.toString());
    }


	@Override
    public String toString() {
	    return "RedisConfiguration []";
    }
}

