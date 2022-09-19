# Microservice DIABETES
## Dans le cadre de la formation OpenClassrooms "Développeur d'application Java" 


Il s’agit du Microservice "DIABETES" de l'application "MEDISCREEN" qui constitue le 9ème projet de la formation

### Objectif du projet

En partant de zéro, développer 4 microservices d'une application Java fonctionnelle.

### Fonctionnalités de l’application

Application qui, en finalité, doit servir à vérifier si des patients sont susceptible d'être atteint de diabete. 

Ce microservice permet de savoir si un patient est susceptible d'attraper du diabètes en fonction de:
- son age
- son sexe
- les différentes notes des praticiens

L’application n’est pas encore livrée dans sa version finale.

### Progression
En plus de renforcer mes compétences sur les aspects étudiés pendant mes précédents projets, ce projet m'a permis de pratiquer la création d'une application divisée en 4 microservices.

### Réalisation


Création de 4 méthodes correspondantes aux 4 cas de diabetes. Chacune des méthodes parcours les notes d'un patient afin d'y detecter les mots clés. Puis en fonction des résultats, de l'age et du sexe, va retourner un des 4 cas de diabetes
Réalisation de tests unitaires et d’intégration,
Le projet poursuit les bonnes pratiques de développement, avec l'isolation et l'indépendance des tests, la séparation des interfaces, l'injection des dépendances, ou encore l'utilisation du Data Transfert Object Pattern.


### Lancement du projet

Avant de lancer l'application, créer une base de données intitulée "mediscreen" sur MySQL, ainsi qu'une base de données intitulée "mediscreen" sur MongoDBCompass (nom de la collection : "notes") Une fois l'application lancée, les tables se généreront toutes seules.

Si vous souhaitez utiliser le code en développement:

- Utilisez votre IDE,
- Changer le fichier properties du microservice patients en localhost : "spring.datasource.url=jdbc:mysql://localhost:3306/mediscreen?serverTimezone=UTC"
- Changer le fichier properties du microservice notes en localhost : "spring.data.mongodb.host=localhost"
- Changer les 3 fichiers proxies du microservice client en localhost au niveau de l'annotation @feign : "@FeignClient(name="nom du service", url="localhost: "numéro du port")"
- Lancer les 4 microservices
- Lancer la vue en http://localhost:8080/


Si vous souhaitez lancer l'application via docker:

- Changer le fichier properties du microservice patients en host.docker.internal : "spring.datasource.url=jdbc:mysql://host.docker.internal:3306/mediscreen?serverTimezone=UTC"
- Changer le fichier properties du microservice notes en localhost : "spring.data.mongodb.host=host.docker.internal"
- Changer les 3 fichiers proxies du microservice client en localhost au niveau de l'annotation @feign : "@FeignClient(name="nom du service", url="host.docker.internal: "numéro du port")"
- Commande pour Build les Jars : mvn clean package -DskipTests=true
- Commande pour build une image Docker : "docker build -t nomDeLImage ." (exemple : docker build -t mediscreen_client_docker)
- Commande pour lancer une image Docker : "docker run -p numéroDePort:numéroDePort nomDeLimage" (exemple : docker run -p 8080:8080 mediscreen_client_docker)
- Build les 4 JAR, et Build et lancer les 4 images relatives aux 4 microservices 
- Lancer la vue en http://localhost:8080/