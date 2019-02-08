CREATE TABLE Person(
	SSN    CHAR(15) NOT NULL,
    Password    CHAR(20),
    FirstName    VARCHAR(50),
    LastName    VARCHAR(50),
    Street    VARCHAR(50),
    City    VARCHAR(50),
    State    VARCHAR(50),
    Zipcode    INT,
    Email    VARCHAR(100),
    Telephone    VARCHAR(15),
	PRIMARY KEY (SSN)); 

CREATE TABLE Employee(
	SSN CHAR(15),
    role VARCHAR(50),
    startDate DATE,
    hourlyRate INTEGER,
    PRIMARY KEY (SSN),
    FOREIGN KEY (SSN) REFERENCES Person(SSN) ON DELETE CASCADE
);

CREATE TABLE User(
	SSN CHAR(15),
    PPP VARCHAR(15),
    Rating INT,
    DateOfLastAct DATETIME,
    PRIMARY KEY (SSN),
    FOREIGN KEY(SSN) REFERENCES Person (SSN) ON DELETE CASCADE
);

CREATE TABLE Profile(
	ProfileID CHAR(25),
    OwnerSSN CHAR(15),
    Age INT,
    DatingAgeRangeStart INT,
    DatingAgeRangeEnd INT,
    DatingGeoRange INT,
    Gender VARCHAR(15),
    Hobbies VARCHAR(1000),
    Height Double,
    Weight Double,
    HairColor VARCHAR(20),
    CreationDate DATETIME NOT NULL,
    LastModDate DATETIME NOT NULL,
    PRIMARY KEY (ProfileID),
    FOREIGN KEY (OwnerSSN) REFERENCES User(SSN) ON DELETE CASCADE
);

CREATE TABLE Date(
	Profile1 CHAR(25),
    Profile2 CHAR(25),
    CustRep CHAR(15),
    Date_Time DATETIME,
    Location VARCHAR(255),
    BookingFee double,
    Comments TEXT,
    User1Rating INT,
    User2Rating INT,
    PRIMARY KEY (Profile1, Profile2, Date_Time),
    FOREIGN KEY (Profile1) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY (Profile2) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY (CustRep) REFERENCES Employee(SSN) ON DELETE SET NULL
    
);

CREATE TABLE Likes(
	Liker CHAR(25),
    Likee CHAR(25),
    Date_Time DATETIME,
    PRIMARY KEY (Liker, Likee, Date_Time),
    FOREIGN KEY (Liker) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY (Likee) REFERENCES Profile(ProfileID) ON DELETE CASCADE
);

CREATE TABLE Referral(
	ProfileA CHAR(25),
    ProfileB CHAR(25),
    ProfileC CHAR(25),
    Date_Time DATETIME,
    PRIMARY KEY (ProfileA, ProfileB, ProfileC, Date_Time),
    FOREIGN KEY(ProfileA) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY(ProfileB) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY(ProfileC) REFERENCES Profile(ProfileID) ON DELETE CASCADE
);


CREATE TABLE SuggestedBy(
	CustRep CHAR(15),
    Profile1 CHAR(25),
    Profile2 CHAR(25),
    Date_Time DATETIME,
    PRIMARY KEY (CustRep, Profile1, Profile2, Date_Time),
    FOREIGN KEY (Profile1) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
    FOREIGN KEY (Profile2) REFERENCES Profile(ProfileID) ON DELETE CASCADE,
	FOREIGN KEY (CustRep) REFERENCES Employee(SSN) ON DELETE CASCADE
);


CREATE TABLE Account(
	OwnerSSN CHAR(15),
    CardNumber INT(16),
    AcctNum CHAR(30),
    AcctCreationDate DATETIME,
    PRIMARY KEY(OwnerSSN, CardNumber, AcctNum),
	FOREIGN KEY (OwnerSSN) REFERENCES USER(SSN) ON DELETE CASCADE
);

