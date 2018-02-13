--  Users表
--pk 165d74333ecd32a6f43cf8b3323cdd0e2117f9cc88ef543362462356eb628066
CREATE TABLE `tb_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50)  COMMENT ' Users名',
  `mobile` varchar(20)   COMMENT '手机号',
  `password` varchar(64) COMMENT '密码',
  `create_time` datetime COMMENT '创建 time ',
   
  


 `address` varchar(40) COMMENT 'address',
  `trackAddress` json  COMMENT 'trackAddress',
  `lables` json   COMMENT 'lables',
  `transactions` json COMMENT 'transactions ',
   `ip` varchar(24) COMMENT 'ip',
   `last_time` int COMMENT 'last login time ',


  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' Users';

--  UsersToken表
CREATE TABLE `tb_token` (
  `user_id` bigint NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime COMMENT '过期 time ',
  `update_time` datetime COMMENT '更新 time ',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' UsersToken';

-- 账号：13612345678  密码：admin
INSERT INTO `tb_user` (`username`, `mobile`, `password`, `create_time`,`address`) VALUES ('mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41','93F2c779f043BD4e3d11d61ceB5d9B47CFF2d903');
