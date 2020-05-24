CREATE TABLE IF NOT EXISTS TB_USER
(
    UserID   INT UNIQUE  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Login    VARCHAR(18) NOT NULL UNIQUE,
    Password VARCHAR(64) NOT NULL,
    Email    VARCHAR(64) NOT NULL UNIQUE,
    IsAdmin  BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS TB_BOOK
(
    BookID          INT UNIQUE   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Title           VARCHAR(100) NOT NULL,
    Author          VARCHAR(50)  NOT NULL,
    PagesNum        INT,
    AddedBy         INT,
    AddDate         DATE,
    BorrowedBy      INT,
    BorrowDate      DATE,
    BorrowQrCode    BLOB,
    ReturnDate      DATE,
    NumberOfBorrows INT
);