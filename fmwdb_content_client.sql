 insert into adresse values
 (1, 'France', 'Belfort','Avenue Jean Jaures','106B', null),
 (2, 'France', 'Montbéliard', 'Place Ferrer', '10', 'appartement 3'),
 (3, 'France', 'Vesoul', 'Rue du lavoir', '15', null);



insert into representant values 
(1, 0765682315, 'john.doe@test.com', 'Doe', 'John', 2, 'Gérant'),
(2, 0689995211, 'Rene.lataupe@sonnerie.fr', 'Lataupe', 'René', 3, 'Entrepreneur');



insert into dossier values 
(1, 0381542219, 'contact@lacompta.fr', 'LaCompta', 'SELARL', 1,1, 130000, 1, 1, 'Société ayant en difficulté'),
(2, 0689995211, 'Rene.lataupe@sonnerie.fr', 'Peintre Lataupe', 'EI', 1,1, null, 2,3,null);

insert into utilisateur values
(1,'test@itfam.fr','Alpha','Testeur','TEST','3bsHYHMj4xyKyfPHP1NfPMYGF4SG2M5DX3VN9eEPRWdd'),
(2,'decouverte.acx@itfam.fr','passe','droit','NEW-CLIENT','jeTestAccountX.2023');


use fmwdb;

select * from adresse; 
select * from dossier;
select * from representant;  

