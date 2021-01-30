CREATE TABLE IF NOT EXISTS materii
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    nume        VARCHAR(60) NOT NULL,
    id_profesor BIGINT DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE (nume),
    KEY materie_to_prof_idx (id_profesor),
    CONSTRAINT materie_to_prof FOREIGN KEY (id_profesor) REFERENCES profesori (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO 'materii'
VALUES (1, 'Mate1', 3),
       (2, 'Mate2', NULL),
       (3, 'Philosofie', 1),
       (4, 'Programare', 4),
       (5, 'Fizica', 2);