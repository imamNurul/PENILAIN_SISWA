-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2020 at 02:40 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skripsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `jdl_mengajar`
--

CREATE TABLE `jdl_mengajar` (
  `id` int(11) NOT NULL,
  `kode_mengajar` varchar(30) NOT NULL,
  `kode_kelas` varchar(30) NOT NULL,
  `kode_guru` varchar(30) NOT NULL,
  `kode_mapel` varchar(30) NOT NULL,
  `hari` varchar(30) NOT NULL,
  `jamMulai` time DEFAULT NULL,
  `jamSelesai` time DEFAULT NULL,
  `tahunAjaran` varchar(50) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jdl_mengajar`
--

INSERT INTO `jdl_mengajar` (`id`, `kode_mengajar`, `kode_kelas`, `kode_guru`, `kode_mapel`, `hari`, `jamMulai`, `jamSelesai`, `tahunAjaran`, `flag`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(10, 'MP001', 'VI', '2020546543', 'MP002', 'Senin', '07:30:00', '08:30:00', '2019/2020', 1, 'Admin', '2020-08-03 04:43:30', NULL, NULL),
(12, 'MP002', 'VI', '20201098378', 'MP008', 'Senin', '08:30:00', '09:30:00', '2019/2020', 1, 'Admin', '2020-08-03 05:11:20', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jdl_mengajar_header`
--

CREATE TABLE `jdl_mengajar_header` (
  `id` int(11) NOT NULL,
  `kode_mengajar` varchar(30) NOT NULL,
  `kode_guru` varchar(30) NOT NULL,
  `createdby` varchar(30) NOT NULL,
  `createddate` date NOT NULL,
  `updatedby` varchar(30) NOT NULL,
  `updateddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_absensi`
--

CREATE TABLE `tbl_absensi` (
  `id` int(11) NOT NULL,
  `kd_absen` varchar(50) NOT NULL,
  `kd_kelas` varchar(50) NOT NULL,
  `nama_kelas` varchar(50) NOT NULL,
  `kd_siswa` varchar(50) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `tgl_buat` timestamp NULL DEFAULT NULL,
  `tgl_ubah` timestamp NULL DEFAULT NULL,
  `semester` varchar(50) NOT NULL,
  `tgl_dari` date DEFAULT NULL,
  `tgl_sampai` date DEFAULT NULL,
  `sakit` int(11) DEFAULT NULL,
  `izin` int(11) DEFAULT NULL,
  `alpa` int(11) DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_absensi`
--

INSERT INTO `tbl_absensi` (`id`, `kd_absen`, `kd_kelas`, `nama_kelas`, `kd_siswa`, `nama_siswa`, `tgl_buat`, `tgl_ubah`, `semester`, `tgl_dari`, `tgl_sampai`, `sakit`, `izin`, `alpa`, `keterangan`) VALUES
(9, 'ABS001', '', 'Ibnu Sina', '1820398', 'ALDI YANTO', '2020-07-08 12:14:40', '2020-08-03 04:10:05', 'Ganjil', '2020-07-01', '2020-07-02', 1, 0, 0, NULL),
(10, 'ABS002', '', 'Ibnu Sina', '18209399', 'AULIA JAHRATUN', '2020-07-08 12:15:55', '2020-08-03 04:10:39', 'Ganjil', '2020-07-07', '2020-07-08', 0, 1, 0, NULL),
(11, 'ABS003', '', 'Ibnu Sina', '18209342', 'MITA YUNANTI', '2020-07-08 12:36:05', '2020-08-03 04:11:14', 'Ganjil', '2020-07-16', '2020-07-17', 0, 1, 0, NULL),
(12, 'ABS004', '', 'Ibnu Sina', '18209340', 'ENJI', '2020-07-08 12:39:09', '2020-08-03 04:11:39', 'Ganjil', '2020-07-21', '2020-07-22', 0, 0, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_absen_detail`
--

CREATE TABLE `tbl_absen_detail` (
  `id` int(11) NOT NULL,
  `id_absen` varchar(30) NOT NULL,
  `nomor_induk` varchar(30) NOT NULL,
  `jml_nilai` int(15) NOT NULL,
  `rata_rata` int(15) NOT NULL,
  `peringkat` varchar(15) NOT NULL,
  `sakit` varchar(15) NOT NULL,
  `izin` varchar(15) NOT NULL,
  `alpa` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_absen_header`
--

CREATE TABLE `tbl_absen_header` (
  `id` int(11) NOT NULL,
  `id_absen` varchar(30) NOT NULL,
  `createdby` varchar(30) NOT NULL,
  `createddate` date NOT NULL,
  `updatedby` varchar(30) NOT NULL,
  `updateddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_guru`
--

CREATE TABLE `tbl_guru` (
  `id` int(11) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `nama_guru` varchar(30) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` varchar(30) NOT NULL,
  `agama` varchar(30) NOT NULL,
  `pendidikan_terakhir` varchar(30) NOT NULL,
  `telp` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `flag` int(3) NOT NULL,
  `wali_kelas` char(1) DEFAULT NULL,
  `kd_kelas` varchar(50) DEFAULT NULL,
  `nm_kelas` varchar(50) DEFAULT NULL,
  `kd_mapel` varchar(50) DEFAULT NULL,
  `nm_mapel` varchar(50) DEFAULT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_guru`
--

INSERT INTO `tbl_guru` (`id`, `nip`, `nama_guru`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `agama`, `pendidikan_terakhir`, `telp`, `status`, `alamat`, `photo`, `flag`, `wali_kelas`, `kd_kelas`, `nm_kelas`, `kd_mapel`, `nm_mapel`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(1, '202012345', 'Aminudin', 'Serang', '1991-08-20', 'L', 'Islam', 'S1 S.Pd', '08123456789', 'Kawin', 'Kp. cidahu', 'C:\\Users\\Imam-pc\\Documents\\Foto.jpg', 1, 'Y', 'VI', 'Abu Bakar As Siddiq', 'AGM001', 'Pendidikan Agama Islam', 'Admin', '2020-06-28 15:26:46', 'Admin', '2020-08-03 03:08:00'),
(2, '202054321', 'Wati Purnamasari ', 'Tanggerang', '1990-10-16', 'P', 'Islam', 'S1 Matematika', '081278786767', 'Belum Kawin', 'Ds. nyompok', 'C:\\Users\\Imam-pc\\Pictures\\Untitled.png', 1, 'Y', 'V', 'Umar Bin Khattab', 'MTK001', 'Matematika', 'Admin', '2020-06-30 01:41:49', 'Admin', '2020-08-03 03:10:53'),
(3, '2020786756', 'Budi Handoko', 'Searang', '1989-07-02', 'L', 'Islam', 'S1 Spd', '08121212121', 'Kawin', 'Kp. Cidahu', 'C:\\Users\\Imam-pc\\Documents\\My Web Sites\\WebSite1\\msweb-brand.png', 1, 'Y', 'III', 'Usman Bin Affan', 'BHSG001', 'Bahasa Inggris', 'Admin', '2020-07-02 05:54:48', 'Admin', '2020-08-03 03:12:27'),
(4, '202009876', 'WiWi Agista', 'Jakarta', '1992-06-01', 'P', 'Islam', 'S1 Spd', '087856543233', 'Belum Kawin', 'Jl. Kirana', 'C:\\Users\\Imam-pc\\Documents\\Foto.jpg', 1, 'Y', 'I', 'Al Gozali', 'IPA001', 'IPA', 'Admin', '2020-07-02 06:14:47', 'Admin', '2020-08-03 03:14:01'),
(5, '202012345', 'Gea Anindia', 'Tanggerang', '1993-03-10', 'P', 'Islam', 'S1 Spd', '08123232323', 'Belum Kawin', 'Ds. Harendong', 'C:\\Users\\Imam-pc\\Downloads\\chart.png', 1, 'Y', 'IV', 'Ali Bin Abi Tholib', 'IPS001', 'IPS', 'Admin', '2020-07-07 09:48:11', 'Admin', '2020-08-03 03:15:54'),
(6, '202076540', 'Abdullah', 'Serang', '1990-08-14', 'L', 'Islam', 'S1 Spd', '081232323232', 'Kawin', 'Kp.Cidahu', 'C:\\Users\\Imam-pc\\Pictures\\bundel.png', 1, 'Y', 'II', 'Ibnu Sina', 'PENJASKES001', 'Penjaskes', 'Admin', '2020-07-07 09:51:03', 'Admin', '2020-08-03 03:16:57'),
(7, '202011006', 'Lala Nayla', 'Serang', '1991-10-17', 'P', 'Islam', 'S1 Spd', '081232132321', 'Belum Kawin', 'Kp.Kamarang', 'C:\\Users\\Imam-pc\\Pictures\\Untitled.png', 1, 'N', NULL, NULL, 'PPKN001', 'PPKN', 'Admin', '2020-07-07 09:52:43', 'Admin', '2020-08-03 03:18:52'),
(8, '2020134590', 'Elis Novianti', 'Serang', '1999-07-30', 'P', 'Islam', 'SI spd', '-', 'Belum Kawin', 'Ds. Garedug', '', 1, 'N', NULL, NULL, 'SENIB001', 'Seni Budaya', 'Admin', '2020-07-30 08:36:39', 'Admin', '2020-08-03 03:20:27'),
(9, '2020546543', 'ADHA', 'Serang', '1999-08-02', 'L', 'Islam', 'S1 spd', '-', 'Belum Kawin', 'Tanggerang', '', 1, 'N', NULL, NULL, 'MP002', 'Bahasa Indonesia', 'Admin', '2020-08-03 04:42:17', 'Admin', '2020-08-03 04:48:10'),
(10, '20201098378', 'MUMUN', 'SERANG', '1998-08-07', 'P', 'Islam', 'S1 spd', '-', 'Belum Kawin', 'Kp.Carenang', '', 1, 'N', NULL, NULL, 'MP008', 'Bahasa Inggris', 'Admin', '2020-08-03 05:08:32', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kelas`
--

CREATE TABLE `tbl_kelas` (
  `id` int(11) NOT NULL,
  `kd_kelas` varchar(30) NOT NULL,
  `nama_kelas` varchar(30) NOT NULL,
  `flag` int(3) NOT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_kelas`
--

INSERT INTO `tbl_kelas` (`id`, `kd_kelas`, `nama_kelas`, `flag`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(1, 'I', 'Al Gozali', 1, 'Admin', '2020-06-26 08:50:59', 'Admin', '2020-07-28 14:55:08'),
(2, 'II', 'Ibnu Sina', 1, 'Admin', '2020-06-26 08:51:12', 'Admin', '2020-07-28 14:55:20'),
(3, 'III', 'Usman Bin Affan', 1, 'Admin', '2020-06-26 08:51:25', 'Admin', '2020-07-28 14:58:51'),
(4, 'IV', 'Ali Bin Abi Tholib', 1, 'Admin', '2020-07-07 09:42:25', 'Admin', '2020-07-28 14:58:39'),
(5, 'V', 'Umar Bin Khattab', 1, 'Admin', '2020-07-07 09:43:07', 'Admin', '2020-07-28 14:59:42'),
(6, 'VI', 'Abu Bakar As Siddiq', 1, 'Admin', '2020-07-07 09:43:20', 'Admin', '2020-07-28 15:00:27');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_mapel`
--

CREATE TABLE `tbl_mapel` (
  `id` int(11) NOT NULL,
  `kd_mapel` varchar(30) NOT NULL,
  `nama_mapel` varchar(30) NOT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `flag` int(3) NOT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_mapel`
--

INSERT INTO `tbl_mapel` (`id`, `kd_mapel`, `nama_mapel`, `keterangan`, `flag`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(1, 'MP001', 'Matematika', '', 1, 'Admin', '2020-06-29 14:06:18', 'Admin', '2020-08-03 04:27:40'),
(2, 'MP002', 'Bahasa Indonesia', '', 1, 'Admin', '2020-06-29 14:06:47', 'Admin', '2020-08-03 04:27:57'),
(3, 'MP003', 'Pendidikan Agama Islam', '', 1, 'Admin', '2020-06-29 14:07:06', 'Admin', '2020-08-03 04:28:33'),
(4, 'MP004', 'PPKN', '', 1, 'Admin', '2020-07-07 09:29:24', 'Admin', '2020-08-03 04:28:47'),
(5, 'MP005', 'IPA', '', 1, 'Admin', '2020-07-07 09:30:17', 'Admin', '2020-08-03 04:29:06'),
(6, 'MP006', 'IPS', '', 1, 'Admin', '2020-07-07 09:30:27', 'Admin', '2020-08-03 04:29:22'),
(7, 'MP007', 'Penjaskes', '', 1, 'Admin', '2020-07-07 09:30:48', 'Admin', '2020-08-03 04:30:20'),
(8, 'MP008', 'Bahasa Inggris', '', 1, 'Admin', '2020-07-07 09:31:24', 'Admin', '2020-08-03 04:30:29'),
(9, 'MP009', 'Seni Budaya', '', 1, 'Admin', '2020-07-07 09:39:03', 'Admin', '2020-08-03 04:30:42'),
(10, 'TIK001', 'TIK', '', 0, 'Admin', '2020-07-07 09:39:12', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_mapel_old`
--

CREATE TABLE `tbl_mapel_old` (
  `id` int(11) NOT NULL,
  `kd_mapel` varchar(30) NOT NULL,
  `nama_mapel` varchar(30) NOT NULL,
  `kode_kelas` varchar(30) NOT NULL,
  `hari` varchar(30) NOT NULL,
  `jamMulai` time DEFAULT NULL,
  `jamSelesai` time DEFAULT NULL,
  `tahunAjaran` int(11) DEFAULT NULL,
  `nip_guru` varchar(30) NOT NULL,
  `flag` int(3) NOT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nilai_detail`
--

CREATE TABLE `tbl_nilai_detail` (
  `id_nilai` varchar(50) NOT NULL,
  `kd_siswa` varchar(50) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `UH` double DEFAULT NULL,
  `UTS` double DEFAULT NULL,
  `UAS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_nilai_detail`
--

INSERT INTO `tbl_nilai_detail` (`id_nilai`, `kd_siswa`, `nama_siswa`, `UH`, `UTS`, `UAS`) VALUES
('NILAI001', '1234', 'Jhon Lenon', 8, 9, 9),
('NILAI001', '5432', 'Mas Mas', 8, 8, 8),
('NILAI002', '1234', 'Jhon Lenon', 6.5, 7, 8),
('NILAI002', '5432', 'Mas Mas', 7, 7.5, 8),
('NILAI003', '1234', 'Jhon Lenon', 8.5, 9, 10),
('NILAI003', '5432', 'Mas Mas', 9, 9.5, 100),
('NILAI003', '4321', 'Dini Nur', 8, 8.5, 9),
('NILAI003', '6677889900', 'Tiya', 7.5, 8, 9),
('NILAI004', '4321', 'Dini Nur', 7, 7.5, 8),
('NILAI004', '6677889900', 'Tiya', 7.5, 8, 9),
('KN001', '1820398', 'ALDI YANTO', 0, 0, 0),
('KN001', '18209399', 'AULIA JAHRATUN', 0, 0, 0),
('KN001', '18209340', 'ENJI', 0, 0, 0),
('KN001', '18209341', 'FITRI', 0, 0, 0),
('KN001', '18209342', 'MITA YUNANTI', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nilai_header`
--

CREATE TABLE `tbl_nilai_header` (
  `id` int(11) NOT NULL,
  `id_nilai` varchar(30) NOT NULL,
  `kd_kelas` varchar(30) NOT NULL,
  `nama_kelas` varchar(100) DEFAULT NULL,
  `kd_mapel` varchar(30) NOT NULL,
  `nama_mapel` varchar(100) DEFAULT NULL,
  `semester` varchar(30) NOT NULL,
  `tahun_ajaran` varchar(50) DEFAULT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_nilai_header`
--

INSERT INTO `tbl_nilai_header` (`id`, `id_nilai`, `kd_kelas`, `nama_kelas`, `kd_mapel`, `nama_mapel`, `semester`, `tahun_ajaran`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(16, 'NILAI001', '123', '11 MIPA 1', 'BHSI001 ', ' Bahasa Indonesia', 'Ganjil', '2019/2020', 'Admin', '2020-07-04 03:23:37', 'Admin', '2020-07-04 03:24:12'),
(19, 'NILAI002', '123', '11 MIPA 1', 'MTK001 ', ' Matematika', 'Ganjil', '2019/2020', 'Admin', '2020-07-04 06:36:51', NULL, NULL),
(20, 'NILAI003', '123', '11 MIPA 1', 'AGM001 ', ' Pendidikan Agama Islam', 'Ganjil', '2019/2020', 'Admin', '2020-07-04 06:37:39', NULL, NULL),
(21, 'NILAI003', '124', '11 MIPA 2', 'BHSI001 ', ' Bahasa Indonesia', 'Ganjil', '2019/2020', 'Admin', '2020-07-04 06:38:30', NULL, NULL),
(22, 'NILAI004', '124', '11 MIPA 2', 'MTK001 ', ' Matematika', 'Ganjil', '2019/2020', 'Admin', '2020-07-04 06:39:09', NULL, NULL),
(23, 'KN001', 'II', 'Ibnu Sina', 'MP002', 'Bahasa Indonesia', 'Ganjil', '2019/2020', 'Admin', '2020-08-03 05:02:01', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_siswa`
--

CREATE TABLE `tbl_siswa` (
  `id` int(11) NOT NULL,
  `nomor_induk` varchar(25) NOT NULL,
  `nama_siswa` varchar(30) DEFAULT NULL,
  `tempat_lahir` varchar(30) DEFAULT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `agama` varchar(30) NOT NULL,
  `tahun_masuk` int(30) NOT NULL,
  `alamat_siswa` varchar(100) NOT NULL,
  `nama_ayah` varchar(30) NOT NULL,
  `nama_ibu` varchar(30) NOT NULL,
  `kj_ayah` varchar(30) DEFAULT NULL,
  `kj_ibu` varchar(30) DEFAULT NULL,
  `telp_wali` varchar(30) DEFAULT NULL,
  `tanggal_lahir` date NOT NULL,
  `flag` int(3) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  `kode_kelas` varchar(50) DEFAULT NULL,
  `nama_kelas` varchar(50) DEFAULT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_siswa`
--

INSERT INTO `tbl_siswa` (`id`, `nomor_induk`, `nama_siswa`, `tempat_lahir`, `jenis_kelamin`, `agama`, `tahun_masuk`, `alamat_siswa`, `nama_ayah`, `nama_ibu`, `kj_ayah`, `kj_ibu`, `telp_wali`, `tanggal_lahir`, `flag`, `photo`, `kode_kelas`, `nama_kelas`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(1, '1820398', 'ALDI YANTO', 'SERANG', 'L', 'Islam', 2018, 'Kp.Kamarang', 'SAKMIN', 'RUSMINAH', 'Buruh Tani', 'Ibu Rumah Tangga', '-', '2012-06-22', 1, 'G:\\Workspace\\WFH-Sunlife\\Feature\\Foto.jpg', 'II', 'Ibnu Sina', 'Admin', '2020-06-25 15:52:46', 'Admin', '2020-08-03 03:52:23'),
(2, '18209399', 'AULIA JAHRATUN', 'SERANG', 'P', 'Islam', 2018, 'Kp. Cidahu', 'SARDANI', 'SITI GUMAESOH', 'Buruh ', 'Guru', '-', '2012-07-02', 1, 'C:\\Users\\Imam-pc\\Pictures\\tContent2.png', 'II', 'Ibnu Sina', 'Admin', '2020-06-25 16:20:07', 'Admin', '2020-08-03 03:52:42'),
(3, '18209340', 'ENJI', 'SERANG', 'L', 'Islam', 2018, 'Kp. Kamarang', 'JUHDI', 'MARYATI', 'buruh', 'Ibu Rumah Tangga', '-', '2012-05-25', 1, 'C:\\Users\\Imam-pc\\Pictures\\tContent1.png', 'II', 'Ibnu Sina', 'Admin', '2020-06-25 16:35:20', 'Admin', '2020-08-03 03:52:55'),
(4, '18209341', 'FITRI', 'SERANG', 'P', 'Islam', 2018, 'Kp. Kamarang', 'UDIN', 'SAPINAH', 'Buruh', 'Ibu Rumah Tangga', '-', '2012-01-30', 1, 'C:\\Users\\Imam-pc\\Documents\\My Web Sites\\WebSite1\\w-brand.png', 'II', 'Ibnu Sina', 'Admin', '2020-06-30 10:06:16', 'Admin', '2020-08-03 03:49:52'),
(5, '18209342', 'MITA YUNANTI', 'Serang', 'L', 'Islam', 2018, 'Kp. kamarang', 'JAENUDIN', 'MULYATI', 'Buruh', 'Ibu Rumah Tangga', '', '2012-07-30', 1, '', 'II', 'Ibnu Sina', 'Admin', '2020-07-30 08:35:06', 'Admin', '2020-08-03 03:52:05');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `category` varchar(30) NOT NULL,
  `flag` int(3) NOT NULL,
  `createdby` varchar(30) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `updatedby` varchar(30) DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `fullname`, `password`, `category`, `flag`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
(1, '1234', 'Sri Wahyuni', 'sep290917', 'Admin', 1, 'Admin', '2020-07-28 14:40:25', 'Admin', '2020-07-28 14:40:25'),
(2, '112233', 'Zaki', '123', 'Admin', 1, 'Admin', '2020-06-26 07:01:08', NULL, NULL),
(3, '321', 'Tiya', '123', 'Guru', 1, 'Admin', '2020-06-26 07:08:08', NULL, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vabsen_siswa`
-- (See below for the actual view)
--
CREATE TABLE `vabsen_siswa` (
`id_absen` varchar(30)
,`nomor_induk` varchar(30)
,`nama_siswa` varchar(30)
,`jml_nilai` int(15)
,`rata_rata` int(15)
,`peringkat` varchar(15)
,`izin` varchar(15)
,`sakit` varchar(15)
,`alpa` varchar(15)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `vnilai_rapor`
-- (See below for the actual view)
--
CREATE TABLE `vnilai_rapor` (
`kd_siswa` varchar(50)
,`nama_siswa` varchar(100)
,`Sakit` decimal(32,0)
,`Izin` decimal(32,0)
,`Alpa` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Structure for view `vabsen_siswa`
--
DROP TABLE IF EXISTS `vabsen_siswa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vabsen_siswa`  AS  select `a`.`id_absen` AS `id_absen`,`b`.`nomor_induk` AS `nomor_induk`,`c`.`nama_siswa` AS `nama_siswa`,`b`.`jml_nilai` AS `jml_nilai`,`b`.`rata_rata` AS `rata_rata`,`b`.`peringkat` AS `peringkat`,`b`.`izin` AS `izin`,`b`.`sakit` AS `sakit`,`b`.`alpa` AS `alpa` from ((`tbl_absen_header` `a` join `tbl_absen_detail` `b` on(`a`.`id_absen` = `b`.`id_absen`)) join `tbl_siswa` `c` on(`b`.`nomor_induk` = `c`.`nomor_induk`)) ;

-- --------------------------------------------------------

--
-- Structure for view `vnilai_rapor`
--
DROP TABLE IF EXISTS `vnilai_rapor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vnilai_rapor`  AS  select `tbl_absensi`.`kd_siswa` AS `kd_siswa`,`tbl_absensi`.`nama_siswa` AS `nama_siswa`,sum(`tbl_absensi`.`sakit`) AS `Sakit`,sum(`tbl_absensi`.`izin`) AS `Izin`,sum(`tbl_absensi`.`alpa`) AS `Alpa` from `tbl_absensi` group by `tbl_absensi`.`kd_siswa`,`tbl_absensi`.`nama_siswa` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jdl_mengajar`
--
ALTER TABLE `jdl_mengajar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jdl_mengajar_header`
--
ALTER TABLE `jdl_mengajar_header`
  ADD PRIMARY KEY (`id`,`kode_mengajar`);

--
-- Indexes for table `tbl_absensi`
--
ALTER TABLE `tbl_absensi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_absen_detail`
--
ALTER TABLE `tbl_absen_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_absen_header`
--
ALTER TABLE `tbl_absen_header`
  ADD PRIMARY KEY (`id`,`id_absen`);

--
-- Indexes for table `tbl_guru`
--
ALTER TABLE `tbl_guru`
  ADD PRIMARY KEY (`id`,`nip`);

--
-- Indexes for table `tbl_kelas`
--
ALTER TABLE `tbl_kelas`
  ADD PRIMARY KEY (`id`,`kd_kelas`);

--
-- Indexes for table `tbl_mapel`
--
ALTER TABLE `tbl_mapel`
  ADD PRIMARY KEY (`id`,`kd_mapel`);

--
-- Indexes for table `tbl_nilai_header`
--
ALTER TABLE `tbl_nilai_header`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_siswa`
--
ALTER TABLE `tbl_siswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jdl_mengajar`
--
ALTER TABLE `jdl_mengajar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `jdl_mengajar_header`
--
ALTER TABLE `jdl_mengajar_header`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_absensi`
--
ALTER TABLE `tbl_absensi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_absen_detail`
--
ALTER TABLE `tbl_absen_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_absen_header`
--
ALTER TABLE `tbl_absen_header`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_guru`
--
ALTER TABLE `tbl_guru`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_kelas`
--
ALTER TABLE `tbl_kelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_mapel`
--
ALTER TABLE `tbl_mapel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_nilai_header`
--
ALTER TABLE `tbl_nilai_header`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `tbl_siswa`
--
ALTER TABLE `tbl_siswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
