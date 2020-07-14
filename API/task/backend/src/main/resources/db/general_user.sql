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

-- TEST DATA --
INSERT INTO `general_user` (`id`, `user_id`, `password`, `name`) VALUES
	(1, 'test', 'qwe123', '일반유저 1'),
	(2, 'user_id 2', 'password 2', '일반유저 2'),
	(3, 'user_id 3', 'password 3', '일반유저 3'),
	(4, 'user_id 4', 'password 4', '일반유저 4'),
	(5, 'user_id 5', 'password 5', '일반유저 5'),
	(6, 'user_id 6', 'password 6', '일반유저 6'),
	(7, 'user_id 7', 'password 7', '일반유저 7');