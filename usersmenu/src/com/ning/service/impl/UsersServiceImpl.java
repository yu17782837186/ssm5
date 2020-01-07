package com.ning.service.impl;

import com.ning.mapper.UsersMapper;
import com.ning.pojo.Users;
import com.ning.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;


    @Override
    public Users login(Users users) {
        return usersMapper.selByUsers(users);
    }
}
