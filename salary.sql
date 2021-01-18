/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : salary

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/01/2021 14:33:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dname` char(8) NOT NULL,
  `vocationsalary` int DEFAULT NULL,
  PRIMARY KEY (`dname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('广告', 800);
INSERT INTO `department` VALUES ('技术', 500);
INSERT INTO `department` VALUES ('海外', 2555);
INSERT INTO `department` VALUES ('研发', 8100);
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eno` char(8) NOT NULL,
  `ename` char(10) NOT NULL,
  `edept` char(10) DEFAULT NULL,
  `esex` char(2) DEFAULT NULL,
  `egrade` char(5) DEFAULT NULL,
  `erank` char(2) DEFAULT NULL,
  `eage` int DEFAULT NULL,
  `ewelfare` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`eno`),
  KEY `ename` (`ename`),
  KEY `eno` (`eno`,`ename`),
  KEY `de` (`edept`),
  CONSTRAINT `de` FOREIGN KEY (`edept`) REFERENCES `department` (`dname`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `employee_chk_1` CHECK (((`esex` = _utf8mb4'男') or (`esex` = _utf8mb4'女'))),
  CONSTRAINT `employee_chk_2` CHECK (((`erank` = _utf8mb4'A') or (`erank` = _utf8mb4'B') or (`erank` = _utf8mb4'C') or (`erank` = _utf8mb4'D')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES ('1', '管理员', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `employee` VALUES ('10001', '李华', '广告', '男', '员工', 'A', 2, '加班补贴');
INSERT INTO `employee` VALUES ('10002', '柯正', '海外', '男', '组长', 'A', 12, '节日');
INSERT INTO `employee` VALUES ('10003', '华盛', '技术', '男', '实习生', 'B', 0, '话费补贴');
INSERT INTO `employee` VALUES ('10004', '叶桦', '广告', '女', '员工', 'B', 2, '差旅');
INSERT INTO `employee` VALUES ('10005', '付彧', '研发', '女', '主管', 'A', 0, '差旅');
INSERT INTO `employee` VALUES ('10006', '易琳', '技术', '女', '经理', 'B', 6, '节日');
COMMIT;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `sno` char(8) NOT NULL,
  `sname` char(10) NOT NULL,
  `basicsalary` int NOT NULL DEFAULT '0',
  `vocationsalary` int NOT NULL DEFAULT '0',
  `agesalary` int NOT NULL DEFAULT '0',
  `welfare` int NOT NULL DEFAULT '0',
  `allsalary` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`sno`,`sname`),
  KEY `index_salary` (`sno`),
  CONSTRAINT `sno_r` FOREIGN KEY (`sno`, `sname`) REFERENCES `employee` (`eno`, `ename`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salary
-- ----------------------------
BEGIN;
INSERT INTO `salary` VALUES ('10001', '李华', 800, 600, 1200, 200, 2800);
INSERT INTO `salary` VALUES ('10002', '柯正', 2555, 800, 7200, 500, 11055);
INSERT INTO `salary` VALUES ('10003', '华盛', 500, 300, 0, 50, 850);
INSERT INTO `salary` VALUES ('10004', '叶桦', 800, 600, 1200, 900, 3500);
INSERT INTO `salary` VALUES ('10005', '付彧', 8100, 1200, 0, 900, 10200);
INSERT INTO `salary` VALUES ('10006', '易琳', 500, 1500, 3600, 500, 6100);
COMMIT;

-- ----------------------------
-- Table structure for salarygrade
-- ----------------------------
DROP TABLE IF EXISTS `salarygrade`;
CREATE TABLE `salarygrade` (
  `grade` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gradesalary` int DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salarygrade
-- ----------------------------
BEGIN;
INSERT INTO `salarygrade` VALUES ('主管', 1200);
INSERT INTO `salarygrade` VALUES ('员工', 600);
INSERT INTO `salarygrade` VALUES ('实习生', 300);
INSERT INTO `salarygrade` VALUES ('组长', 800);
INSERT INTO `salarygrade` VALUES ('经理', 1500);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` char(8) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `employee` (`eno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'root', '123456');
INSERT INTO `user` VALUES ('10001', '10001', '123456');
INSERT INTO `user` VALUES ('10002', '10002', '123456');
INSERT INTO `user` VALUES ('10003', '10003', '123456');
INSERT INTO `user` VALUES ('10004', '10004', '123456');
INSERT INTO `user` VALUES ('10005', '10005', '123456');
INSERT INTO `user` VALUES ('10006', '10006', '123456');
COMMIT;

