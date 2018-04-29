mvn package
scp /Users/peng/project/renren-security/renren-api/target/renren-api.jar root@45.32.120.137:/opt
ssh  root@45.32.120.137

#!/bin/bash  
  
#ssh -f -n -l www-online 192.168.110.34 "/home/www-online/uptimelog.sh &" # 后台运行ssh  
  
# pid=$(ps aux | grep "ssh root@45.32.120.137 /opt/restart.sh" | awk '{print $2}' | sort -n | head -n 1) # 获取进程号  
  
# echo "ssh command is running, pid:${pid}"  
  
# sleep 3 && kill ${pid} && echo "ssh command is complete" # 延迟3秒后执行kill命令，关闭ssh进程，延迟时间可以根据调用的命令不同调整  
  
# exit 0 