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

package io.renren.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import io.renren.entity.UserEntity;
import io.renren.form.LoginForm;

/**
 *  Users
 * 
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> ,BaseService{

	UserEntity queryByAddress(String Address);
	UserEntity queryByMail(String mail);

	/**
	 *  Users Login
	 * @param form     Login Form
	 * @return        返回 Login信息
	 */
	Map<String, Object> login(LoginForm form,String ip,int device) throws Exception;
	
	Map<String, Object> update(UserEntity User,String ip,int device,String key) throws Exception;
}
