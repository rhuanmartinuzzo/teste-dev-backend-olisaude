CREATE TABLE IF NOT EXISTS `health_prob`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(200) NOT NULL,
    `tier` int(1) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB;