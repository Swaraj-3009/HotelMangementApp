CREATE DATABASE hotel;

USE hotel;

CREATE TABLE manager(
    sno INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE users(
    name VARCHAR(100),
    password VARCHAR(100),
    address VARCHAR(225),
    adhaar VARCHAR(16) PRIMARY KEY,
    roomAlloted INT,
    partyHallAlloted INT,
    meetingHallAlloted INT,
    bill FLOAT,
    swimmingPass BOOLEAN,
    playzonePass BOOLEAN,
    gymPass BOOLEAN
);

CREATE TABLE employee(
    name VARCHAR(100),
    password VARCHAR(100),
    address VARCHAR(225),
    adhaar VARCHAR(16) PRIMARY KEY,
    designation VARCHAR(100),
    salary FLOAT
);

CREATE TABLE hotelData(
    totalBookedRoom INT,
    totalBookedPartyHall INT,
    totalBookedMeetingHall INT
);