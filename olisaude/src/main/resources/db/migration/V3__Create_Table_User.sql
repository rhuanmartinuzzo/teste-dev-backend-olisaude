CREATE TABLE IF NOT EXISTS `users`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(255) NOT NULL,
    `password` varchar(255) DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `birth_day` timestamp NOT NULL,
    `gender` varchar(6) NOT NULL,
    `created_at` timestamp NOT NULL,
    `updated_at` timestamp DEFAULT NULL,
    `account_non_expired` bit(1) DEFAULT NULL,
    `account_non_locked` bit(1) DEFAULT NULL,
    `credentials_non_expired` bit(1) DEFAULT NULL,
    `enabled` bit(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY  `uk_user_name` (`user_name`)
) ENGINE=InnoDB;