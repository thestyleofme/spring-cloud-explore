/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql5.7.26
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : spring_cloud_explore

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 26/11/2020 01:49:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------

DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
`client_id` varchar(48) NOT NULL,
`resource_ids` varchar(256) DEFAULT NULL,
`client_secret` varchar(256) DEFAULT NULL,
`scope` varchar(256) DEFAULT NULL,
`authorized_grant_types` varchar(256) DEFAULT NULL,
`web_server_redirect_uri` varchar(256) DEFAULT NULL,
`authorities` varchar(256) DEFAULT NULL,
`access_token_validity` int(11) DEFAULT NULL,
`refresh_token_validity` int(11) DEFAULT NULL,
`additional_information` varchar(4096) DEFAULT NULL,
`autoapprove` varchar(256) DEFAULT NULL,
PRIMARY KEY (`client_id`)
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('c1', 'autodeliver,resume', 'secret', 'all', 'password,refresh_token', '', '', 7200, 259200, NULL, NULL);

-- ----------------------------
-- Table structure for users
-- ----------------------------

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `username` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                          `password` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------

INSERT INTO `spring_cloud_explore`.`users`(`id`, `username`, `password`) VALUES (1, 'admin', '123456');


SET FOREIGN_KEY_CHECKS = 1;
