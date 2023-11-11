-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlydiemsv
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `diem_hoc_phan`
--

DROP TABLE IF EXISTS `diem_hoc_phan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem_hoc_phan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `diem` double NOT NULL,
  `ma_hoc_phan` varchar(255) DEFAULT NULL,
  `mssv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmlp2vengpv3tqxkrbddfxceoc` (`ma_hoc_phan`),
  KEY `FKa6m7gdyoasmvdhpjkk2wqki7h` (`mssv`),
  CONSTRAINT `FKa6m7gdyoasmvdhpjkk2wqki7h` FOREIGN KEY (`mssv`) REFERENCES `sinh_vien` (`mssv`),
  CONSTRAINT `FKmlp2vengpv3tqxkrbddfxceoc` FOREIGN KEY (`ma_hoc_phan`) REFERENCES `hoc_phan` (`ma_hoc_phan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem_hoc_phan`
--

LOCK TABLES `diem_hoc_phan` WRITE;
/*!40000 ALTER TABLE `diem_hoc_phan` DISABLE KEYS */;
INSERT INTO `diem_hoc_phan` VALUES (1,8.5,'HP001','SV001'),(2,7,'HP002','SV002'),(3,6.5,'HP003','SV003'),(4,9,'HP004','SV004'),(5,8,'HP005','SV005'),(6,7.5,'HP006','SV006'),(7,8,'HP007','SV007'),(8,9.5,'HP008','SV008'),(9,6,'HP009','SV009'),(10,7.5,'HP010','SV010'),(11,8,'HP011','SV011'),(12,9,'HP012','SV012'),(13,7.5,'HP013','SV013'),(14,8,'HP014','SV014'),(15,9.5,'HP015','SV015'),(16,8,'HP016','SV016'),(17,9,'HP017','SV017'),(18,7.5,'HP018','SV018'),(19,8.5,'HP019','SV019'),(20,9,'HP020','SV020'),(21,7.7,'HP001','SV002'),(22,8,'HP003','SV002');
/*!40000 ALTER TABLE `diem_hoc_phan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvien` (
  `magv` varchar(255) NOT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `tengv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`magv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES ('GV001','Dia chi A','nguyenvana@email.com','1234567890','Nguyen Van Anh'),('GV002','Dia chi B','tranthib@email.com','0987654321','Trần Thị Bé'),('GV003','Dia chi C','levanc@email.com','0123456789','Le Van C'),('GV004','Dia chi D','phamthid@email.com','9876543210','Pham Thi D'),('GV005','Dia chi E','hoangvane@email.com','5432109876','Hoang Van E'),('GV006','Dia chi F','nguyenthif@email.com','1357924680','Nguyen Thi F'),('GV007','Dia chi G','tranvang@email.com','4567890123','Tran Van G'),('GV008','Dia chi H','lethih@email.com','6789012345','Le Thi H'),('GV009','Dia chi I','phamvani@email.com','7890123456','Pham Van I'),('GV010','Dia chi K','hoangthik@email.com','8901234567','Hoang Thi K'),('GV011','Dia chi L','nguyenvanl@email.com','9012345678','Nguyen Van L'),('GV012','Dia chi M','tranvanm@email.com','3456789012','Tran Van M'),('GV013','Dia chi N','levann@email.com','2345678901','Le Van N'),('GV014','Dia chi P','phamthip@email.com','1234567890','Pham Thi P'),('GV015','Dia chi Q','hoangvanq@email.com','6543210987','Hoang Van Q'),('GV016','Dia chi R','nguyenthir@email.com','3456789012','Nguyen Thi R'),('GV017','Dia chi S','tranvans@email.com','4567890123','Tran Van S'),('GV018','Dia chi T','lethit@email.com','5678901234','Le Thi T'),('GV019','Dia chi U','phamvanu@email.com','6789012345','Pham Van U'),('GV020','Dia chi V','hoangthiv@email.com','7890123456','Hoang Thi V');
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoc_phan`
--

