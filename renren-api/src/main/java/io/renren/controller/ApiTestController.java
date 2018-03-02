package io.renren.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.entity.UserEntity;
import io.renren.service.TransactionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 测试interface
 *
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api(tags = "blockeeper test")
public class ApiTestController {

	@Autowired
	private TransactionsService transactionsService;

	@Login
	@GetMapping("userInfo")
	@ApiOperation(value = "获取 Users信息", response = UserEntity.class)
	public R userInfo(@ApiIgnore @LoginUser UserEntity user) {
		return R.ok().put("user", user);
	}

	@Login
	@GetMapping("userId")
	@ApiOperation("获取 UsersID")
	public R userInfo(@ApiIgnore @RequestAttribute("userId") Integer userId) {
		return R.ok().put("userId", userId);
	}

	@CrossOrigin
	@RequestMapping(value = { "/version" }, method = RequestMethod.GET)
	@ResponseBody
	public R getVersion(HttpServletResponse rs) {
		rs.setStatus(HttpServletResponse.SC_OK);
		return R.ok().put("msg", "version:1.1");
	}

	@CrossOrigin
	@RequestMapping(value = { "/balance/{address}" }, method = RequestMethod.GET)
	@ResponseBody
	public R getBalanceByAddress(HttpServletResponse rs) {
		rs.setStatus(HttpServletResponse.SC_OK);
		return R.ok().put("msg", "version:1.1");
	}

	@CrossOrigin
	@RequestMapping(value = { "/blockNumber" }, method = RequestMethod.GET)
	@ResponseBody
	public R getblockNumber(HttpServletResponse rs) {
		rs.setStatus(HttpServletResponse.SC_OK);
		Map<String, Object> map = transactionsService.getCurrentBlockNumber();
		return R.ok(map).put("msg", "this is success");
	}
	
	

	@CrossOrigin
	@RequestMapping(value = { "/gasPrice" }, method = RequestMethod.GET)
	@ResponseBody
	public R getGasPrice(HttpServletResponse rs) {
		rs.setStatus(HttpServletResponse.SC_OK);
		Map<String, Object> map = transactionsService.getgasPrice();
		return R.ok(map).put("msg", "this is success");
	}
	
	
	
	

	@GetMapping("notToken")
	@ApiOperation("忽略Token验证测试")

	public R notToken(HttpServletResponse rs) {
		rs.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		// rs.setStatus(sc);
		return R.ok().put("msg", "withour token");
	}

}
