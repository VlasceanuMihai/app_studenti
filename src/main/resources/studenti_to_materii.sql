CREATE TABLE IF NOT EXISTS 'studenti_to_materii'
(
    'id'         BIGINT NOT NULL AUTO_INCREMENT,
    'id_student' BIGINT NOT NULL,
    'id_materie' BIGINT NOT NULL,
    PRIMARY KEY ('id'),
    KEY 'fk_student_idx' ('id_student'),
    KEY 'fk_materie_idx' ('id_materie'),
    CONSTRAINT 'fk_student' FOREIGN KEY ('id_student') REFERENCES 'studenti' ('id'),
    CONSTRAINT 'fk_materie' FOREIGN KEY ('id_materie') REFERENCES 'materii' ('id')
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO 'studenti_to_materii'
VALUES (1, 2, 1),
       (2, 6, 1),
       (3, 6, 5);
