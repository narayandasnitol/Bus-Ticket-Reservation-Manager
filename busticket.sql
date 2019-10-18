-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2018 at 04:26 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `busticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `busID` int(11) NOT NULL,
  `busNumber` varchar(20) NOT NULL,
  `licenseNumber` varchar(20) NOT NULL,
  `busType` varchar(20) NOT NULL,
  `availableSeats` varchar(5000) NOT NULL,
  `totalSeats` int(11) NOT NULL,
  `busRoute` varchar(500) NOT NULL,
  `priceClassic` double NOT NULL,
  `priceEconomy` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`busID`, `busNumber`, `licenseNumber`, `busType`, `availableSeats`, `totalSeats`, `busRoute`, `priceClassic`, `priceEconomy`) VALUES
(1, 'Bus1', 'DHAKA METRO- 12345', 'AC', 'A1 A2 A3 A4 B1 B2 B3 B4 C1 C2 C3 C4 D1 D2 D3 D4 E1 E2 E3 E4 F1 F2 F3 F4 G1 G2 G3 G4', 40, 'Dhaka-Sylhet', 1200, 1400),
(2, 'Bus2', 'DHAKA METRO- 54689', 'AC', 'A1 A2 A3 A4 B1 B2 B3 B4 C1 C2 C3 C4 D1 D2 D3 D4 E1 E2 E3 E4 F1 F2 F3 F4 G1 G2 G3 G4', 40, 'Dhaka-Rajshahi', 1100, 1300),
(3, 'Bus3', 'DHAKA METRO- 35647', 'Non AC', 'A1 A2 A3 A4 B1 B2 B3 B4 C1 C2 C3 C4 D1 D2 D3 D4 E1 E2 E3 E4 F1 F2 F3 F4 G1 G2 G3 G4', 40, 'Dhaka-Chittagong', 500, 700),
(4, 'Bus4', 'DHAKA METRO- 45321', 'Non AC', 'A1 A2 A3 A4 B1 B2 B3 B4 C1 C2 C3 C4 D1 D2 D3 D4 E1 E2 E3 E4 F1 F2 F3 F4 G1 G2 G3 G4', 40, 'Dhaka-Khulna', 600, 800);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL,
  `staffName` varchar(100) NOT NULL,
  `staffUsername` varchar(100) NOT NULL,
  `staffEmail` varchar(100) NOT NULL,
  `staffPassword` varchar(100) NOT NULL,
  `staffAge` int(11) NOT NULL,
  `staffAddress` varchar(200) NOT NULL,
  `staffPhone` varchar(20) NOT NULL,
  `staffCounter` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticketID` int(11) NOT NULL,
  `numberofTickets` int(11) NOT NULL,
  `seatType` varchar(20) NOT NULL,
  `journeyDate` date NOT NULL,
  `price` double NOT NULL,
  `seatNumber` varchar(10) NOT NULL,
  `issueDate` date DEFAULT NULL,
  `route` varchar(100) NOT NULL,
  `departureTime` time NOT NULL,
  `paymentType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` int(11) NOT NULL,
  `transactionNumber` varchar(100) NOT NULL,
  `cardType` varchar(100) NOT NULL,
  `cardNumber` int(11) NOT NULL,
  `expiryDate` date NOT NULL,
  `cardHolderName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`busID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticketID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `busID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staffID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticketID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
