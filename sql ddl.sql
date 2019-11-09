CREATE TABLE `announcement` (
  `announcement_id` int(11) NOT NULL,
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
  CONSTRAINT `category_id` FOREIGN KEY (`anncmnt_category_id`) REFERENCES `announcementcategory` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `email` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `status_id` FOREIGN KEY (`status_id`) REFERENCES `announcementstatus` (`status_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `announcementcategory` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `announcementstatus` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `job` (
  `anncmnt_id` int(11) NOT NULL,
  `anncmnt_organization` varchar(45) DEFAULT NULL,
  `candidate_responsibility` varchar(2048) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `benefits` varchar(3000) DEFAULT NULL,
  `requirements` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`anncmnt_id`),
  CONSTRAINT `jobId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `scholarship` (
  `anncmnt_id` int(11) NOT NULL,
  `min_grade` decimal(2,0) DEFAULT NULL,
  `scholarship_award` decimal(2,0) DEFAULT NULL,
  `requirements` varchar(5000) DEFAULT NULL,
  `program_allowed` varchar(2048) DEFAULT NULL,
  `university_allowed` varchar(2048) DEFAULT NULL,
  `year_allowed` int(11) DEFAULT NULL,
  `degree_allowed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`anncmnt_id`),
  CONSTRAINT `scholarshipId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `age` smallint(99) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `userjobattributes` (
  `skills` varchar(1024) NOT NULL,
  `experience` int(11) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  KEY `email_idx` (`user_email`),
  CONSTRAINT `jobUserEmail` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `userschoralshipattributes` (
  `user_email` varchar(45) NOT NULL,
  `grade` decimal(2,0) DEFAULT NULL,
  `degree` varchar(45) DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `program` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_email`),
  CONSTRAINT `userEmail` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `version` (
  `version` decimal(1,0) NOT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `voluntariness` (
  `anncmnt_id` int(11) NOT NULL,
  `anncmnt_organization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`anncmnt_id`),
  CONSTRAINT `vountarinessId` FOREIGN KEY (`anncmnt_id`) REFERENCES `announcement` (`announcement_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
