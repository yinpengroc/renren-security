package io.renren.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.renren.common.utils.R;
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
public class ApiLoginController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	// @Autowired
	// private RedisUtils redisUtils;

	@PostMapping("login")
	@ApiOperation("login")
	public R login(@RequestBody LoginForm form,HttpServletRequest request,HttpServletResponse response) {
		 Map<String, Object> map=null;
//		 System.out.println(getIp(request)+"mail:"+form.getAddress()+"address:"+form.getEmail());
     try {
    	  map = userService.login(form,getIp(request),getDevice(request));
	} catch (Exception e) {
		// TODO: handle exception
		  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		  logger.warn(getIp(request)+e.getMessage());
		return R.error(4, "the input is error");
	}
		
        
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
