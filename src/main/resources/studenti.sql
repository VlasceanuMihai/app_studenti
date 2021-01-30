CREATE TABLE IF NOT EXISTS studenti
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    nume          VARCHAR(60)  NOT NULL,
    prenume       VARCHAR(60)  NOT NULL,
    date_of_birth DATE         NOT NULL,
    cnp           VARCHAR(60)  NOT NULL,
    email         VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (cnp)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO 'studenti'
VALUES (1, 'Georgel', 'Georgica', '21-03-1996', '1234', 'student1@gmail.com'),
       (2, 'Mirel', 'Mirelian', '10-10-1996', '12345', 'student2@gmail.com'),
       (3, 'Codrut', 'Popescu', '04-09-1996', '123456', 'student3@gmail.com'),
       (4, 'Marcel', 'Pavel', '01-07-1996', '1234567', 'student4@gmail.com'),
       (5, 'Virgil', 'Iantu', '17-02-1996', '12345678', 'student5@gmail.com'),
       (6, 'Ionel', 'Popescu', '22-01-1996', '123456789', 'student6@gmail.com');
