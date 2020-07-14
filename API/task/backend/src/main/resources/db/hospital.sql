--drop table `hospital`
CREATE TABLE `hospital` (
    `id` INT(11) NOT NULL AUTO_INCREMENT
    , `name` VARCHAR(100) NOT NULL
    , `address` VARCHAR(500) NOT NULL
	, `website_url` VARCHAR(500) NULL
    , PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=UTF8_DANISH_CI
;

-- TEST DATA --
INSERT INTO `hospital` (`id`, `name`, `address`, `website_url`) VALUES
	(1, '병원 1', '서울시 1', 'website_url 1'),
	(2, '병원 2', '부산 2', 'website_url 2'),
	(3, '병원 3', '제주 3', 'website_url 3');