# ITFAM - AccountX

DISCLAIMER : AccountX n'est pas en mesure de vous permettre de faire votre comptabilité à ce jour. Si vous souhaitez utiliser ce projet, aucun service d'assistance ne vous sera dédié. La fiabilité du projet ne peut être garantie. La sécurité du projet peut être compromise. 

NOTE : AccountX.pptx présente des informations supplémentaires sur la structure du projet et ses fonctionnalités. Il est conseillé de consulter ce document. 



Setup 

1/ Utiliser git clone ou dwnld un zip pour obtenir le projet

2/ Telecharger toutes les sources avec maven spécifiés dans le pom.xml 

3/ Configurer le serveur glassfish 7.0 et utiliser "domain1" (doit être dans le meme dossier que accountX)



Initialisation de BDD

1/ Creer la base de données sous MySQL avec le fichier structure

2/ Completer la BDD avec le fichier de contenu 

3/ Ajouter un utilisateur coorespondant à vous même ou alors utilisez le passe-droit suivant : 

    id : decouverte.acx@itfam.fr
    
    mdp : jeTestAccountX.2023
    
Ce mot de passe contourne la fonction de hashage il faut absolument supprimer celui-ci de la BDD dès lors que vous avez créer votre utilisateur. 

----------------------------------------------------------------------------------------------------------------------------------------------

Creer son utilisateur; 

1/ Ouvrir le projet

2/ Dans la classe "connexion" du modèle enlevez les balises de commentaires autour du code d'affichage du mot de passe crypté dans le log

3/ Executer le programme et entrer vos identifiants et mot de passe dans la page login qui s'affiche (http://localhost:8080/accountx/login)

4/ Retourner dans la console et copier votre mot de passe crypté, vous pouvez creer votre utilisateur dans la BDD MySQL avec ce mot de passe
