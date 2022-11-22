DROP TABLE IF EXISTS dbuser;
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
    Privilege int NOT NULL
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
    Description Varchar,
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

INSERT INTO users(Name, email,password, Privilege)
VALUES ('Rune', 'rune@hotmail.dk', 'hej', 1);
INSERT INTO users(Name, email,password, Privilege)
VALUES ('Hanne', 'hanne@hotmail.dk', 'nej', 1);
INSERT INTO users(Name, Email, password, Privilege)
VALUES ('test', 'test@test.test', 'test', 1);
INSERT INTO users(Name, Email, password, Privilege)
VALUES ('admin', 'admin@test.test', 'admin', 2);


INSERT INTO Companies(Email, Name) VALUES ('vamp@ink.com', 'BSucker');
INSERT INTO Companies(Email, Name) VALUES ('Gimme@your.kidney', 'Organ Harvest');
INSERT INTO Companies(Email, Name) VALUES ('NickFury@hotmail.com', 'Project Super Soldier');
INSERT INTO Companies(Email, Name) VALUES ('CaptainAmerica@hotmail.com', 'Reverse Super Soldier');
INSERT INTO Companies(Email, Name) VALUES ('Needle@gmail.com', 'Needle');

INSERT INTO Diseases(name) VALUES ('Diabetes');
INSERT INTO Diseases(name) VALUES ('Cancer');
INSERT INTO Diseases(name) VALUES ('ALS');
INSERT INTO Diseases(name) VALUES ('Torn ACL');
INSERT INTO Diseases(name) VALUES ('Erectile dysfunction');

INSERT INTO Trials(company, TrialName, Location, Description) VALUES (1, 'New type of insulin', 'Denmark', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (1, 'The cure for diabetes', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (2, 'Cancer research', 'Næstved', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (2, 'Stem cell research', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (3, 'ALS research', 'Aarhus', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (3, 'Ice bucket challenge', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (4, 'Torn ACL study', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (4, 'You got a doodoo knee?', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (5, 'Got a sad willy?', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');
INSERT INTO Trials(company, TrialName, Location, Description) VALUES (5, 'Improve your endurance TODAY', 'Copenhagen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce egestas fringilla elit, eu porta justo semper vel. Aenean consectetur tincidunt dui at tempus. Suspendisse sed libero id mauris iaculis consequat. Fusce eu magna consequat, consequat ex nec, aliquam risus. Vestibulum tempor nulla eget risus hendrerit consectetur. Quisque gravida, ligula non condimentum ullamcorper, lectus lectus molestie est, ut molestie massa nisi quis ante. Phasellus eu rhoncus lacus. Aliquam aliquet nulla ex, a scelerisque metus convallis nec.');

