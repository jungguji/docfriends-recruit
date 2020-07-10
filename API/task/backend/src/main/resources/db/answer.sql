--drop table `answer`
CREATE TABLE `answer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT
	, `question_id` INT(11) NOT NULL
    , `content` TEXT NOT NULL
	, `tag` VARCHAR(500) NULL
	, `create_date` DATE NOT NULL
	, `doctor_id` INT(11) NOT NULL
    , PRIMARY KEY (`id`)
	, INDEX `fk_answer_question` (`question_id`)
    , CONSTRAINT `fk_answer_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
	, INDEX `fk_answer_doctor` (`doctor_id`)
    , CONSTRAINT `fk_answer_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=UTF8_DANISH_CI
;