-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2020 at 10:31 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khanakhaza_ct021`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin_ct021`
--

CREATE TABLE `adminlogin_ct021` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `TypeOfCustomer` varchar(50) DEFAULT NULL,
  `security_Ques` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogin_ct021`
--

INSERT INTO `adminlogin_ct021` (`username`, `password`, `TypeOfCustomer`, `security_Ques`) VALUES
('manu', 'manu123', 'admmin', 'manugupta');

-- --------------------------------------------------------

--
-- Table structure for table `cart_ct021`
--

CREATE TABLE `cart_ct021` (
  `cart_id` int(20) NOT NULL,
  `food_id` int(20) DEFAULT NULL,
  `cust_email` varchar(30) DEFAULT NULL,
  `food_qty` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart_ct021`
--

INSERT INTO `cart_ct021` (`cart_id`, `food_id`, `cust_email`, `food_qty`) VALUES
(4, 3, 'devansh.005gupta@gmail.com', 10),
(5, 5, 'devansh.005gupta@gmail.com', 10);

-- --------------------------------------------------------

--
-- Table structure for table `customer_ct021`
--

CREATE TABLE `customer_ct021` (
  `cust_id` int(20) NOT NULL,
  `cust_name` varchar(20) DEFAULT NULL,
  `cust_email` varchar(50) DEFAULT NULL,
  `cust_add` varchar(40) DEFAULT NULL,
  `cust_password` varchar(20) DEFAULT NULL,
  `cust_mobile_num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_ct021`
--

INSERT INTO `customer_ct021` (`cust_id`, `cust_name`, `cust_email`, `cust_add`, `cust_password`, `cust_mobile_num`) VALUES
(1, 'Devansh', 'devansh.005gupta@gmail.com', 'Narhe', '123', 1),
(2, 'a', 'a', 'a', 'manugupta', 1);

-- --------------------------------------------------------

--
-- Table structure for table `food_ct021`
--

CREATE TABLE `food_ct021` (
  `food_id` int(20) NOT NULL,
  `food_name` varchar(50) DEFAULT NULL,
  `food_cost` int(40) DEFAULT NULL,
  `food_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_ct021`
--

INSERT INTO `food_ct021` (`food_id`, `food_name`, `food_cost`, `food_type`) VALUES
(1, 'paneer', 10, 'veg'),
(2, 'chicken', 10, 'non_veg'),
(3, 'mutter_paneer', 100, 'veg'),
(4, 'shahiPanner', 100, 'veg'),
(5, 'tandoori', 10, 'non_veg');

-- --------------------------------------------------------

--
-- Table structure for table `orderrs`
--

CREATE TABLE `orderrs` (
  `orderr_id` int(20) NOT NULL,
  `cust_email` varchar(40) DEFAULT NULL,
  `total_bill` int(50) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderrs`
--

INSERT INTO `orderrs` (`orderr_id`, `cust_email`, `total_bill`, `order_date`) VALUES
(2, 'devansh.005gupta@gmail.com', 1100, '2019-11-19 09:54:27'),
(4, 'a', 20, '2020-01-09 09:30:52');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_ct021`
--
ALTER TABLE `cart_ct021`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `customer_ct021`
--
ALTER TABLE `customer_ct021`
  ADD PRIMARY KEY (`cust_id`),
  ADD UNIQUE KEY `cust_email` (`cust_email`);

--
-- Indexes for table `food_ct021`
--
ALTER TABLE `food_ct021`
  ADD PRIMARY KEY (`food_id`),
  ADD UNIQUE KEY `food_id` (`food_id`);

--
-- Indexes for table `orderrs`
--
ALTER TABLE `orderrs`
  ADD PRIMARY KEY (`orderr_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart_ct021`
--
ALTER TABLE `cart_ct021`
  MODIFY `cart_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `customer_ct021`
--
ALTER TABLE `customer_ct021`
  MODIFY `cust_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food_ct021`
--
ALTER TABLE `food_ct021`
  MODIFY `food_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orderrs`
--
ALTER TABLE `orderrs`
  MODIFY `orderr_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
