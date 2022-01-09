DROP DATABASE cloud;

CREATE DATABASE cloud;

USE cloud;

CREATE TABLE Utilisateur(
    IdUtilisateur INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    DateNaissance DATE,
    Email VARCHAR(100),
    MotDePasse VARCHAR(100),
    Sexe VARCHAR(1),
    Contact VARcHAR(10)
);

CREATE TABLE TypeSignalement(
    IdType INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NomType VARCHAR(50),
    Couleur VARCHAR(50)
);

CREATE TABLE StatusSignalement(
    IdStatus INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NomStatus VARCHAR(50)
);

CREATE TABLE Signalement(
    IdSignalement INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    IdUtilisateur INTEGER,
    IdType INTEGER,
    IdStatus INTEGER,
    DescriptionSignalement TEXT,
    Longitude REAL,
    Latitude REAL,
    DateHeureSignalement DATETIME,
    FOREIGN KEY(IdUtilisateur) REFERENCES Utilisateur(IdUtilisateur),
    FOREIGN KEY(IdType) REFERENCES TypeSignalement(IdType),
    FOREIGN KEY(IdStatus) REFERENCES StatusSignalement(IdStatus)
);

CREATE TABLE Photos(
    IdSignalement INTEGER,
    Photos VARCHAR(100),
    FOREIGN KEY(IdSignalement) REFERENCES Signalement(IdSignalement)
);

CREATE TABLE NotificationSignalement(
    IdNotification INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    IdUtilisateur INTEGER,
    DescriptionNotification TEXT,
    DateHeureNotification DATETIME,
    FOREIGN KEY(IdUtilisateur) REFERENCES Utilisateur(IdUtilisateur)
);

CREATE TABLE Region(
    IdRegion INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NomRegion VARCHAR(50)
);

CREATE TABLE ResponsableRegion(
    IdResponsable INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    IdRegion INTEGER,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(50),
    MotDePasse VARCHAR(100),
    FOREIGN KEY(IdRegion) REFERENCES Region(IdRegion)
);
