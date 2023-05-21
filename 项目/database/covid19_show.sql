/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : covid19_show

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 21/06/2021 08:31:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for china_data
-- ----------------------------
DROP TABLE IF EXISTS `china_data`;
CREATE TABLE `china_data`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `now_have` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_have` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of china_data
-- ----------------------------
INSERT INTO `china_data` VALUES ('上海', '2', '35');
INSERT INTO `china_data` VALUES ('云南', '2', '35');
INSERT INTO `china_data` VALUES ('内蒙古', '2', '35');
INSERT INTO `china_data` VALUES ('北京', '2', '35');
INSERT INTO `china_data` VALUES ('南海诸岛', '2', '35');
INSERT INTO `china_data` VALUES ('台湾', '2', '35');
INSERT INTO `china_data` VALUES ('吉林', '2', '35');
INSERT INTO `china_data` VALUES ('四川', '2', '35');
INSERT INTO `china_data` VALUES ('天津', '2', '35');
INSERT INTO `china_data` VALUES ('宁夏', '2', '35');
INSERT INTO `china_data` VALUES ('安徽', '2', '35');
INSERT INTO `china_data` VALUES ('山东', '2', '35');
INSERT INTO `china_data` VALUES ('山西', '2', '35');
INSERT INTO `china_data` VALUES ('广东', '2', '35');
INSERT INTO `china_data` VALUES ('广西', '2', '35');
INSERT INTO `china_data` VALUES ('新疆', '2', '35');
INSERT INTO `china_data` VALUES ('江苏', '2', '35');
INSERT INTO `china_data` VALUES ('江西', '2', '35');
INSERT INTO `china_data` VALUES ('河北', '2', '35');
INSERT INTO `china_data` VALUES ('河南', '2', '35');
INSERT INTO `china_data` VALUES ('浙江', '2', '35');
INSERT INTO `china_data` VALUES ('海南', '2', '35');
INSERT INTO `china_data` VALUES ('湖北', '2', '35');
INSERT INTO `china_data` VALUES ('湖南', '2', '35');
INSERT INTO `china_data` VALUES ('澳门', '2', '35');
INSERT INTO `china_data` VALUES ('甘肃', '2', '35');
INSERT INTO `china_data` VALUES ('福建', '2', '35');
INSERT INTO `china_data` VALUES ('西藏', '2', '35');
INSERT INTO `china_data` VALUES ('贵州', '2', '35');
INSERT INTO `china_data` VALUES ('辽宁', '2', '35');
INSERT INTO `china_data` VALUES ('重庆', '2', '35');
INSERT INTO `china_data` VALUES ('陕西', '2', '35');
INSERT INTO `china_data` VALUES ('青海', '2', '35');
INSERT INTO `china_data` VALUES ('香港', '2', '35');
INSERT INTO `china_data` VALUES ('黑龙江', '2', '35');

-- ----------------------------
-- Table structure for covid_data
-- ----------------------------
DROP TABLE IF EXISTS `covid_data`;
CREATE TABLE `covid_data`  (
  `date` date NOT NULL,
  `now_sure` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `now_add` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `now_icu` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `add_sure` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `add_died` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `add_save` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of covid_data
-- ----------------------------
INSERT INTO `covid_data` VALUES ('2021-06-16', '1', '1', '1', '11', '1', '1');
INSERT INTO `covid_data` VALUES ('2021-06-17', '14', '13', '14', '12', '12', '12');
INSERT INTO `covid_data` VALUES ('2021-06-18', '12', '12', '12', '12', '12', '12');
INSERT INTO `covid_data` VALUES ('2021-06-19', '13', '12', '111', '111', '111', '111');
INSERT INTO `covid_data` VALUES ('2021-06-20', '12', '12', '1212', '12', '12', '12');

-- ----------------------------
-- Table structure for foreigncoviddata
-- ----------------------------
DROP TABLE IF EXISTS `foreigncoviddata`;
CREATE TABLE `foreigncoviddata`  (
  `date` date NOT NULL,
  `now_sure` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `new_add` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `new_died` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `new_save` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of foreigncoviddata
-- ----------------------------
INSERT INTO `foreigncoviddata` VALUES ('2021-06-17', '1', '1', '1', '1');
INSERT INTO `foreigncoviddata` VALUES ('2021-06-18', '23', '23', '23', '23');
INSERT INTO `foreigncoviddata` VALUES ('2021-06-19', '12', '12', '12', '12');
INSERT INTO `foreigncoviddata` VALUES ('2021-06-20', '13', '111', '111', '1111');

-- ----------------------------
-- Table structure for home_article
-- ----------------------------
DROP TABLE IF EXISTS `home_article`;
CREATE TABLE `home_article`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_article
-- ----------------------------
INSERT INTO `home_article` VALUES (5, '哈哈哈哈哈', '是否萨芬安但', 'https://521h.oss-accelerate.aliyuncs.com/20210526/1621999921581280.jpg');
INSERT INTO `home_article` VALUES (7, 'sdsds', 'sdsds', 'https://521h.oss-accelerate.aliyuncs.com/20210526/1622011957219581.png');
INSERT INTO `home_article` VALUES (8, '老耿是个程序员', 'sdsdf', 'https://521h.oss-accelerate.aliyuncs.com/20210526/1622011925216854.jpg');

-- ----------------------------
-- Table structure for home_rouling
-- ----------------------------
DROP TABLE IF EXISTS `home_rouling`;
CREATE TABLE `home_rouling`  (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_rouling
-- ----------------------------
INSERT INTO `home_rouling` VALUES (29, 'https://521h.oss-accelerate.aliyuncs.com/20210526/1622011298435317.jpg', 'sdsds');
INSERT INTO `home_rouling` VALUES (30, 'https://521h.oss-accelerate.aliyuncs.com/20210526/1621999336663254.jpg', 'https://v.qq.com/');
INSERT INTO `home_rouling` VALUES (31, 'https://521h.oss-accelerate.aliyuncs.com/20210526/162199965186663.jpg', 'sdsds123');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (3, 'sd ', 'sf ', 'https://521h.oss-accelerate.aliyuncs.com/20210524/1621817693263755.jpg');
INSERT INTO `question` VALUES (4, 'sd ', 'sf ', 'https://521h.oss-accelerate.aliyuncs.com/20210524/162181771247851.jpg');
INSERT INTO `question` VALUES (5, 'sd', 'sd', 'https://521h.oss-accelerate.aliyuncs.com/20210524/1621817783717932.jpg');
INSERT INTO `question` VALUES (6, 'sda', 'ssds', 'https://521h.oss-accelerate.aliyuncs.com/20210524/1621817891767689.jpg');

-- ----------------------------
-- Table structure for rouling_message
-- ----------------------------
DROP TABLE IF EXISTS `rouling_message`;
CREATE TABLE `rouling_message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rouling_message
-- ----------------------------
INSERT INTO `rouling_message` VALUES (13, '老耿是个程序员', 'sdsds');
INSERT INTO `rouling_message` VALUES (14, '老耿是个程序员', 'sda');

