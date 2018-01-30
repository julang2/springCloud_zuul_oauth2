package com.hfcsbc.service;


import com.hfcsbc.domain.SystemUser;

import java.util.Optional;

/**
 * Created by Joeysin on  2017/8/18  上午10:47.
 * Describe：系统用户
 */
public interface SystemUserService {

    Optional<SystemUser> findOneWithAuthoritiesByLogin(String name);


}
