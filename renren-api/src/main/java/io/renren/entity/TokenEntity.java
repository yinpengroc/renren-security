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

package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;



/**
 *  UsersToken
 * 
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:22:07
 */
@TableName("tb_token")
public class TokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *  UsersID
	 */
	@TableId(type=IdType.INPUT)
	private Long userId;
	private String token;
	/**
	 * 过期 time 
	 */
	private Date expireTime;
	/**
	 * 更新 time 
	 */
	private Date updateTime;

	/**
	 *  config ： UsersID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取： UsersID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 *  config ：token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：token
	 */
	public String getToken() {
		return token;
	}
	/**
	 *  config ：过期 time 
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：过期 time 
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 *  config ：更新 time 
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新 time 
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
