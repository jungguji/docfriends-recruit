CREATE TABLE `doctor` (
    `id` INT(11) NOT NULL AUTO_INCREMENT
    , `user_id` VARCHAR(50) NOT NULL
    , `password` VARCHAR(500) NOT NULL
	, `name` VARCHAR(20) NOT NULL
	, `hospital_id` INT(11) NULL
    , PRIMARY KEY (`id`)
	, INDEX `fk_doctor_hospital` (`hospital_id`)
    , CONSTRAINT `fk_doctor_hospital` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=UTF8_DANISH_CI
;

-- TEST DATA --
INSERT INTO `doctor` (`id`, `user_id`, `password`, `name`, `hospital_id`) VALUES
	(1, 'user_id 1', 'password 1', '의사 1', 1),
	(2, 'user_id 2', 'password 2', '의사 2', 1),
	(3, 'user_id 3', 'password 3', '의사 3', 1),
	(4, 'user_id 4', 'password 4', '의사 4', 2),
	(5, 'user_id 5', 'password 5', '의사 5', 3);