/*
Created: 05.01.2021
Modified: 05.01.2021
Model: Oracle 19c
Database: Oracle 19c
*/


-- Create tables section -------------------------------------------------

-- Table Clients

CREATE TABLE Clients(
  Client_ID Integer NOT NULL,
  First_name Varchar2(30 ),
  Last_name Varchar2(40 ),
  Registration_date Timestamp(0) NOT NULL
)
/

-- Add keys for table Clients

ALTER TABLE Clients ADD CONSTRAINT PK_Clients PRIMARY KEY (Client_ID)
/

-- Table Courts

CREATE TABLE Courts(
  Court_ID Integer NOT NULL,
  Name Varchar2(30 ),
  Address Varchar2(40 ),
  Opening_hour Integer NOT NULL,
  Closing_hour Integer NOT NULL
)
/

-- Add keys for table Courts

ALTER TABLE Courts ADD CONSTRAINT PK_Courts PRIMARY KEY (Court_ID)
/

-- Table Bookings

CREATE TABLE Bookings(
  Booking_ID Integer NOT NULL,
  Hour Integer NOT NULL,
  Court_ID Integer NOT NULL,
  Client_ID Integer NOT NULL,
  Employee_ID Integer
)
/

-- Create indexes for table Bookings

CREATE INDEX IX_Relationship2 ON Bookings (Court_ID)
/

CREATE INDEX IX_Relationship5 ON Bookings (Client_ID)
/

CREATE INDEX IX_Relationship7 ON Bookings (Employee_ID)
/

-- Add keys for table Bookings

ALTER TABLE Bookings ADD CONSTRAINT PK_Bookings PRIMARY KEY (Booking_ID)
/

-- Table Employees

CREATE TABLE Employees(
  Employee_ID Integer NOT NULL,
  First_name Varchar2(30 ),
  Last_name Varchar2(40 ),
  Registration_date Timestamp(0) NOT NULL,
  Salary Float
)
/

-- Add keys for table Employees

ALTER TABLE Employees ADD CONSTRAINT PK_Employees PRIMARY KEY (Employee_ID)
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Bookings ADD CONSTRAINT Has_court FOREIGN KEY (Court_ID) REFERENCES Courts (Court_ID)
/



ALTER TABLE Bookings ADD CONSTRAINT Has_client FOREIGN KEY (Client_ID) REFERENCES Clients (Client_ID)
/



ALTER TABLE Bookings ADD CONSTRAINT Has_employee FOREIGN KEY (Employee_ID) REFERENCES Employees (Employee_ID)
/





