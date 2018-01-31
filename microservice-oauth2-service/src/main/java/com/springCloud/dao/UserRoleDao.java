package com.springCloud.dao;

import com.springCloud.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Joeysin on  2017/8/18  上午10:22.
 * Describe：
 */
@Mapper
public interface UserRoleDao {
    UserRole getUserRoleById(String id);

}
