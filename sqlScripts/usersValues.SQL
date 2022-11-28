DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS trials;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS disease;
DROP TABLE IF EXISTS userdiseases;
DROP TABLE IF EXISTS diseases;

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

CREATE TABLE diseases(
    diseaseid SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL
);

CREATE TABLE userdiseases(
   diseaseid int NOT NULL ,
   userid int NOT NULL ,
   FOREIGN KEY (diseaseid) references diseases,
   FOREIGN KEY (userid) references users,
   PRIMARY KEY (diseaseid, userid)
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

INSERT INTO diseases(name) VALUES ('diebetes');
INSERT INTO diseases(name) values ('Cancer');
INSERT INTO diseases(name) values ('Being a Javascript developer');
INSERT INTO diseases(name) values ('ALS');