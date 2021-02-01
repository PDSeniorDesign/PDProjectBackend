-- MySQL dump 10.13  Distrib 5.7.30, for Win32 (AMD64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fields`
--

DROP TABLE IF EXISTS `fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fields` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `form_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqvybh7bbb87ep1fgw5anjijvj` (`form_id`),
  CONSTRAINT `FKqvybh7bbb87ep1fgw5anjijvj` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fields`
--

LOCK TABLES `fields` WRITE;
/*!40000 ALTER TABLE `fields` DISABLE KEYS */;
INSERT INTO `fields` VALUES (22,'lastName','text',NULL),(23,'firstName','text',NULL),(24,'middleInitial','text',NULL),(25,'employeeNumber','text',NULL),(26,'hostedId','text',NULL),(27,'departmentName','text',NULL),(28,'departmentNumber','text',NULL),(53,'registrationType','checkbox',NULL),(54,'requestType','checkbox',NULL),(55,'companyName','text',NULL),(56,'companyEmailAddress','text',NULL),(57,'departmentEmailAddress','text',NULL),(58,'countyEmailAddress','text',NULL),(59,'employeeEmailAddress','text',NULL),(60,'businessStreetAddress','text',NULL),(61,'businessCity','text',NULL),(62,'businessState','text',NULL),(63,'businessZip','text',NULL),(64,'businessPhoneNumber','text',NULL),(65,'workMailingAddress','text',NULL),(66,'companyStreetAddress','text',NULL),(67,'companyCity','text',NULL),(68,'companyState','text',NULL),(69,'companyZip','text',NULL),(70,'companyPhoneNumber','text',NULL),(71,'countyPhoneNumber','text',NULL),(72,'workPhoneNumber','text',NULL),(73,'contractWorkOrderNumber','text',NULL),(74,'contractExpirationDate','text',NULL),(75,'customerSignature','text',NULL),(76,'customerSignatureDate','text',NULL),(77,'ibmLogOnId','text',NULL),(78,'majorGroupCode','text',NULL),(79,'lsoGroupCode','text',NULL),(80,'securityAuthorization','text',NULL),(81,'tsoAccess','checkbox',NULL),(82,'tsoGroupCode','text',NULL),(83,'binNumber','text',NULL),(84,'subGroup1','text',NULL),(85,'subGroup2','text',NULL),(86,'subGroup3','text',NULL),(87,'onlineAccess','checkbox',NULL),(88,'systemApplication','text',NULL),(89,'groupName','text',NULL),(90,'oldGroup','text',NULL),(91,'dmvSystemCode','text',NULL),(92,'unixRequestType','text',NULL),(93,'unixLogOnId','text',NULL),(94,'unixApplication','text',NULL),(95,'unixAccessGroup','text',NULL),(96,'unixAccountNumber','text',NULL),(97,'billingAccountNumber','text',NULL),(98,'accessType','text',NULL),(99,'internetApplication','checkbox',NULL),(100,'exchangeEmail','checkbox',NULL),(101,'emailEncryption','checkbox',NULL),(102,'laCountyGovAccess','checkbox',NULL),(103,'tokenlessAuthentication','checkbox',NULL),(104,'lacMobileWifiAccess','checkbox',NULL),(105,'cherwellSms','checkbox',NULL),(106,'windowsRightsMgmt','checkbox',NULL),(107,'gmailAccess','checkbox',NULL),(108,'yahooMailAccess','checkbox',NULL),(109,'otherEmailDomain','text',NULL),(110,'businessJustification','text',NULL),(111,'defaultCountyWidePolicy','checkbox',NULL),(112,'departmentPolicyRule0','checkbox',NULL),(113,'departmentPolicyRule1','checkbox',NULL),(114,'departmentPolicyRule2','checkbox',NULL),(115,'departmentPolicyRule3','checkbox',NULL),(116,'departmentPolicyRule4','checkbox',NULL),(117,'socialNetworkingFacebook','checkbox',NULL),(118,'socialNetworkingTwitter','checkbox',NULL),(119,'socialNetworkingLinkedIn','checkbox',NULL),(120,'apsAo','text',NULL),(121,'jaiSystemLocation','text',NULL),(122,'requestDate','text',NULL),(123,'fullName','text',NULL);
/*!40000 ALTER TABLE `fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form_fields`
--

DROP TABLE IF EXISTS `form_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form_fields` (
  `form_id` int(11) NOT NULL,
  `field_id` int(11) NOT NULL,
  KEY `FK5co8kifp8c29demkb1j0nm1ym` (`field_id`),
  KEY `FKoaf23i4o45w65iclgspjv8mg0` (`form_id`),
  CONSTRAINT `FK5co8kifp8c29demkb1j0nm1ym` FOREIGN KEY (`field_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKoaf23i4o45w65iclgspjv8mg0` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form_fields`
--

LOCK TABLES `form_fields` WRITE;
/*!40000 ALTER TABLE `form_fields` DISABLE KEYS */;
INSERT INTO `form_fields` VALUES (6,22),(6,23),(6,24),(5,22),(5,23),(5,24),(4,22),(4,23),(4,24),(3,22),(3,23),(3,24),(2,22),(2,23),(2,24),(1,22),(1,23),(1,24);
/*!40000 ALTER TABLE `form_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms`
--

DROP TABLE IF EXISTS `forms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms`
--

LOCK TABLES `forms` WRITE;
/*!40000 ALTER TABLE `forms` DISABLE KEYS */;
INSERT INTO `forms` VALUES (1,'ISD Active Directory Hosted Registration Forms Contractor and Vendors'),(2,'ISD Active Directory Hosted Registration Forms Contractor and Vendors'),(3,'ISD Downey Data Center Registration Contractors and Vendors'),(4,'ISD Downey Data Center Registration LA County Employees'),(5,'ISD Internet Registration Form Contractors and Vendors'),(6,'ISD Internet Registration Form Permanent Employees');
/*!40000 ALTER TABLE `forms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forms_fields`
--

DROP TABLE IF EXISTS `forms_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forms_fields` (
  `form_id` int(11) NOT NULL,
  `fields_id` int(11) NOT NULL,
  `referenced_in_id` int(11) NOT NULL,
  `forms_id` int(11) NOT NULL,
  KEY `FKhxnjv94t5hbndei8i1xyl2o10` (`fields_id`),
  KEY `FKn0lj79hn5bwkvy436yyifpeq8` (`form_id`),
  KEY `FK3y767ppig7mpp6s9jybpgihge` (`referenced_in_id`),
  KEY `FK3va2aapb6vlp0so8glgis02ta` (`forms_id`),
  CONSTRAINT `FK3va2aapb6vlp0so8glgis02ta` FOREIGN KEY (`forms_id`) REFERENCES `forms` (`id`),
  CONSTRAINT `FK3y767ppig7mpp6s9jybpgihge` FOREIGN KEY (`referenced_in_id`) REFERENCES `forms` (`id`),
  CONSTRAINT `FKhxnjv94t5hbndei8i1xyl2o10` FOREIGN KEY (`fields_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKn0lj79hn5bwkvy436yyifpeq8` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forms_fields`
--

LOCK TABLES `forms_fields` WRITE;
/*!40000 ALTER TABLE `forms_fields` DISABLE KEYS */;
/*!40000 ALTER TABLE `forms_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (233);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mappings`
--

DROP TABLE IF EXISTS `mappings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mappings` (
  `id` int(11) NOT NULL,
  `field_id` varchar(255) DEFAULT NULL,
  `form_id` int(11) NOT NULL,
  `request_field_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mappings`
--

LOCK TABLES `mappings` WRITE;
/*!40000 ALTER TABLE `mappings` DISABLE KEYS */;
INSERT INTO `mappings` VALUES (29,'TextBox_1',1,'lastName'),(30,'TextBox_1',2,'lastName'),(31,'TextBox_1',5,'lastName'),(32,'TextBox_1',6,'lastName'),(33,'TextBox_2',1,'firstName'),(34,'TextBox_2',2,'firstName'),(35,'TextBox_2',5,'firstName'),(36,'TextBox_2',6,'firstName'),(37,'TextBox_3',1,'middleInitial'),(38,'TextBox_3',2,'middleInitial'),(39,'TextBox_3',5,'middleInitial'),(40,'TextBox_3',6,'middleInitial'),(41,'TextBox_4',1,'employeeNumber'),(42,'TextBox_4',6,'employeeNumber'),(43,'TextBox_5',1,'hostedId'),(44,'TextBox_7',1,'departmentName'),(45,'TextBox_15',2,'departmentName'),(46,'TextBox_15',5,'departmentName'),(47,'TextBox_7',6,'departmentName'),(48,'TextBox_8',1,'departmentNumber'),(49,'TextBox_16',2,'departmentNumber'),(50,'TextBox_16',5,'departmentNumber'),(51,'TextBox_8',6,'departmentNumber'),(124,'TextBox_4',2,'companyName'),(125,'TextBox_4',5,'companyName'),(126,'TextBox_5',2,'companyEmailAddress'),(127,'TextBox_5',5,'companyEmailAddress'),(128,'TextBox_6',1,'departmentEmailAddress'),(129,'TextBox_6',6,'departmentEmailAddress'),(130,'TextBox_13',2,'countyEmailAddress'),(131,'TextBox_13',5,'countyEmailAddress'),(132,'TextBox_9',1,'businessStreetAddress'),(133,'TextBox_17',2,'businessStreetAddress'),(134,'TextBox_17',5,'businessStreetAddress'),(135,'TextBox_9',6,'businessStreetAddress'),(136,'TextBox_7',3,'workMailingAddress'),(137,'TextBox_7',4,'workMailingAddress'),(138,'TextBox_6',2,'companyStreetAddress'),(139,'TextBox_6',5,'companyStreetAddress'),(140,'TextBox_8',3,'workPhoneNumber'),(141,'TextBox_8',4,'workPhoneNumber'),(142,'TextBox_11',2,'contractWorkOrderNumber'),(143,'TextBox_11',5,'contractWorkOrderNumber'),(144,'TextBox_12',2,'contractExpirationDate'),(145,'TextBox_12',5,'contractExpirationDate'),(146,'TextBox_20',5,'customerSignature'),(147,'TextBox_21',5,'customerSignatureDate'),(148,'TextBox_9',3,'ibmLogOnId'),(149,'TextBox_22',3,'unixLogOnId'),(150,'TextBox_9',4,'ibmLogOnId'),(151,'TextBox_24',4,'unixLogOnId'),(152,'TextBox_10',3,'majorGroupCode'),(153,'TextBox_10',4,'majorGroupCode'),(154,'TextBox_11',3,'lsoGroupCode'),(155,'TextBox_11',4,'lsoGroupCode'),(156,'TextBox_12',4,'securityAuthorization'),(157,'CheckBox_5',3,'tsoAccess'),(158,'CheckBox_5',4,'tsoAccess'),(159,'TextBox_12',3,'tsoGroupCode'),(160,'TextBox_13',4,'tsoGroupCode'),(161,'TextBox_14',4,'binNumber'),(162,'TextBox_13',3,'subGroup1'),(163,'TextBox_15',4,'subGroup1'),(164,'TextBox_14',3,'subGroup2'),(165,'TextBox_16',4,'subGroup2'),(166,'TextBox_15',3,'subGroup3'),(167,'TextBox_17',4,'subGroup3'),(168,'CheckBox_6',3,'onlineAccess'),(169,'CheckBox_6',4,'onlineAccess'),(170,'TextBox_16',3,'systemApplication'),(171,'TextBox_18',4,'systemApplication'),(172,'TextBox_17',3,'groupName'),(173,'TextBox_19',4,'groupName'),(174,'TextBox_18',3,'oldGroup'),(175,'TextBox_20',4,'oldGroup'),(176,'TextBox_20',3,'dmvSystemCode'),(177,'TextBox_22',4,'dmvSystemCode'),(178,'TextBox_23',3,'unixApplication'),(179,'TextBox_25',4,'unixApplication'),(180,'TextBox_24',3,'unixAccessGroup'),(181,'TextBox_26',4,'unixAccessGroup'),(182,'TextBox_25',3,'unixAccountNumber'),(183,'TextBox_27',4,'unixAccountNumber'),(184,'TextBox_26',3,'billingAccountNumber'),(185,'TextBox_28',4,'billingAccountNumber'),(186,'CheckBox_4',1,'internetApplication'),(187,'CheckBox_4',2,'internetApplication'),(188,'CheckBox_5',1,'exchangeEmail'),(189,'CheckBox_5',2,'exchangeEmail'),(190,'CheckBox_6',1,'emailEncryption'),(191,'CheckBox_6',2,'emailEncryption'),(192,'CheckBox_8',1,'tokenlessAuthentication'),(193,'CheckBox_8',2,'tokenlessAuthentication'),(194,'CheckBox_9',1,'lacMobileWifiAccess'),(195,'CheckBox_9',2,'lacMobileWifiAccess'),(196,'CheckBox_10',1,'cherwellSms'),(197,'CheckBox_10',2,'cherwellSms'),(198,'CheckBox_11',1,'windowsRightsMgmt'),(199,'CheckBox_7',2,'windowsRightsMgmt'),(200,'CheckBox_12',1,'gmailAccess'),(201,'CheckBox_11',2,'gmailAccess'),(202,'CheckBox_13',1,'yahooMailAccess'),(203,'CheckBox_12',2,'yahooMailAccess'),(204,'TextBox_13',1,'businessJustification'),(205,'TextBox_20',2,'businessJustification'),(206,'CheckBox_4',5,'defaultCountyWidePolicy'),(207,'CheckBox_4',6,'defaultCountyWidePolicy'),(208,'CheckBox_5',5,'departmentPolicyRule0'),(209,'CheckBox_5',6,'departmentPolicyRule0'),(210,'CheckBox_6',5,'departmentPolicyRule1'),(211,'CheckBox_6',6,'departmentPolicyRule1'),(212,'CheckBox_7',5,'departmentPolicyRule2'),(213,'CheckBox_7',6,'departmentPolicyRule2'),(214,'CheckBox_8',5,'departmentPolicyRule3'),(215,'CheckBox_8',6,'departmentPolicyRule3'),(216,'CheckBox_9',5,'departmentPolicyRule4'),(217,'CheckBox_9',6,'departmentPolicyRule4'),(218,'CheckBox_10',5,'socialNetworkingFacebook'),(219,'CheckBox_10',6,'socialNetworkingFacebook'),(220,'CheckBox_11',5,'socialNetworkingTwitter'),(221,'CheckBox_11',6,'socialNetworkingTwitter'),(222,'CheckBox_12',5,'socialNetworkingLinkedIn'),(223,'CheckBox_12',6,'socialNetworkingLinkedIn'),(224,'TextBox_19',3,'apsAo'),(225,'TextBox_21',4,'apsAo'),(226,'TextBox_21',3,'jaiSystemLocation'),(227,'TextBox_23',4,'jaiSystemLocation'),(228,'TextBox_3',3,'fullName'),(229,'TextBox_3',4,'fullName'),(230,'TextBox_1',3,'requestDate'),(231,'TextBox_1',4,'requestDate');
/*!40000 ALTER TABLE `mappings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_requests`
--

DROP TABLE IF EXISTS `service_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_requests` (
  `id` varchar(255) NOT NULL,
  `access_type` varchar(255) DEFAULT NULL,
  `aps_ao` varchar(255) DEFAULT NULL,
  `billing_account_number` int(11) DEFAULT NULL,
  `bin_number` int(11) DEFAULT NULL,
  `business_city` varchar(255) DEFAULT NULL,
  `business_justification` varchar(255) DEFAULT NULL,
  `business_phone_number` varchar(255) DEFAULT NULL,
  `business_state` varchar(255) DEFAULT NULL,
  `business_street_address` varchar(255) DEFAULT NULL,
  `business_zip` varchar(255) DEFAULT NULL,
  `cherwell_sms` bit(1) NOT NULL,
  `company_city` varchar(255) DEFAULT NULL,
  `company_email_address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_phone_number` varchar(255) DEFAULT NULL,
  `company_state` varchar(255) DEFAULT NULL,
  `company_street_address` varchar(255) DEFAULT NULL,
  `company_zip` varchar(255) DEFAULT NULL,
  `contract_expiration_date` varchar(255) DEFAULT NULL,
  `contract_work_order_number` int(11) DEFAULT NULL,
  `county_email_address` varchar(255) DEFAULT NULL,
  `county_phone_number` varchar(255) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `customer_signature` varchar(255) DEFAULT NULL,
  `customer_signature_date` varchar(255) DEFAULT NULL,
  `default_county_wide_policy` bit(1) NOT NULL,
  `department_email_address` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `department_number` int(11) DEFAULT NULL,
  `department_policy_rule0` bit(1) NOT NULL,
  `department_policy_rule1` bit(1) NOT NULL,
  `department_policy_rule2` bit(1) NOT NULL,
  `department_policy_rule3` bit(1) NOT NULL,
  `department_policy_rule4` bit(1) NOT NULL,
  `dmv_system_code` varchar(255) DEFAULT NULL,
  `email_encryption` bit(1) NOT NULL,
  `employee_email_address` varchar(255) DEFAULT NULL,
  `employee_number` int(11) DEFAULT NULL,
  `exchange_email` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gmail_access` bit(1) NOT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `hosted_id` int(11) DEFAULT NULL,
  `ibm_log_on_id` int(11) DEFAULT NULL,
  `internet_application` bit(1) NOT NULL,
  `jai_system_location` varchar(255) DEFAULT NULL,
  `la_county_gov_access` bit(1) NOT NULL,
  `lac_mobile_wifi_access` bit(1) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `lso_group_code` int(11) DEFAULT NULL,
  `major_group_code` int(11) DEFAULT NULL,
  `middle_initial` varchar(255) DEFAULT NULL,
  `old_group` varchar(255) DEFAULT NULL,
  `online_access` bit(1) NOT NULL,
  `other_email_domain` varchar(255) DEFAULT NULL,
  `registration_type` varchar(255) DEFAULT NULL,
  `request_status` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `security_authorization` varchar(255) DEFAULT NULL,
  `social_networking_facebook` bit(1) NOT NULL,
  `social_networking_linked_in` bit(1) NOT NULL,
  `social_networking_twitter` bit(1) NOT NULL,
  `sub_group1` varchar(255) DEFAULT NULL,
  `sub_group2` varchar(255) DEFAULT NULL,
  `sub_group3` varchar(255) DEFAULT NULL,
  `submit_date` varchar(255) DEFAULT NULL,
  `system_application` varchar(255) DEFAULT NULL,
  `tokenless_authentication` bit(1) NOT NULL,
  `tso_access` bit(1) NOT NULL,
  `tso_group_code` int(11) DEFAULT NULL,
  `unix_access_group` varchar(255) DEFAULT NULL,
  `unix_account_number` int(11) DEFAULT NULL,
  `unix_application` varchar(255) DEFAULT NULL,
  `unix_log_on_id` int(11) DEFAULT NULL,
  `unix_request_type` varchar(255) DEFAULT NULL,
  `windows_rights_mgmt` bit(1) NOT NULL,
  `work_mailing_address` varchar(255) DEFAULT NULL,
  `work_phone_number` varchar(255) DEFAULT NULL,
  `yahoo_mail_access` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_requests`
--

LOCK TABLES `service_requests` WRITE;
/*!40000 ALTER TABLE `service_requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_requests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-29 15:08:21
