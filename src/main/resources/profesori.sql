CREATE TABLE IF NOT EXISTS profesori
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    nume VARCHAR(50) NOT NULL,
    cnp  VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (cnp)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO profesori
VALUES (1, 'Fometescu', '1960142443512'),
       (2, 'Pavel', '1234567890123'),
       (3, 'Pop', '0987654321098'),
       (4, 'Georgescu', '0987654321123');