package com.hfcsbc.domain; /***********************************************************************
 * Module:  SystemUser.java
 * Author:  yao
 * Purpose: Defines the Class SystemUser
 ***********************************************************************/

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/** 系统用户*/
@Data
public class SystemUser   {


   private String id;

   private String password;

   private String username;

   private String email;

   private Boolean activated;//0=禁用  1=正常

   private String createDate;

   private String resetDate = null;

   private Set<UserRole> authorities = new HashSet<UserRole>();
   //dto
   private String oldPassword;

}