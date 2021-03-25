-- Adminer 4.7.8 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `admin` (`id`, `password`, `email`) VALUES
(1,	'pass123',	'lacpdrequestreviewer@gmail.com');

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `application_coordinators`;
CREATE TABLE `application_coordinators` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `application_coordinators` (`id`, `email`, `name`, `phone`) VALUES
(235,	'LACPDFormTester@gmail.com',	'Application Coordinator',	'0123456789');

DROP TABLE IF EXISTS `department_heads`;
CREATE TABLE `department_heads` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `department_heads` (`id`, `email`, `name`, `phone`) VALUES
(233,	'LACPDFormTester@gmail.com',	'Department Head',	'0123456789');

DROP TABLE IF EXISTS `dept_info_security_officers`;
CREATE TABLE `dept_info_security_officers` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `dept_info_security_officers` (`id`, `email`, `name`, `phone`) VALUES
(237,	'LACPDFormTester@gmail.com',	'Dept Info Security Officer',	'0123456789');

DROP TABLE IF EXISTS `div_chief_managers`;
CREATE TABLE `div_chief_managers` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `div_chief_managers` (`id`, `email`, `name`, `phone`) VALUES
(234,	'LACPDFormTester@gmail.com',	'Div Chief / Manager',	'0123456789');

DROP TABLE IF EXISTS `fields`;
CREATE TABLE `fields` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `form_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqvybh7bbb87ep1fgw5anjijvj` (`form_id`),
  CONSTRAINT `FKqvybh7bbb87ep1fgw5anjijvj` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `fields` (`id`, `name`, `type`, `form_id`) VALUES
(22,	'lastName',	'text',	NULL),
(23,	'firstName',	'text',	NULL),
(24,	'middleInitial',	'text',	NULL),
(25,	'employeeNumber',	'text',	NULL),
(26,	'hostedId',	'text',	NULL),
(27,	'departmentName',	'text',	NULL),
(28,	'departmentNumber',	'text',	NULL),
(53,	'registrationType',	'checkbox',	NULL),
(54,	'requestType',	'checkbox',	NULL),
(55,	'companyName',	'text',	NULL),
(56,	'companyEmailAddress',	'text',	NULL),
(57,	'departmentEmailAddress',	'text',	NULL),
(58,	'countyEmailAddress',	'text',	NULL),
(59,	'employeeEmailAddress',	'text',	NULL),
(60,	'businessStreetAddress',	'text',	NULL),
(61,	'businessCity',	'text',	NULL),
(62,	'businessState',	'text',	NULL),
(63,	'businessZip',	'text',	NULL),
(64,	'businessPhoneNumber',	'text',	NULL),
(65,	'workMailingAddress',	'text',	NULL),
(66,	'companyStreetAddress',	'text',	NULL),
(67,	'companyCity',	'text',	NULL),
(68,	'companyState',	'text',	NULL),
(69,	'companyZip',	'text',	NULL),
(70,	'companyPhoneNumber',	'text',	NULL),
(71,	'countyPhoneNumber',	'text',	NULL),
(72,	'workPhoneNumber',	'text',	NULL),
(73,	'contractWorkOrderNumber',	'text',	NULL),
(74,	'contractExpirationDate',	'text',	NULL),
(75,	'customerSignature',	'text',	NULL),
(76,	'customerSignatureDate',	'text',	NULL),
(77,	'ibmLogOnId',	'text',	NULL),
(78,	'majorGroupCode',	'text',	NULL),
(79,	'lsoGroupCode',	'text',	NULL),
(80,	'securityAuthorization',	'text',	NULL),
(81,	'tsoAccess',	'checkbox',	NULL),
(82,	'tsoGroupCode',	'text',	NULL),
(83,	'binNumber',	'text',	NULL),
(84,	'subGroup1',	'text',	NULL),
(85,	'subGroup2',	'text',	NULL),
(86,	'subGroup3',	'text',	NULL),
(87,	'onlineAccess',	'checkbox',	NULL),
(88,	'systemApplication',	'text',	NULL),
(89,	'groupName',	'text',	NULL),
(90,	'oldGroup',	'text',	NULL),
(91,	'dmvSystemCode',	'text',	NULL),
(92,	'unixRequestType',	'text',	NULL),
(93,	'unixLogOnId',	'text',	NULL),
(94,	'unixApplication',	'text',	NULL),
(95,	'unixAccessGroup',	'text',	NULL),
(96,	'unixAccountNumber',	'text',	NULL),
(97,	'billingAccountNumber',	'text',	NULL),
(98,	'accessType',	'text',	NULL),
(99,	'internetApplication',	'checkbox',	NULL),
(100,	'exchangeEmail',	'checkbox',	NULL),
(101,	'emailEncryption',	'checkbox',	NULL),
(102,	'laCountyGovAccess',	'checkbox',	NULL),
(103,	'tokenlessAuthentication',	'checkbox',	NULL),
(104,	'lacMobileWifiAccess',	'checkbox',	NULL),
(105,	'cherwellSms',	'checkbox',	NULL),
(106,	'windowsRightsMgmt',	'checkbox',	NULL),
(107,	'gmailAccess',	'checkbox',	NULL),
(108,	'yahooMailAccess',	'checkbox',	NULL),
(109,	'otherEmailDomain',	'text',	NULL),
(110,	'businessJustification',	'text',	NULL),
(111,	'defaultCountyWidePolicy',	'checkbox',	NULL),
(112,	'departmentPolicyRule0',	'checkbox',	NULL),
(113,	'departmentPolicyRule1',	'checkbox',	NULL),
(114,	'departmentPolicyRule2',	'checkbox',	NULL),
(115,	'departmentPolicyRule3',	'checkbox',	NULL),
(116,	'departmentPolicyRule4',	'checkbox',	NULL),
(117,	'socialNetworkingFacebook',	'checkbox',	NULL),
(118,	'socialNetworkingTwitter',	'checkbox',	NULL),
(119,	'socialNetworkingLinkedIn',	'checkbox',	NULL),
(120,	'apsAo',	'text',	NULL),
(121,	'jaiSystemLocation',	'text',	NULL),
(122,	'requestDate',	'text',	NULL),
(123,	'fullName',	'text',	NULL);

