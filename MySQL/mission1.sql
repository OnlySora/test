/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mission1

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/03/2020 00:09:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` enum('前端工程师','JAVA工程师','运维工程师','iOS工程师','Android工程师','UI设计师','产品经理','测试工程师') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adminTime` datetime(0) NOT NULL,
  `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sno` int(0) NOT NULL,
  `dayLink` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `willing` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `senior` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('史旭朝', '408998785', '产品经理', '2019-12-06 00:00:00', '运城学院', 1830, 'http://www.jnshu.com/school/36883/daily', '如果不能在修真院冲刺苦修，未来三年内找不到女朋友', '赵玉影', '朋友推荐');
INSERT INTO `student` VALUES ('屈连君', '756691481', 'JAVA工程师', '2019-08-26 00:00:00', '河北大学工商学院', 6086, 'https://www.jnshu.com/school/35557/daily', 'make progress every day', '何家欢 ', NULL);
INSERT INTO `student` VALUES ('周自辉', '535935506', 'JAVA工程师', '2019-12-24 00:00:00', '南阳理工学院', 6213, 'http://www.jnshu.com/school/9152/daily', '啥也不说就是干！！！', '林泽宇', '知乎');
INSERT INTO `student` VALUES ('王鹏', '1197178284', 'JAVA工程师', '2019-12-06 00:00:00', '黑龙江科技大学', 6287, 'http://www.jnshu.com/school/39867/daily', '加油学！', '张恒', '朋友推荐');
INSERT INTO `student` VALUES ('王玺', '614843204', '前端工程师', '2019-11-05 00:00:00', '南京航空航天大学金城学院', 8392, 'http://www.jnshu.com/school/39482/daily', '确实也是心怀梦想来加入修真院的大家庭的，希望以后都能顺顺利利！！', '周家正', '');
INSERT INTO `student` VALUES ('张雄', '1525678297', '前端工程师', '2019-12-06 00:00:00', '大四学生', 8448, 'http://www.jnshu.com/school/39805/daily', '努力奋进，为自己以后的修行路上打好基础，否则，就让我变胖2斤！', '高世豪', NULL);
INSERT INTO `student` VALUES ('蔡瑞丰', '714669826', '产品经理', '2019-08-03 00:00:00', '西南石油大学', 38189, 'http://www.jnshu.com/school/38189/daily', '在修真院努力，明年毕业找到自己最喜欢的工作，不然就不毕业。', '符文华', NULL);
INSERT INTO `student` VALUES ('朱春雨', '920683808', '前端工程师', '2019-11-07 00:00:00', '辽宁理工学院', 39518, 'http://www.jnshu.com/school/39518/daily', '如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖15斤！', '赵玉影', '朋友推荐');
INSERT INTO `student` VALUES ('陈东', '1184137830', 'JAVA工程师', '2019-11-23 00:00:00', '长江大学', 39595, 'http://www.jnshu.com/daily/108754?total=8&page=1&uid=39595&sort=0&orderBy=3', '学习永远是自己的事情！加油！！！', '甘小龙', NULL);
INSERT INTO `student` VALUES ('崔庆龙', '390799446', '测试工程师', '2019-11-23 00:00:00', '三门峡职业技术学院', 39609, 'http://www.jnshu.com/school/39609/daily', '如果我不能在IT修真院坚持到底好好学习，就让我胖十斤', '汪明放', '知乎');

SET FOREIGN_KEY_CHECKS = 1;