-- ----------------------------
-- Table structure for welfare
-- ----------------------------
DROP TABLE IF EXISTS `welfare`;
CREATE TABLE `welfare` (
  `wname` char(10) NOT NULL,
  `wsalary` int DEFAULT NULL,
  PRIMARY KEY (`wname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of welfare
-- ----------------------------
BEGIN;
INSERT INTO `welfare` VALUES ('加班补贴', 200);
INSERT INTO `welfare` VALUES ('差旅', 900);
INSERT INTO `welfare` VALUES ('网费', 50);
INSERT INTO `welfare` VALUES ('自定义补贴', 900);
INSERT INTO `welfare` VALUES ('节日', 500);
INSERT INTO `welfare` VALUES ('话费补贴', 50);
COMMIT;

-- ----------------------------
-- View structure for v_all
-- ----------------------------
DROP VIEW IF EXISTS `v_all`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_all` AS select `employee`.`eno` AS `eno`,`employee`.`ename` AS `ename`,`employee`.`edept` AS `edept`,`employee`.`esex` AS `esex`,`employee`.`egrade` AS `egrade`,`employee`.`erank` AS `erank`,`employee`.`eage` AS `eage`,`employee`.`ewelfare` AS `ewelfare`,`salary`.`sno` AS `sno`,`salary`.`sname` AS `sname`,`salary`.`basicsalary` AS `basicsalary`,`salary`.`vocationsalary` AS `vocationsalary`,`salary`.`agesalary` AS `agesalary`,`salary`.`welfare` AS `welfare`,`salary`.`allsalary` AS `allsalary` from (`employee` join `salary`) where (`employee`.`eno` = `salary`.`sno`)  WITH CASCADED CHECK OPTION;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_userbegin`;
delimiter ;;
CREATE TRIGGER `tr_userbegin` AFTER INSERT ON `employee` FOR EACH ROW INSERT INTO user (id,username,password) VALUES (new.eno+0,new.eno,123456)
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_salarybegin`;
delimiter ;;
CREATE TRIGGER `tr_salarybegin` AFTER INSERT ON `employee` FOR EACH ROW INSERT INTO salary (sno,sname) VALUES (new.eno,new.ename)
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_welfaresalary`;
delimiter ;;
CREATE TRIGGER `tr_welfaresalary` AFTER UPDATE ON `employee` FOR EACH ROW UPDATE salary,employee,welfare SET salary.welfare = welfare.wsalary
WHERE salary.sno = employee.eno AND employee.ewelfare = welfare.wname
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_basicsalary`;
delimiter ;;
CREATE TRIGGER `tr_basicsalary` AFTER UPDATE ON `employee` FOR EACH ROW UPDATE salary,employee,department SET salary.basicsalary = department.vocationsalary
WHERE employee.edept = department.dname AND salary.sno = employee.eno
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_vocationsalary`;
delimiter ;;
CREATE TRIGGER `tr_vocationsalary` AFTER UPDATE ON `employee` FOR EACH ROW UPDATE salary,employee,salarygrade SET salary.vocationsalary = salarygrade.gradesalary
WHERE employee.egrade = salarygrade.grade AND salary.sno = employee.eno
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table employee
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_agesalary`;
delimiter ;;
CREATE TRIGGER `tr_agesalary` AFTER UPDATE ON `employee` FOR EACH ROW UPDATE salary,employee SET salary.agesalary = employee.eage * 600
WHERE salary.sno = employee.eno
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table salary
-- ----------------------------
DROP TRIGGER IF EXISTS `tr_allsalary`;
delimiter ;;
CREATE TRIGGER `tr_allsalary` BEFORE UPDATE ON `salary` FOR EACH ROW SET new.allsalary = new.basicsalary+new.vocationsalary+new.agesalary+new.welfare
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `updateuser`;
delimiter ;;
CREATE TRIGGER `updateuser` BEFORE UPDATE ON `user` FOR EACH ROW UPDATE `user`
SET username = id
;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
