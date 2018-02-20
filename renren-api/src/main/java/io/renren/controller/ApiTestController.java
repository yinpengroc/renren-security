package io.renren.controller;


import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 测试interface
 *
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试interface")
public class ApiTestController {

    @Login
    @GetMapping("userInfo")
    @ApiOperation(value="获取 Users信息", response=UserEntity.class)
    public R userInfo(@ApiIgnore @LoginUser UserEntity user){
        return R.ok().put("user", user);
    }
    
  
    
    

    @Login
    @GetMapping("userId")
    @ApiOperation("获取 UsersID")
    public R userInfo(@ApiIgnore @RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

	@RequestMapping(value = { "/version", "/versiontest" }, method = RequestMethod.GET)
	@ResponseBody 
    public R getVersion(HttpServletResponse rs) {
    	rs.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return R.ok().put("msg", "version:1.1");
	}
    
    
    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    
    public R notToken(HttpServletResponse rs){
    	rs.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	//rs.setStatus(sc);
        return R.ok().put("msg", "withour token");
    }

}
