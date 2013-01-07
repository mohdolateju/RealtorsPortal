-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 28, 2010 at 06:13 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `realtors_portal`
--

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE IF NOT EXISTS `ads` (
  `ads_id` int(11) NOT NULL auto_increment,
  `ad_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `location` varchar(45) NOT NULL,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`ads_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `ads`
--

INSERT INTO `ads` (`ads_id`, `ad_name`, `username`, `category`, `type`, `description`, `location`, `date`) VALUES
(12, 'mohdolatejuad12', 'mohdolateju', 'Office Space', 'Rent', 'Welcome Welcome Welcome, get ready for 419', 'Abuja', '2010-12-23 20:22:54'),
(14, 'mohdolatejuad14', 'mohdolateju', 'Office Space', 'Rent', 'Bukola''s Village', 'Kwara', '2010-12-24 13:26:18'),
(18, 'megatrixad18', 'megatrix', 'Office Space', 'Buy', 'The winner of the Big Start 2009/2010, Yahya Stapic from the American University of Sharjah, is currently working with ATI to launch his winning business idea -  pionieering retail  and fashion incubator concept. United Designers. Yahya and his winning Story.', 'Mumbai', '2010-12-25 15:42:39'),
(19, 'adminad19', 'admin', 'Office Space', 'Rent', 'This is just a test', 'AdminCollege', '2010-12-26 13:54:17');

-- --------------------------------------------------------

--
-- Table structure for table `subscription_package`
--

CREATE TABLE IF NOT EXISTS `subscription_package` (
  `package_id` int(11) NOT NULL auto_increment,
  `package_name` varchar(45) NOT NULL,
  `duration` int(11) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY  (`package_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `subscription_package`
--

INSERT INTO `subscription_package` (`package_id`, `package_name`, `duration`, `price`) VALUES
(1, 'admin', 0, 0),
(2, 'Standard', 30, 1000),
(3, 'Professional', 60, 1500),
(4, 'Home', 15, 500);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_log`
--

CREATE TABLE IF NOT EXISTS `transaction_log` (
  `credit_cardno` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `transaction_type` varchar(45) NOT NULL,
  PRIMARY KEY  (`credit_cardno`),
  KEY `fk_transaction_users1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaction_log`
--

INSERT INTO `transaction_log` (`credit_cardno`, `user_id`, `date`, `transaction_type`) VALUES
(123456789, 1008, '2010-12-20 00:45:17', 'registration');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `package_id` int(11) NOT NULL,
  `registration_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_users_subscription_package1` (`package_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1009 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `firstname`, `middlename`, `lastname`, `email`, `role`, `status`, `package_id`, `registration_date`) VALUES
(1001, 'admin', 'admin', 'Mohammed', 'Balarabe', 'Olateju', 'mohdolateju@gmail.com', 'admin', 1, 1, '2010-12-17 19:14:05'),
(1004, 'megatrix', 'agent', 'Mohammed', 'Balarabe', 'Olateju', 'mohdolateju@yahoo.com', 'agent', 1, 2, '2010-12-17 19:53:24'),
(1005, 'mohdolateju', 'pseller', 'Mohammed', 'Balarabe', 'Olateju', 'mohdolateju@hotmail.com', 'privateseller', 1, 3, '2010-12-17 18:48:42'),
(1008, 'mohammed', 'mohammed', 'Mohammed', 'mohammed', 'mohammed', 'mohammed@mohammed.com', 'privateseller', 1, 2, '2010-12-20 00:45:17');

-- --------------------------------------------------------

--
-- Table structure for table `user_ads`
--

CREATE TABLE IF NOT EXISTS `user_ads` (
  `user_id` int(11) NOT NULL,
  `ads_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`ads_id`),
  KEY `fk_user_ads_ads1` (`ads_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_ads`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction_log`
--
ALTER TABLE `transaction_log`
  ADD CONSTRAINT `fk_transaction_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_subscription_package1` FOREIGN KEY (`package_id`) REFERENCES `subscription_package` (`package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_ads`
--
ALTER TABLE `user_ads`
  ADD CONSTRAINT `fk_user_ads_ads1` FOREIGN KEY (`ads_id`) REFERENCES `ads` (`ads_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_ads_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
