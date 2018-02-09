本地部署

创建数据库blockeeper，数据库编码为UTF-8
执行db/mysql.sql文件，初始化数据【按需导入表结构及数据】
修改application-dev.yml文件，更新MySQL账号和密码
在renren-security目录下，执行mvn clean install

Eclipse、IDEA运行AdminApplication.java，则可启动项目【renren-admin】
renren-admin访问路径：http://localhost:8080/renren-admin
swagger文档路径：http://localhost:8080/renren-admin/swagger/index.html
账号密码：admin/admin

Eclipse、IDEA运行ApiApplication.java，则可启动项目【renren-api】
renren-api访问路径：http://localhost:8081/renren-api/swagger-ui.html

Eclipse、IDEA运行GeneratorApplication.java，则可启动项目【renren-generator】
renren-generator访问路径：http://localhost:8082/renren-generator

分布式部署

分布式部署，需要安装redis，并配置config.properties里的redis信息
需要配置【renren.redis.open=true】，表示开启redis缓存
需要配置【renren.shiro.redis=true】，表示把shiro session存到redis里
