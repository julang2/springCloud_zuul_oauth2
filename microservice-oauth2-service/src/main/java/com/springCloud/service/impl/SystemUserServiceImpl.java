package com.springCloud.service.impl;

import com.google.common.collect.Sets;
import com.springCloud.dao.SystemUserDao;
import com.springCloud.dao.UserRoleDao;
import com.springCloud.domain.SystemUser;
import com.springCloud.domain.UserRole;
import com.springCloud.service.SystemUserService;
import com.springCloud.util.AuthoritiesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


/**
 * Created by Joeysin on  2017/8/18  上午10:49.
 * Describe：系统用户
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    private static final String ORIGINALPASSWORD = "111111";
    @Autowired
    private SystemUserDao systemUserDao;
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public Optional<SystemUser> findOneWithAuthoritiesByLogin(String name) {
        SystemUser user = systemUserDao.findSystenUserByname(name);
        if (user != null) {
            UserRole authority = userRoleDao.getUserRoleById(user.getId());
            if (authority != null) {
                Set set = Sets.newHashSet();
                set.add(authority);
                if (authority.getRole().equals(AuthoritiesConstants.ADMIN.trim())) {
                    set.add(new UserRole(null, null, AuthoritiesConstants.USER));
                    set.add(new UserRole(null, null, AuthoritiesConstants.ANONYMOUS));
                } else if (authority.getRole().equals(AuthoritiesConstants.USER.trim())) {
                    set.add(new UserRole(null, null, AuthoritiesConstants.ANONYMOUS));
                }
                user.setAuthorities(set);
            }
        }
        return Optional.ofNullable(user);
    }


}
