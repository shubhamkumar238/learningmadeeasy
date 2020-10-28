DROP SCHEMA IF EXISTS `learning_made_easy`;

CREATE SCHEMA `learning_made_easy`;

USE `learning_made_easy`;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `teacher_details`;
CREATE TABLE `teacher_details` (
  `teacher_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `about` varchar(400) NOT NULL,
  `achievements` varchar(400) NOT NULL,
  `myobjectives` varchar(400) NOT NULL,
  `expert_category` varchar(45) NOT NULL,
  `extra_category` varchar(150) NOT NULL,
  PRIMARY KEY (`teacher_details_id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `teacher_details_id` int(11) DEFAULT NULL,
  `course_rating` int(11) DEFAULT NULL,
  `course_review` varchar(150) DEFAULT NULL,
  `reviewer_first_name` varchar (45) DEFAULT NULL,
  `reviewer_last_name` varchar (45) DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  
  CONSTRAINT `FK_TEACHER_DETAILS` 
  FOREIGN KEY (`teacher_details_id`) 
  REFERENCES `teacher_details` (`teacher_details_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course_category`;
CREATE TABLE `course_category` (
  `course_category_name` varchar(45) NOT NULL,
  `course_url` varchar(45) NOT NULL,
  PRIMARY KEY (`course_category_name`)
 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `course_category` varchar(45) DEFAULT NULL,
  `course_summary` varchar(150) DEFAULT NULL,
  `requirements` varchar(45) DEFAULT NULL,
  `course_rating` int(11) DEFAULT NULL,
  `course_review` varchar(150) DEFAULT NULL,
  `reviewer_first_name` varchar (45) DEFAULT NULL,
  `reviewer_last_name` varchar (45) DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  
  PRIMARY KEY (`course_id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`course_name`),
  
  KEY `FK_TEACHER_idx` (`teacher_id`),
  
  CONSTRAINT `FK_TEACHER` 
  FOREIGN KEY (`teacher_id`) 
  REFERENCES `teacher` (`teacher_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `course_id` int(11) NOT NULL ,
  `student_id` int(11) NOT NULL ,
  
   PRIMARY KEY (`course_id`,`student_id`),
   
   CONSTRAINT `FK_COURSE1` FOREIGN KEY (`course_id`) 
   REFERENCES `course` (`course_id`) 
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  
   CONSTRAINT `FK_STUDENT1` FOREIGN KEY (`student_id`) 
   REFERENCES `student` (`student_id`) 
   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;




DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_url` varchar(100) NOT NULL,
  `video_name` varchar(45) DEFAULT NULL,
  `video_description` varchar(45) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  
   PRIMARY KEY (`video_url`),
   
   CONSTRAINT `FK_COURSE2` FOREIGN KEY (`course_id`) 
   REFERENCES `course` (`course_id`) 
   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `timestamp`;
CREATE TABLE `timestamp` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `video_url` varchar(45) NOT NULL,
  `resume_time` int(11) NOT NULL,
   PRIMARY KEY (`video_url`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `problem` varchar(200) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  
  CONSTRAINT `FK_COURSE4` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`course_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `response` varchar(400) NOT NULL,
  PRIMARY KEY (`answer_id`),
  
  CONSTRAINT `FK_QUESTION` FOREIGN KEY (`question_id`) 
  REFERENCES `question` (`question_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



