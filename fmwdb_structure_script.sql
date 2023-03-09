
-- -----------------------------------------------------
-- Schema fmwdb
-- -----------------------------------------------------
CREATE DATABASE fmwdb;
USE fmwdb ;

-- -----------------------------------------------------
-- Table adresse
-- -----------------------------------------------------
CREATE TABLE adresse (
  idadresse INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  pays VARCHAR(45) NOT NULL,
  ville VARCHAR(45) NOT NULL,
  rue VARCHAR(45) NOT NULL,
  numero VARCHAR(10), 
  complement VARCHAR(90)
 );



-- -----------------------------------------------------
-- Table representant
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS representant (
  idrepresentant INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tel INT NOT NULL,
  mail VARCHAR(80) NOT NULL,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  adresse INT NOT NULL,
  qualite VARCHAR(45) NOT NULL,
  
  FOREIGN KEY (adresse) REFERENCES adresse (idadresse)
  );
    



-- -----------------------------------------------------
-- Table dossier
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS dossier (
  iddossier INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tel INT NOT NULL,
  mail VARCHAR(80) NOT NULL,
  denomination_sociale VARCHAR(80) NOT NULL,
  forme_juridique VARCHAR(45) NOT NULL,
  regime_fiscal INT NOT NULL,
  regime_tva INT NOT NULL,
  capital FLOAT,
  representant INT NOT NULL,
  adresse INT NOT NULL,
  commentaire VARCHAR(200) NULL,
  
  FOREIGN KEY (adresse) REFERENCES adresse (idadresse),
  FOREIGN KEY (representant) REFERENCES representant (idrepresentant)
    );



-- -----------------------------------------------------
-- Table Journal
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Journal (
  idJournal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dossier INT NOT NULL,
  Type INT NOT NULL,
  libellé VARCHAR(45) NOT NULL,
  code VARCHAR(45) NOT NULL,
  commentaire VARCHAR(200) NULL,
  solde DOUBLE NOT NULL,

  FOREIGN KEY (dossier) REFERENCES dossier (iddossier)
);
   



-- -----------------------------------------------------
-- Table compte
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compte (
  idcompte INT PRIMARY KEY NOT NULL,
  numero_compte INT NOT NULL,
  libelle VARCHAR(45) NOT NULL,
  dossier INT NOT NULL,
  solde DOUBLE NOT NULL,

  FOREIGN KEY (dossier) REFERENCES dossier (iddossier)
);



-- -----------------------------------------------------
-- Table financement
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS financement (
  idfinancement INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  duree INT NOT NULL,
  montant DOUBLE NOT NULL,
  taux DOUBLE NOT NULL,
  mode_rbsmt INT NOT NULL,
  date_prem_echeance DATETIME NOT NULL,
  rbsmt_total DOUBLE NOT NULL,
  cout_assurance DOUBLE NOT NULL,
  montant_interet_prem_echeance DOUBLE NOT NULL,
  commentaire TEXT NULL,
  compte INT NOT NULL,
  etablissement VARCHAR(45) NOT NULL,
  intitule VARCHAR(45) NOT NULL,
  
  FOREIGN KEY (compte) REFERENCES compte (idcompte)
  );



-- -----------------------------------------------------
-- Table immobilisation
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS immobilisation (
  idimmobilisation INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  date_acquisition DATETIME NOT NULL,
  cout_acquisition DOUBLE NOT NULL,
  duree_amt_eco INT NOT NULL,
  mode_amt_eco INT NOT NULL,
  base_amt_eco DOUBLE NOT NULL,
  num_financement INT NULL,
  duree_amt_fisca INT NULL,
  mode_amt_fisca INT NULL,
  base_amt_fisca DOUBLE NULL,
  compte_immo INT NOT NULL,
  commentaires TEXT NULL,
  type INT NOT NULL,
  intitule VARCHAR(45) NOT NULL,
  
  FOREIGN KEY (compte_immo) REFERENCES compte (idcompte),
  FOREIGN KEY (num_financement) REFERENCES financement (idfinancement)
    );



