DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS trials;
DROP TABLE IF EXISTS companies;

CREATE TABLE users(
    id int NOT NULL ,
    Name varchar(255) NOT NULL ,
    Email varchar(255),
    cpr Integer,
    PRIMARY KEY (id)
);

CREATE TABLE companies(
    id int NOT NULL ,
    Email varchar(255) NOT NULL,
    CName VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE trials(
    id int NOT NULL ,
    CompanyID integer NOT NULL,
    TrialName varchar(255) NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (CompanyID) REFERENCES companies
);

INSERT INTO users(id, Name)
VALUES (3001,'Rune');
INSERT INTO users(id, Name)
VALUES ( 3023,'Lars');
INSERT INTO users(id, Name)
VALUES (3002,'Jannik');
INSERT INTO users(id, Name)
VALUES (3012, 'Mogens' );
INSERT INTO users(id, Name)
VALUES (3015, 'Pernille');
INSERT INTO users(id, Name)
VALUES (3018, 'Lotte' );
INSERT INTO users(id, Name)
VALUES (3019, 'Caroline');
INSERT INTO users(id, Name)
VALUES (3020, 'Kenneth');
INSERT INTO users(id, Name)
VALUES (3050, 'Hanne');
INSERT INTO users(id, Name)
VALUES (3051, 'Venø');
INSERT INTO users(id, Name)
VALUES (3052, 'Christian');
INSERT INTO users(id, Name)
VALUES (3053, 'Hans');
INSERT INTO users(id, Name)
VALUES (3054, 'Bente');
INSERT INTO users(id, Name)
VALUES (3055, 'Funcker');
INSERT INTO users(id, Name)
VALUES (3056, 'Løbet');
INSERT INTO users(id, Name)
VALUES (3057, 'Tør');
INSERT INTO users(id, Name)
VALUES (3058, 'For');
INSERT INTO users(id, Name)
VALUES (3059, 'Navne');
INSERT INTO users(id, Name)
VALUES (3060, 'Otto');
INSERT INTO users(id, Name)
VALUES (3061, 'Niels');
INSERT INTO users(id, Name)
VALUES (3062, 'HundeHoved' );
INSERT INTO users(id, Name)
VALUES (3067, 'EasterEgg');
INSERT INTO users(id, Name)
VALUES (3068, 'HanneTo');

INSERT INTO companies(id, Email, CName) VALUES (1100, 'vamp@ink.com', 'BSucker');
INSERT INTO companies(id, Email, CName) VALUES (1200, 'Gimme@your.kidney', 'Organ Harvest');
INSERT INTO companies(id, Email, CName) VALUES (1300, 'NickFury@hotmail.com', 'Project Super Soldier');
INSERT INTO companies(id, Email, CName) VALUES (1400, 'CaptainAmerica@hotmail.com', 'Reverse Super Soldier');
INSERT INTO companies(id, Email, CName) VALUES (1500, 'Needle@gmail.com', 'Needle');

INSERT INTO trials(id, CompanyID, TrialName) VALUES (2000, 1100, 'GoodSuckin');
INSERT INTO trials(id, CompanyID, TrialName) VALUES (2100, 1200, 'You Only Need One');
INSERT INTO trials(id, CompanyID, TrialName) VALUES (2200, 1300, 'Need new Captain');
INSERT INTO trials(id, CompanyID, TrialName) VALUES (2300, 1400, 'Nick sucks');