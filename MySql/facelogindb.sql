/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : facelogindb

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 11/02/2023 20:29:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `facial_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_nick_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_true_name` varchar(160) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_age` smallint(6) DEFAULT NULL,
  `user_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `reg_time` datetime(0) DEFAULT NULL,
  `last_login_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `idx_facialid`(`facial_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
