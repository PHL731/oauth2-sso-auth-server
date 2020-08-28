package com.example.oauth2ssoauthserver.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.oauth2ssoauthserver.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        SysUser user = userService.getOne(queryWrapper);
        if (null == user) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }
//        List<SysPermission> permissionList = permissionService.findByUserId(sysUser.getId());
//        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
//        if (!CollectionUtils.isEmpty(permissionList)) {
//            for (SysPermission sysPermission : permissionList) {
//                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
//            }
//        }

//        MyUser myUser = new MyUser(user.getUserName(), passwordEncoder.encode(user.getUserPasswd()), authorityList);

        User myUser = new User(user.getUserName(), passwordEncoder.encode(user.getUserPasswd()), new ArrayList<>());
        log.info("登录成功！用户: {}", JSON.toJSONString(myUser));
        return myUser;
    }
}
