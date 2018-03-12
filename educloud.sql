-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: educloud
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryId` int(5) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(100) NOT NULL,
  `majorId` int(5) NOT NULL,
  PRIMARY KEY (`categoryId`),
  KEY `FK_category_major` (`majorId`),
  CONSTRAINT `FK_category_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'前端开发',1),(2,'后端开发',1),(3,'移动开发',1),(4,'数据库',1),(5,'人工智恩',1),(6,'云计算&大数据',1),(7,'运维&测试',1),(8,'UI设计',1),(9,'会计学',2),(10,'营销学',2);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorydetailed`
--

DROP TABLE IF EXISTS `categorydetailed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorydetailed` (
  `cgdetailedId` int(5) NOT NULL AUTO_INCREMENT,
  `cgdetailedName` varchar(100) NOT NULL,
  `categoryId` int(5) NOT NULL,
  PRIMARY KEY (`cgdetailedId`),
  KEY `FK_cgdetailed_category` (`categoryId`),
  CONSTRAINT `FK_cgdetailed_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorydetailed`
--

LOCK TABLES `categorydetailed` WRITE;
/*!40000 ALTER TABLE `categorydetailed` DISABLE KEYS */;
INSERT INTO `categorydetailed` VALUES (1,'HTML/CSS',1),(2,'JavaScript',1),(3,'Html5',1),(4,'CSS3',1),(5,'jQuery',1),(6,'Node.js',1),(7,'Bootstrap',1),(8,'Angular',1),(9,'React.JS',1),(10,'Vue.js',1),(11,'Sass/Less',1),(12,'Web/App',1),(13,'前端工具',1),(14,'银行会计学',9),(15,'基础会计学',9),(16,'市场营销学',10),(20,'Android',3),(21,'IOS',3),(22,'Unity 3D',3),(23,'Cocos2d -x',3),(24,'Ajax',1);
/*!40000 ALTER TABLE `categorydetailed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapterdetailed`
--

DROP TABLE IF EXISTS `chapterdetailed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chapterdetailed` (
  `detailedId` int(16) NOT NULL AUTO_INCREMENT,
  `chapterId` int(16) NOT NULL,
  `detailedTile` varchar(100) NOT NULL COMMENT '每一章中 节的详细信息',
  `videoUrl` varchar(255) NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`detailedId`),
  KEY `FK_detailed_chapter` (`chapterId`),
  CONSTRAINT `FK_detailed_chapter` FOREIGN KEY (`chapterId`) REFERENCES `videochapter` (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapterdetailed`
--

