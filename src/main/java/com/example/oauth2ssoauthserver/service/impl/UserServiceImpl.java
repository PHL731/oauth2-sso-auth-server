package com.example.oauth2ssoauthserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oauth2ssoauthserver.entity.SysUser;
import com.example.oauth2ssoauthserver.mapper.UserMapper;
import com.example.oauth2ssoauthserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
}
