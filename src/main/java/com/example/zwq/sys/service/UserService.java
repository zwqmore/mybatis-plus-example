package com.example.zwq.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zwq.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwq
 * @since 2022-01-04
 */
public interface UserService extends IService<User> {


	List<User> selectAll();

	List<User> selectByExample(QueryWrapper<User> qw);

	List<User> selectPageByExample(int current, int size, QueryWrapper<User> qw);

}
