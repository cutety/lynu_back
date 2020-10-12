/*
Navicat MySQL Data Transfer

Source Server         : 39.97.178.218
Source Server Version : 50649
Source Host           : 39.97.178.218:3306
Source Database       : stu_it_info

Target Server Type    : MYSQL
Target Server Version : 50649
File Encoding         : 65001

Date: 2020-10-12 17:39:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply_info
-- ----------------------------
DROP TABLE IF EXISTS `apply_info`;
CREATE TABLE `apply_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `apply_preference` int(11) DEFAULT '0',
  `admission_major` varchar(50) NOT NULL,
  `region` varchar(10) DEFAULT NULL,
  `major_preference_first` varchar(45) DEFAULT '',
  `major_preference_second` varchar(45) DEFAULT '',
  `major_preference_third` varchar(45) DEFAULT '',
  `major_preference_forth` varchar(45) DEFAULT '',
  `major_preference_fifth` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2274 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for check_in_info
-- ----------------------------
DROP TABLE IF EXISTS `check_in_info`;
CREATE TABLE `check_in_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `stu_name` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `check_in_status` int(11) DEFAULT '0',
  `check_in_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2275 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(20) NOT NULL,
  `stu_name` varchar(10) NOT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `polical_status` varchar(45) DEFAULT NULL,
  `nation` varchar(4) DEFAULT NULL,
  `candidate_category` varchar(10) DEFAULT NULL,
  `graduated_school` varchar(45) DEFAULT NULL,
  `candidate_characteristics` varchar(20) DEFAULT NULL,
  `candidate_household_registry` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `candidate_result` int(11) NOT NULL,
  `grade` varchar(4) DEFAULT NULL,
  `adcode` varchar(10) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2274 DEFAULT CHARSET=utf8mb4;
