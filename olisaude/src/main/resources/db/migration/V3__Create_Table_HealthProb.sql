CREATE TABLE IF NOT EXISTS `health_prob`(
                                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                            `name` varchar(200) NOT NULL,
                                            `tier` int(1) NOT NULL,
                                            `user_id` bigint(20) NOT NULL,
                                            PRIMARY KEY (`id`),
                                            KEY `fk_user_health` (`user_id`),
                                            CONSTRAINT `fk_user_health` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB;