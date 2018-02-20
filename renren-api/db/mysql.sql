--  Users表
--pk 165d74333ecd32a6f43cf8b3323cdd0e2117f9cc88ef543362462356eb628066
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL,
  `username` varchar(50) DEFAULT NULL COMMENT ' Users名',
  `mobile` varchar(20) DEFAULT NULL COMMENT 'phone',
  `mail` varchar(64) NOT NULL,
  `password` varchar(64) DEFAULT NULL COMMENT 'password',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建 time ',
  `address` varchar(40) DEFAULT NULL COMMENT 'address',
  `trackAddress` json DEFAULT NULL COMMENT 'trackAddress',
  `lables` json DEFAULT NULL COMMENT 'lables',
  `tax` json DEFAULT NULL,
  `transactions` json DEFAULT NULL COMMENT 'transactions ',
  `ip` varchar(24) DEFAULT NULL COMMENT 'ip',
  `last_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'last login time '
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
