DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS trials;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS trialdiseases;
DROP TABLE IF EXISTS userdiseases;


CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    Name varchar(255) NOT NULL ,
    Email varchar(255),
    cpr INTEGER,
    hash varchar(255),
    password varchar(255)
);

CREATE TABLE companies(
    id SERIAL PRIMARY KEY,
    Email varchar(255) NOT NULL,
    CompanyName VARCHAR(255) NOT NULL
);

CREATE TABLE trials(
    id SERIAL PRIMARY KEY,
    company int NOT NULL,
    TrialName varchar(255) NOT NULL ,
    Location varchar(255),
    Description Varchar(255),
    FOREIGN KEY (company) REFERENCES companies
);

INSERT INTO users(Name)
VALUES ('Rune');
INSERT INTO users(Name)
VALUES ('Lars');
INSERT INTO users(Name)
VALUES ('Jannik');
INSERT INTO users(Name)
VALUES ('Mogens' );
INSERT INTO users(Name)
VALUES ('Pernille');
INSERT INTO users(Name)
VALUES ('Lotte' );
INSERT INTO users(Name)
VALUES ('Caroline');
INSERT INTO users(Name)
VALUES ('Kenneth');
INSERT INTO users(Name)
VALUES ('Hanne');
INSERT INTO users(Name)
VALUES ('Venø');
INSERT INTO users(Name)
VALUES ('Christian');
INSERT INTO users(Name)
VALUES ('Hans');
INSERT INTO users(Name)
VALUES ('Bente');
INSERT INTO users(Name)
VALUES ('Funcker');
INSERT INTO users(Name)
VALUES ('Løbet');
INSERT INTO users(Name)
VALUES ('Tør');
INSERT INTO users(Name)
VALUES ('For');
INSERT INTO users(Name)
VALUES ('Navne');
INSERT INTO users(Name)
VALUES ('Otto');
INSERT INTO users(Name)
VALUES ('Niels');
INSERT INTO users(Name)
VALUES ('HundeHoved' );
INSERT INTO users(Name)
VALUES ('EasterEgg');
INSERT INTO users(Name)
VALUES ('HanneTo');
INSERT INTO users(Name, email,password)
VALUES ('Rune', 'rune@hotmail.dk', 'hej');

INSERT INTO companies(Email, CompanyName) VALUES ('vamp@ink.com', 'BSucker');
INSERT INTO companies(Email, CompanyName) VALUES ('Gimme@your.kidney', 'Organ Harvest');
INSERT INTO companies(Email, CompanyName) VALUES ('NickFury@hotmail.com', 'Project Super Soldier');
INSERT INTO companies(Email, CompanyName) VALUES ('CaptainAmerica@hotmail.com', 'Reverse Super Soldier');
INSERT INTO companies(Email, CompanyName) VALUES ('Needle@gmail.com', 'Needle');