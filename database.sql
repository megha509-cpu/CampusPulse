CREATE DATABASE IF NOT EXISTS campuspulse;

USE campuspulse;

CREATE TABLE IF NOT EXISTS issues (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    location VARCHAR(150) NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending',
    priority VARCHAR(50) DEFAULT 'Medium'
);

CREATE TABLE IF NOT EXISTS `library` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(200) NOT NULL,
    author VARCHAR(150) NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    issue_date DATE,
    return_date DATE,
    status VARCHAR(50) DEFAULT 'Issued'
);

CREATE TABLE IF NOT EXISTS mess (
    id INT PRIMARY KEY AUTO_INCREMENT,
    meal_type VARCHAR(50) NOT NULL,
    meal_date DATE NOT NULL,
    menu VARCHAR(500) NOT NULL,
    rating DECIMAL(3,1),
    feedback VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS facilities (
    id INT PRIMARY KEY AUTO_INCREMENT,
    facility_name VARCHAR(150) NOT NULL,
    location VARCHAR(150) NOT NULL,
    status VARCHAR(50) DEFAULT 'Available',
    maintenance_date DATE,
    description VARCHAR(500)
);
