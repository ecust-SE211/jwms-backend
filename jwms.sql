/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : jwms

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 09/01/2024 23:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '考勤表id',
  `clid` int NOT NULL,
  `date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Class_id`(`clid`) USING BTREE,
  CONSTRAINT `Class_id` FOREIGN KEY (`clid`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (9, 1, '2024-01-09 15:59:58');

-- ----------------------------
-- Table structure for attendancerecord
-- ----------------------------
DROP TABLE IF EXISTS `attendancerecord`;
CREATE TABLE `attendancerecord`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sid` int NOT NULL COMMENT '学生id',
  `fid` int NOT NULL COMMENT '考勤表id',
  `date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `AttendanceRecord_Student_id`(`sid`) USING BTREE,
  INDEX `AttendanceRecord_Attendance_id`(`fid`) USING BTREE,
  CONSTRAINT `AttendanceRecord_Attendance_id` FOREIGN KEY (`fid`) REFERENCES `attendance` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `AttendanceRecord_Student_id` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendancerecord
-- ----------------------------
INSERT INTO `attendancerecord` VALUES (2, 1, 9, '2024-01-09 16:17:27');
INSERT INTO `attendancerecord` VALUES (3, 1, 9, '2024-01-09 16:24:45');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教学班id',
  `cid` int NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Course_id`(`cid`) USING BTREE,
  CONSTRAINT `Course_id` FOREIGN KEY (`cid`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 1);

-- ----------------------------
-- Table structure for classstudent
-- ----------------------------
DROP TABLE IF EXISTS `classstudent`;
CREATE TABLE `classstudent`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `clid` int NOT NULL COMMENT '班级id',
  `sid` int NOT NULL COMMENT '学生id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Class_id_classStudent1`(`clid`) USING BTREE,
  INDEX `Student_id_classStudent1`(`sid`) USING BTREE,
  CONSTRAINT `Class_id_classStudent1` FOREIGN KEY (`clid`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Student_id_classStudent1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classstudent
-- ----------------------------
INSERT INTO `classstudent` VALUES (4, 1, 1);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '软件文档写作');

-- ----------------------------
-- Table structure for jwteacher
-- ----------------------------
DROP TABLE IF EXISTS `jwteacher`;
CREATE TABLE `jwteacher`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教务老师id',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jwteacher
-- ----------------------------
INSERT INTO `jwteacher` VALUES (1, '1145141919810', 'rjj');
INSERT INTO `jwteacher` VALUES (2, '1145141919810', 'wwj');

-- ----------------------------
-- Table structure for spring_session
-- ----------------------------
DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE `spring_session`  (
  `PRIMARY_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SESSION_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` int NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`) USING BTREE,
  UNIQUE INDEX `SPRING_SESSION_IX1`(`SESSION_ID`) USING BTREE,
  INDEX `SPRING_SESSION_IX2`(`EXPIRY_TIME`) USING BTREE,
  INDEX `SPRING_SESSION_IX3`(`PRINCIPAL_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spring_session
-- ----------------------------

-- ----------------------------
-- Table structure for spring_session_attributes
-- ----------------------------
DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE `spring_session_attributes`  (
  `SESSION_PRIMARY_ID` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`) USING BTREE,
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of spring_session_attributes
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL COMMENT '学生id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '123456' COMMENT '学生密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'rjj', '1145141919810');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL COMMENT '教师id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '教师姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '123456' COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '1', '123456');
INSERT INTO `teacher` VALUES (3, 'rjj', '1145141919810');

-- ----------------------------
-- Table structure for teacherrole
-- ----------------------------
DROP TABLE IF EXISTS `teacherrole`;
CREATE TABLE `teacherrole`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tid` int NOT NULL COMMENT '老师id',
  `clid` int NOT NULL COMMENT '教学班id',
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '教师角色',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Class_id_teacherRole`(`clid`) USING BTREE,
  INDEX `Teacher_id_teacher`(`tid`) USING BTREE,
  CONSTRAINT `Class_id_teacherRole` FOREIGN KEY (`clid`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Teacher_id_teacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacherrole
-- ----------------------------
INSERT INTO `teacherrole` VALUES (2, 1, 1, 'TeacherB');

SET FOREIGN_KEY_CHECKS = 1;
