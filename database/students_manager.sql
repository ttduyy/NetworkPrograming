-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Apr 10, 2023 at 02:18 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `students_list`
--

CREATE TABLE `students_list` (
  `id` varchar(10) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dateOfBirth` varchar(20) NOT NULL,
  `class` varchar(10) NOT NULL,
  `major` varchar(50) NOT NULL,
  `score` double NOT NULL,
  `chat` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students_list`
--

INSERT INTO `students_list` (`id`, `firstName`, `lastName`, `gender`, `dateOfBirth`, `class`, `major`, `score`, `chat`) VALUES
('1', 'Minh', 'Nguyen', 'Male', '26/03/2003', '1', 'InformationTechnology', 10, 'oooo'),
('2', 'Duy', 'Tran', 'Male', '17/06/2003', '1', 'InformationTechnology', 9, 'hello'),
('3', 'Hao', 'Tran', 'Female', '08/03/2003', '2', 'InformationTechnology', 1, 'huhuhu'),
('4', 'Qui', 'Huynh', 'Male', '25/05/2003', '1', 'InformationTechnology', 8, 'no');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students_list`
--
ALTER TABLE `students_list`
  ADD UNIQUE KEY `primary_key` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
