package io.renren.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 *  Logininterface
 *
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags=" Logininterface")
public class ApiLoginController  {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
   	private RedisUtils redisUtils;
 


    @PostMapping("login")
    @ApiOperation(" Login")
    public R login(@RequestBody LoginForm form){
        // Formvalidate
       // ValidatorUtils.validateEntity(form);
        // Users Login
        UserEntity userEntity= new UserEntity();
        userEntity.setUsername("test1234");
        redisUtils.set("12345", userEntity);
        
        
       // Map<String, Object> map = userService.login(form);
        Map<String, Object> map =new HashMap();
        map.put("key", "12345");
        
        

        return R.ok(map);
    }

  
   
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }


}
