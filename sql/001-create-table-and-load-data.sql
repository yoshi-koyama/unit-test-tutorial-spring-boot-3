DROP TABLE IF EXISTS anime;

CREATE TABLE anime (
                        id int unsigned AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        genre VARCHAR(100) NOT NULL,
                        PRIMARY KEY(id)
);

INSERT INTO anime (name, genre) VALUES ("鬼滅の刃", "ダークファンタジー");
INSERT INTO anime (name, genre) VALUES ("SPY×FAMILY", "ホームコメディ");
