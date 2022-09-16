CREATE TABLE IF NOT EXISTS `users`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(200) NOT NULL,
    `birth_day` DATE NOT NULL,
    `gender` varchar(6) NOT NULL,
    `created_at` date NOT NULL,
    `updated_at` date DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;