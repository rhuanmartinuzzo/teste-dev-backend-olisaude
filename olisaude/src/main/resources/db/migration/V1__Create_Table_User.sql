CREATE TABLE IF NOT EXISTS `users`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `birth_day` timestamp NOT NULL,
    `gender` varchar(6) NOT NULL,
    `created_at` timestamp NOT NULL,
    `updated_at` timestamp DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;