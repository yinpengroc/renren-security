package io.renren.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.renren.common.utils.IpAdrressUtil;

public class BaseController {
	public final Logger logger = LoggerFactory.getLogger(BaseController.class);
	private String ip = null;

	String getIp(HttpServletRequest request) {
		if (this.ip == null) {
			this.ip = IpAdrressUtil.getIpAdrress(request);
		}
		return this.ip;

	}

	private int device = 0;

	int getDevice(HttpServletRequest request) {
		if (this.device == 0) {
			String User_Agent = request.getHeader("User-Agent");
			int dev = 0;
			if (User_Agent.contains("Android") || User_Agent.contains("Linux")) {
				dev = 1;
				System.out.println("Android移动客户端");
				if (User_Agent.contains("MicroMessenger")) {
					dev = 2;
					System.out.println("微信");
				}
			} else if (User_Agent.contains("iPhone")) {
				dev = 3;
				System.out.println("iPhone移动客户端");

			} else if (User_Agent.contains("iPad")) {
				dev = 4;
				System.out.println("iPad客户端");

			} else if (User_Agent.contains("Windows")) {
				dev = 5;
				System.out.println("Windows");
			}
			this.device = dev;
		}
		return this.device;
	}

}
