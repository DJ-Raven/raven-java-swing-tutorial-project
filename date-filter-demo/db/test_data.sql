/*
Navicat MySQL Data Transfer

Source Server         : SERVER-3305
Source Server Version : 50620
Source Host           : localhost:3305
Source Database       : test_data

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2024-05-22 22:32:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `InvoiceID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `InvoiceNumber` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Total` float(10,2) DEFAULT NULL,
  `Cost` float(10,2) DEFAULT NULL,
  `Profit` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`InvoiceID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