-- -----------------------------------------------------
-- Table utilisateur
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS utilisateur (
  idutilisateur INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  mail VARCHAR(80) NOT NULL,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  code VARCHAR(45) NOT NULL,
  mdp VARCHAR(64) NOT NULL
  );



-- -----------------------------------------------------
-- Table compte_auxiliaire
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compte_auxiliaire (
  idcompte_auxiliaire INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  compte_rattachement INT NOT NULL,
  libelle VARCHAR(45) NOT NULL,
  type INT NOT NULL,
  identifiant VARCHAR(10) NOT NULL,
  solde DOUBLE NOT NULL,
  
  FOREIGN KEY (compte_rattachement) REFERENCES compte (idcompte)
    );



-- -----------------------------------------------------
-- Table ecriture_comptable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ecriture_comptable (
  idecriture_comptable INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  date_saisie DATETIME NOT NULL,
  date_validation DATETIME NULL,
  operateur INT NOT NULL,
  code_operation INT NOT NULL,
  debit DOUBLE NULL,
  credit DOUBLE NULL,
  num_compte INT NOT NULL,
  num_compt_aux INT NULL,
  num_facture VARCHAR(45) NULL,
  libelle VARCHAR(45) NULL,
  date_facture DATETIME NULL,
  journal INT NOT NULL,
  lettrage VARCHAR(45) NULL,
  date_lettrage DATETIME NULL,
  montant_devise DOUBLE NULL,
  type_devise INT NULL,
  
  FOREIGN KEY (operateur) REFERENCES utilisateur (idutilisateur),
  FOREIGN KEY (num_compte) REFERENCES compte (idcompte),
  FOREIGN KEY (num_compt_aux) REFERENCES compte_auxiliaire (idcompte_auxiliaire),
  FOREIGN KEY (journal) REFERENCES Journal (idJournal)
);


DELIMITER //
CREATE PROCEDURE read_utilisateur (input_mail varchar(80), input_mdp varchar(64))
BEGIN
	select * from utilisateur where (mail = input_mail AND mdp = input_mdp);
END //
DELIMITER ;























-- -----------------------------------------------------
-- Routine - READ
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE read_all (tableToRead varchar(30))
BEGIN
    SET @query = CONCAT('SELECT * FROM ', tableToRead);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE readWhereID (tableToRead varchar(30),id int)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', tableToRead, ' WHERE id',tableToRead,'=',id);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;nom
-- -----------------------------------------------------
-- Routine - UPDATE
-- -----------------------------------------------------

DELIMITER //
create procedure update_contact (  
  id INT,
  xtel INT,
  xmail VARCHAR(80),
  xdenomination_sociale VARCHAR(80),
  xforme_juridique VARCHAR(45),
  xcommentaire VARCHAR(200)
)
begin 
	update dossier set 
    tel = xtel,
    mail = xmail,
    denomination_sociale = xdenomination_sociale,
    forme_juridique= xforme_juridique,
    commentaire = xcommentaire
    where iddossier = id;
end //
DELIMITER ;

DELIMITER //
create procedure update_adresse (  
  id INT,
  xrue VARCHAR(45),
  xville VARCHAR(45),
  xnumero VARCHAR(10),
  xcomplement VARCHAR(90),
  xpays VARCHAR(45)
)
begin 
	update adresse set 
    rue = xrue,
    ville = xville,
    numero = xnumero,
    complement= xcomplement,
    pays = xpays
    where idadresse = id;
end //
DELIMITER ;

DELIMITER //
create procedure update_representant (  
  id INT,
  xtel INT,
  xmail VARCHAR(80),
  xnom VARCHAR(45),
  xprenom VARCHAR(45),
  xqualite VARCHAR(45)
)
begin 
	update representant set 
    tel = xtel,
    mail = xmail,
    nom = xnom,
    prenom = xprenom,
    qualite = xqualite
    where idrepresentant = id;
end //
DELIMITER ;
