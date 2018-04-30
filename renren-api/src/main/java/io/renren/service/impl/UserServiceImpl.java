/**
 * Copyright 2018 blockeeper
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;

import io.renren.common.exception.RRException;
import io.renren.common.utils.RedisUtils;
import io.renren.common.validator.Assert;
import io.renren.dao.UserDao;
import io.renren.entity.TokenEntity;
import io.renren.entity.UserEntity;
import io.renren.form.LoginForm;
import io.renren.service.TokenService;
import io.renren.service.UserService;

import org.apache.catalina.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public UserEntity queryByMail(String mail) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMail(mail);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public UserEntity queryByAddress(String Address) {
		UserEntity userEntity = new UserEntity();
		userEntity.setAddress(Address);
		;
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public Map<String, Object> login(LoginForm form) {
		UserEntity userEntity = null;
		String mail = form.getEmail();
		String address = form.getAddress();
		if (StringUtils.isNotEmpty(mail)) {
			userEntity = queryByMail(mail);
			if (userEntity == null) {
				userEntity = new UserEntity();
				userEntity.setMail(mail);
				userEntity.setUsername(form.getName());
				baseMapper.insert(userEntity);
			}

		} else if (StringUtils.isNotEmpty(address)) {
			userEntity = queryByAddress(address);
			if (address == null) {
				userEntity = new UserEntity();
				userEntity.setAddress(address);
				baseMapper.insert(userEntity);
			}

		} else {
			throw new RRException("手机号或密码错误");

		}

		// 获取 Logintoken
		TokenEntity tokenEntity = tokenService.createToken(userEntity.getUserId());
		redisUtils.set(tokenEntity.getToken(), userEntity);
		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}

}
