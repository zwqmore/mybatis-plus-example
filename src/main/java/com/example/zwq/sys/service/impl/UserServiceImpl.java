package com.example.zwq.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zwq.sys.entity.User;
import com.example.zwq.sys.mapper.UserMapper;
import com.example.zwq.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2022-01-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> selectAll() {
		return userMapper.selectList(new QueryWrapper<>());
	}

	@Override
	public List<User> selectByExample(QueryWrapper<User> qw) {
		return userMapper.selectList(qw);
	}

	@Override
	public List<User> selectPageByExample(int current, int size, QueryWrapper<User> qw) {
		Page<User> userPage = new Page<>(current , size);
		IPage<User> userIPage = userMapper.selectPage(userPage,qw);
		System.out.println("总页数： "+userIPage.getPages());
		System.out.println("总记录数： "+userIPage.getTotal());
		userIPage.getRecords().forEach(System.out::println);
		return userIPage.getRecords();
	}
}