-- ----------------------------
-- Table structure for rumor
-- ----------------------------
DROP TABLE IF EXISTS `rumor`;
CREATE TABLE `rumor`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_rumor` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rumor
-- ----------------------------
INSERT INTO `rumor` VALUES (4, 'hahahah', b'0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('sasa', '3230630470@qq.com', '20030311');

-- ----------------------------
-- Table structure for world_data
-- ----------------------------
DROP TABLE IF EXISTS `world_data`;
CREATE TABLE `world_data`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `now_have` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_have` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of world_data
-- ----------------------------
INSERT INTO `world_data` VALUES ('Afghanistan', '1', '9999');
INSERT INTO `world_data` VALUES ('Albania', '1', '10000');
INSERT INTO `world_data` VALUES ('Algeria', '1', '10001');
INSERT INTO `world_data` VALUES ('Angola', '1', '10002');
INSERT INTO `world_data` VALUES ('Argentina', '1', '10003');
INSERT INTO `world_data` VALUES ('Armenia', '1', '10004');
INSERT INTO `world_data` VALUES ('Austria', '1', '10005');
INSERT INTO `world_data` VALUES ('Azerbaijan', '1', '10006');
INSERT INTO `world_data` VALUES ('Bahamas', '1', '10007');
INSERT INTO `world_data` VALUES ('Bangladesh', '1', '10008');
INSERT INTO `world_data` VALUES ('Belarus', '1', '10009');
INSERT INTO `world_data` VALUES ('Belgium', '1', '10010');
INSERT INTO `world_data` VALUES ('Belize', '1', '10011');
INSERT INTO `world_data` VALUES ('Benin', '1', '10012');
INSERT INTO `world_data` VALUES ('Bermuda', '1', '10013');
INSERT INTO `world_data` VALUES ('Bhutan', '1', '10014');
INSERT INTO `world_data` VALUES ('Bolivia', '1', '10015');
INSERT INTO `world_data` VALUES ('Bosnia and Herz.', '1', '10016');
INSERT INTO `world_data` VALUES ('Bosnia and Herzegovina', '1', '10017');
INSERT INTO `world_data` VALUES ('Botswana', '1', '10018');
INSERT INTO `world_data` VALUES ('Br. Indian Ocean Ter.', '1', '10019');
INSERT INTO `world_data` VALUES ('Brazil', '1', '10020');
INSERT INTO `world_data` VALUES ('Brunei', '1', '10021');
INSERT INTO `world_data` VALUES ('Bulgaria', '1', '10022');
INSERT INTO `world_data` VALUES ('Burkina Faso', '1', '10023');
INSERT INTO `world_data` VALUES ('Burundi', '1', '10024');
INSERT INTO `world_data` VALUES ('Cambodia', '1', '10025');
INSERT INTO `world_data` VALUES ('Cameroon', '1', '10026');
INSERT INTO `world_data` VALUES ('Central African Rep.', '1', '10027');
INSERT INTO `world_data` VALUES ('Central African Republic', '1', '10028');
INSERT INTO `world_data` VALUES ('Chad', '1', '10029');
INSERT INTO `world_data` VALUES ('Chile', '1', '10030');
INSERT INTO `world_data` VALUES ('Colombia', '1', '10031');
INSERT INTO `world_data` VALUES ('Congo', '1', '10032');
INSERT INTO `world_data` VALUES ('Costa Rica', '1', '10033');
INSERT INTO `world_data` VALUES ('Côte d\'Ivoire', '1', '10034');
INSERT INTO `world_data` VALUES ('Croatia', '1', '10035');
INSERT INTO `world_data` VALUES ('Cuba', '1', '10036');
INSERT INTO `world_data` VALUES ('Cyprus', '1', '10037');
INSERT INTO `world_data` VALUES ('Czech Rep.', '1', '10038');
INSERT INTO `world_data` VALUES ('Czech Republic', '1', '10039');
INSERT INTO `world_data` VALUES ('Dem. Rep. Congo', '1', '10040');
INSERT INTO `world_data` VALUES ('Dem. Rep. Korea', '1', '10041');
INSERT INTO `world_data` VALUES ('Democratic Republic of the Congo', '1', '10042');
INSERT INTO `world_data` VALUES ('Denmark', '1', '10043');
INSERT INTO `world_data` VALUES ('Djibouti', '1', '10044');
INSERT INTO `world_data` VALUES ('Dominican Rep.', '1', '10045');
INSERT INTO `world_data` VALUES ('Dominican Republic', '1', '10046');
INSERT INTO `world_data` VALUES ('East Timor', '1', '10047');
INSERT INTO `world_data` VALUES ('Ecuador', '1', '10048');
INSERT INTO `world_data` VALUES ('Egypt', '1', '10049');
INSERT INTO `world_data` VALUES ('El Salvador', '1', '10050');
INSERT INTO `world_data` VALUES ('Eq. Guinea', '1', '10051');
INSERT INTO `world_data` VALUES ('Equatorial Guinea', '1', '10052');
INSERT INTO `world_data` VALUES ('Eritrea', '1', '10053');
INSERT INTO `world_data` VALUES ('Estonia', '1', '10054');
INSERT INTO `world_data` VALUES ('Ethiopia', '1', '10055');
INSERT INTO `world_data` VALUES ('Falkland Islands', '1', '10056');
INSERT INTO `world_data` VALUES ('Fiji', '1', '10057');
INSERT INTO `world_data` VALUES ('Finland', '1', '10058');
INSERT INTO `world_data` VALUES ('France', '1', '10059');
INSERT INTO `world_data` VALUES ('French Guiana', '1', '10060');
INSERT INTO `world_data` VALUES ('French Southern and Antarctic Lands', '1', '10061');
INSERT INTO `world_data` VALUES ('Gabon', '1', '10062');
INSERT INTO `world_data` VALUES ('Gambia', '1', '10063');
INSERT INTO `world_data` VALUES ('Georgia', '1', '10064');
INSERT INTO `world_data` VALUES ('Germany', '1', '10065');
INSERT INTO `world_data` VALUES ('Ghana', '1', '10066');
INSERT INTO `world_data` VALUES ('Greece', '1', '10067');
INSERT INTO `world_data` VALUES ('Greenland', '1', '10068');
INSERT INTO `world_data` VALUES ('Guatemala', '1', '10069');
INSERT INTO `world_data` VALUES ('Guinea', '1', '10070');
INSERT INTO `world_data` VALUES ('Guinea Bissau', '1', '10071');
INSERT INTO `world_data` VALUES ('Guinea-Bissau', '1', '10072');
INSERT INTO `world_data` VALUES ('Guyana', '1', '10073');
INSERT INTO `world_data` VALUES ('Haiti', '1', '10074');
INSERT INTO `world_data` VALUES ('Honduras', '1', '10075');
INSERT INTO `world_data` VALUES ('Hungary', '1', '10076');
INSERT INTO `world_data` VALUES ('Iceland', '1', '10077');
INSERT INTO `world_data` VALUES ('India', '1', '10078');
INSERT INTO `world_data` VALUES ('Indonesia', '1', '10079');
INSERT INTO `world_data` VALUES ('Iraq', '1', '10080');
INSERT INTO `world_data` VALUES ('Ireland', '1', '10081');
INSERT INTO `world_data` VALUES ('Israel', '1', '10082');
INSERT INTO `world_data` VALUES ('Italy', '1', '10083');
INSERT INTO `world_data` VALUES ('Ivory Coast', '1', '10084');
INSERT INTO `world_data` VALUES ('Jamaica', '1', '10085');
INSERT INTO `world_data` VALUES ('Jordan', '1', '10086');
INSERT INTO `world_data` VALUES ('Kazakhstan', '1', '10087');
INSERT INTO `world_data` VALUES ('Kenya', '1', '10088');
INSERT INTO `world_data` VALUES ('Korea', '1', '10089');
INSERT INTO `world_data` VALUES ('Kosovo', '1', '10090');
INSERT INTO `world_data` VALUES ('Kuwait', '1', '10091');
INSERT INTO `world_data` VALUES ('Kyrgyzstan', '1', '10092');
INSERT INTO `world_data` VALUES ('Lao PDR', '1', '10093');
INSERT INTO `world_data` VALUES ('Laos', '1', '10094');
INSERT INTO `world_data` VALUES ('Latvia', '1', '10095');
INSERT INTO `world_data` VALUES ('Lebanon', '1', '10096');
INSERT INTO `world_data` VALUES ('Lesotho', '1', '10097');
INSERT INTO `world_data` VALUES ('Liberia', '1', '10098');
INSERT INTO `world_data` VALUES ('Libya', '1', '10099');
INSERT INTO `world_data` VALUES ('Lithuania', '1', '10100');
INSERT INTO `world_data` VALUES ('Luxembourg', '1', '10101');
INSERT INTO `world_data` VALUES ('Macedonia', '1', '10102');
INSERT INTO `world_data` VALUES ('Madagascar', '1', '10103');
INSERT INTO `world_data` VALUES ('Malawi', '1', '10104');
INSERT INTO `world_data` VALUES ('Malaysia', '1', '10105');
INSERT INTO `world_data` VALUES ('Mali', '1', '10106');
INSERT INTO `world_data` VALUES ('Mauritania', '1', '10107');
INSERT INTO `world_data` VALUES ('Mexico', '1', '10108');
INSERT INTO `world_data` VALUES ('Moldova', '1', '10109');
INSERT INTO `world_data` VALUES ('Mongolia', '1', '10110');
INSERT INTO `world_data` VALUES ('Montenegro', '1', '10111');
INSERT INTO `world_data` VALUES ('Morocco', '1', '10112');
INSERT INTO `world_data` VALUES ('Mozambique', '1', '10113');
INSERT INTO `world_data` VALUES ('Myanmar', '1', '10114');
INSERT INTO `world_data` VALUES ('N. Cyprus', '1', '10115');
INSERT INTO `world_data` VALUES ('Namibia', '1', '10116');
INSERT INTO `world_data` VALUES ('Nepal', '1', '10117');
INSERT INTO `world_data` VALUES ('Netherlands', '1', '10118');
INSERT INTO `world_data` VALUES ('New Caledonia', '1', '10119');
INSERT INTO `world_data` VALUES ('New Zealand', '1', '10120');
INSERT INTO `world_data` VALUES ('Nicaragua', '1', '10121');
INSERT INTO `world_data` VALUES ('Niger', '1', '10122');
INSERT INTO `world_data` VALUES ('Nigeria', '1', '10123');
INSERT INTO `world_data` VALUES ('North Korea', '1', '10124');
INSERT INTO `world_data` VALUES ('Northern Cyprus', '1', '10125');
INSERT INTO `world_data` VALUES ('Norway', '1', '10126');
INSERT INTO `world_data` VALUES ('Oman', '1', '10127');
INSERT INTO `world_data` VALUES ('Pakistan', '1', '10128');
INSERT INTO `world_data` VALUES ('Palestine', '1', '10129');
INSERT INTO `world_data` VALUES ('Panama', '1', '10130');
INSERT INTO `world_data` VALUES ('Papua New Guinea', '1', '10131');
INSERT INTO `world_data` VALUES ('Paraguay', '1', '10132');
INSERT INTO `world_data` VALUES ('Peru', '1', '10133');
INSERT INTO `world_data` VALUES ('Philippines', '1', '10134');
INSERT INTO `world_data` VALUES ('Poland', '1', '10135');
INSERT INTO `world_data` VALUES ('Portugal', '1', '10136');
INSERT INTO `world_data` VALUES ('Puerto Rico', '1', '10137');
INSERT INTO `world_data` VALUES ('Qatar', '1', '10138');
INSERT INTO `world_data` VALUES ('Republic of Serbia', '1', '10139');
INSERT INTO `world_data` VALUES ('Republic of the Congo', '1', '10140');
INSERT INTO `world_data` VALUES ('Romania', '1', '10141');
INSERT INTO `world_data` VALUES ('Rwanda', '1', '10142');
INSERT INTO `world_data` VALUES ('S. Sudan', '1', '10143');
INSERT INTO `world_data` VALUES ('Saudi Arabia', '1', '10144');
INSERT INTO `world_data` VALUES ('Senegal', '1', '10145');
INSERT INTO `world_data` VALUES ('Serbia', '1', '10146');
INSERT INTO `world_data` VALUES ('Siachen Glacier', '1', '10147');
INSERT INTO `world_data` VALUES ('Sierra Leone', '1', '10148');
INSERT INTO `world_data` VALUES ('Singapore Rep.', '1', '10149');
INSERT INTO `world_data` VALUES ('Slovakia', '1', '10150');
INSERT INTO `world_data` VALUES ('Slovenia', '1', '10151');
INSERT INTO `world_data` VALUES ('Solomon Is.', '1', '10152');
INSERT INTO `world_data` VALUES ('Solomon Islands', '1', '10153');
INSERT INTO `world_data` VALUES ('Somalia', '1', '10154');
INSERT INTO `world_data` VALUES ('Somaliland', '1', '10155');
INSERT INTO `world_data` VALUES ('South Africa', '1', '10156');
INSERT INTO `world_data` VALUES ('South Korea', '1', '10157');
INSERT INTO `world_data` VALUES ('South Sudan', '1', '10158');
INSERT INTO `world_data` VALUES ('Spain', '1', '10159');
INSERT INTO `world_data` VALUES ('Sri Lanka', '1', '10160');
INSERT INTO `world_data` VALUES ('Sudan', '1', '10161');
INSERT INTO `world_data` VALUES ('Suriname', '1', '10162');
INSERT INTO `world_data` VALUES ('Swaziland', '1', '10163');
INSERT INTO `world_data` VALUES ('Sweden', '1', '10164');
INSERT INTO `world_data` VALUES ('Switzerland', '1', '10165');
INSERT INTO `world_data` VALUES ('Syria', '1', '10166');
INSERT INTO `world_data` VALUES ('Tajikistan', '1', '10167');
INSERT INTO `world_data` VALUES ('Tanzania', '1', '10168');
INSERT INTO `world_data` VALUES ('Thailand', '1', '10169');
INSERT INTO `world_data` VALUES ('The Bahamas', '1', '10170');
INSERT INTO `world_data` VALUES ('Timor-Leste', '1', '10171');
INSERT INTO `world_data` VALUES ('Togo', '1', '10172');
INSERT INTO `world_data` VALUES ('Trinidad and Tobago', '1', '10173');
INSERT INTO `world_data` VALUES ('Tunisia', '1', '10174');
INSERT INTO `world_data` VALUES ('Turkmenistan', '1', '10175');
INSERT INTO `world_data` VALUES ('Uganda', '1', '10176');
INSERT INTO `world_data` VALUES ('Ukraine', '1', '10177');
INSERT INTO `world_data` VALUES ('United Arab Emirates', '1', '10178');
INSERT INTO `world_data` VALUES ('United Kingdom', '1', '10179');
INSERT INTO `world_data` VALUES ('United Republic of Tanzania', '1', '10180');
INSERT INTO `world_data` VALUES ('United States', '1', '10181');
INSERT INTO `world_data` VALUES ('United States Virgin Islands', '1', '10182');
INSERT INTO `world_data` VALUES ('Uruguay', '1', '10183');
INSERT INTO `world_data` VALUES ('Uzbekistan', '1', '10184');
INSERT INTO `world_data` VALUES ('Venezuela', '1', '10185');
INSERT INTO `world_data` VALUES ('Vietnam', '1', '10186');
INSERT INTO `world_data` VALUES ('W. Sahara', '1', '10187');
INSERT INTO `world_data` VALUES ('West Bank', '1', '10188');
INSERT INTO `world_data` VALUES ('Western Sahara', '1', '10189');
INSERT INTO `world_data` VALUES ('Yemen', '1', '10190');
INSERT INTO `world_data` VALUES ('Zambia', '1', '10191');
INSERT INTO `world_data` VALUES ('Zimbabwe', '1', '10192');
INSERT INTO `world_data` VALUES ('中国', '1', '10193');
INSERT INTO `world_data` VALUES ('伊朗', '1', '10194');
INSERT INTO `world_data` VALUES ('俄罗斯', '1', '10195');
INSERT INTO `world_data` VALUES ('加拿大', '1', '10196');
INSERT INTO `world_data` VALUES ('土耳其', '1', '10197');
INSERT INTO `world_data` VALUES ('日本', '1', '10198');
INSERT INTO `world_data` VALUES ('澳大利亚', '1', '10199');
INSERT INTO `world_data` VALUES ('美国', '1', '10200');

SET FOREIGN_KEY_CHECKS = 1;
