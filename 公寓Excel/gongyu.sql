/*
Navicat MySQL Data Transfer

Source Server         : zheng
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : gongyu

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-31 12:35:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_administrator
-- ----------------------------
DROP TABLE IF EXISTS `tbl_administrator`;
CREATE TABLE `tbl_administrator` (
  `adm_id` int(11) NOT NULL AUTO_INCREMENT,
  `adm_user` varchar(20) NOT NULL,
  `adm_pass` varchar(20) DEFAULT '000000',
  PRIMARY KEY (`adm_id`),
  UNIQUE KEY `adm_user` (`adm_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_check
-- ----------------------------
DROP TABLE IF EXISTS `tbl_check`;
CREATE TABLE `tbl_check` (
  `check_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_id` int(11) NOT NULL,
  `stu_id` int(11) NOT NULL,
  `check_in_time` datetime DEFAULT NULL,
  `check_out_time` datetime DEFAULT NULL,
  `check_state` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`check_id`),
  KEY `stu_id` (`stu_id`),
  KEY `dorm_id` (`dorm_id`),
  CONSTRAINT `tbl_check_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tbl_student` (`stu_id`),
  CONSTRAINT `tbl_check_ibfk_2` FOREIGN KEY (`dorm_id`) REFERENCES `tbl_dorm` (`dorm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_dorm
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dorm`;
CREATE TABLE `tbl_dorm` (
  `dorm_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_name` varchar(20) NOT NULL,
  `dorm_state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dorm_id`),
  UNIQUE KEY `dorm_name` (`dorm_name`)
) ENGINE=InnoDB AUTO_INCREMENT=676 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_faculty
-- ----------------------------
DROP TABLE IF EXISTS `tbl_faculty`;
CREATE TABLE `tbl_faculty` (
  `fac_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_name` varchar(20) NOT NULL,
  PRIMARY KEY (`fac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_registration
-- ----------------------------
DROP TABLE IF EXISTS `tbl_registration`;
CREATE TABLE `tbl_registration` (
  `reg_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `reg_time` datetime NOT NULL,
  `reg_state` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`reg_id`),
  KEY `stu_id` (`stu_id`),
  CONSTRAINT `tbl_registration_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tbl_student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_specialty
-- ----------------------------
DROP TABLE IF EXISTS `tbl_specialty`;
CREATE TABLE `tbl_specialty` (
  `spe_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_id` int(11) NOT NULL,
  `spe_name` varchar(20) NOT NULL,
  PRIMARY KEY (`spe_id`),
  UNIQUE KEY `spe_name` (`spe_name`),
  KEY `fac_id` (`fac_id`),
  CONSTRAINT `tbl_specialty_ibfk_1` FOREIGN KEY (`fac_id`) REFERENCES `tbl_faculty` (`fac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_student
-- ----------------------------
DROP TABLE IF EXISTS `tbl_student`;
CREATE TABLE `tbl_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(12) DEFAULT NULL,
  `stu_period` varchar(10) DEFAULT NULL,
  `stu_name` varchar(20) DEFAULT NULL,
  `spe_id` int(11) DEFAULT NULL,
  `stu_birthday` date DEFAULT NULL,
  `stu_sex` bit(1) DEFAULT NULL,
  `stu_phone` varchar(11) DEFAULT NULL,
  `stu_picture` varchar(255) DEFAULT NULL,
  `stu_address` varchar(255) DEFAULT NULL,
  `stu_state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `stu_no` (`stu_no`),
  KEY `spe_id` (`spe_id`),
  CONSTRAINT `tbl_student_ibfk_1` FOREIGN KEY (`spe_id`) REFERENCES `tbl_specialty` (`spe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `dId` int(11) NOT NULL,
  `dName` varchar(255) DEFAULT NULL,
  `dPass` varchar(255) DEFAULT NULL,
  `dAge` int(11) DEFAULT NULL,
  `dSex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_visit
-- ----------------------------
DROP TABLE IF EXISTS `tbl_visit`;
CREATE TABLE `tbl_visit` (
  `vis_id` int(11) NOT NULL AUTO_INCREMENT,
  `vis_name` varchar(20) NOT NULL,
  `vis_card` varchar(18) NOT NULL,
  `vis_time` datetime NOT NULL,
  `stu_id` int(11) NOT NULL,
  `vis_description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`vis_id`),
  KEY `stu_id` (`stu_id`),
  CONSTRAINT `tbl_visit_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tbl_student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
