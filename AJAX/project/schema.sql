CREATE TABLE XYZ_PROFILE (
    Email VARCHAR(100) PRIMARY KEY,
    Password VARCHAR(50) NOT NULL,
    Name VARCHAR(100) NOT NULL,
    DateOfBirth DATE,
    Gender VARCHAR(10),
    Occupation VARCHAR(50),
    City VARCHAR(50),
    Mobile VARCHAR(15)
);

CREATE TABLE XYZ_BOOK (
    BookId INT PRIMARY KEY AUTO_INCREMENT,
    BookName VARCHAR(100) NOT NULL,
    Category VARCHAR(50),
    Author VARCHAR(100),
    Description TEXT,
    Price DECIMAL(10,2)
);