package com.hfcsbc.security;

import com.hfcsbc.dao.SystemUserDao;
import com.hfcsbc.domain.SystemUser;
import com.hfcsbc.service.SystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Joeysin on 2017/6/9.
 */
//@Service("userDetailsService")
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserService systemUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUser> userFromDatabase = systemUserService.findOneWithAuthoritiesByLogin(username);//通过账号查询
        return userFromDatabase.map(user -> {
            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getRole()))//role化。。。把role交由Authorition
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(username,
                    user.getPassword(),
                    grantedAuthorities);//返回一个 authorization封装的（账号，密码，角色） 对象
        }).orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not found in the " +
                "database"));//数据库不存在此账号
    }
}
