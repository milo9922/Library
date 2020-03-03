CREATE TABLE IF NOT EXISTS TB_USER
(
    UserID   int UNIQUE  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Login    varchar(18) NOT NULL UNIQUE,
    Password varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS TB_BOOK
(
    BookID   int UNIQUE  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Title    varchar(30) NOT NULL,
    Author   varchar(30) NOT NULL,
    PagesNum int
);