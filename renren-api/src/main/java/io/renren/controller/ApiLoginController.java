package io.renren.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.toolkit.StringUtils;

import io.renren.common.utils.IpAdrressUtil;
import io.renren.common.utils.R;
import io.renren.common.utils.RedisUtils;
import io.renren.entity.UserEntity;
import io.renren.form.LoginForm;
import io.renren.service.TokenService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Logininterface
 *
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags = " Logininterface")
public class ApiLoginController implements BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	// @Autowired
	// private RedisUtils redisUtils;

	@PostMapping("login")
	@ApiOperation("login")
	public R login(@RequestBody LoginForm form,HttpServletRequest request) {

		Map<String, Object> map = userService.login(form,IpAdrressUtil.getIpAdrress(request));

		return R.ok(map);
	}

	@PostMapping("logout")
	@ApiOperation("退出")
	public R logout(@ApiIgnore @RequestAttribute("userId") long userId) {
		tokenService.expireToken(userId);
		return R.ok();
	}

	// @PostMapping("google")
	// @ApiOperation("google login callback")
	// public void googleApi() {
	//
	// System.out.println("this is callback");
	//
	//
	//
	// }

}
