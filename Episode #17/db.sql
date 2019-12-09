-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 09, 2019 at 01:39 AM
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
-- Database: `clientname`
--

-- --------------------------------------------------------

--
-- Table structure for table `cosmetics`
--

DROP TABLE IF EXISTS `cosmetics`;
CREATE TABLE IF NOT EXISTS `cosmetics` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) NOT NULL,
  `cape_enabled` tinyint(1) NOT NULL DEFAULT '0',
  `cape_style` varchar(30) DEFAULT NULL,
  `hat_enabled` tinyint(1) NOT NULL DEFAULT '0',
  `hat_color_r` tinyint(3) UNSIGNED NOT NULL DEFAULT '0',
  `hat_color_g` tinyint(3) UNSIGNED NOT NULL DEFAULT '0',
  `hat_color_b` tinyint(3) UNSIGNED NOT NULL DEFAULT '0',
  `googly_eyes` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cosmetics`
--

INSERT INTO `cosmetics` (`id`, `uuid`, `cape_enabled`, `cape_style`, `hat_enabled`, `hat_color_r`, `hat_color_g`, `hat_color_b`, `googly_eyes`) VALUES
(1, '575973e5-e497-3cb3-bb63-d114ffcff0b1', 0, NULL, 0, 255, 0, 255, 1),
(3, '575973e5-e497-3cb3-bb63-d114ffcff0b2', 1, 'smiley_face', 1, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hwidban`
--

DROP TABLE IF EXISTS `hwidban`;
CREATE TABLE IF NOT EXISTS `hwidban` (
  `hwid` varchar(255) NOT NULL,
  `isBanned` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`hwid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hwidban`
--

INSERT INTO `hwidban` (`hwid`, `isBanned`) VALUES
('hwidbanned', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hwidwhitelist`
--

DROP TABLE IF EXISTS `hwidwhitelist`;
CREATE TABLE IF NOT EXISTS `hwidwhitelist` (
  `hwid` varchar(255) NOT NULL,
  `isWhitelisted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`hwid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hwidwhitelist`
--

INSERT INTO `hwidwhitelist` (`hwid`, `isWhitelisted`) VALUES
('fake-hwid', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usermap`
--

DROP TABLE IF EXISTS `usermap`;
CREATE TABLE IF NOT EXISTS `usermap` (
  `uuid` varchar(36) NOT NULL,
  `hwid` varchar(255) NOT NULL,
  `username` varchar(16) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usermap`
--

INSERT INTO `usermap` (`uuid`, `hwid`, `username`, `updated_time`) VALUES
('ed3dfa00-7125-4572-b48d-9f9d82e9f007', 'fake-hwid', 'FakeUser', '2019-11-28 06:02:30');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` char(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'TestAccount', '$2a$10$EEazA2nRW8n6Ymn3EAeGH.3n7CQ9NsbP2dZf0O6lYgrzJolgs.1lS');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
