package io.renren.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 测试interface
 *
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")

@Api(tags = "blockeeper superController")
public class BaseController {

	public Object getUserByToken(@RequestHeader HttpHeaders headers) {

		String token =  headers.AUTHORIZATION;
		System.out.println("from request:" + token);
		if (token.isEmpty()) {
			return null;
		}
		return token;//redisUtils.get(token);

	}

	// @RequestHeader HttpHeaders headers
}