DROP TABLE IF EXISTS `form_fields`;
CREATE TABLE `form_fields` (
  `form_id` int NOT NULL,
  `field_id` int NOT NULL,
  KEY `FK5co8kifp8c29demkb1j0nm1ym` (`field_id`),
  KEY `FKoaf23i4o45w65iclgspjv8mg0` (`form_id`),
  CONSTRAINT `FK5co8kifp8c29demkb1j0nm1ym` FOREIGN KEY (`field_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKoaf23i4o45w65iclgspjv8mg0` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `form_fields` (`form_id`, `field_id`) VALUES
(6,	22),
(6,	23),
(6,	24),
(5,	22),
(5,	23),
(5,	24),
(4,	22),
(4,	23),
(4,	24),
(3,	22),
(3,	23),
(3,	24),
(2,	22),
(2,	23),
(2,	24),
(1,	22),
(1,	23),
(1,	24);

DROP TABLE IF EXISTS `forms`;
CREATE TABLE `forms` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `forms` (`id`, `name`) VALUES
(1,	'ISD Active Directory Hosted Registration Forms Contractor and Vendors'),
(2,	'ISD Active Directory Hosted Registration Forms Contractor and Vendors'),
(3,	'ISD Downey Data Center Registration Contractors and Vendors'),
(4,	'ISD Downey Data Center Registration LA County Employees'),
(5,	'ISD Internet Registration Form Contractors and Vendors'),
(6,	'ISD Internet Registration Form Permanent Employees');

DROP TABLE IF EXISTS `forms_fields`;
CREATE TABLE `forms_fields` (
  `form_id` int NOT NULL,
  `fields_id` int NOT NULL,
  `referenced_in_id` int NOT NULL,
  `forms_id` int NOT NULL,
  KEY `FKhxnjv94t5hbndei8i1xyl2o10` (`fields_id`),
  KEY `FKn0lj79hn5bwkvy436yyifpeq8` (`form_id`),
  KEY `FK3y767ppig7mpp6s9jybpgihge` (`referenced_in_id`),
  KEY `FK3va2aapb6vlp0so8glgis02ta` (`forms_id`),
  CONSTRAINT `FK3va2aapb6vlp0so8glgis02ta` FOREIGN KEY (`forms_id`) REFERENCES `forms` (`id`),
  CONSTRAINT `FK3y767ppig7mpp6s9jybpgihge` FOREIGN KEY (`referenced_in_id`) REFERENCES `forms` (`id`),
  CONSTRAINT `FKhxnjv94t5hbndei8i1xyl2o10` FOREIGN KEY (`fields_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKn0lj79hn5bwkvy436yyifpeq8` FOREIGN KEY (`form_id`) REFERENCES `forms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(238);

DROP TABLE IF EXISTS `mappings`;
CREATE TABLE `mappings` (
  `id` int NOT NULL,
  `field_id` varchar(255) DEFAULT NULL,
  `form_id` int NOT NULL,
  `request_field_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mappings` (`id`, `field_id`, `form_id`, `request_field_name`) VALUES
(29,	'TextBox_1',	1,	'lastName'),
(30,	'TextBox_1',	2,	'lastName'),
(31,	'TextBox_1',	5,	'lastName'),
(32,	'TextBox_1',	6,	'lastName'),
(33,	'TextBox_2',	1,	'firstName'),
(34,	'TextBox_2',	2,	'firstName'),
(35,	'TextBox_2',	5,	'firstName'),
(36,	'TextBox_2',	6,	'firstName'),
(37,	'TextBox_3',	1,	'middleInitial'),
(38,	'TextBox_3',	2,	'middleInitial'),
(39,	'TextBox_3',	5,	'middleInitial'),
(40,	'TextBox_3',	6,	'middleInitial'),
(41,	'TextBox_4',	1,	'employeeNumber'),
(42,	'TextBox_4',	6,	'employeeNumber'),
(43,	'TextBox_5',	1,	'hostedId'),
(44,	'TextBox_7',	1,	'departmentName'),
(45,	'TextBox_15',	2,	'departmentName'),
(46,	'TextBox_15',	5,	'departmentName'),
(47,	'TextBox_7',	6,	'departmentName'),
(48,	'TextBox_8',	1,	'departmentNumber'),
(49,	'TextBox_16',	2,	'departmentNumber'),
(50,	'TextBox_16',	5,	'departmentNumber'),
(51,	'TextBox_8',	6,	'departmentNumber'),
(124,	'TextBox_4',	2,	'companyName'),
(125,	'TextBox_4',	5,	'companyName'),
(126,	'TextBox_5',	2,	'companyEmailAddress'),
(127,	'TextBox_5',	5,	'companyEmailAddress'),
(128,	'TextBox_6',	1,	'departmentEmailAddress'),
(129,	'TextBox_6',	6,	'departmentEmailAddress'),
(130,	'TextBox_13',	2,	'countyEmailAddress'),
(131,	'TextBox_13',	5,	'countyEmailAddress'),
(132,	'TextBox_9',	1,	'businessStreetAddress'),
(133,	'TextBox_17',	2,	'businessStreetAddress'),
(134,	'TextBox_17',	5,	'businessStreetAddress'),
(135,	'TextBox_9',	6,	'businessStreetAddress'),
(136,	'TextBox_7',	3,	'workMailingAddress'),
(137,	'TextBox_7',	4,	'workMailingAddress'),
(138,	'TextBox_6',	2,	'companyStreetAddress'),
(139,	'TextBox_6',	5,	'companyStreetAddress'),
(140,	'TextBox_8',	3,	'workPhoneNumber'),
(141,	'TextBox_8',	4,	'workPhoneNumber'),
(142,	'TextBox_11',	2,	'contractWorkOrderNumber'),
(143,	'TextBox_11',	5,	'contractWorkOrderNumber'),
(144,	'TextBox_12',	2,	'contractExpirationDate'),
(145,	'TextBox_12',	5,	'contractExpirationDate'),
(146,	'TextBox_20',	5,	'customerSignature'),
(147,	'TextBox_21',	5,	'customerSignatureDate'),
(148,	'TextBox_9',	3,	'ibmLogOnId'),
(149,	'TextBox_22',	3,	'unixLogOnId'),
(150,	'TextBox_9',	4,	'ibmLogOnId'),
(151,	'TextBox_24',	4,	'unixLogOnId'),
(152,	'TextBox_10',	3,	'majorGroupCode'),
(153,	'TextBox_10',	4,	'majorGroupCode'),
(154,	'TextBox_11',	3,	'lsoGroupCode'),
(155,	'TextBox_11',	4,	'lsoGroupCode'),
(156,	'TextBox_12',	4,	'securityAuthorization'),
(157,	'CheckBox_5',	3,	'tsoAccess'),
(158,	'CheckBox_5',	4,	'tsoAccess'),
(159,	'TextBox_12',	3,	'tsoGroupCode'),
(160,	'TextBox_13',	4,	'tsoGroupCode'),
(161,	'TextBox_14',	4,	'binNumber'),
(162,	'TextBox_13',	3,	'subGroup1'),
(163,	'TextBox_15',	4,	'subGroup1'),
(164,	'TextBox_14',	3,	'subGroup2'),
(165,	'TextBox_16',	4,	'subGroup2'),
(166,	'TextBox_15',	3,	'subGroup3'),
(167,	'TextBox_17',	4,	'subGroup3'),
(168,	'CheckBox_6',	3,	'onlineAccess'),
(169,	'CheckBox_6',	4,	'onlineAccess'),
(170,	'TextBox_16',	3,	'systemApplication'),
(171,	'TextBox_18',	4,	'systemApplication'),
(172,	'TextBox_17',	3,	'groupName'),
(173,	'TextBox_19',	4,	'groupName'),
(174,	'TextBox_18',	3,	'oldGroup'),
(175,	'TextBox_20',	4,	'oldGroup'),
(176,	'TextBox_20',	3,	'dmvSystemCode'),
(177,	'TextBox_22',	4,	'dmvSystemCode'),
(178,	'TextBox_23',	3,	'unixApplication'),
(179,	'TextBox_25',	4,	'unixApplication'),
(180,	'TextBox_24',	3,	'unixAccessGroup'),
(181,	'TextBox_26',	4,	'unixAccessGroup'),
(182,	'TextBox_25',	3,	'unixAccountNumber'),
(183,	'TextBox_27',	4,	'unixAccountNumber'),
(184,	'TextBox_26',	3,	'billingAccountNumber'),
(185,	'TextBox_28',	4,	'billingAccountNumber'),
(186,	'CheckBox_4',	1,	'internetApplication'),
(187,	'CheckBox_4',	2,	'internetApplication'),
(188,	'CheckBox_5',	1,	'exchangeEmail'),
(189,	'CheckBox_5',	2,	'exchangeEmail'),
(190,	'CheckBox_6',	1,	'emailEncryption'),
(191,	'CheckBox_6',	2,	'emailEncryption'),
(192,	'CheckBox_8',	1,	'tokenlessAuthentication'),
(193,	'CheckBox_8',	2,	'tokenlessAuthentication'),
(194,	'CheckBox_9',	1,	'lacMobileWifiAccess'),
(195,	'CheckBox_9',	2,	'lacMobileWifiAccess'),
(196,	'CheckBox_10',	1,	'cherwellSms'),
(197,	'CheckBox_10',	2,	'cherwellSms'),
(198,	'CheckBox_11',	1,	'windowsRightsMgmt'),
(199,	'CheckBox_7',	2,	'windowsRightsMgmt'),
(200,	'CheckBox_12',	1,	'gmailAccess'),
(201,	'CheckBox_11',	2,	'gmailAccess'),
(202,	'CheckBox_13',	1,	'yahooMailAccess'),
(203,	'CheckBox_12',	2,	'yahooMailAccess'),
(204,	'TextBox_13',	1,	'businessJustification'),
(205,	'TextBox_20',	2,	'businessJustification'),
(206,	'CheckBox_4',	5,	'defaultCountyWidePolicy'),
(207,	'CheckBox_4',	6,	'defaultCountyWidePolicy'),
(208,	'CheckBox_5',	5,	'departmentPolicyRule0'),
(209,	'CheckBox_5',	6,	'departmentPolicyRule0'),
(210,	'CheckBox_6',	5,	'departmentPolicyRule1'),
(211,	'CheckBox_6',	6,	'departmentPolicyRule1'),
(212,	'CheckBox_7',	5,	'departmentPolicyRule2'),
(213,	'CheckBox_7',	6,	'departmentPolicyRule2'),
(214,	'CheckBox_8',	5,	'departmentPolicyRule3'),
(215,	'CheckBox_8',	6,	'departmentPolicyRule3'),
(216,	'CheckBox_9',	5,	'departmentPolicyRule4'),
(217,	'CheckBox_9',	6,	'departmentPolicyRule4'),
(218,	'CheckBox_10',	5,	'socialNetworkingFacebook'),
(219,	'CheckBox_10',	6,	'socialNetworkingFacebook'),
(220,	'CheckBox_11',	5,	'socialNetworkingTwitter'),
(221,	'CheckBox_11',	6,	'socialNetworkingTwitter'),
(222,	'CheckBox_12',	5,	'socialNetworkingLinkedIn'),
(223,	'CheckBox_12',	6,	'socialNetworkingLinkedIn'),
(224,	'TextBox_19',	3,	'apsAo'),
(225,	'TextBox_21',	4,	'apsAo'),
(226,	'TextBox_21',	3,	'jaiSystemLocation'),
(227,	'TextBox_23',	4,	'jaiSystemLocation'),
(228,	'TextBox_3',	3,	'fullName'),
(229,	'TextBox_3',	4,	'fullName'),
(230,	'TextBox_1',	3,	'requestDate'),
(231,	'TextBox_1',	4,	'requestDate');

DROP TABLE IF EXISTS `service_requests`;
CREATE TABLE `service_requests` (
  `request_number` int NOT NULL,
  `adaptive_authentication_vpn` bit(1) NOT NULL,
  `add_logon_id` bit(1) NOT NULL,
  `agreement_id` varchar(255) DEFAULT NULL,
  `application_coordinator_email` varchar(150) DEFAULT NULL,
  `application_coordinator_name` varchar(150) DEFAULT NULL,
  `application_coordinator_phone` varchar(20) DEFAULT NULL,
  `billing_account_number` varchar(150) DEFAULT NULL,
  `bin_number` varchar(50) DEFAULT NULL,
  `business_city` varchar(50) DEFAULT NULL,
  `business_justification` varchar(250) DEFAULT NULL,
  `business_phone_number` varchar(20) DEFAULT NULL,
  `business_state` varchar(50) DEFAULT NULL,
  `business_street_address` varchar(100) DEFAULT NULL,
  `business_zip` varchar(20) DEFAULT NULL,
  `change_logon_id` bit(1) NOT NULL,
  `cherwell_sms` bit(1) NOT NULL,
  `company_city` varchar(50) DEFAULT NULL,
  `company_email_address` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `company_phone_number` varchar(20) DEFAULT NULL,
  `company_state` varchar(50) DEFAULT NULL,
  `company_street_address` varchar(100) DEFAULT NULL,
  `company_zip` varchar(20) DEFAULT NULL,
  `contract_expiration_date` varchar(20) DEFAULT NULL,
  `contract_work_order_number` varchar(50) DEFAULT NULL,
  `county_email_address` varchar(100) DEFAULT NULL,
  `county_phone_number` varchar(20) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `default_county_wide_policy` bit(1) NOT NULL,
  `delete_logon_id` bit(1) NOT NULL,
  `delete_prior_registration` bit(1) NOT NULL,
  `department_head_email` varchar(150) DEFAULT NULL,
  `department_head_name` varchar(150) DEFAULT NULL,
  `department_head_phone` varchar(20) DEFAULT NULL,
  `department_name` varchar(100) DEFAULT NULL,
  `department_number` varchar(50) DEFAULT NULL,
  `department_policy_rule0` bit(1) NOT NULL,
  `department_policy_rule1` bit(1) NOT NULL,
  `department_policy_rule2` bit(1) NOT NULL,
  `department_policy_rule3` bit(1) NOT NULL,
  `department_policy_rule4` bit(1) NOT NULL,
  `dept_info_security_officer_email` varchar(150) DEFAULT NULL,
  `dept_info_security_officer_name` varchar(150) DEFAULT NULL,
  `dept_info_security_officer_phone` varchar(20) DEFAULT NULL,
  `div_chief_manager_email` varchar(150) DEFAULT NULL,
  `div_chief_manager_name` varchar(150) DEFAULT NULL,
  `div_chief_manager_phone` varchar(20) DEFAULT NULL,
  `email_encryption` bit(1) NOT NULL,
  `employee_email_address` varchar(100) DEFAULT NULL,
  `employee_number` varchar(50) DEFAULT NULL,
  `exchange_email` bit(1) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `gmail_access` bit(1) NOT NULL,
  `group_name` varchar(150) DEFAULT NULL,
  `ibm_log_on_id` varchar(50) DEFAULT NULL,
  `internet_application` bit(1) NOT NULL,
  `is_complete` bit(1) NOT NULL,
  `is_employee` bit(1) NOT NULL,
  `is_submitted` bit(1) NOT NULL,
  `la_county_gov_access` bit(1) NOT NULL,
  `lac_mobile_wifi_access` bit(1) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `lso_group_code` varchar(150) DEFAULT NULL,
  `major_group_code` varchar(150) DEFAULT NULL,
  `manager_email` varchar(150) DEFAULT NULL,
  `manager_name` varchar(150) DEFAULT NULL,
  `manager_phone` varchar(20) DEFAULT NULL,
  `manager_title` varchar(150) DEFAULT NULL,
  `middle_initial` varchar(5) DEFAULT NULL,
  `new_registration` bit(1) NOT NULL,
  `old_group` varchar(150) DEFAULT NULL,
  `online_access` bit(1) NOT NULL,
  `other_email_access` bit(1) NOT NULL,
  `other_email_domain` varchar(100) DEFAULT NULL,
  `replace_lost_token` bit(1) NOT NULL,
  `request_status` varchar(255) DEFAULT NULL,
  `secur_id_vpn` bit(1) NOT NULL,
  `security_authorization` varchar(250) DEFAULT NULL,
  `social_networking_facebook` bit(1) NOT NULL,
  `social_networking_linked_in` bit(1) NOT NULL,
  `social_networking_twitter` bit(1) NOT NULL,
  `sub_group1` varchar(150) DEFAULT NULL,
  `sub_group2` varchar(150) DEFAULT NULL,
  `sub_group3` varchar(150) DEFAULT NULL,
  `submit_date` varchar(255) DEFAULT NULL,
  `system_application` varchar(250) DEFAULT NULL,
  `tokenless_authentication` bit(1) NOT NULL,
  `tso_access` bit(1) NOT NULL,
  `tso_group_code` varchar(150) DEFAULT NULL,
  `unix_access_group` varchar(150) DEFAULT NULL,
  `unix_account_number` varchar(150) DEFAULT NULL,
  `unix_add_logon_id` bit(1) NOT NULL,
  `unix_application` varchar(150) DEFAULT NULL,
  `unix_change_logon_id` bit(1) NOT NULL,
  `unix_delete_logon_id` bit(1) NOT NULL,
  `unix_log_on_id` varchar(150) DEFAULT NULL,
  `update_prior_registration` bit(1) NOT NULL,
  `windows_rights_mgmt` bit(1) NOT NULL,
  `work_mailing_address` varchar(150) DEFAULT NULL,
  `yahoo_mail_access` bit(1) NOT NULL,
  PRIMARY KEY (`request_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `service_requests` (`request_number`, `adaptive_authentication_vpn`, `add_logon_id`, `agreement_id`, `application_coordinator_email`, `application_coordinator_name`, `application_coordinator_phone`, `billing_account_number`, `bin_number`, `business_city`, `business_justification`, `business_phone_number`, `business_state`, `business_street_address`, `business_zip`, `change_logon_id`, `cherwell_sms`, `company_city`, `company_email_address`, `company_name`, `company_phone_number`, `company_state`, `company_street_address`, `company_zip`, `contract_expiration_date`, `contract_work_order_number`, `county_email_address`, `county_phone_number`, `create_date`, `default_county_wide_policy`, `delete_logon_id`, `delete_prior_registration`, `department_head_email`, `department_head_name`, `department_head_phone`, `department_name`, `department_number`, `department_policy_rule0`, `department_policy_rule1`, `department_policy_rule2`, `department_policy_rule3`, `department_policy_rule4`, `dept_info_security_officer_email`, `dept_info_security_officer_name`, `dept_info_security_officer_phone`, `div_chief_manager_email`, `div_chief_manager_name`, `div_chief_manager_phone`, `email_encryption`, `employee_email_address`, `employee_number`, `exchange_email`, `first_name`, `gmail_access`, `group_name`, `ibm_log_on_id`, `internet_application`, `is_complete`, `is_employee`, `is_submitted`, `la_county_gov_access`, `lac_mobile_wifi_access`, `last_name`, `lso_group_code`, `major_group_code`, `manager_email`, `manager_name`, `manager_phone`, `manager_title`, `middle_initial`, `new_registration`, `old_group`, `online_access`, `other_email_access`, `other_email_domain`, `replace_lost_token`, `request_status`, `secur_id_vpn`, `security_authorization`, `social_networking_facebook`, `social_networking_linked_in`, `social_networking_twitter`, `sub_group1`, `sub_group2`, `sub_group3`, `submit_date`, `system_application`, `tokenless_authentication`, `tso_access`, `tso_group_code`, `unix_access_group`, `unix_account_number`, `unix_add_logon_id`, `unix_application`, `unix_change_logon_id`, `unix_delete_logon_id`, `unix_log_on_id`, `update_prior_registration`, `windows_rights_mgmt`, `work_mailing_address`, `yahoo_mail_access`) VALUES
(378804,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'CBJCHBCAABAAD3LDS_t1JPp3RxV7Y54WWUEXiPzHuozl',	'lacpdformtester@gmail.com',	'Application Coordinator',	'0123456789',	'844362',	'Bin Number',	'Los Angeles',	'Access required to these technologies.',	'555-263-8342',	'CA',	'500 Example Ave.',	'90032',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'Los Angeles',	'lacpdformtester@gmail.com',	'Jim\'s Burgers',	'232-626-1673',	'CA',	'123 Apple St.',	'90032',	'06/01/2021',	'C2672721',	'lacpdformtester@gmail.com',	'612-626-7832',	'03/07/2021',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'lacpdformtester@gmail.com',	'Department Head',	'0123456789',	'Example Department',	'512',	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'lacpdformtester@gmail.com',	'Dept Info Security Officer',	'0123456789',	'lacpdformtester@gmail.com',	'Div Chief',	'0123456789',	CONV('0', 2, 10) + 0,	'lacpdformtester@gmail.com',	'15',	CONV('0', 2, 10) + 0,	'John',	CONV('1', 2, 10) + 0,	'Test Group',	'23626',	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'Doe',	'2352762',	'272727',	'lacpdformtester@gmail.com',	'Manager',	'0123456789',	'Title',	'F',	CONV('1', 2, 10) + 0,	'Old Group',	CONV('1', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'',	CONV('0', 2, 10) + 0,	'Submitted',	CONV('0', 2, 10) + 0,	'Authorization',	CONV('1', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'Test Subgroup',	'Test Subgroup',	'Test Subgroup',	'03/22/2021',	'application',	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'Group Code',	'',	'',	CONV('1', 2, 10) + 0,	'',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'261361',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	'100 3rd St, Los Angeles, CA, 90032',	CONV('0', 2, 10) + 0);

-- 2021-03-23 05:21:35
