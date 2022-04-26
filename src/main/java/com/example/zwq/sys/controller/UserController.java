package com.example.zwq.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zwq.sys.entity.User;
import com.example.zwq.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.zwq.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwq
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Object selectUserAll() {
		return userService.selectAll();
	}

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public Object selectUserByExample(String username) {
		QueryWrapper<User> qw = new QueryWrapper<>();
		qw.like("name", username);
		return userService.selectByExample(qw);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Object selectUserByExamplePage(int current, int size, String name) {
		QueryWrapper<User> qw = new QueryWrapper<>();
		if(name != null && !"".equals(name)) {
			qw.like("name", name);
		}
		return userService.selectPageByExample(current, size, qw);
	}
}

