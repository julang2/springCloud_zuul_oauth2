package com.hfcsbc.domain; /***********************************************************************
 * Module:  UserRole.java
 * Author:  yao
 * Purpose: Defines the Class UserRole
 ***********************************************************************/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色表 {ROLE_ADMIN,ROLE_USER,ROLE_ANONYMOUS}
 *
 * @pdOid fc0a80d9-ccac-4c28-ac48-dbe8b8a24680
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    /**
     * @pdOid 268fdb16-e611-4494-8178-97c5139c3ec4
     */
    public String id;
    /**
     * @pdOid c0060b5a-5da7-415e-9442-d392e61c3224
     */
    public String userId;
    /**
     * @pdOid a36d3b61-f58d-436d-b978-4096302be587
     */
    public String role;

}