CREATE DATABASE `announcementplatform` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `role` (
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `age` smallint(99) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `role_idx` (`role`),
  CONSTRAINT `roleFk` FOREIGN KEY (`role`) REFERENCES `role` (`description`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `announcementcategory` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `announcementstatus` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `announcement` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT,
  `anncmnt_name` varchar(45) NOT NULL,
  `status_id` int(11) NOT NULL,
  `anncmnt_category_id` int(11) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `url` varchar(45) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`announcement_id`),
  KEY `categoryId_idx` (`anncmnt_category_id`),
  KEY `statusId_idx` (`status_id`),
  KEY `email_idx` (`user_email`),
  CONSTRAINT `category_id` FOREIGN KEY (`anncmnt_category_id`) REFERENCES `announcementcategory` (`category_id`),
  CONSTRAINT `email` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `status_id` FOREIGN KEY (`status_id`) REFERENCES `announcementstatus` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

CREATE TABLE `job` (
  `anncmnt_id` int(11) NOT NULL,
  `anncmnt_organization` varchar(45) DEFAULT NULL,
  `candidate_responsibility` varchar(2048) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `benefits` varchar(3000) DEFAULT NULL,
  `requirements` varchar(5000) DEFAULT NULL,
  KEY `jobId_idx` (`anncmnt_id`),
  CONSTRAINT `jobId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `scholarship` (
  `anncmnt_id` int(11) NOT NULL,
  `min_grade` decimal(3,2) DEFAULT NULL,
  `scholarship_award` decimal(8,2) DEFAULT NULL,
  `requirements` varchar(5000) DEFAULT NULL,
  `program_allowed` varchar(2048) DEFAULT NULL,
  `university_allowed` varchar(2048) DEFAULT NULL,
  `year_allowed` int(11) DEFAULT NULL,
  `degree_allowed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`anncmnt_id`),
  CONSTRAINT `scholarshipId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `voluntariness` (
  `anncmnt_id` int(11) NOT NULL,
  `anncmnt_organization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`anncmnt_id`),
  CONSTRAINT `voluntarinessId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `userjobattributes` (
  `skills` varchar(1024) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  `user_email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_email`),
  KEY `email_idx` (`user_email`),
  CONSTRAINT `jobUserEmail` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `userschoralshipattributes` (
  `user_email` varchar(45) NOT NULL,
  `grade` decimal(3,2) DEFAULT NULL,
  `degree` varchar(45) DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `program` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_email`),
  CONSTRAINT `userEmail` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `uservolunteerattributes` (
  `user_email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_email`),
  CONSTRAINT `fkEmail` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `announcementplatform`.`announcementcategory`
(`category_id`,`category_name`) VALUES
(1, 'Job');

INSERT INTO `announcementplatform`.`announcementcategory`
(`category_id`,`category_name`) VALUES
(2, 'Scholarship');

INSERT INTO `announcementplatform`.`announcementcategory`
(`category_id`,`category_name`) VALUES
(3, 'Voluntariness');

INSERT INTO `announcementplatform`.`announcementstatus`
(`status_id`,`status_name`) VALUES
(1,'Active');

INSERT INTO `announcementplatform`.`announcementstatus`
(`status_id`,`status_name`) VALUES
(2,'Inactive');

INSERT INTO `announcementplatform`.`degree`
(`iddegree`,`degree_description`) VALUES
(1,'Bachelor');

INSERT INTO `announcementplatform`.`degree`
(`iddegree`,`degree_description`) VALUES 
(2,'Master');

INSERT INTO `announcementplatform`.`degree`
(`iddegree`,`degree_description`) VALUES 
(3,'Doctor');

INSERT INTO `announcementplatform`.`role`
(`description`, `id`) VALUES
('ADMIN',1);

INSERT INTO `announcementplatform`.`role`
(`description`, `id`) VALUES
('USER',2);
