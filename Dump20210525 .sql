create database htttns;
use htttns;
-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: htttns
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `bacluong`
--

DROP TABLE IF EXISTS bacluong;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE bacluong (
  Id int NOT NULL AUTO_INCREMENT,
  ChinhanhId int NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sotien float NOT NULL,
  PRIMARY KEY (Id),
  KEY FKBacluong489790 (ChinhanhId),
  CONSTRAINT FKBacluong489790 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bacluong`
--

LOCK TABLES bacluong WRITE;
/*!40000 ALTER TABLE bacluong DISABLE KEYS */;
INSERT INTO bacluong VALUES (1,1,'lương nhân viên bậc 2',5000000),(2,1,'lương bậc 3',10000000);
/*!40000 ALTER TABLE bacluong ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bangkpi`
--

DROP TABLE IF EXISTS bangkpi;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE bangkpi (
  Id int NOT NULL AUTO_INCREMENT,
  BangluongId int DEFAULT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Dachot bit(1) NOT NULL,
  Dasudung bit(1) NOT NULL,
  PRIMARY KEY (Id),
  KEY FKBangKPI896980 (BangluongId),
  CONSTRAINT FKBangKPI896980 FOREIGN KEY (BangluongId) REFERENCES bangluong (Id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangkpi`
--

LOCK TABLES bangkpi WRITE;
/*!40000 ALTER TABLE bangkpi DISABLE KEYS */;
INSERT INTO bangkpi VALUES (1,2,'Bảng KPI Phòng nhân sự tháng 5',_binary '',_binary '\0'),(2,NULL,'Bảng KPI Chi nhánh tháng 5',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE bangkpi ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bangluong`
--

DROP TABLE IF EXISTS bangluong;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE bangluong (
  Id int NOT NULL AUTO_INCREMENT,
  ChinhanhId int NOT NULL,
  NgayBD date NOT NULL,
  NgayKT date NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Quythuong float NOT NULL,
  PRIMARY KEY (Id),
  KEY FKBangluong714446 (ChinhanhId),
  CONSTRAINT FKBangluong714446 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangluong`
--

LOCK TABLES bangluong WRITE;
/*!40000 ALTER TABLE bangluong DISABLE KEYS */;
INSERT INTO bangluong VALUES (2,1,'2021-05-01','2021-05-31','Bảng lương tháng 5 chi nhánh Hà Nội',3000000);
/*!40000 ALTER TABLE bangluong ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ca`
--

DROP TABLE IF EXISTS ca;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ca (
  Id int NOT NULL AUTO_INCREMENT,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Socong float NOT NULL,
  giobd time(6) NOT NULL,
  giokt time(6) NOT NULL,
  Codinh bit(1) NOT NULL,
  T2 bit(1) NOT NULL,
  T3 bit(1) NOT NULL,
  T4 bit(1) NOT NULL,
  T5 bit(1) NOT NULL,
  T6 bit(1) NOT NULL,
  T7 bit(1) NOT NULL,
  Cn bit(1) NOT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca`
--

LOCK TABLES ca WRITE;
/*!40000 ALTER TABLE ca DISABLE KEYS */;
INSERT INTO ca VALUES (1,'ca hành chính 1',1,'07:00:00.000000','16:00:00.000000',_binary '',_binary '',_binary '',_binary '',_binary '',_binary '',_binary '',_binary ''),(2,'ca hành chính 2',1,'07:00:00.000000','17:00:00.000000',_binary '',_binary '',_binary '',_binary '',_binary '',_binary '',_binary '',_binary '\0'),(3,'ca làm thêm chủ nhật',1,'14:00:00.000000','19:00:00.000000',_binary '',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '');
/*!40000 ALTER TABLE ca ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canhanvien`
--

DROP TABLE IF EXISTS canhanvien;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE canhanvien (
  Id int NOT NULL AUTO_INCREMENT,
  NghiphepId int DEFAULT NULL,
  CaId int NOT NULL,
  NhanvienId int NOT NULL,
  Ngay date NOT NULL,
  gioden time(6) NOT NULL,
  giove time(6) NOT NULL,
  Tinhcong float NOT NULL,
  Nghiphep bit(1) NOT NULL,
  Pheduyet bit(1) NOT NULL,
  PRIMARY KEY (Id),
  KEY FKCanhanvien118485 (NhanvienId),
  KEY FKCanhanvien885704 (CaId),
  KEY FKCanhanvien198972 (NghiphepId),
  CONSTRAINT FKCanhanvien118485 FOREIGN KEY (NhanvienId) REFERENCES nhanvien (Id),
  CONSTRAINT FKCanhanvien198972 FOREIGN KEY (NghiphepId) REFERENCES nghiphep (Id),
  CONSTRAINT FKCanhanvien885704 FOREIGN KEY (CaId) REFERENCES ca (Id)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canhanvien`
--

LOCK TABLES canhanvien WRITE;
/*!40000 ALTER TABLE canhanvien DISABLE KEYS */;
INSERT INTO canhanvien VALUES (1,NULL,2,1,'2021-05-01','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(2,NULL,2,1,'2021-05-03','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(3,NULL,2,1,'2021-05-04','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(4,NULL,2,1,'2021-05-05','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(5,NULL,2,1,'2021-05-06','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(6,NULL,2,1,'2021-05-07','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(7,NULL,2,1,'2021-05-08','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(8,NULL,2,1,'2021-05-10','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(9,NULL,2,1,'2021-05-11','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(10,NULL,2,1,'2021-05-12','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(11,NULL,2,1,'2021-05-13','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(12,NULL,2,1,'2021-05-14','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(13,NULL,2,1,'2021-05-15','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(14,NULL,2,1,'2021-05-17','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(15,NULL,2,1,'2021-05-18','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(16,NULL,2,1,'2021-05-19','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(17,NULL,2,1,'2021-05-20','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(18,NULL,2,1,'2021-05-21','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(19,NULL,2,1,'2021-05-22','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(20,NULL,2,1,'2021-05-24','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(21,NULL,2,1,'2021-05-25','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(22,NULL,2,1,'2021-05-26','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(23,NULL,2,1,'2021-05-27','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(24,NULL,2,1,'2021-05-28','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(25,NULL,2,1,'2021-05-29','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(26,NULL,2,1,'2021-05-31','07:00:00.000000','17:00:00.000000',1,_binary '\0',_binary '\0'),(27,NULL,1,2,'2021-05-01','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(28,NULL,1,2,'2021-05-02','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(29,NULL,1,2,'2021-05-03','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(30,NULL,1,2,'2021-05-04','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(31,NULL,1,2,'2021-05-05','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(32,NULL,1,2,'2021-05-06','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(33,NULL,1,2,'2021-05-07','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(34,NULL,1,2,'2021-05-08','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(35,NULL,1,2,'2021-05-09','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(36,NULL,1,2,'2021-05-10','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(37,NULL,1,2,'2021-05-11','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(38,NULL,1,2,'2021-05-12','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(39,NULL,1,2,'2021-05-13','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(40,NULL,1,2,'2021-05-14','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(41,NULL,1,2,'2021-05-15','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(42,NULL,1,2,'2021-05-16','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(43,NULL,1,2,'2021-05-17','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(44,NULL,1,2,'2021-05-18','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(45,NULL,1,2,'2021-05-19','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(46,NULL,1,2,'2021-05-20','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(47,NULL,1,2,'2021-05-21','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(48,NULL,1,2,'2021-05-22','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(49,NULL,1,2,'2021-05-23','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(50,NULL,1,2,'2021-05-24','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(51,NULL,1,2,'2021-05-25','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(52,NULL,1,2,'2021-05-26','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(53,NULL,1,2,'2021-05-27','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(54,NULL,1,2,'2021-05-28','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(55,NULL,1,2,'2021-05-29','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(56,NULL,1,2,'2021-05-30','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0'),(57,NULL,1,2,'2021-05-31','07:00:00.000000','16:00:00.000000',1,_binary '\0',_binary '\0');
/*!40000 ALTER TABLE canhanvien ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chinhanh`
--

DROP TABLE IF EXISTS chinhanh;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE chinhanh (
  Id int NOT NULL AUTO_INCREMENT,
  CongtyId int NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Dc varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sdt varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (Id),
  KEY FKChinhanh28796 (CongtyId),
  CONSTRAINT FKChinhanh28796 FOREIGN KEY (CongtyId) REFERENCES congty (Id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chinhanh`
--

LOCK TABLES chinhanh WRITE;
/*!40000 ALTER TABLE chinhanh DISABLE KEYS */;
INSERT INTO chinhanh VALUES (1,1,'Chi nhánh Hà Nội','số 100- đường Nguyễn Gia Thiều- Hà Đông','');
/*!40000 ALTER TABLE chinhanh ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS chucvu;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE chucvu (
  Id int NOT NULL AUTO_INCREMENT,
  CongtyId int NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Mota varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (Id),
  KEY FKChucvu365667 (CongtyId),
  CONSTRAINT FKChucvu365667 FOREIGN KEY (CongtyId) REFERENCES congty (Id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES chucvu WRITE;
/*!40000 ALTER TABLE chucvu DISABLE KEYS */;
INSERT INTO chucvu VALUES (1,1,'Quản lý nhân sự',''),(2,1,'Quản lý nhân viên',''),(3,1,'Giám đốc',''),(4,1,'Nhân viên','');
/*!40000 ALTER TABLE chucvu ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `congty`
--

DROP TABLE IF EXISTS congty;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE congty (
  Id int NOT NULL AUTO_INCREMENT,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sdt varchar(11) NOT NULL,
  Email varchar(50) NOT NULL,
  Kinhdoanh varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congty`
--

LOCK TABLES congty WRITE;
/*!40000 ALTER TABLE congty DISABLE KEYS */;
INSERT INTO congty VALUES (1,'Công ty trách nhiệm hữu hạn xây dựng','','','');
/*!40000 ALTER TABLE congty ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotkpi`
--

DROP TABLE IF EXISTS cotkpi;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE cotkpi (
  Id int NOT NULL AUTO_INCREMENT,
  BangKPIId int NOT NULL,
  Chitieu int NOT NULL,
  Heso float NOT NULL,
  ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  donvi varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKCotKPI632690 (BangKPIId),
  CONSTRAINT FKCotKPI632690 FOREIGN KEY (BangKPIId) REFERENCES bangkpi (Id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotkpi`
--

LOCK TABLES cotkpi WRITE;
/*!40000 ALTER TABLE cotkpi DISABLE KEYS */;
INSERT INTO cotkpi VALUES (1,1,10,0.3,'Nhân viên kỹ thuật','Số lượng tuyển dụng'),(2,1,3,0.3,'Bảng lương tháng 5','Số lượng tạo');
/*!40000 ALTER TABLE cotkpi ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgiakpi`
--

DROP TABLE IF EXISTS danhgiakpi;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE danhgiakpi (
  Id int NOT NULL AUTO_INCREMENT,
  NhanvienId int NOT NULL,
  BangKPIId int NOT NULL,
  PRIMARY KEY (Id),
  KEY FKDanhgiaKPI149360 (BangKPIId),
  KEY FKDanhgiaKPI107122 (NhanvienId),
  CONSTRAINT FKDanhgiaKPI107122 FOREIGN KEY (NhanvienId) REFERENCES nhanvien (Id),
  CONSTRAINT FKDanhgiaKPI149360 FOREIGN KEY (BangKPIId) REFERENCES bangkpi (Id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgiakpi`
--

LOCK TABLES danhgiakpi WRITE;
/*!40000 ALTER TABLE danhgiakpi DISABLE KEYS */;
INSERT INTO danhgiakpi VALUES (1,1,1),(2,2,1);
/*!40000 ALTER TABLE danhgiakpi ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diemkpi`
--

DROP TABLE IF EXISTS diemkpi;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE diemkpi (
  Id int NOT NULL AUTO_INCREMENT,
  CotKPIId int NOT NULL,
  DanhgiaKPIId int NOT NULL,
  Giatri int NOT NULL,
  PRIMARY KEY (Id),
  KEY FKDiemKPI317904 (DanhgiaKPIId),
  KEY FKDiemKPI166896 (CotKPIId),
  CONSTRAINT FKDiemKPI166896 FOREIGN KEY (CotKPIId) REFERENCES cotkpi (Id),
  CONSTRAINT FKDiemKPI317904 FOREIGN KEY (DanhgiaKPIId) REFERENCES danhgiakpi (Id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diemkpi`
--

LOCK TABLES diemkpi WRITE;
/*!40000 ALTER TABLE diemkpi DISABLE KEYS */;
INSERT INTO diemkpi VALUES (1,1,1,10),(2,1,2,0),(3,2,1,0),(4,2,2,2);
/*!40000 ALTER TABLE diemkpi ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocvien`
--

DROP TABLE IF EXISTS hocvien;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE hocvien (
  Id int NOT NULL AUTO_INCREMENT,
  KhoahocId int NOT NULL,
  NhanvienId int NOT NULL,
  PhongbanId int DEFAULT NULL,
  ChucvuId int DEFAULT NULL,
  Danhgia float NOT NULL,
  PRIMARY KEY (Id),
  KEY FKHocvien770879 (NhanvienId),
  KEY FKHocvien598777 (KhoahocId),
  CONSTRAINT FKHocvien598777 FOREIGN KEY (KhoahocId) REFERENCES khoahoc (Id),
  CONSTRAINT FKHocvien770879 FOREIGN KEY (NhanvienId) REFERENCES nhanvien (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocvien`
--

LOCK TABLES hocvien WRITE;
/*!40000 ALTER TABLE hocvien DISABLE KEYS */;
/*!40000 ALTER TABLE hocvien ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdong`
--

DROP TABLE IF EXISTS hopdong;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE hopdong (
  Id int NOT NULL AUTO_INCREMENT,
  So varchar(50) NOT NULL,
  Ngayky date NOT NULL,
  Hethan date NOT NULL,
  Noidung varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  NhanvienId int NOT NULL,
  PRIMARY KEY (Id),
  KEY FKHopdong246464 (NhanvienId),
  CONSTRAINT FKHopdong246464 FOREIGN KEY (NhanvienId) REFERENCES nhanvien (Id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdong`
--

LOCK TABLES hopdong WRITE;
/*!40000 ALTER TABLE hopdong DISABLE KEYS */;
INSERT INTO hopdong VALUES (1,'HDLD202105NVQL','2021-05-25','2022-05-25','hợp đồng lao động thời vụ',1);
/*!40000 ALTER TABLE hopdong ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoahoc`
--

DROP TABLE IF EXISTS khoahoc;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE khoahoc (
  Id int NOT NULL AUTO_INCREMENT,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  ChinhanhId int NOT NULL,
  Khaigiang date DEFAULT NULL,
  Ketthuc date DEFAULT NULL,
  Chiphi float NOT NULL,
  PRIMARY KEY (Id),
  KEY FKKhoahoc774588 (ChinhanhId),
  CONSTRAINT FKKhoahoc774588 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoahoc`
--

LOCK TABLES khoahoc WRITE;
/*!40000 ALTER TABLE khoahoc DISABLE KEYS */;
/*!40000 ALTER TABLE khoahoc ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi`
--

DROP TABLE IF EXISTS kpi;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE kpi (
  Id int NOT NULL AUTO_INCREMENT,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Donvi varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi`
--

LOCK TABLES kpi WRITE;
/*!40000 ALTER TABLE kpi DISABLE KEYS */;
/*!40000 ALTER TABLE kpi ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nghiphep`
--

DROP TABLE IF EXISTS nghiphep;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE nghiphep (
  Id int NOT NULL AUTO_INCREMENT,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Hscong float NOT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nghiphep`
--

LOCK TABLES nghiphep WRITE;
/*!40000 ALTER TABLE nghiphep DISABLE KEYS */;
/*!40000 ALTER TABLE nghiphep ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS nhanvien;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE nhanvien (
  Id int NOT NULL AUTO_INCREMENT,
  PhongbanId int NOT NULL,
  ChucvuId int NOT NULL,
  BacluongId int NOT NULL,
  ChinhanhId int NOT NULL,
  Hoten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sdt varchar(11) NOT NULL,
  Dc varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Email varchar(50) NOT NULL,
  Tdn varchar(50) NOT NULL,
  Mk varchar(50) NOT NULL,
  Trinhdo varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Congviec varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (Id),
  KEY FKNhanvien549595 (ChinhanhId),
  KEY FKNhanvien110584 (BacluongId),
  KEY FKNhanvien645634 (ChucvuId),
  KEY FKNhanvien813097 (PhongbanId),
  CONSTRAINT FKNhanvien110584 FOREIGN KEY (BacluongId) REFERENCES bacluong (Id),
  CONSTRAINT FKNhanvien549595 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id),
  CONSTRAINT FKNhanvien645634 FOREIGN KEY (ChucvuId) REFERENCES chucvu (Id),
  CONSTRAINT FKNhanvien813097 FOREIGN KEY (PhongbanId) REFERENCES phongban (Id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES nhanvien WRITE;
/*!40000 ALTER TABLE nhanvien DISABLE KEYS */;
INSERT INTO nhanvien VALUES (1,1,1,1,1,'Quản lý nhân sự 1','8239999999','số 123 đường Nguyễn Trãi','abc@email.com','quanlinhansu1','quanlinhansu1','Đại học','Quản lý nhân sự chi nhánh'),(2,1,2,1,1,'Quản lý nhân viên 1','823999777','số 125 đường Nguyễn Trãi','bcd@email.com','quanlinhanvien1','quanlinhanvien1','Đại học','Quản lý lương thưởng chi nhánh'),(3,4,4,1,1,'Nhân viên 1','8239995555','số 127 đường Nguyễn Trãi','cde@email.com','nhanvien1','nhanvien1','Đại học','Tiếp thị các sản phẩm của chi nhánh'),(4,2,3,2,1,'Giám đốc 1','82399955556','số 135 đường Nguyễn Trãi','def@email.com','giamdoc1','giamdoc1','Đại học','Giám đốc chi nhánh Hà Nội');
/*!40000 ALTER TABLE nhanvien ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieuluong`
--

DROP TABLE IF EXISTS phieuluong;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE phieuluong (
  Id int NOT NULL AUTO_INCREMENT,
  BangluongId int NOT NULL,
  NhanvienId int NOT NULL,
  Socong float NOT NULL,
  Kpi float NOT NULL,
  Tienthuong float NOT NULL,
  Thanhtien float NOT NULL,
  PhongbanId int NOT NULL,
  ChucvuId int NOT NULL,
  BacluongId int NOT NULL,
  PRIMARY KEY (Id),
  KEY FKPhieuluong214719 (NhanvienId),
  KEY FKPhieuluong728835 (BangluongId),
  KEY FKPhieuluong287289 (PhongbanId),
  KEY FKPhieuluong119826 (ChucvuId),
  KEY FKPhieuluong584775 (BacluongId),
  CONSTRAINT FKPhieuluong119826 FOREIGN KEY (ChucvuId) REFERENCES chucvu (Id),
  CONSTRAINT FKPhieuluong214719 FOREIGN KEY (NhanvienId) REFERENCES nhanvien (Id),
  CONSTRAINT FKPhieuluong287289 FOREIGN KEY (PhongbanId) REFERENCES phongban (Id),
  CONSTRAINT FKPhieuluong584775 FOREIGN KEY (BacluongId) REFERENCES bacluong (Id),
  CONSTRAINT FKPhieuluong728835 FOREIGN KEY (BangluongId) REFERENCES bangluong (Id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieuluong`
--

LOCK TABLES phieuluong WRITE;
/*!40000 ALTER TABLE phieuluong DISABLE KEYS */;
INSERT INTO phieuluong VALUES (3,2,1,26,0.3,900000,4333330,1,1,1),(4,2,2,31,0.2,600000,5166670,1,2,1);
/*!40000 ALTER TABLE phieuluong ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phongban`
--

DROP TABLE IF EXISTS phongban;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE phongban (
  Id int NOT NULL AUTO_INCREMENT,
  ChinhanhId int NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sdt varchar(11) NOT NULL,
  Email varchar(50) NOT NULL,
  PRIMARY KEY (Id),
  KEY FKPhongban556958 (ChinhanhId),
  CONSTRAINT FKPhongban556958 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongban`
--

LOCK TABLES phongban WRITE;
/*!40000 ALTER TABLE phongban DISABLE KEYS */;
INSERT INTO phongban VALUES (1,1,'Nhân sự','',''),(2,1,'Giám đốc','',''),(3,1,'Bán hàng','',''),(4,1,'Tiếp thị','','');
/*!40000 ALTER TABLE phongban ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuyendung`
--

DROP TABLE IF EXISTS tuyendung;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE tuyendung (
  Id int NOT NULL AUTO_INCREMENT,
  ChinhanhId int NOT NULL,
  Vitri varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Soluong int NOT NULL,
  Han date NOT NULL,
  MotaYC varchar(50) NOT NULL,
  PRIMARY KEY (Id),
  KEY FKTuyendung9316 (ChinhanhId),
  CONSTRAINT FKTuyendung9316 FOREIGN KEY (ChinhanhId) REFERENCES chinhanh (Id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuyendung`
--

LOCK TABLES tuyendung WRITE;
/*!40000 ALTER TABLE tuyendung DISABLE KEYS */;
INSERT INTO tuyendung VALUES (1,1,'Nhân viên bán hàng',12,'2021-06-25','Có kinh nghiệm bán hàng');
/*!40000 ALTER TABLE tuyendung ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ungvien`
--

DROP TABLE IF EXISTS ungvien;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ungvien (
  Id int NOT NULL AUTO_INCREMENT,
  TuyendungId int NOT NULL,
  Ten varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Sdt varchar(11) NOT NULL,
  Email varchar(50) NOT NULL,
  Dc varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Giaidoan varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  Ngaypv date NOT NULL,
  Motacv varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (Id),
  KEY FKUngvien129214 (TuyendungId),
  CONSTRAINT FKUngvien129214 FOREIGN KEY (TuyendungId) REFERENCES tuyendung (Id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ungvien`
--

LOCK TABLES ungvien WRITE;
/*!40000 ALTER TABLE ungvien DISABLE KEYS */;
INSERT INTO ungvien VALUES (2,1,'Nguyễn Văn A','8234638223','abc@email.com','số 123 đường Nguyễn Trãi','Xét tuyển phỏng vấn','2021-05-26',NULL);
/*!40000 ALTER TABLE ungvien ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 22:50:35
