# Projet d'Annonces

Ce projet Spring Boot implémente une API pour gérer des annonces. Les annonces peuvent être de différents types tels que l'immobilier, les véhicules et l'emploi. L'architecture utilisée est la 3-tiers avec les couches Controller, Service et Repository.

## Installation

1. Clonez ce dépôt de code source sur votre machine locale.

```bash
git clone https://github.com/HL-Abdallah/AnnonceAPI.git
```

2. Accédez au répertoire du projet.

```bash
cd AnnonceAPI
```

3. Compilez le projet à l'aide de Maven.

```bash
mvn clean install
```

## Exécution

1. Après avoir compilé le projet, vous pouvez lancer l'application en exécutant la commande suivante :

```bash
mvn spring-boot:run
```

2. L'application sera accessible à l'adresse suivante : http://localhost:8082

## API Endpoints

L'API expose les endpoints suivants :

- **POST /annonces** : Crée une nouvelle annonce en fournissant les détails (titre, description, prix, type).
- **GET /annonces** : Récupère la liste complète des annonces.
- **DELETE /annonces/{id}** : Supprime une annonce spécifiée par son ID.
- **PUT /annonces/{id}** : Modifie une annonce existante en fournissant son ID et les détails mis à jour.

## Documentation API avec Swagger

L'API est documentée à l'aide de Swagger. Vous pouvez consulter la documentation de l'API et tester les endpoints en accédant à l'URL suivante : http://localhost:8082/swagger-ui.html

## Base de données

Ce projet utilise une base de données PostgreSQL v15 par défaut. Si vous souhaitez utiliser une autre base de données, veuillez modifier la configuration dans le fichier `application.properties`.
