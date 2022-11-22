DROP TABLE IF EXISTS TrialDiseases;
DROP TABLE IF EXISTS UserDiseases;
DROP TABLE IF EXISTS Subscribe;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Trials;
DROP TABLE IF EXISTS Companies;
DROP TABLE IF EXISTS Diseases;

CREATE TABLE Users(
    id SERIAL PRIMARY KEY,
    Name varchar(255) NOT NULL ,
    Email varchar(255) NOT NULL ,
    password varchar(255),
    Salt varchar(255),
    Privilege varchar(255) NOT NULL
);

CREATE TABLE Companies(
    id SERIAL PRIMARY KEY,
    Email varchar(255) NOT NULL,
    Name VARCHAR(255) NOT NULL
);

CREATE TABLE Trials(
    id SERIAL PRIMARY KEY,
    company int NOT NULL,
    TrialName varchar(255) NOT NULL ,
    Location varchar(255),
    Description Varchar(255),
    FOREIGN KEY (company) REFERENCES Companies
);

CREATE TABLE Diseases(
    id SERIAL PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE TrialDiseases(
  diseaseid int not null ,
  trialid int not null ,
  FOREIGN KEY (diseaseid) REFERENCES Diseases,
  FOREIGN KEY (trialid) REFERENCES Trials
);

CREATE TABLE UserDiseases(
  diseaseid int not null ,
  userid int not null ,
  FOREIGN KEY (diseaseid) REFERENCES Diseases,
  FOREIGN KEY (userid) REFERENCES Users
);

CREATE TABLE Subscribe(
    trialid int not null ,
    userid int not null ,
    FOREIGN KEY (trialid) REFERENCES Trials,
    FOREIGN KEY (userid) REFERENCES Users
);

INSERT INTO users(Name, email,password)
VALUES ('Rune', 'rune@hotmail.dk', 'hej');
INSERT INTO users(Name, email,password)
VALUES ('Hanne', 'hanne@hotmail.dk', 'nej');

INSERT INTO Companies(Email, Name) VALUES ('vamp@ink.com', 'BSucker');
INSERT INTO Companies(Email, Name) VALUES ('Gimme@your.kidney', 'Organ Harvest');
INSERT INTO Companies(Email, Name) VALUES ('NickFury@hotmail.com', 'Project Super Soldier');
INSERT INTO Companies(Email, Name) VALUES ('CaptainAmerica@hotmail.com', 'Reverse Super Soldier');
INSERT INTO Companies(Email, Name) VALUES ('Needle@gmail.com', 'Needle');