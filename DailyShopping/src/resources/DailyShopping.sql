/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - dailyshopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dailyshopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dailyshopping`;

/*Table structure for table `consignee_information` */

DROP TABLE IF EXISTS `consignee_information`;

CREATE TABLE `consignee_information` (
  `o_takeSiteID` int(11) NOT NULL AUTO_INCREMENT,
  `o_name` varchar(10) DEFAULT NULL,
  `o_phone` varchar(20) DEFAULT NULL,
  `o_add` varchar(50) DEFAULT NULL,
  `u_id` int(11) NOT NULL,
  `o_area` varchar(50) DEFAULT NULL,
  `o_code` varchar(6) DEFAULT '000000',
  `u_default_add` int(11) DEFAULT '0',
  PRIMARY KEY (`o_takeSiteID`),
  KEY `FK_Reference_35` (`u_id`),
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `consignee_information` */

insert  into `consignee_information`(`o_takeSiteID`,`o_name`,`o_phone`,`o_add`,`u_id`,`o_area`,`o_code`,`u_default_add`) values (8,'小万1','13756489799','成华区1',2,NULL,'000000',0),(13,'王磊','17895646','圣诞快乐发考虑',1,'四川宜宾武侯区','564',1),(14,'阿萨德','165454656545646','是打发斯蒂芬',13,'四川宜宾成华区','5454',1),(15,'','','',18,'四川成都武侯区','',1);

/*Table structure for table `g_colors` */

DROP TABLE IF EXISTS `g_colors`;

CREATE TABLE `g_colors` (
  `g_colorsID` int(11) NOT NULL AUTO_INCREMENT,
  `g_colors` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`g_colorsID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `g_colors` */

insert  into `g_colors`(`g_colorsID`,`g_colors`) values (1,'红色'),(2,'白色'),(3,'黑色'),(4,'灰色'),(5,'蓝色'),(6,'绿色');

/*Table structure for table `g_rank` */

DROP TABLE IF EXISTS `g_rank`;

