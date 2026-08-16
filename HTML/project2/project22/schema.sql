CREATE DATABASE IF NOT EXISTS talentnext_db;
USE talentnext_db;

CREATE TABLE IF NOT EXISTS users (
    userid VARCHAR(20) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    dob DATE,
    gender VARCHAR(10),
    state VARCHAR(50),
    contact VARCHAR(15),
    address TEXT
);