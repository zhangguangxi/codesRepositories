/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.103(pc)
Source Server Version : 50712
Source Host           : 192.168.1.103:3306
Source Database       : clinic

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-05 18:38:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `id` int(11) NOT NULL COMMENT '自增逐渐id',
  `name` char(50) NOT NULL COMMENT '姓名',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(10) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生表';

-- ----------------------------
-- Records of t_doctor
-- ----------------------------

-- ----------------------------
-- Table structure for t_medication
-- ----------------------------
DROP TABLE IF EXISTS `t_medication`;
CREATE TABLE `t_medication` (
  `id` int(11) NOT NULL COMMENT '自增主键id',
  `useage` tinyint(4) NOT NULL COMMENT '用量',
  `total_amt` decimal(10,0) NOT NULL COMMENT '处方金额(总金额)',
  `medcine_id` int(11) NOT NULL COMMENT '药品id',
  `symptoms_id` int(11) NOT NULL COMMENT '症状id',
  `doctor_id` int(11) NOT NULL COMMENT '医生id',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_medication_doctor` (`doctor_id`) USING BTREE,
  KEY `FK_Reference_medication_medicine` (`medcine_id`) USING BTREE,
  KEY `FK_Reference_medication_symptoms` (`symptoms_id`) USING BTREE,
  CONSTRAINT `t_medication_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `t_doctor` (`id`),
  CONSTRAINT `t_medication_ibfk_2` FOREIGN KEY (`medcine_id`) REFERENCES `t_medicine` (`id`),
  CONSTRAINT `t_medication_ibfk_3` FOREIGN KEY (`symptoms_id`) REFERENCES `t_symptoms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medication
-- ----------------------------

-- ----------------------------
-- Table structure for t_medicine
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE `t_medicine` (
  `id` int(11) NOT NULL COMMENT '自增主键id',
  `chinese_name` char(100) NOT NULL COMMENT '中文名称',
  `english_name` char(100) NOT NULL COMMENT '英文名称',
  `introduces_name` char(100) NOT NULL COMMENT '简述',
  `position` char(100) NOT NULL COMMENT '药品所在位置',
  `cost_price` decimal(10,0) NOT NULL COMMENT '成本价',
  `sale_price` decimal(10,0) NOT NULL COMMENT '售价',
  `inventory` int(11) NOT NULL COMMENT '库存',
  `comments` text NOT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine
-- ----------------------------

-- ----------------------------
-- Table structure for t_symptoms
-- ----------------------------
DROP TABLE IF EXISTS `t_symptoms`;
CREATE TABLE `t_symptoms` (
  `id` int(11) NOT NULL COMMENT '自增主键id',
  `patient_id` int(11) NOT NULL COMMENT '患者id',
  `description` text NOT NULL COMMENT '症状描述',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_symptoms_patient` (`patient_id`) USING BTREE,
  CONSTRAINT `t_symptoms_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='症状表';

-- ----------------------------
-- Records of t_symptoms
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `chinese_name` char(50) NOT NULL COMMENT '中文名',
  `english_name` char(50) DEFAULT NULL COMMENT '英文名',
  `pinying_name` char(50) NOT NULL COMMENT '拼音名',
  `id_card` char(18) NOT NULL COMMENT '身份证号',
  `sex` tinyint(4) NOT NULL COMMENT '性别',
  `nation` char(20) NOT NULL COMMENT '国籍',
  `birthday` date NOT NULL COMMENT '生日',
  `is_marry` tinyint(1) NOT NULL DEFAULT '0' COMMENT '婚否(0:未婚 1:已婚)',
  `phone` char(11) NOT NULL COMMENT '电话',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='患者表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张光喜', 'sky', 'zhangguangxi', '430426198805284816', '1', '中国', '1988-05-28', '0', '18612198768', '2016-06-05 18:06:21', '2016-06-05 18:06:21');