CREATE TABLE `g_rank` (
  `g_rankID` int(11) NOT NULL AUTO_INCREMENT,
  `g_rankname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`g_rankID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `g_rank` */

insert  into `g_rank`(`g_rankID`,`g_rankname`) values (1,'首页'),(2,'商品详情展示默认'),(3,'商品详情展示后备');

/*Table structure for table `g_size` */

DROP TABLE IF EXISTS `g_size`;

CREATE TABLE `g_size` (
  `g_sizeID` int(11) NOT NULL AUTO_INCREMENT,
  `g_size` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`g_sizeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `g_size` */

insert  into `g_size`(`g_sizeID`,`g_size`) values (1,'S'),(2,'M'),(3,'L'),(4,'XL'),(5,'XXL');

/*Table structure for table `g_son` */

DROP TABLE IF EXISTS `g_son`;

CREATE TABLE `g_son` (
  `g_sonID` int(11) NOT NULL AUTO_INCREMENT,
  `g_sName` varchar(10) DEFAULT NULL,
  `g_describe` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`g_sonID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `g_son` */

insert  into `g_son`(`g_sonID`,`g_sName`,`g_describe`) values (1,'雅鹿','雅鹿会呼吸的服装'),(2,'南极人','南极人保暖领导者'),(3,'红豆男装','红豆进入潮流'),(4,'花花公子','洋溢着浓浓的绅士休闲味道'),(5,'罗蒙','优质服务'),(6,'七匹狼','中国男装行业开创性品牌'),(7,'美特斯邦威','百姓认证品牌'),(8,'美国苹果','欧美商务休闲风尚'),(9,'四川拍拍衣','本土服装'),(10,'才子男装','中国高端领导者'),(11,'鼎度','装出世界'),(12,'尊尚鸟','男士日系服装'),(13,NULL,NULL);

/*Table structure for table `g_sort1` */

DROP TABLE IF EXISTS `g_sort1`;

CREATE TABLE `g_sort1` (
  `g_sort1ID` int(11) NOT NULL AUTO_INCREMENT,
  `g_sName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`g_sort1ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `g_sort1` */

insert  into `g_sort1`(`g_sort1ID`,`g_sName`) values (1,'男装'),(2,'女装'),(3,'童装'),(4,'老年装');

/*Table structure for table `g_sort2` */

DROP TABLE IF EXISTS `g_sort2`;

CREATE TABLE `g_sort2` (
  `g_sort2ID` int(11) NOT NULL AUTO_INCREMENT,
  `g_sName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`g_sort2ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `g_sort2` */

insert  into `g_sort2`(`g_sort2ID`,`g_sName`) values (1,'外套'),(2,'T恤'),(3,'衬衣'),(4,'长裤'),(5,'牛仔裤');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `g_ID` int(11) NOT NULL AUTO_INCREMENT,
  `g_sort1ID` int(11) DEFAULT NULL,
  `g_sort2ID` int(11) DEFAULT NULL,
  `g_sonID` int(11) DEFAULT NULL,
  `g_colorsID` int(11) DEFAULT NULL,
  `g_sizeID` int(11) DEFAULT NULL,
  `g_integral` int(11) DEFAULT NULL,
  `g_g_price` double DEFAULT NULL,
  `g_src` varchar(50) DEFAULT NULL,
  `g_rankID` int(11) DEFAULT NULL,
  PRIMARY KEY (`g_ID`),
  KEY `FK_Reference_60` (`g_sort1ID`),
  KEY `FK_Reference_61` (`g_sonID`),
  KEY `FK_Reference_62` (`g_colorsID`),
  KEY `FK_Reference_63` (`g_sizeID`),
  KEY `FK_Reference_64` (`g_rankID`),
  KEY `FK_Reference_65` (`g_sort2ID`),
  CONSTRAINT `FK_Reference_60` FOREIGN KEY (`g_sort1ID`) REFERENCES `g_sort1` (`g_sort1ID`),
  CONSTRAINT `FK_Reference_61` FOREIGN KEY (`g_sonID`) REFERENCES `g_son` (`g_sonID`),
  CONSTRAINT `FK_Reference_62` FOREIGN KEY (`g_colorsID`) REFERENCES `g_colors` (`g_colorsID`),
  CONSTRAINT `FK_Reference_63` FOREIGN KEY (`g_sizeID`) REFERENCES `g_size` (`g_sizeID`),
  CONSTRAINT `FK_Reference_64` FOREIGN KEY (`g_rankID`) REFERENCES `g_rank` (`g_rankID`),
  CONSTRAINT `FK_Reference_65` FOREIGN KEY (`g_sort2ID`) REFERENCES `g_sort2` (`g_sort2ID`)
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`g_ID`,`g_sort1ID`,`g_sort2ID`,`g_sonID`,`g_colorsID`,`g_sizeID`,`g_integral`,`g_g_price`,`g_src`,`g_rankID`) values (1,1,1,1,1,1,30,220,'6a40ad01-4413-49ef-b576-5bca49437196_1.jpg',1),(2,1,1,1,1,1,59,854,'3a01c424-48df-4f39-97cf-68970345523e_5.jpg',1),(3,1,1,1,2,1,30,220,'5325066f-c1b4-4290-9f36-ba129e18c9bf_4.jpg',2),(4,1,1,1,2,1,234,220,'dea4ad2a-979a-4f2d-84a8-778f36e00689_9.jpg',2),(5,1,1,1,2,2,32,3202,'1d7cc8c6-aa68-47c1-9534-0d70c642bca9_12.jpg',2),(6,1,1,1,4,1,34,220,'edb54f8e-5038-4dcd-be28-62755d387a82_28.jpg',2),(7,1,1,1,2,1,30,234,'923b53ce-4347-4226-9850-0519d3ead4ed_5.jpg',1),(8,1,1,1,2,1,30,455,'744f3dee-bd44-410e-9073-752d843d0116_9.jpg',1),(9,1,1,1,3,1,23,220,'d5d05490-9be6-4f40-9787-1ef40aa0bfd5_7.jpg',2),(10,1,1,1,3,1,23,455,'439a0599-74ba-4e86-9a7e-d8f4e82fca38_33.jpg',1),(11,1,1,1,3,1,23,235,'43ada390-f194-4a64-886c-b10b01d63ccf_37.jpg',1),(12,1,1,1,3,1,23,300,'f6918cf2-7653-4d17-84b7-2bf8eb1f92c0_34.jpg',2),(13,1,1,1,3,1,32,300,'0c661ca7-37c3-4ed3-84fa-e9c0c03ca1d4_24.png',2),(14,1,1,1,3,2,53,32,'47e6bd67-08d4-480f-a0e4-6c5f0d7068cc_36.jpg',2),(15,1,1,1,4,2,234,220,'35e8e512-ebb5-41bb-a0e1-f7c7bed30ccb_4.jpg',1),(16,1,1,1,3,3,26,220,'da80d5d4-37b5-4cdd-a636-da3f8f992897_9.jpg',1),(17,1,1,1,4,1,3242,220,'e49864a1-cb06-4fdf-ae36-94a8e54a652f_6.jpg',1),(18,1,1,1,4,1,23,300,'cfa3225f-cf79-468a-bdd1-1fdb9469b70e_8.jpg',1),(19,1,1,1,4,1,23,455,'d704ecdd-6de9-4feb-b89b-420e83fb4a13_44.jpg',1),(20,1,1,1,5,1,23,300,'1ae6d75a-b3ae-4d64-8c54-2860017015aa_5.jpg',1),(21,1,1,1,5,2,23,34,'bf5d9797-311f-4eea-815d-c45d24f5346d_66.jpg',1),(22,1,1,1,4,2,43,23,'37f6bf10-0139-434c-8eb2-a612a7d36b33_56.jpg',1),(23,1,1,1,6,1,45,34,'0e3a4429-fedd-4336-8930-b7d82b4d5845_56.jpg',1),(24,1,1,1,5,3,43,232,'7a97d453-c4a6-4fd0-b229-ff98d18d8b74_52.jpg',1),(25,1,1,1,6,1,23,455,'450546f0-2ba2-494e-985b-24808bc469b5_41.jpg',1),(26,1,1,1,6,2,453,300,'9cf2f80e-720d-48c6-91bc-8b4e902152fe_33.jpg',1),(27,1,1,1,5,1,34,23,'22d471cc-0ad0-4f4b-9b1f-653b5fe57489_12.jpg',1),(28,1,1,1,4,2,43,234,'76a594d2-10d7-4608-9823-3c01af39a411_40.jpg',2),(29,1,1,1,2,1,23,23422,'54daf6ad-18e5-432e-be4a-60924f80df81_4.jpg',2),(30,1,1,1,3,1,23,520,'75d98ca3-c43a-4694-a55d-e1e0feb79342_59.jpg',1),(31,1,2,1,1,1,26,220,'3481db61-783b-4229-8c06-16b203b62e1d_28.jpg',1),(32,1,2,1,1,2,343,12,'a4cb7ea7-db97-4b55-8e34-29de9effc2d3_7.jpg',1),(33,1,2,1,1,2,12,260,'9b5038b9-c2ae-40a3-b00b-0294ac827172_6.jpg',1),(34,1,2,1,1,2,12,300,'e5760768-f3f0-42fd-b95c-14a0c268290f_55.jpg',1),(35,1,2,1,1,2,123,220,'3e9b2dd4-7bf1-4c8d-ad8d-c039dd732a3b_61.jpg',1),(36,1,2,1,1,1,213,300,'a90182ab-7d5f-44da-94bf-740f0802cc97_90.jpg',1),(37,1,2,1,1,2,41,213,'087b2cc8-fc8c-40af-910f-8e1bc151e3b5_60.jpg',1),(38,1,1,1,2,1,12,12,'5d533f1c-d0ca-408b-8917-d966ec4120b2_50.jpg',1),(39,1,1,1,2,2,213,260,'c2c8eaf0-5724-44be-a040-ea002d319757_44.jpg',1),(40,1,2,1,2,1,342,123,'bc42063e-2908-4fbc-a096-6663f4e106d4_59.jpg',1),(41,1,2,1,2,2,43,213,'59491efa-a670-4ff6-ab8a-806868d7f26b_41.jpg',2),(42,1,2,1,2,1,43,21,'4e7df8ab-41b2-4367-afdc-c0aae4351cd4_42.jpg',1),(43,1,2,1,2,2,432,123,'be775fcc-5896-41ee-ac8f-3f8ea9799d1f_51.jpg',2),(44,1,2,1,3,2,332,123,'56cf7d90-9e45-4c49-b826-df5f3b96bbc1_5.jpg',2),(45,1,2,1,3,2,42,434,'9882d000-c3bc-4e59-9e9d-101ab6c45b44_70.jpg',2),(46,1,2,1,3,1,30,31,'45af2503-c0e7-40cb-8b34-7af0534a0ce4_8.jpg',1),(47,1,2,1,3,2,432,213,'9c4b2ae5-0e79-4e6a-b83d-f7a4358efe1f_51.jpg',2),(48,1,2,1,3,2,4324,123,'712eb1f7-ecd8-4b8f-90a2-ec61f788442f_44.jpg',2),(49,1,2,1,4,2,21,300,'5bf78e16-e7b6-47cb-966f-54e48c3ea64d_32.jpg',2),(50,1,2,1,3,2,123,1231,'4528ec97-8d1a-4687-ac51-b6e7569b276c_72.jpg',2),(51,1,2,1,3,2,123,234,'eb4cd17b-d712-4bd2-b992-aa3ea813857b_41.jpg',2),(52,1,2,1,4,2,22,260,'d9de33dc-39ca-41f2-9b6a-b07a3e83c66b_39.jpg',2),(53,1,2,1,4,1,23,300,'cb0dbb1a-1b6f-4701-912f-51161f8427a5_41.jpg',1),(54,1,2,1,4,1,30,300,'d74f5b97-ffce-47e9-93dd-a97e0ee6534e_52.jpg',1),(55,1,2,1,4,2,424,342,'7a952a76-06f4-4ddf-85f5-d3eecb5dffbd_72.jpg',2),(56,1,2,1,4,1,23,300,'697e2d1e-0bf0-4dfe-992b-e08fdd71ffe8_49.jpg',1),(57,1,2,1,4,2,532,423,'750ce565-58d7-461c-8a3e-bdf36499ffe3_38.jpg',2),(58,1,2,1,6,1,22,300,'dcbaebe0-1a8e-4b04-a460-89662fd040c3_41.jpg',1),(59,1,2,1,5,1,23,220,'ca8413f8-8304-44ab-b9db-53ac864984c5_65.jpg',1),(60,1,2,1,5,1,23,300,'4c057cde-f8e3-4e6f-b160-cbeb14fd2656_33.jpg',1),(61,1,3,1,2,3,34,324,'ca7b7e22-f4f4-4014-99d8-e68b1c9235c0_5.jpg',2),(62,1,3,1,4,4,30,260,'fbbc1248-b4fc-4364-a4bd-516c3226d265_36.jpg',3),(63,1,3,1,3,1,452,32,'f9c6abef-f05e-4207-90ba-b1354eae4c8a_50.jpg',1),(64,1,3,1,1,1,22,300,'88ec8b9b-2bdd-4739-90b3-98e59260efac_9.jpg',1),(65,1,3,1,1,1,30,300,'0abcb7c7-813b-4725-9c46-7e35671e9e1c_4.jpg',1),(66,1,3,1,2,1,234,32,'126ec294-f705-4ca0-9323-9c16e8595c09_9.jpg',1),(67,1,3,1,1,2,23,300,'ee096a2e-83f4-46c6-a51d-575c641dd7c9_92.jpg',1),(68,1,3,1,2,1,342,300,'1a305382-4cb3-4187-af3d-96f159fdbae7_1.jpg',1),(69,1,2,1,2,1,22,220,'efe7f281-2ac6-433f-b8b6-6d51f20a4eeb_2.jpg',1),(70,1,3,1,3,2,22,300,'f3ed7597-dcc9-41f8-a41a-091e427925dd_54.jpg',1),(71,1,4,1,2,2,30,220,'d05e7469-718c-482e-8e6c-0e0aa791a1f8_12.jpg',2),(72,1,4,1,1,1,30,300,'8c207567-4e2f-4aa5-a51b-e4dbbd7ed450_12.jpg',2),(73,1,4,1,3,2,22,300,'310baba0-2b02-4653-9caf-4fb8ac27091d_53.jpg',2),(74,1,5,1,3,1,30,220,'e935d124-ef07-481e-b5e5-1db0d5e49c90_49.jpg',1),(75,1,4,1,2,2,26,300,'ea656d8f-6ceb-46bf-90a6-6e7eee27b51c_41.jpg',1),(76,1,4,1,4,4,22,260,'5160397b-88fe-45d3-89c0-aae8dd14c876_41.jpg',2),(77,1,5,1,1,1,30,220,'26c87850-ea24-43f8-8a55-f0186b42ef98_14.jpg',2),(78,1,5,1,3,2,32,434,'c7fbe03a-b8fc-4da1-a253-8887aa0ed1fc_44.jpg',1),(79,1,5,1,3,2,34,3241,'ac2f188f-ecdf-4bbf-9ea8-4cb3ee723336_60.jpg',2),(80,1,5,1,1,2,23,300,'5a38ed15-aa48-4d1d-92c9-4a82551a3b8d_19.jpg',1),(81,1,5,1,3,2,23,453,'78813410-f746-41eb-9353-c61db9db6bd9_38.jpg',2),(82,1,5,1,2,1,22,300,'27b9f665-2459-47e1-a45f-fd4cfd34652f_5.jpg',1),(83,1,5,1,1,1,435,34,'f0902946-5116-4db5-beb8-cc5a12221af8_48.jpg',1),(84,2,1,1,2,1,324,234,'a874564d-8346-4cf2-be32-6cf9bd8ad1b2_11.jpg',2),(85,2,1,1,3,2,423,234,'abbf586c-976a-4c85-848f-1f4309a3bb1d_4.jpg',2),(86,2,1,1,2,2,342,234,'d0dac2d4-2c3c-4bf8-99f6-ae2c1344f1ee_45.jpg',2),(87,2,1,1,3,1,22,300,'9fbac799-33b7-4501-aea9-c76884622686_44.jpg',1),(88,2,1,1,1,1,30,300,'a41aeb14-a5fc-44ed-bc08-7762305b3c83_8.jpg',1),(89,2,1,1,2,3,22,220,'7a0dbc3c-9bd5-4f3c-aa17-3b7b76b98a2b_26.jpg',1),(90,2,1,1,3,1,30,300,'2cf87a7a-3c10-4b1f-9d86-a12f9d739898_38.jpg',2),(91,2,1,1,2,1,45,300,'a1e0ccec-1f24-42b9-9aae-4c8044e4d242_8.jpg',1),(92,2,1,1,2,1,34,234,'b7cc26a2-09f5-408a-8e0d-8f68ca76d3de_33.jpg',1),(93,2,1,1,2,2,22,220,'97cc3315-7612-4e79-9d6e-777152ae9ba6_36.jpg',2),(94,2,1,1,2,3,234,324,'a50f76ad-858a-46bf-a7b7-99d18685dfdf_41.jpg',3),(95,2,1,1,4,1,26,220,'0f5d48b6-c846-457a-a91b-4040fe73843b_32.jpg',1),(96,2,1,1,5,3,30,300,'a474d918-e704-4ee5-997c-c6e368bc2493_28.jpg',2),(97,2,1,1,2,1,324,260,'2571f074-ad3d-48cd-a5dc-5cc5336296cb_12.jpg',1),(98,2,1,1,3,3,22,520,'a22f3a98-afba-4909-bab0-24cbf6991c65_45.jpg',2),(99,2,1,1,2,2,30,300,'dddb0fbe-adb9-4d6a-9c5e-6c8729af26eb_33.jpg',2),(100,1,1,1,2,3,30,220,'1749b563-81bc-4092-a985-a423286e316f_52.jpg',2),(101,2,2,1,2,2,324,23,'2bc4bf4b-4ad9-4f36-8c06-d4e9690849ce_38.jpg',2),(102,2,2,1,2,3,234,234,'8d2f7ade-dc9b-4d82-b0ad-619e5909038c_6.jpg',2),(103,2,2,1,3,3,26,300,'b239258c-c1d3-4c5e-bb63-4684f701319d_4.jpg',2),(104,1,2,1,2,2,233,324,'1fe6f1bc-cfa6-40b8-97ed-41a6e5228e1c_47.jpg',2),(105,2,2,1,3,2,423,234,'24311d44-2206-4343-bf33-c7bff23b8ad0_28.jpg',2),(106,2,2,1,2,2,4324,234,'0cc8fadd-39b2-446e-b2d0-c6ed9369a389_45.jpg',2),(107,2,2,1,2,2,26,260,'ca759584-00a1-416c-a8b0-0e6b51041048_36.jpg',1),(108,2,3,1,1,1,23,260,'e2d7c291-f7e8-4ba6-882a-745c30660800_68.jpg',2),(109,2,3,1,5,2,26,260,'16861d7e-d83a-4d6b-a2d3-9494ef110ead_69.jpg',2),(110,2,3,1,2,3,23,300,'2c28bf0e-9542-4ced-8416-6706b75432e5_20.jpg',2),(111,2,4,1,4,2,26,260,'7d2d53e1-401e-4d35-9873-74c3bda72fba_33.jpg',2),(112,3,1,1,1,1,26,300,'fe63372f-8735-40eb-bcae-673ab73d7d14_52.jpg',1),(113,3,1,1,2,3,22,300,'e83d1cf1-eaae-41a1-8112-e992130172b3_51.jpg',2),(114,3,1,1,3,2,30,300,'c37bbb24-01ae-41b1-b430-4ac3ebf344fa_42.jpg',2),(115,3,3,1,2,2,22,260,'0de7f823-66ee-41c9-9795-52a444d30f40_32.jpg',2),(116,3,1,1,2,1,22,300,'fda97751-c270-45cb-9ab0-1f66336388dd_37.jpg',2),(117,3,1,1,3,1,52,260,'9f7f67be-0db8-44ea-af85-891c1783be28_44.jpg',1),(118,3,1,1,1,1,23,260,'f291ed62-d08a-4bd1-b210-8bae7481a665_2.jpg',1),(119,4,1,1,2,2,30,300,'c83b1497-2da7-4795-970e-53d1e95d8397_42.jpg',2),(120,4,1,1,2,2,30,300,'faca45bc-ee63-4f21-8a97-a3fb75136f8d_56.jpg',2),(121,4,1,1,3,3,22,220,'0e8a6d07-a6fa-43e8-87d6-6cb80c0369de_2.jpg',3),(122,4,2,1,2,2,30,220,'4ab307d7-a305-41ac-9436-aa67fe0b842f_37.jpg',2),(123,4,1,1,2,1,23,300,'3b3dc675-a9ce-4fec-a494-9c8545747d53_50.jpg',1),(124,1,1,2,2,2,26,300,'ae5d023a-9878-4c3e-b893-f0ebff3b2a6f_36.jpg',2),(125,1,1,2,3,3,26,300,'cc160153-73ef-474b-8079-e16beecd1ad0_28.jpg',1),(126,1,1,6,2,2,234,300,'c173f89f-6dbe-4e21-b573-a0c5bccb51a4_89.jpg',2),(127,1,4,1,3,1,22,220,'c49d720b-1379-4ec8-9de5-c123abfbe943_38.jpg',2),(128,1,1,1,2,1,22,34,'55119ab0-9e51-48ad-b0a7-77af728ef6ca_50.jpg',1),(129,1,1,1,4,2,24,234,'3e5cb839-aedb-4c6f-8ee8-4315b6b91877_65.jpg',2),(130,1,1,1,3,2,234,2341,'4c3ed7e0-27bb-4a76-9fc0-6404db5b8eb2_80.jpg',2),(131,1,1,1,5,1,23412,234,'9d4f6b8b-5acd-4f6f-abf4-72d9feead990_64.jpg',2),(132,1,1,1,4,3,23,23,'f56f5e93-620e-4c2b-b8d2-6b4a302a553c_43.jpg',2),(133,2,3,1,1,1,23,220,'5af8bfd3-9346-4d7c-aba1-48e294ba91bc_49.jpg',1),(134,3,2,1,2,1,342,12321342,'d7d289c2-8c33-42aa-baec-7aabaa3f2120_41.jpg',2),(135,4,1,1,3,2,321,231,'510cfbce-4397-4eab-ab91-36538a1eadbf_37.jpg',2),(136,2,4,1,6,1,1,1,'1a504b8b-a351-440c-b17e-6a8993fcc28d_47.jpg',1),(137,3,2,1,3,3,342,234,'cfb3f701-5bb4-4697-aede-3b728287db69_56.jpg',3),(138,3,2,1,2,2,34,123,'dafdf2b3-33da-44c6-83d0-fd49c5741d12_81.jpg',2),(139,1,1,1,1,1,435,23,'325f8026-ff9e-45ee-8393-cf6432525c65_44.jpg',2),(140,4,4,1,4,1,2213,342,'7c55b3c7-e8d9-4fef-9da8-caa456b0f27a_4.jpg',1),(141,3,2,1,2,2,12,234,'19735176-00d6-4128-bc44-e1719c14920d_5.jpg',1),(142,1,1,1,1,2,345,34,'e2c9f733-c5a8-453d-b409-fda4a09c0bb7_49.jpg',2),(143,3,2,1,2,1,123,2345,'01c58268-4d72-423b-a5b1-9e9f7544e383_5.jpg',2),(144,3,2,1,3,2,42,12,'8935e9dd-b2bd-422e-b98c-48a11228ce9f_37.jpg',2),(145,1,2,1,3,3,123,23,'4fa4b305-7a53-4af1-93a8-d23fedb19b1a_32.jpg',2),(146,2,1,1,3,2,67,657,'d018cc03-5c0a-4864-bdf9-5dbabf38c445_4.jpg',1),(147,2,2,1,4,3,87,657,'d9705fb0-1866-4738-99c7-c927677763ea_44.jpg',2),(148,3,2,1,3,3,87,67,'37ff63e6-ba20-4762-bd08-d2adca507b1c_35.jpg',3),(149,3,2,1,2,2,786,678,'1b4f0ed7-6c5e-4033-b4e5-79cf01ca3a8b_5.jpg',1),(150,2,2,1,2,2,54,678,'e9d0d72e-2c6e-4b23-849f-514620d46384_21.jpg',2),(151,1,1,1,1,1,876,76,'ef79df79-3338-4131-8e95-01fea50a15c7_19.jpg',1),(152,2,4,1,2,1,56,76,'7b426f68-04af-4f9b-8be3-0380e2f11e55_25.jpg',1),(153,3,2,1,2,1,22,2000,'3c52ecbe-3af9-479b-b13b-8c6d35da9e86_32.jpg',1),(154,3,2,1,2,1,22,2000,'0a583967-64ee-4e2b-8704-acdb50c4f772_32.jpg',1),(155,1,2,1,1,1,6,789,'48df519f-eccf-4f11-92ad-e1d6188c77a3_37.jpg',1),(156,2,1,1,2,1,56,564,'0f84a172-2da7-4393-9b90-421eca862c8e_56.jpg',1),(157,1,1,1,3,2,765,56,'19ae93c9-92af-44b5-a4bc-ac41e2d402cd_29.jpg',2),(158,1,3,1,3,1,676,654,'abce626e-3829-4236-b6c0-51950c4902e0_46.jpg',1),(159,1,2,1,1,1,454,5675,'0199f909-0c88-4b4c-8b85-e5525744d395_65.jpg',1),(160,2,5,1,6,1,22,300,'982a6d99-ed95-4346-9f32-47b102f31ee8_79.jpg',1),(161,4,2,1,1,1,45,657,'8c26eea8-a886-4e7b-bf1e-3eb6d4f7704b_57.jpg',1),(162,3,1,1,2,1,22,300,'5a17d5b7-6744-4289-b0a9-4a4ae3244604_41.jpg',1),(163,3,3,1,3,2,645,2,'a5660462-87c4-4c46-8f76-5be687cdc276_59.jpg',2),(164,3,2,1,4,2,3,56,'35cfe98c-b817-4f96-bdd5-9d77f0124bd4_54.jpg',1),(165,2,2,1,2,2,45,300,'689c050c-da14-45f8-b284-aa50903de2bf_25.jpg',1),(166,2,2,1,2,3,2,22,'15dc22e9-83d2-4768-979b-18ebab5170e8_92.jpg',2),(167,2,2,1,3,3,2,23,'c5a0874a-666f-497b-a024-609c9d634a0a_53.jpg',3),(168,2,4,1,2,1,30,234,'25dbd18a-d679-434e-a912-21f72da2ee2a_66.jpg',1),(169,2,2,1,3,3,22,222,'0a137200-e6aa-4b8b-a490-98c0c50996ab_49.jpg',2),(170,2,2,1,2,1,4,44,'1db26e49-71aa-4026-a3c7-7328e764328f_38.jpg',1),(171,2,2,1,4,1,52,55,'ae627275-f9e5-41a9-aedf-cc66b823b2ca_77.jpg',1),(172,3,3,1,3,3,565,55,'78eed134-65ec-4807-899f-dd9cc5a0ea44_54.jpg',2),(173,3,2,1,3,2,22,260,'5d826341-2f0c-422a-a628-1261014aae8b_46.jpg',2),(174,3,2,1,3,2,45,300,'bb0b0067-1149-45b1-a12a-5aace979a795_42.jpg',1),(175,4,2,1,2,2,6,66,'06d87a23-4a8f-42b6-bba8-5d2c268c99c8_88.jpg',2),(176,4,2,1,3,2,6,77,'aea0a747-5bbb-4787-a823-571e163fa16e_66.jpg',2),(177,2,2,1,3,2,55,776,'4f071c32-e999-420e-bf42-d78dd513d84d_61.jpg',2),(178,2,2,1,2,2,5,76555,'ed68f7b6-7059-4bce-84c4-4de62dbf5e73_36.jpg',2),(179,2,2,1,3,2,21,12,'1d114344-09d8-4683-857c-30b5117f3bad_33.jpg',2),(180,2,2,1,2,2,2,231,'ce673c7e-ee0b-4717-919d-33fd782e4d49_55.jpg',2),(181,2,1,2,2,2,23,34,'1366d139-ebfe-4c77-93f2-a9009f677774_6.jpg',2),(182,2,1,3,2,2,53,234,'8d091964-a9bb-4d85-b689-d2c12149e339_40.jpg',2),(183,2,1,2,2,2,87,89,'a5a89a88-4e14-4902-9383-ec64af9e5d6a_47.jpg',2),(184,2,1,5,3,2,78,789,'da46210d-5976-4fed-a8dd-bde7fc43425e_29.jpg',2),(185,3,1,2,3,2,98,789,'af6f45ab-1312-4c51-b19a-103ede8fa6d3_37.jpg',2),(186,3,1,3,3,3,77,789,'13aa081a-c639-48c8-87f9-fecc1e7bd1cc_37.jpg',3),(187,2,1,2,3,2,88,78,'498ccd97-44ea-497a-9c86-24e0e6c93480_41.jpg',3),(188,2,1,3,2,2,78,854,'5ed27fc2-82ad-4b1c-8f81-9d88a014845c_48.jpg',2),(189,1,1,10,3,3,7,45,'13fe2d9d-bf76-4cb2-b255-e76be30a42d5_12.jpg',3),(190,2,1,7,3,2,22,300,'36627ecc-e55f-4443-aa90-769debfb2035_49.jpg',2),(191,3,1,2,2,2,56,45,'8e13e3a0-fe74-4890-b295-3b7f95c1a406_52.jpg',3),(192,2,1,7,3,2,56,56,'0eae5d06-d3e7-48d7-a53e-fc0705bccd60_65.jpg',2),(193,2,1,2,2,2,5,45,'7501026f-627d-4210-a2b6-3276a5b2b859_2.jpg',1),(194,2,1,12,2,2,65,45,'97408423-d101-4fcf-9d77-9e27b2e054e7_57.jpg',3),(195,3,1,7,3,3,65,45,'c7a901dd-d407-4c94-9807-7f9edf4a3d1d_49.jpg',2),(196,4,1,6,3,2,2,32,'991d346c-70a3-4812-83bf-067094c133be_56.jpg',2),(197,3,1,5,2,3,22,260,'863fb794-4ef1-4f8a-ac14-e323910f2e81_37.jpg',2),(198,3,1,5,1,3,655,1255,'1f068bbc-015c-481d-be9d-5f284f169298_41.jpg',2),(199,3,1,4,4,3,23,220,'62f82ba5-b0aa-47cc-b237-3b9624e7187d_40.jpg',2),(200,2,1,7,3,2,7,88,'70549e2b-cef3-42b1-a8ce-a607b21d2ab2_43.jpg',2),(201,3,1,8,3,2,6,66,'521fb8fb-b692-4e74-ad85-4f8180f1f3eb_30.jpg',2),(202,1,1,4,3,3,654,45,'35cd162f-abe0-4a75-af6b-75a2e3aa0ca2_45.jpg',3),(203,1,1,1,1,1,44,645,'2f6fd89b-46c1-4ded-a669-8812c93dcce5_81.jpg',1),(204,3,1,2,2,2,54,45,'198ebd37-140a-4201-9ba2-d3ee9e0e2960_53.jpg',2),(205,3,1,9,3,3,45,456,'e67f848c-7a41-445e-a7c8-4e9accd324c1_51.jpg',2),(206,3,1,9,3,3,456,45,'bcb9d404-2fb4-45d6-a0dd-4c2e3f7c582d_67.jpg',1),(207,3,1,9,3,1,65,45,'9e150656-1fcd-45a3-9fc2-60f2ce5e3ddd_62.jpg',2),(208,4,1,10,1,4,22,260,'1b8d2057-f228-45a1-a845-9bc5b1a3e178_14.jpg',2),(209,3,1,3,2,2,22,220,'74667425-bdc8-42d0-b0ec-ca67c742aa8b_4.jpg',2),(210,1,1,3,2,2,45,65,'d6b39726-fe06-40a8-abda-ffb9ef80f379_37.jpg',2),(211,1,1,11,1,1,30,300,'0dfee7ed-25c5-423c-8d87-80c39ab3af81_14.jpg',1),(212,1,1,11,2,1,320,320,'e735c526-44e4-492a-a2cc-b3be86b8f23e_19.jpg',2),(213,1,1,11,3,1,26,260,'ec6310f1-2402-48e5-abc0-9104d8b1b5f5_2.jpg',2),(214,1,1,11,4,1,52,520,'28d40477-31c8-441c-a678-7a800e846d1d_11.jpg',2),(215,1,1,11,5,1,26,260,'1103ad6b-56dc-47af-aaae-3e8c26ea10e0_15.jpg',2),(216,1,1,11,6,1,23,234,'f45ff8af-ff05-44f1-ae75-926febe460c5_38.jpg',1),(218,1,1,1,1,1,30,220,'972dfc5e-3e32-4f31-b0ea-0f8929bee601_7.jpg',1),(219,1,1,1,1,1,99,999,'b72753e1-02f1-4207-bab1-7c7150c584ef_1.jpg',1),(220,2,2,2,1,1,33,333,'9d5378d7-c50a-409f-b2f6-6845a1d5f1bb_1.jpg',2),(221,3,2,11,2,2,45,220,'66298166-5420-4eaa-9608-242de2ee3c12_6.jpg',2),(222,2,2,3,3,2,45,220,'97399e75-9a65-4228-a241-f4c555c124e9_8.jpg',2),(223,1,1,1,1,1,30,220,'88397d1a-dbe4-441c-9cc0-a11ba08aacb3_5.jpg',1),(224,1,1,1,1,1,22,220,'55474d10-a29a-4503-9de4-6720a9ba9cc3_8.jpg',1),(225,1,1,1,1,1,30,300,'c1eeff87-5e85-468e-a4f8-bbb3224be96d_11.jpg',1),(226,1,1,1,1,1,30,300,'7cec84df-af64-4366-82c3-8c6711546342_11.jpg',1),(227,1,1,1,1,1,26,300,'e81b1fe5-ea61-49ba-b9f7-eb1fc7b0b215_23.png',1),(228,3,2,3,1,1,22,260,'91fe2386-d243-4c2a-897f-7b8ae5ef9ca7_7.jpg',1),(229,1,1,1,1,1,22,300,'38f136e9-07f4-4ab3-9484-de834f851b3e_11.jpg',1),(230,1,1,1,1,1,30,300,'059c12ce-5a43-4b13-8621-ec280de824ae_1.jpg',1),(231,1,1,1,1,1,26,300,'a4abd649-ec23-4906-97b1-4f14ad0d8778_32.jpg',1),(232,1,1,1,1,1,30,260,'cb014c2a-9e29-47a6-aac6-12b1bd146662_5.jpg',1),(233,3,1,1,1,1,26,300,'c25f5d46-c4c6-491c-9592-9ff776be6562_6.jpg',1),(234,3,1,1,1,1,26,300,'d90e9089-c3ae-47a8-9edc-b1540d006557_6.jpg',1),(235,1,1,1,1,1,30,300,'94f92d8a-fbf8-4a1f-b40f-df4d3ddd320b_6.jpg',1),(236,1,1,1,1,1,30,300,'e2fd418c-353e-4893-9689-397024bbe3d6_6.jpg',1),(237,1,1,1,1,1,30,300,'deb38140-42e1-4cf9-90ed-48722b520248_6.jpg',1),(238,3,3,1,1,1,22,300,'c72eedfe-e26a-4f04-92ba-fb66997135f9_6.jpg',1),(239,1,1,1,1,1,30,300,'db9f2587-1a4f-4234-a516-1505039f5b35_10.jpg',1),(240,2,2,3,1,1,30,260,'46d84caa-f1e1-4d3f-b557-a7b41683f94f_5.jpg',1),(241,1,1,1,1,1,30,300,'1dc69dfd-5b59-4dfb-96a8-70986750d1ac_6.jpg',1),(242,2,1,1,1,1,30,220,'04eb9eb0-f15d-462a-b892-1c85a047ce21_12.jpg',1),(243,4,5,12,5,4,30,220,'74e21315-f869-404e-9304-3f05c8a6dd81_5.jpg',3),(244,4,1,1,1,1,26,3333,'84adfaf1-9f00-4012-aaf1-c3b394a8a4f3_40.jpg',1),(245,1,1,1,1,1,30,300,'bc7c436e-f7f5-4a49-8883-fa13d9e89333_1.jpg',1),(246,1,1,1,1,1,22,300,'a1abb2ad-bfd6-43e3-adb6-cfdcb2f202fa_5.jpg',1),(247,3,1,1,1,1,30,300,'491c92cc-7801-4611-b7ae-d6eb010d398f_11.jpg',1),(248,1,1,1,1,1,22,220,'0ff9357c-3e61-450f-b3a7-16ceaddca5f0_1.jpg',1),(249,1,1,1,1,1,30,300,'9f5a6d0d-0cec-4481-b8f1-84a8808fcfbe_5.jpg',1),(250,1,1,1,1,1,26,300,'b4f8f2ce-714b-474f-8bed-dedfa8770c23_6.jpg',1),(251,2,1,1,1,1,22,300,'7685a63d-968f-43e8-8154-f95927d35d9f_10.jpg',1),(252,1,1,1,1,1,22,300,'a676431c-5167-4d1b-aa5e-0e8ce8120a0e_5.jpg',1),(253,1,1,1,1,1,30,300,'62a6a905-510c-4d6c-aa3f-60d4b0c5eca4_11.jpg',1),(254,1,1,1,1,1,30,300,'a477d08b-3cb4-403d-a677-d62ddf7f64ec_1.jpg',1),(255,1,1,1,1,1,30,300,'84555dcb-d72a-4b27-9019-bb8ffe1704aa_6.jpg',1),(256,1,1,1,1,1,30,300,'689f6b11-a040-484a-80c6-0d4525e810b5_12.jpg',1),(257,1,1,1,1,1,30,300,'7175fb51-456d-49d6-a252-55e98717f8d7_10.jpg',1),(258,1,1,1,1,1,30,300,'53c85b7d-2126-4547-8997-ae693ca43e9d_10.jpg',1),(259,1,1,1,1,1,26,260,'00c13829-62c1-49ca-88cf-f2b4f340a37c_11.jpg',1),(260,1,1,1,1,1,22,300,'188d08c0-03d2-4f89-ae15-6e8f8c1f0924_6.jpg',1),(261,1,1,1,1,1,52,220,'b429e7a8-af3c-4a5b-8836-532b95b32397_11.jpg',1),(262,1,1,1,1,1,30,260,'9bb21a1e-5d9e-4c3b-ad8b-6277c428c806_6.jpg',1),(263,1,1,1,1,1,22,300,'78e1c07d-5e15-4e88-a4f0-fcdec29e49a3_7.jpg',1),(264,1,1,1,1,1,30,300,'a2a53fc8-d604-4f11-9aa0-5fe463323f29_7.jpg',1),(265,1,1,1,1,1,30,300,'b9256c2e-3461-48b0-b9fc-09cb2abac6ec_8.jpg',1),(266,1,1,1,1,1,30,300,'29deec94-98ea-43b4-a877-887f4a3c63ef_5.jpg',1),(267,1,1,1,1,1,22,300,'f97a86b9-c36c-4844-a35b-e5f0c8b75168_6.jpg',1),(268,1,1,1,1,1,22,300,'e3eeb864-bcfd-4258-a7b6-f1fb72b12cb8_5.jpg',1),(269,1,1,1,1,1,22,220,'5f0c92d3-8e11-4209-94bf-867453cc6ed7_7.jpg',1),(270,1,1,1,1,1,22,300,'e2efae8f-afe0-4cfa-be16-eaa14e5a3091_5.jpg',1),(271,1,1,1,1,1,30,300,'3fd9b144-1fa8-4bc7-9023-514fbcb8205c_8.jpg',1),(272,1,1,1,1,1,30,300,'fbfc412d-f244-4c28-9364-a53ca4eabfb7_8.jpg',1),(273,1,1,1,1,1,22,300,'630eccdd-05f6-41d0-8caa-9e73753cf6fb_6.jpg',1),(274,1,1,1,1,1,22,300,'c47fb707-3566-47af-8523-940a4021345e_6.jpg',1),(275,1,1,1,1,1,52,300,'94d4c9b0-c03f-410e-b1c0-689e37752bb8_8.jpg',1),(276,1,1,1,1,1,22,220,'dc52fa07-cc01-4ccc-868f-965cd72afaf4_8.jpg',1),(277,1,1,1,1,1,30,300,'d72d8780-05c0-4ebc-8ebb-f98282c36d71_6.jpg',1),(278,1,1,1,1,1,22,300,'4ed71a55-923b-4975-ab24-2bc3f0d4f7bf_8.jpg',1),(279,1,1,1,1,1,30,300,'298bfbe0-d611-4f22-bb68-55cec76197a6_11.jpg',1),(280,1,1,1,1,1,30,260,'a13b9b44-6f2d-493b-a96a-4ba4e356055b_10.jpg',1),(281,1,1,1,1,1,30,300,'ad9bcb32-abfa-468c-9b51-75a85ba3f08d_4.jpg',1),(282,1,1,1,1,1,30,220,'e6075902-72b5-4d6b-a085-1b3ecfd4d13d_12.jpg',1),(283,1,1,1,1,1,22,300,'eccdb82b-1194-488f-8d20-571d3f97985e_9.jpg',1),(284,1,1,1,1,1,22,300,'8af2d6ea-929f-4cdd-b322-7f2092907d59_9.jpg',1),(285,1,1,1,1,1,30,300,'31c1b7e9-db41-4874-842e-cb54a6aaa445_7.jpg',1),(286,1,1,1,1,1,22,300,'e3781e84-e050-45ff-8ead-6c9ceead80ce_5.jpg',1),(287,1,1,1,1,1,30,300,'be20c484-6103-42af-88d8-b5c1081a7567_11.jpg',1),(288,1,1,1,1,1,30,300,'4705ccd1-0bb2-4ee3-8da7-0961945c6fbf_6.jpg',1),(289,1,1,1,1,1,30,300,'f620121a-b26e-458a-9a8e-95f8fcba40a4_4.jpg',1),(290,1,1,1,1,1,30,220,'9b8922fc-fd8d-4cff-9419-1d2ef5117968_5.jpg',1);

/*Table structure for table `historyorder` */

DROP TABLE IF EXISTS `historyorder`;

CREATE TABLE `historyorder` (
  `historyOrderID` int(11) NOT NULL AUTO_INCREMENT,
  `o_ID` int(11) DEFAULT NULL,
  `o_statusID` int(11) DEFAULT NULL,
  PRIMARY KEY (`historyOrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `historyorder` */

/*Table structure for table `integral` */

DROP TABLE IF EXISTS `integral`;

CREATE TABLE `integral` (
  `i_lID` int(11) NOT NULL AUTO_INCREMENT,
  `i_number` int(11) DEFAULT NULL,
  `i_authority` int(11) DEFAULT NULL,
  PRIMARY KEY (`i_lID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `integral` */

/*Table structure for table `n_sort` */

DROP TABLE IF EXISTS `n_sort`;

CREATE TABLE `n_sort` (
  `n_SortID` int(11) NOT NULL AUTO_INCREMENT,
  `n_sortname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`n_SortID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `n_sort` */

insert  into `n_sort`(`n_SortID`,`n_sortname`) values (1,'优惠'),(2,'2');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `n_ID` int(11) NOT NULL AUTO_INCREMENT,
  `n_SortID` int(11) DEFAULT NULL,
  `n_title` varchar(1000) DEFAULT NULL,
  `n_content` varchar(1000) DEFAULT NULL,
  `newscreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`n_ID`),
  KEY `FK_Reference_20` (`n_SortID`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`n_SortID`) REFERENCES `n_sort` (`n_SortID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`n_ID`,`n_SortID`,`n_title`,`n_content`,`newscreatetime`) values (4,1,'家电低至五折','家电低至五折','2018-09-28 11:10:18'),(5,1,'[ 公告 ]发福利 买车就抢千元油卡','[ 公告 ]发福利 买车就抢千元油卡','2018-09-28 11:12:33'),(6,1,'易购服饰勋章体系改版公告2324','亲爱的易购商城用户：<br><br><br>\r\n\r\n   为了更好地为广大图书勋章用户开展服务，提供更丰富的惊喜权益，自9月10日00:00起，京东图书勋章体系将迎来一次全新改版。<br><br><br>\r\n   新的图书勋章等级对京东图书用户体系的评估维度进行了优化升级，它基于用户近12个月在京东图书的消费金额计算得出，京东图书勋章等级每天更新并成为用户享受相关权益的评价标准。3\r\n','2018-09-28 14:02:14');

/*Table structure for table `o_info` */

DROP TABLE IF EXISTS `o_info`;

CREATE TABLE `o_info` (
  `o_InfoID` int(11) NOT NULL AUTO_INCREMENT,
  `g_ID` int(11) DEFAULT NULL,
  `o_price` double DEFAULT NULL,
  `o_totalprice` double DEFAULT NULL,
  `o_status` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `o_time` timestamp NULL DEFAULT NULL,
  `o_count` int(11) DEFAULT NULL,
  `order_son_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`o_InfoID`),
  KEY `FK_Reference_12` (`g_ID`),
  KEY `FK_Reference_41` (`orderID`),
  KEY `FK_Reference_51` (`o_status`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`g_ID`) REFERENCES `goods` (`g_ID`),
  CONSTRAINT `FK_Reference_41` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  CONSTRAINT `FK_Reference_51` FOREIGN KEY (`o_status`) REFERENCES `o_status` (`o_statusID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `o_info` */

insert  into `o_info`(`o_InfoID`,`g_ID`,`o_price`,`o_totalprice`,`o_status`,`orderID`,`o_time`,`o_count`,`order_son_number`) values (1,1,50,150,1,NULL,NULL,NULL,NULL),(2,2,60,180,1,NULL,NULL,NULL,NULL),(3,219,999,4995,1,4,'2018-09-28 10:42:29',5,NULL),(4,125,300,2100,1,4,'2018-09-28 10:42:29',7,NULL),(5,125,300,2100,1,4,'2018-09-28 10:42:29',7,NULL),(6,125,300,600,1,4,'2018-09-28 10:42:29',2,NULL),(7,128,34,136,1,4,'2018-09-28 10:42:29',4,NULL),(8,125,300,1200,1,5,'2018-09-28 12:12:15',4,NULL),(9,132,23,23,1,5,'2018-09-28 12:12:15',1,NULL),(10,124,300,300,1,5,'2018-09-28 12:12:15',1,NULL),(11,1,220,440,1,5,'2018-09-28 12:12:15',2,NULL),(12,128,34,102,1,6,'2018-09-28 14:05:43',3,NULL),(13,124,300,300,1,7,'2018-09-28 14:06:17',1,NULL);

/*Table structure for table `o_status` */

DROP TABLE IF EXISTS `o_status`;

CREATE TABLE `o_status` (
  `o_statusID` int(11) NOT NULL AUTO_INCREMENT,
  `o_statusname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`o_statusID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `o_status` */

insert  into `o_status`(`o_statusID`,`o_statusname`) values (1,'未支付'),(2,'已支付'),(3,'已发货'),(4,'已签收'),(5,'退换货'),(6,'已取消');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `o_statusID` int(11) DEFAULT NULL,
  `u_ID` int(11) DEFAULT NULL,
  `o_money` double DEFAULT NULL,
  `o_add` varchar(50) DEFAULT NULL,
  `o_name` varchar(20) DEFAULT NULL,
  `o_phone` varchar(20) DEFAULT NULL,
  `order_Time` timestamp NULL DEFAULT NULL,
  `order_number` varchar(20) DEFAULT NULL,
  `payment` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `FK_Reference_11` (`o_statusID`),
  KEY `FK_Reference_13` (`u_ID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`o_statusID`) REFERENCES `o_status` (`o_statusID`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`u_ID`) REFERENCES `user` (`u_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`orderID`,`o_statusID`,`u_ID`,`o_money`,`o_add`,`o_name`,`o_phone`,`order_Time`,`order_number`,`payment`) values (1,1,1,20,'四川省成都市武侯区','张三','13578948946',NULL,NULL,NULL),(2,1,1,100,'青羊区大道','李四','13688994586',NULL,NULL,NULL),(3,2,2,20,'四川省成都市武侯区','张三','13578948946',NULL,NULL,NULL),(4,2,13,9931,'四川宜宾成华区是打发斯蒂芬','阿萨德','165454656545646','2018-09-28 10:42:28','201809281042286499','支付宝'),(5,2,1,1963,'四川宜宾武侯区圣诞快乐发考虑','王磊','17895646','2018-09-28 12:12:15','201809281212151550','支付宝'),(6,2,18,102,'四川成都武侯区','','','2018-09-28 14:05:43','20180928140543197','支付宝'),(7,1,18,300,'四川成都武侯区','','','2018-09-28 14:06:17','201809281406173459','银行扣款/转账');

/*Table structure for table `s_car` */

DROP TABLE IF EXISTS `s_car`;

CREATE TABLE `s_car` (
  `s_CarID` int(11) NOT NULL AUTO_INCREMENT,
  `g_ID` int(11) DEFAULT NULL,
  `u_ID` int(11) DEFAULT NULL,
  `goods_count` int(11) DEFAULT '1',
  `u_add_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`s_CarID`),
  KEY `FK_Reference_18` (`g_ID`),
  KEY `FK_Reference_33` (`u_ID`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`g_ID`) REFERENCES `goods` (`g_ID`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`u_ID`) REFERENCES `user` (`u_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `s_car` */

insert  into `s_car`(`s_CarID`,`g_ID`,`u_ID`,`goods_count`,`u_add_time`) values (16,128,16,1,'2018-09-27 10:33:45'),(30,128,15,2,'2018-09-28 10:33:34'),(31,157,14,6,'2018-09-28 10:36:35'),(36,187,1,1,'2018-09-28 13:37:13'),(37,187,1,4,'2018-09-28 14:00:22');

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `t_ID` int(11) NOT NULL AUTO_INCREMENT,
  `g_ID` int(11) DEFAULT NULL,
  `t_content` varchar(50) DEFAULT NULL,
  `t_time` varchar(20) DEFAULT NULL,
  `u_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

insert  into `topic`(`t_ID`,`g_ID`,`t_content`,`t_time`,`u_ID`) values (1,1,'中国很棒','2018-6-7',1),(2,2,'北京青年','2018-6-8',2),(3,3,'欧美','2018-6-9',3);

/*Table structure for table `u_limit` */

DROP TABLE IF EXISTS `u_limit`;

CREATE TABLE `u_limit` (
  `u_LimitID` int(11) NOT NULL AUTO_INCREMENT,
  `u_Limitname` varchar(10) DEFAULT NULL,
  `u_Limitnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_LimitID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `u_limit` */

insert  into `u_limit`(`u_LimitID`,`u_Limitname`,`u_Limitnumber`) values (1,'普通用户',1),(2,'管理员用户',2),(3,'VIP用户',3);

/*Table structure for table `u_login` */

DROP TABLE IF EXISTS `u_login`;

CREATE TABLE `u_login` (
  `u_LoginID` int(11) NOT NULL AUTO_INCREMENT,
  `u_loginName` varbinary(10) DEFAULT NULL,
  `u_loginpwd` varchar(10) DEFAULT NULL,
  `u_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_LoginID`),
  KEY `FK_Reference_31` (`u_ID`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`u_ID`) REFERENCES `user` (`u_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `u_login` */

insert  into `u_login`(`u_LoginID`,`u_loginName`,`u_loginpwd`,`u_ID`) values (1,'admin','456789',1),(9,'admin123','111111',13),(10,'admin222','111111',14),(11,'admin333','111111',15),(12,'wangzi','789789',16),(13,'admin1','222222',17),(14,'admin555','222222',18);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_ID` int(11) NOT NULL AUTO_INCREMENT,
  `u_Name` varchar(20) DEFAULT NULL,
  `u_integral` int(11) DEFAULT '0',
  `u_RealName` varchar(10) DEFAULT NULL,
  `u_Age` int(11) DEFAULT NULL,
  `u_Sex` char(2) DEFAULT NULL,
  `u_Phone` varchar(20) DEFAULT NULL,
  `u_papers` varchar(20) DEFAULT NULL,
  `u_address` varchar(50) DEFAULT NULL,
  `u_email` varchar(50) DEFAULT NULL,
  `u_limit` int(11) DEFAULT '1',
  `u_LoginName` varchar(20) DEFAULT NULL,
  `u_money` double DEFAULT NULL,
  `u_lastlogin_time` timestamp NULL DEFAULT NULL,
  `u_registration_time` timestamp NULL DEFAULT NULL,
  `u_path` varchar(100) DEFAULT 'E:\\pic\\9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg',
  PRIMARY KEY (`u_ID`),
  KEY `FK_Reference_32` (`u_limit`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`u_limit`) REFERENCES `u_limit` (`u_LimitID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_ID`,`u_Name`,`u_integral`,`u_RealName`,`u_Age`,`u_Sex`,`u_Phone`,`u_papers`,`u_address`,`u_email`,`u_limit`,`u_LoginName`,`u_money`,`u_lastlogin_time`,`u_registration_time`,`u_path`) values (1,'aa',1,'dgdg',20,'','13800001111','555555','成都','123@163.com',1,'admin',NULL,'2018-09-29 13:41:19','2018-09-19 22:21:13','E:\\pic\\06337ad3-2bc2-46ea-98ff-39026edae145_9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg'),(13,NULL,0,NULL,NULL,NULL,'13330301111',NULL,NULL,'1@1.com',1,'admin123',NULL,'2018-09-28 10:39:43','2018-09-19 22:32:14','E:\\pic\\9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg'),(14,NULL,0,NULL,NULL,NULL,'13330302222',NULL,NULL,'11111@1.com',1,'admin222',NULL,'2018-09-28 10:36:23','2018-09-19 22:41:17','E:\\pic\\9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg'),(15,NULL,0,NULL,NULL,NULL,'13330301111',NULL,NULL,'121212@1.com',1,'admin333',NULL,'2018-09-28 10:33:23','2018-09-20 17:13:49','E:\\pic\\88675cd3-7ef3-4625-ba43-f07e9822418c_user.jpg'),(16,NULL,0,NULL,NULL,NULL,'13188888888',NULL,NULL,'1682535@qq.com',1,'wangzi',NULL,'2018-09-26 14:36:04','2018-09-26 14:36:04','E:\\pic\\9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg'),(17,NULL,0,NULL,NULL,NULL,'13100000000',NULL,NULL,'123@163.com',1,'admin1',NULL,'2018-09-26 16:41:42','2018-09-26 16:41:42','E:\\pic\\9d976d1a-4c8e-4b41-85f1-bbb516df9781_user.jpg'),(18,NULL,0,NULL,NULL,NULL,'13100000000',NULL,NULL,'12@123.com',1,'admin555',NULL,'2018-09-28 14:03:24','2018-09-28 14:03:24','E:\\pic\\57ace4f0-826b-41f0-9420-2942ee029c4b_1.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
