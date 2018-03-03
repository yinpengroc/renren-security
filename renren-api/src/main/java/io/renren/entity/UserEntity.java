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

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 *  Users
 * 
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:22:06
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public List<LabelEntity> getLabels() {
		return labels;
	}
	public void setLabels(List<LabelEntity> labels) {
		this.labels = labels;
	}
	public List<TaxEntity> getTax() {
		return tax;
	}
	public void setTax(List<TaxEntity> tax) {
		this.tax = tax;
	}
	public List<TsEntity> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TsEntity> transactions) {
		this.transactions = transactions;
	}
	public String getTrackAddress() {
		return trackAddress;
	}
	public void setTrackAddress(String trackAddress) {
		this.trackAddress = trackAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDevice() {
		return device;
	}
	public void setDevice(int device) {
		this.device = device;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private List<LabelEntity> labels;
	private List<TaxEntity> tax;
	private List<TsEntity>transactions;
	private String trackAddress;
	private String address;
	private int device;
	private String ip;
	/**
	 *  UsersID
	 */
	@TableId
	private Long userId;
	/**
	 *  Users名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	@JSONField(serialize=false)
	private String password;
	/**
	 * 创建 time 
	 */
	private Date createTime;

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
	 *  config ： Users名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取： Users名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 *  config ：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 *  config ：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *  config ：创建 time 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建 time 
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