DROP TABLE IF EXISTS `hoc_phan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_phan` (
  `ma_hoc_phan` varchar(255) NOT NULL,
  `ten_hoc_phan` varchar(255) DEFAULT NULL,
  `so_tin_chi` int NOT NULL,
  PRIMARY KEY (`ma_hoc_phan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_phan`
--

LOCK TABLES `hoc_phan` WRITE;
/*!40000 ALTER TABLE `hoc_phan` DISABLE KEYS */;
INSERT INTO `hoc_phan` VALUES ('HP001','Học phần A',2),('HP002','Học phần B',3),('HP003','Học phần C',3),('HP004','Học phần D',1),('HP005','Học phần E',3),('HP006','Học phần F',1),('HP007','Học phần G',2),('HP008','Học phần H',1),('HP009','Học phần I',3),('HP010','Học phần J',3),('HP011','Học phần K',1),('HP012','Học phần L',2),('HP013','Học phần M',3),('HP014','Học phần N',1),('HP015','Học phần O',1),('HP016','Học phần P',1),('HP017','Học phần Q',1),('HP018','Học phần R',3),('HP019','Học phần S',2),('HP020','Học phần T',1),('HPLTUD','Lap Trinh ung dung java',2),('HPLTW22','Lập Trình Web 1',3),('HPTKHT1','Phân tích thiết kế hệ thống',3);
/*!40000 ALTER TABLE `hoc_phan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocphan_giangvien`
--

DROP TABLE IF EXISTS `hocphan_giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocphan_giangvien` (
  `ma_hoc_phan` varchar(255) NOT NULL,
  `magv` varchar(255) NOT NULL,
  PRIMARY KEY (`ma_hoc_phan`,`magv`),
  KEY `FKctucq69eurlptgxt2tu9vntrr` (`magv`),
  CONSTRAINT `FK97cnsprmj2wt1bn90rpy32g6q` FOREIGN KEY (`ma_hoc_phan`) REFERENCES `hoc_phan` (`ma_hoc_phan`),
  CONSTRAINT `FKctucq69eurlptgxt2tu9vntrr` FOREIGN KEY (`magv`) REFERENCES `giangvien` (`magv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocphan_giangvien`
--

LOCK TABLES `hocphan_giangvien` WRITE;
/*!40000 ALTER TABLE `hocphan_giangvien` DISABLE KEYS */;
INSERT INTO `hocphan_giangvien` VALUES ('HP001','GV001'),('HP002','GV002'),('HP003','GV003'),('HP004','GV004'),('HP005','GV005'),('HP006','GV006'),('HP007','GV007'),('HP008','GV008'),('HP009','GV009'),('HP010','GV010'),('HP011','GV011'),('HP012','GV012'),('HP013','GV013'),('HP014','GV014'),('HP015','GV015'),('HP016','GV016'),('HP017','GV017');
/*!40000 ALTER TABLE `hocphan_giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `ma_khoa` varchar(255) NOT NULL,
  `ten_khoa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_khoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES ('KH001','Khoa Công nghệ thông tin'),('KH002','Khoa Kinh tế'),('KH003','Khoa Kỹ thuật điện tử - Viễn thông'),('KH004','Khoa Ngoại ngữ'),('KH005','Khoa Kỹ thuật Công nghiệp'),('KH006','Khoa Điều dưỡng'),('KH007','Khoa Kỹ thuật Xây dựng'),('KH008','Khoa Quản trị kinh doanh'),('KH009','Khoa Công nghệ kỹ thuật ô tô'),('KH010','Khoa Kỹ thuật Môi trường'),('KHV92','KHOA KHÔNG LÀM MÀ ĐÒI CÓ ĂN 1');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop` (
  `ma_lop` varchar(255) NOT NULL,
  `ten_lop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_lop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES ('L001','Lớp A7'),('L002','Lớp B'),('L003','Lớp C'),('L004','Lớp D'),('L005','Lớp E'),('L006','Lớp F'),('L007','Lớp G'),('L008','Lớp H'),('L009','Lớp I'),('L010','Lớp J');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganh`
--

DROP TABLE IF EXISTS `nganh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganh` (
  `ma_nganh` varchar(255) NOT NULL,
  `ten_nganh` varchar(255) DEFAULT NULL,
  `khoa_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_nganh`),
  KEY `FKf19evb4wgijodpa6il4obpy2y` (`khoa_id`),
  CONSTRAINT `FKf19evb4wgijodpa6il4obpy2y` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`ma_khoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganh`
--

LOCK TABLES `nganh` WRITE;
/*!40000 ALTER TABLE `nganh` DISABLE KEYS */;
INSERT INTO `nganh` VALUES ('N001','Công nghệ thông tin','KH001'),('N002','Kỹ thuật điện tử','KH003'),('N003','Quản trị kinh doanh','KH008'),('N004','Kỹ thuật cơ khí','KH005'),('N005','Tiếng Anh','KH004'),('N006','Hệ thống thông tin','KH001'),('N007','Kỹ thuật viễn thông','KH003'),('N008','Kinh tế chính trị','KH002'),('N009','Kỹ thuật xây dựng','KH007'),('N010','Điều dưỡng','KH006'),('N011','Kỹ thuật công nghiệp','KH005'),('N012','Kỹ thuật ô tô','KH009'),('N013','Kinh tế quốc tế','KH002'),('N014','Quản lý xây dựng','KH007'),('N015','Marketing','KH008'),('N016','Kỹ thuật môi trường','KH010'),('N017','Kỹ thuật truyền thông','KH003'),('N018','Tài chính ngân hàng','KH008'),('N019','Tiếng Trung','KH004'),('N020','Quản lý môi trường','KH010'),('NG002','Không làm mà đòi có ăn','KH002');
/*!40000 ALTER TABLE `nganh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien`
--

DROP TABLE IF EXISTS `sinh_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien` (
  `mssv` varchar(255) NOT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ngay_sinh` datetime(6) DEFAULT NULL,
  `noi_sinh` varchar(255) DEFAULT NULL,
  `phai` varchar(255) DEFAULT NULL,
  `khoa_id` varchar(255) DEFAULT NULL,
  `lop_id` varchar(255) DEFAULT NULL,
  `nganh_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mssv`),
  KEY `FK5hpypr0lq486jaa0xt1261sle` (`khoa_id`),
  KEY `FKk73ubjggi42sgcv07an050p2r` (`lop_id`),
  KEY `FKct487ii903fk24og9if6d0719` (`nganh_id`),
  CONSTRAINT `FK5hpypr0lq486jaa0xt1261sle` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`ma_khoa`),
  CONSTRAINT `FKct487ii903fk24og9if6d0719` FOREIGN KEY (`nganh_id`) REFERENCES `nganh` (`ma_nganh`),
  CONSTRAINT `FKk73ubjggi42sgcv07an050p2r` FOREIGN KEY (`lop_id`) REFERENCES `lop` (`ma_lop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien`
--

LOCK TABLES `sinh_vien` WRITE;
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` VALUES ('AD002','Thúy Vân','2009-06-17 17:00:00.000000','Bình Định','Nữ','KH001','L001','N001'),('AD01','Thành Phạm 1','2002-11-21 17:00:00.000000','Bình Định','nam','KH001','L002','N001'),('SP01','Tự Tin','2002-12-30 17:00:00.000000','Bình Định','Nam','KH001','L001','N001'),('SV001','Nguyen Van A','2000-01-01 00:00:00.000000','TP.HCM','Nam','KH001','L001','N001'),('SV002','Tran Thi B','2000-02-02 00:00:00.000000','Can Tho','Nu','KH002','L002','N002'),('SV003','Le Van C','2000-03-03 00:00:00.000000','Ha Noi','Nam','KH003','L003','N003'),('SV004','Pham Thi D','2000-04-04 00:00:00.000000','Da Nang','Nu','KH004','L004','N004'),('SV005','Ho Van E','2000-05-05 00:00:00.000000','Hue','Nam','KH005','L005','N005'),('SV006','Nguyen Van F','2000-06-06 00:00:00.000000','TP.HCM','Nam','KH001','L001','N001'),('SV007','Tran Thi G','2000-07-07 00:00:00.000000','Can Tho','Nu','KH002','L002','N002'),('SV008','Le Van H','2000-08-08 00:00:00.000000','Ha Noi','Nam','KH003','L003','N003'),('SV009','Pham Van I','2000-09-09 00:00:00.000000','Da Nang','Nam','KH004','L004','N004'),('SV010','Ho Van K','2000-10-10 00:00:00.000000','Hue','Nam','KH005','L005','N005'),('SV011','Nguyen Van L','2000-11-11 00:00:00.000000','TP.HCM','Nam','KH001','L001','N001'),('SV012','Tran Thi M','2000-12-12 00:00:00.000000','Can Tho','Nu','KH002','L002','N002'),('SV013','Le Van N','2000-01-13 00:00:00.000000','Ha Noi','Nam','KH003','L003','N003'),('SV014','Pham Van P','2000-02-14 00:00:00.000000','Da Nang','Nam','KH004','L004','N004'),('SV015','Ho Van Q','2000-03-15 00:00:00.000000','Hue','Nam','KH005','L005','N005'),('SV016','Nguyen Van R','2000-04-16 00:00:00.000000','TP.HCM','Nam','KH001','L001','N001'),('SV017','Tran Van S','2000-05-17 00:00:00.000000','Can Tho','Nam','KH002','L002','N002'),('SV018','Le Van T','2000-06-18 00:00:00.000000','Ha Noi','Nam','KH003','L003','N003'),('SV019','Pham Van U','2000-07-19 00:00:00.000000','Da Nang','Nam','KH004','L004','N004'),('SV020','Ho Van V','2000-08-20 00:00:00.000000','Hue','Nam','KH005','L005','N005');
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_ke_hoc_tap`
--

DROP TABLE IF EXISTS `thong_ke_hoc_tap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_ke_hoc_tap` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dtb_he10` double NOT NULL,
  `dtb_he4` double NOT NULL,
  `so_tin_chi_tich_luy` int NOT NULL,
  `tong_so_mon_da_hoc` int NOT NULL,
  `mssv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qrjcdd5tv909nbf1qm19ops8t` (`mssv`),
  CONSTRAINT `FKq4jyd8t6necrpv1nxf85gnq1b` FOREIGN KEY (`mssv`) REFERENCES `sinh_vien` (`mssv`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_ke_hoc_tap`
--

LOCK TABLES `thong_ke_hoc_tap` WRITE;
/*!40000 ALTER TABLE `thong_ke_hoc_tap` DISABLE KEYS */;
INSERT INTO `thong_ke_hoc_tap` VALUES (1,8,3.2,60,20,'SV001'),(2,7.5,3,45,15,'SV002'),(3,6.8,2.7,50,18,'SV003'),(4,8.5,3.4,65,22,'SV004'),(5,7.2,2.9,55,19,'SV005'),(6,7.9,3.2,58,20,'SV006'),(7,8.2,3.3,62,21,'SV007'),(8,7,2.8,48,16,'SV008'),(9,8.7,3.5,70,24,'SV009'),(10,7.8,3.1,52,18,'SV010'),(11,8.3,3.4,65,22,'SV011'),(12,8.8,3.6,75,25,'SV012'),(13,6.5,2.6,40,14,'SV013'),(14,7.7,3.1,52,18,'SV014'),(15,8.9,3.7,80,27,'SV015'),(16,8.1,3.2,60,20,'SV016'),(17,8.6,3.4,68,23,'SV017'),(18,7.3,2.9,55,19,'SV018'),(19,9,3.6,75,25,'SV019'),(20,7.6,3,50,17,'SV020');
/*!40000 ALTER TABLE `thong_ke_hoc_tap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@gmail.com','$2a$10$WeZIn.tWwMFea6cJGNCa/umcW4soRAbJxt88wV0mDSTV9ctmX4cnW','admin'),(2,'sv01@gmail.com','$2a$10$UK9AbfpaRDD51qnev3opYOymISD0bYWido2BrkKKRNxPwMLLeAEcm','sv01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-04 11:24:08
