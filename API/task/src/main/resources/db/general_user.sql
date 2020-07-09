--drop table `general_user`
CREATE TABLE `general_user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT
    , `user_id` VARCHAR(50) NOT NULL
    , `password` VARCHAR(500) NOT NULL
	, `name` VARCHAR(20) NOT NULL
    , PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=UTF8_DANISH_CI
;