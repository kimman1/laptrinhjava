-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 10, 2019 at 09:25 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `MaAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `AccountAdmin` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PasswordAdmin` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`MaAdmin`, `AccountAdmin`, `PasswordAdmin`) VALUES
(1, 'admin', 'admin'),
(2, 'quangadmin', 'quangadmin'),
(3, 'quanadmin', 'quanadmin'),
(4, 'manadmin', 'manadmin');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenKH` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `SDTKH` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AccountKH` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PasswordKH` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `SDTKH`, `DiaChi`, `AccountKH`, `PasswordKH`) VALUES
(1, 'Mãn', '0985855746', '93 đường số 6 ', 'kimman1', 'kimman'),
(2, 'Quân', '123456789', '371 nguyễn kiệm ', 'quan123', 'quan'),
(3, 'Tiên ', '0123456789', '91 đường số 3', 'tien1', 'tien');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNV` int(11) NOT NULL AUTO_INCREMENT,
  `AccountNV` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PasswordNV` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `SDTNV` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `StatusNV` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `AccountNV`, `PasswordNV`, `TenNV`, `SDTNV`, `StatusNV`) VALUES
(1, 'quangdeptrai', 'choquang', 'Quảng', '123456789', 'Đang Làm'),
(2, 'quandeptrai', 'quan123', 'Quân', '0123456', 'Đang Làm');

-- --------------------------------------------------------

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
CREATE TABLE IF NOT EXISTS `phieumuon` (
  `MaPhieuMuon` int(11) NOT NULL AUTO_INCREMENT,
  `MaKH` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayMuon` date DEFAULT NULL,
  `HanTra` date DEFAULT NULL,
  `NgayTra` date DEFAULT NULL,
  `SoLuongMuon` int(11) NOT NULL,
  `TienBoiThuong` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TienPhat` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaPhieuMuon`),
  KEY `MaSach_idx` (`MaSach`),
  KEY `MaKH_idx` (`MaKH`),
  KEY `MaNV_idx` (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieumuon`
--

INSERT INTO `phieumuon` (`MaPhieuMuon`, `MaKH`, `MaSach`, `MaNV`, `NgayMuon`, `HanTra`, `NgayTra`, `SoLuongMuon`, `TienBoiThuong`, `TienPhat`) VALUES
(2, 1, 13, 1, '2019-09-23', '2019-10-26', '2019-10-26', 2, '50000', NULL),
(20, 3, 1, 1, '2019-10-08', '2019-10-22', '2019-10-23', 5, NULL, NULL),
(22, 2, 12, 1, '2019-10-08', '2019-10-22', '2019-10-23', 2, NULL, NULL),
(23, 3, 14, 1, '2019-10-08', '2019-10-25', '2019-11-01', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
CREATE TABLE IF NOT EXISTS `sach` (
  `MaSach` int(11) NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenTacGia` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `NXB` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoLuong` int(10) NOT NULL,
  `GiaSach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `TenTacGia`, `NXB`, `SoLuong`, `GiaSach`) VALUES
(1, 'Lập trình hướng đối tượng ', 'Tô Oai Hùng ', '371 Nguyễn Kiệm', 5, '50'),
(2, 'Lập Trình Java', 'Dương Hữu Thành', '371 Nguyễn Kiệm', 10, '70'),
(3, 'Lập Trình Mạng', 'Lưu Quang Phương', '371 Nguyễn Kiệm', 10, '12'),
(4, 'Quản Trị Hệ CSDL', 'Hồ Quang Khải', '371 Nguyễn Kiệm', 10, '60'),
(12, 'Quản Trị Mạng', 'Lưu Quang Phương', '371 Nguyễn Kiệm', 98, '200'),
(13, 'Kiến Trúc Máy Tính', 'Tô Oai Hùng', '371 Nguyễn Kiệm', 100, '300'),
(14, 'Xử Lý Ảnh', 'Lê Viết Tuấn', '371 Nguyễn Kiệm', 98, '400');

-- --------------------------------------------------------

--
-- Table structure for table `thongke`
--

DROP TABLE IF EXISTS `thongke`;
CREATE TABLE IF NOT EXISTS `thongke` (
  `MaPhieuTK` int(11) NOT NULL AUTO_INCREMENT,
  `SoPhieuQuaHan` int(11) DEFAULT NULL,
  `SoPhieuMuon` int(11) DEFAULT NULL,
  `TongTienPhat` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaPhieuTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `MaKH` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `MaSach` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
