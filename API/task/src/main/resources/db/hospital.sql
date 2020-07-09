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