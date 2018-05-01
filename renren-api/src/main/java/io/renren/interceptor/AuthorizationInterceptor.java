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

package io.renren.interceptor;


import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.renren.common.exception.RRException;
import io.renren.common.utils.RedisUtils;
import io.renren.entity.UserEntity;

/**
 * 权限(Token)验证
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    private TokenService tokenService;

    public static final String USER_KEY = "userInfo";
    @Autowired
	private RedisUtils redisUtils;
	private static final Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String ip = request.getRemoteAddr();
		long startTime = System.currentTimeMillis();
		request.setAttribute("requestStartTime", startTime);
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// // 获取用户token
		Method method = handlerMethod.getMethod();
		// System.out.println();
		log.info("用户:" + ip + ",访问目标:" + method.getName());

		// 从header中获取token
		String token = request.getHeader("Authorization");
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter("Authorization");
		}

		// token为空
		if (StringUtils.isBlank(token)) {
			throw new RRException("token can not empty", 400);
		}

		// //查询token信息
		// TokenEntity tokenEntity = tokenService.queryByToken(token);
		// if(tokenEntity == null || tokenEntity.getExpireTime().getTime() <
		// System.currentTimeMillis()){
		// throw new RRException("token Unauthorized，please reLogin",401);
		// }
		//
		// // we can put userid into rquest or user entity
		// request.setAttribute(USER_KEY, tokenEntity.getUserId());

		UserEntity user = (UserEntity) redisUtils.get(token, UserEntity.class);
		// String user =redisUtils.get(token);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			throw new RRException("without autority", 401);
		}

		request.setAttribute(USER_KEY, user);

		return true;
	}
    
    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        long startTime = (Long) request.getAttribute("requestStartTime");
 
        long endTime = System.currentTimeMillis();
 
        long executeTime = endTime - startTime;
         System.out.println("this invoked the post");
        // log it
        if (executeTime > 1000) {
            System.out.println("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        } else {
            System.out.println("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        }
 
    }
    
}
