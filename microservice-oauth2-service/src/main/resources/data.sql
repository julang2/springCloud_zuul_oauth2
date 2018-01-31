/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.16.243_3306
 Source Server Type    : MySQL
 Source Server Version : 50629
 Source Host           : 192.168.16.243:3306
 Source Schema         : eeee

 Target Server Type    : MySQL
 Target Server Version : 50629
 File Encoding         : 65001

 Date: 30/01/2018 16:55:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `activated` tinyint(1) NULL DEFAULT 1 COMMENT '账号是否激活',
  `create_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reset_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号重置/修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1791976485', 'admin', '$2a$10$0N52pv0c.ttpMGRzfP2Dx.4YBcXAMJDhMeeq044CfsgkCctOih3Le', 'string', 1, '2017-09-19', '2017-10-10');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `role` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表 {ROLE_ADMIN,ROLE_USER,ROLE_ANONYMOUS}' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1791976485', 'ROLE_ADMIN');

SET FOREIGN_KEY_CHECKS = 1;
