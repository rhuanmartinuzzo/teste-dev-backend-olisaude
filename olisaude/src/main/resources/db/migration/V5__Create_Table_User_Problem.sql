CREATE TABLE IF NOT EXISTS `user_problem`(
    `id_user` bigint(20) NOT NULL,
    `id_problem` bigint(20) NOT NULL,
    PRIMARY KEY (`id_user`, `id_problem`),
    KEY `fk_user_problem_problem` (`id_problem`),
    CONSTRAINT `fk_user_problem` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_user_problem_problem` FOREIGN KEY (`id_problem`) REFERENCES `health_prob` (`id`)
) ENGINE=InnoDB;