LOCK TABLES `chapterdetailed` WRITE;
/*!40000 ALTER TABLE `chapterdetailed` DISABLE KEYS */;
INSERT INTO `chapterdetailed` VALUES (35,17,'会计基础概念','videos/temp/1517739397132.mp4'),(36,17,'会计需要掌握的知识','videos/temp/1517739397136.mp4'),(37,18,'随便','videos/temp/1517739470335.mp4'),(38,18,'坑人策列','videos/temp/1517739470346.mp4'),(39,19,'艰苦艰苦','videos/temp/1517749845532.mp4'),(40,20,'大数据库','videos/temp/1517749975514.mp4'),(41,20,'个人用户将会给','videos/temp/1517749975519.mp4'),(42,20,'热人要融入','videos/temp/1517749975525.mp4'),(43,21,'课程介绍','videos/temp/1517751437722.mp4'),(44,22,'Bitmap高效加载','videos/temp/1517751502429.mp4'),(45,23,'Android缓存','videos/temp/1517751549268.mp4'),(46,24,'LruCache','videos/temp/1517751611472.mp4'),(47,24,'DiskLruache','videos/temp/1517751611478.mp4'),(48,25,'总结','videos/temp/1517751651870.mp4'),(49,26,'1.Android开发环境搭建','videos/temp/1517751925416.mp4'),(50,26,'2.模拟器的使用','videos/temp/1517751925421.mp4'),(51,27,'简单的Android的程序','videos/temp/1517751969570.mp4'),(52,28,'TextView控件学习','videos/temp/1517752062391.mp4'),(53,28,'EditText控件学习','videos/temp/1517752062396.mp4'),(54,29,'课程介绍','videos/temp/1517801574605.mp4'),(55,30,'营销概念','videos/temp/1517801668319.mp4'),(56,30,'相关知识点','videos/temp/1517801668324.mp4'),(57,31,'课程介绍','videos/temp/1517801831193.mp4'),(58,32,'如何使用','videos/temp/1517801910008.mp4'),(59,32,'基本操作','videos/temp/1517801910014.mp4'),(60,33,'总结','videos/temp/1517801939898.mp4'),(61,34,'课程介绍','videos/temp/1517802041850.mp4'),(62,35,'结论介绍','videos/temp/1517802068371.mp4'),(63,36,'课程概要','videos/temp/1517802173027.mp4'),(64,37,'知识点讲解','videos/temp/1517802235013.mp4'),(65,37,'第二章总结','videos/temp/1517802235018.mp4'),(66,38,'知识点讲解','videos/temp/1517802875234.mp4'),(67,39,'韩国锦湖','videos/temp/1517803014913.mp4'),(68,40,'好久好久不','videos/temp/1517803114631.mp4'),(69,41,'u就复活','videos/temp/1517803153807.mp4'),(70,41,'其味无穷','videos/temp/1517803153812.mp4'),(71,42,'拉开距离','videos/temp/1517803218080.mp4'),(72,43,'课程介绍','videos/temp/1517803932869.mp4'),(73,44,'数据存储(1)','videos/temp/1517804041943.mp4'),(74,45,'数据存储(2)','videos/temp/1517804083916.mp4'),(75,46,'数据存储(3)','videos/temp/1517804106178.mp4'),(76,47,'数据存储(4)','videos/temp/1517804138297.mp4'),(77,48,'课程总结','videos/temp/1517804166044.mp4'),(78,49,'服务器环境的搭建','videos/temp/1517807130083.avi'),(79,50,'第一个ajax程序','videos/temp/1517807216332.mp4');
/*!40000 ALTER TABLE `chapterdetailed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `forumId` int(16) NOT NULL AUTO_INCREMENT COMMENT '询问区',
  `userId` int(16) NOT NULL,
  `videoId` int(16) NOT NULL,
  `contents` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`forumId`),
  KEY `FK_forum_user` (`userId`),
  KEY `FK_forum_video` (`videoId`),
  CONSTRAINT `FK_forum_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK_forum_video` FOREIGN KEY (`videoId`) REFERENCES `videoinfo` (`videoId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (3,1,8,'的撒发生的功夫的话购房计划'),(4,1,8,'都是官方电话给返回结果看'),(5,7,8,'u给用户不仅不会v成本'),(6,8,8,'客户尽快结婚了'),(7,9,8,'官方价格和健康的首付大概'),(8,11,8,'恢复骨结核给开通热议他如何看价格规划局规划局 '),(9,1,8,'；‘了'),(10,7,8,'优惠哟尽快离开就；离开'),(11,8,8,'1231200000000000000'),(12,9,8,'u有哦ip拍'),(13,11,8,'去微软推哦怕');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `majorId` int(5) NOT NULL AUTO_INCREMENT,
  `majorName` varchar(100) NOT NULL,
  PRIMARY KEY (`majorId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'IT互联网'),(2,'金融管理');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderinfo` (
  `orderId` int(16) NOT NULL AUTO_INCREMENT,
  `userId` int(16) NOT NULL,
  `videoId` int(16) NOT NULL,
  `orderState` int(2) NOT NULL DEFAULT '0' COMMENT '是否付款',
  PRIMARY KEY (`orderId`),
  KEY `FK_order_user` (`userId`),
  KEY `FK_order_video` (`videoId`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK_order_video` FOREIGN KEY (`videoId`) REFERENCES `videoinfo` (`videoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rank` (
  `rankId` int(5) NOT NULL AUTO_INCREMENT,
  `rankName` varchar(100) NOT NULL,
  PRIMARY KEY (`rankId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` VALUES (1,'初级'),(2,'中级'),(3,'高级');
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roleinfo`
--

DROP TABLE IF EXISTS `roleinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roleinfo` (
  `roleId` int(5) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roleinfo`
--

LOCK TABLES `roleinfo` WRITE;
/*!40000 ALTER TABLE `roleinfo` DISABLE KEYS */;
INSERT INTO `roleinfo` VALUES (1,'学生'),(2,'教师'),(3,'管机员');
/*!40000 ALTER TABLE `roleinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `scheduleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `videoId` int(11) NOT NULL,
  PRIMARY KEY (`scheduleId`),
  KEY `FK_schedule_user_idx` (`userId`),
  KEY `FK_schedule_video_idx` (`videoId`),
  CONSTRAINT `FK_schedule_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_schedule_video` FOREIGN KEY (`videoId`) REFERENCES `videoinfo` (`videoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,1,8),(2,1,9),(3,1,10),(4,1,11),(5,1,12);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(16) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userAccount` varchar(50) NOT NULL COMMENT '用于登录的账号',
  `userPass` varchar(200) NOT NULL,
  `locked` int(1) NOT NULL DEFAULT '0',
  `role` int(5) NOT NULL,
  `faceImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userAccount` (`userAccount`),
  KEY `roleName` (`role`),
  CONSTRAINT `roleName` FOREIGN KEY (`role`) REFERENCES `roleinfo` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'测试','101','123456',0,1,NULL),(7,'红电话电话','3155457','qqq',0,1,NULL),(8,'有trytry让他','132134564','123',0,1,NULL),(9,'有t5453132ry让他','4135431','123',0,1,NULL),(11,'fdgdfgdfh','111','123',0,1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videoassess`
--

DROP TABLE IF EXISTS `videoassess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videoassess` (
  `assessId` int(16) NOT NULL AUTO_INCREMENT,
  `videoId` int(16) NOT NULL,
  `score` float(6,0) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `userId` int(16) NOT NULL,
  PRIMARY KEY (`assessId`),
  KEY `FK_assess_video` (`videoId`),
  KEY `FK_assess_user_idx` (`userId`),
  CONSTRAINT `FK_assess_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_assess_video` FOREIGN KEY (`videoId`) REFERENCES `videoinfo` (`videoId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videoassess`
--

LOCK TABLES `videoassess` WRITE;
/*!40000 ALTER TABLE `videoassess` DISABLE KEYS */;
INSERT INTO `videoassess` VALUES (1,8,10,'可可以可以可以',1),(2,8,5,'规划规范化广泛',1),(3,8,2,'iu偶i是的人',1);
/*!40000 ALTER TABLE `videoassess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videochapter`
--

DROP TABLE IF EXISTS `videochapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videochapter` (
  `chapterId` int(16) NOT NULL AUTO_INCREMENT,
  `videoId` int(16) NOT NULL,
  `chapterName` varchar(100) NOT NULL,
  PRIMARY KEY (`chapterId`),
  KEY `FK_chapter_videoInfo` (`videoId`),
  CONSTRAINT `FK_chapter_videoInfo` FOREIGN KEY (`videoId`) REFERENCES `videoinfo` (`videoId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videochapter`
--

LOCK TABLES `videochapter` WRITE;
/*!40000 ALTER TABLE `videochapter` DISABLE KEYS */;
INSERT INTO `videochapter` VALUES (17,8,'第一章'),(18,8,'第二章 银行规则'),(19,8,'第三章'),(20,8,'第四章'),(21,9,'第一章'),(22,9,'第二章 Bitmap高效缓存'),(23,9,'第三章 Android缓存策略'),(24,9,'第4章 项目案例'),(25,9,'第5章 课程总结'),(26,10,'第1章 Android开发环境及工具'),(27,10,'第2章 第一个Android程序'),(28,10,'第3章 Android UI控件学习'),(29,11,'第一章 市场营销介绍'),(30,11,'第二章 市场营销概念'),(31,12,'第一章 node.js课程介绍'),(32,12,'第二章 node.js使用'),(33,12,'第三章 课程总结'),(34,13,'第一章 看看'),(35,13,'第二章 课程结论'),(36,14,'第一章 课程概要'),(37,14,'第二章 课程知识'),(38,15,'第一章 课程介绍'),(39,16,'第一章 课程介绍'),(40,17,'第一章 课程介绍'),(41,17,'第二章 课规范化风格'),(42,18,'第二章 课规范化风格'),(43,35,'第一章 课程介绍'),(44,35,'第二章 数据存储原理'),(45,35,'第三章 数据存储原理'),(46,35,'第四章 数据存储原理'),(47,35,'第五章 数据存储原理'),(48,35,'第6章 课程总结'),(49,36,'第一章 Ajax原理 准备工作'),(50,36,'第二章 Ajax原理 实践');
/*!40000 ALTER TABLE `videochapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videoinfo`
--

DROP TABLE IF EXISTS `videoinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videoinfo` (
  `videoId` int(16) NOT NULL AUTO_INCREMENT,
  `videoTile` varchar(100) NOT NULL,
  `videoDiscript` varchar(255) NOT NULL,
  `rankId` int(5) NOT NULL COMMENT '等级难度',
  `studySum` int(16) NOT NULL DEFAULT '0' COMMENT '学习人数',
  `prices` decimal(8,2) NOT NULL DEFAULT '0.00',
  `categoryId` int(5) NOT NULL,
  `recommend` int(5) NOT NULL DEFAULT '0' COMMENT '推荐标志，默认不推荐',
  `cgdetailedId` int(5) NOT NULL,
  `majorId` int(5) NOT NULL,
  `picUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`videoId`),
  KEY `FK_video_major` (`majorId`),
  KEY `FK_video_rank` (`rankId`),
  KEY `FK_video_category` (`categoryId`),
  KEY `FK_video_categoryDetailed` (`cgdetailedId`),
  CONSTRAINT `FK_video_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`),
  CONSTRAINT `FK_video_categoryDetailed` FOREIGN KEY (`cgdetailedId`) REFERENCES `categorydetailed` (`cgdetailedId`),
  CONSTRAINT `FK_video_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`),
  CONSTRAINT `FK_video_rank` FOREIGN KEY (`rankId`) REFERENCES `rank` (`rankId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videoinfo`
--

LOCK TABLES `videoinfo` WRITE;
/*!40000 ALTER TABLE `videoinfo` DISABLE KEYS */;
INSERT INTO `videoinfo` VALUES (8,'慕课','该工程测试',1,0,0.00,9,1,14,2,'videos/img/1517739272436.jpg'),(9,'Bitmap高效缓存','本门课程会介绍Btmap相关知识点及如何高效加载，还会介绍Android缓存策略，通过综合所学模仿ImageLoader实现图片的高效加载功能',1,0,0.00,3,2,20,1,'videos/img/1517751371147.jpg'),(10,'Android开发从零开始','从基础的环境配置到案例的实现',1,100,0.00,3,2,20,1,'videos/img/1517751809192.jpg'),(11,'测试--4','哦哦哦哦哦哦哦哦哦',2,0,100.00,10,0,16,2,'videos/img/1517801514419.jpg'),(12,'测试--5','牛牛牛牛牛牛牛牛牛牛牛',2,456,0.00,1,1,6,1,'videos/img/1517801773569.jpg'),(13,'测试--6','啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦',1,22,0.00,1,0,1,1,'videos/img/1517801992351.jpeg'),(14,'测试--7','哈哈哈哈哈估计大家',1,0,0.00,1,1,7,1,'videos/img/1517802109238.jpg'),(15,'测试--8','后果脚后跟经过豆腐干反对',2,0,200.00,1,0,8,1,'videos/img/1517802843232.jpg'),(16,'测试--9','体育馆附近后果脚后跟艰苦好空间好空间和',1,4574,300.00,1,1,5,1,'videos/img/1517802988834.jpg'),(17,'测试--10','i偶客户比较好看就好看久了就会立刻理科',1,0,500.00,10,0,16,2,'videos/img/1517803094489.jpg'),(18,'测试--11','烘干机烘干机很快就会',1,879,400.00,1,1,1,1,'videos/img/1517803197083.jpg'),(19,'测试12','的后果将会尽快汇款',1,0,0.00,1,0,1,1,'videos/img/1517803251627.jpg'),(20,'测试--12','韩国客家话客家话客家话',1,546,0.00,1,1,1,1,'videos/img/1517803287480.jpg'),(21,'测试--13','太热一热屠洪刚艰苦虎骨酒后果就',1,0,0.00,1,0,1,1,'videos/img/1517803318635.jpg'),(22,'测试--14','房价回归结果回家换个',1,4564,0.00,1,1,1,1,'videos/img/1517803348723.jpg'),(23,'测试--15','官方的不会v能不能股份合计国服激活工具户籍科交换空间好看',1,0,0.00,1,1,1,1,'videos/img/1517803378786.jpg'),(24,'测试--16','结果很快就很快乐谁惹我规范化v不能回家很广泛化工',1,0,0.00,1,0,1,1,'videos/img/1517803419266.jpg'),(25,'测试--17','通用图激活工具吗nhk更何况军火库军火库回家u机关还将涵盖',1,0,0.00,1,0,1,1,'videos/img/1517803451058.jpg'),(26,'测试--18','话就回归结果很快就很快就看了看； 过的发挥规范化风格化法国',1,0,0.00,1,1,1,1,'videos/img/1517803496234.jpg'),(27,'测试--19','就看见了空间；了客服沟通意图和国际化国际化',1,0,0.00,1,1,1,1,'videos/img/1517803527079.jpg'),(28,'测试--20','后果脚后跟u和国际化风格呵呵规划局的激活工具 很多国家和国家黄飞鸿发',3,0,0.00,1,2,1,1,'videos/img/1517803558414.jpeg'),(29,'测试--21','话估计很快就会关机开机很快 付款计划看看建行卡健康 进口货',3,0,0.00,1,1,1,1,'videos/img/1517803590377.jpg'),(30,'测试--22','股东分红风格花粉管工行建行给就规划就会感觉韩国',2,0,0.00,1,2,1,1,'videos/img/1517803623923.jpg'),(31,'测试--23','发动反攻丰华股份凤凰国际汇款了；离开； ',2,0,0.00,1,1,1,1,'videos/img/1517803658044.jpg'),(32,'测试--24','规范化风格恢复会更加规划局韩国花见花开回家看就好看',2,0,0.00,1,0,1,1,'videos/img/1517803691399.jpg'),(33,'测试--25','发的规划规范放个寒假过后话估计很快就好看韩剧 就很快就会 健康 健康',3,0,0.00,1,1,1,1,'videos/img/1517803726885.jpg'),(34,'测试--26','很反感和规范股份华国锋讲话稿会尽快和公开即将回国会更加规划规划局韩国 ',3,0,0.00,1,2,1,1,'videos/img/1517803755904.jpg'),(35,'Android后台开发','介绍使用Android数据存储的使用',2,0,111.00,3,1,20,1,'videos/img/1517803887847.jpg'),(36,'Ajax课程','介绍初级的Ajax的原理及其简单的使用，提供了相关的案例',1,0,0.00,1,1,24,1,'videos/img/1517807042441.jpg');
/*!40000 ALTER TABLE `videoinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-12 10:32:18
