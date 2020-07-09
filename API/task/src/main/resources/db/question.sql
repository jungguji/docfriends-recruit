--drop table `question`
CREATE TABLE `question` (
    `id` INT(11) NOT NULL AUTO_INCREMENT
    , `title` VARCHAR(100) NOT NULL
    , `content` TEXT NOT NULL
	, `tag` VARCHAR(500) NULL
	, `create_date` DATE NOT NULL
	, `user_id` INT(11) NOT NULL
    , PRIMARY KEY (`id`)
	, INDEX `fk_question_general_user` (`user_id`)
    , CONSTRAINT `fk_question_general_user` FOREIGN KEY (`user_id`) REFERENCES `general_user` (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=UTF8_DANISH_CI
;