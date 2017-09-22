-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.27


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema org
--

CREATE DATABASE IF NOT EXISTS org;
USE org;

--
-- Definition of table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `ClientID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClientNamr` varchar(45) NOT NULL,
  `FKOrgID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ClientID`),
  KEY `FKOrgID` (`FKOrgID`),
  CONSTRAINT `FKOrgID` FOREIGN KEY (`FKOrgID`) REFERENCES `organization` (`orgID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=445 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`ClientID`,`ClientNamr`,`FKOrgID`) VALUES 
 (111,'ABC',1),
 (222,'PQR',1),
 (333,'XYZ',2),
 (444,'JKL',2);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


--
-- Definition of table `fields`
--

DROP TABLE IF EXISTS `fields`;
CREATE TABLE `fields` (
  `FieldID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FieldName` varchar(45) NOT NULL,
  `FKFormID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`FieldID`),
  KEY `FKFormID` (`FKFormID`),
  CONSTRAINT `FKFormID` FOREIGN KEY (`FKFormID`) REFERENCES `form` (`FromID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fields`
--

/*!40000 ALTER TABLE `fields` DISABLE KEYS */;
INSERT INTO `fields` (`FieldID`,`FieldName`,`FKFormID`) VALUES 
 (1,'Field1',44),
 (2,'Field2',44),
 (3,'Field3',44),
 (4,'Field4',55),
 (5,'Field15',55),
 (6,'Field6',66),
 (7,'Field7',66),
 (8,'Field8',77);
/*!40000 ALTER TABLE `fields` ENABLE KEYS */;


--
-- Definition of table `form`
--

DROP TABLE IF EXISTS `form`;
CREATE TABLE `form` (
  `FromID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FromName` varchar(45) NOT NULL,
  `FKClientID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`FromID`),
  KEY `FKClientID` (`FKClientID`),
  CONSTRAINT `FKClientID` FOREIGN KEY (`FKClientID`) REFERENCES `client` (`ClientID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `form`
--

/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` (`FromID`,`FromName`,`FKClientID`) VALUES 
 (44,'MagarpattaForm',111),
 (55,'HinjewadiFrom',222),
 (66,'IndoreForm',333),
 (77,'Hyd',444);
/*!40000 ALTER TABLE `form` ENABLE KEYS */;


--
-- Definition of table `organization`
--

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `orgID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orgName` varchar(45) NOT NULL,
  PRIMARY KEY (`orgID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` (`orgID`,`orgName`) VALUES 
 (1,'Yash'),
 (2,'JD');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
