CREATE TABLE IF NOT EXISTS TB_USER
(
    UserID   INT UNIQUE  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Login    VARCHAR(18) NOT NULL UNIQUE,
    Password VARCHAR(64) NOT NULL,
    Email    VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS TB_BOOK
(
    BookID          INT UNIQUE  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Title           VARCHAR(30) NOT NULL,
    Author          VARCHAR(30) NOT NULL,
    PagesNum        INT,
    AddedBy         INT,
    AddDate         DATE,
    BorrowedBy      INT,
    BorrowDate      DATE,
    ReturnDate      DATE,
    NumberOfBorrows INT
);