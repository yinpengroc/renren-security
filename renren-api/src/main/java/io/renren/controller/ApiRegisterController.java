package io.renren.controller;


import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.UserEntity;
import io.renren.form.RegisterForm;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *  Registerinterface
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/api")
@Api(tags=" Registerinterface")
public class ApiRegisterController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation(" Register")
    public R register(@RequestBody RegisterForm form){
        // Formvalidate
        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.insert(user);

        return R.ok();
    }
}
