rm -rf out.file
ps -ef | grep java 
pkill java
pkill tomcat
pkill renren-api
java -jar renren-api.jar > out.file  2>&1 & 
