# Projet Spring Boot - API pour test technique

## Description

Ce projet est une API de gestion d'exploitation agricole  et d'animaux développée en **Spring Boot**. Les entités principales sont **Farm** (exploitation agricole) et **Animal** (animaux de la ferme). Lors du démarrage, des données fictives sont générées à l'aide de **Faker** et insérées dans une base de données en mémoire **H2**.

Le projet inclut des exemples de routes pour manipuler les entités et fournit une base pour un exercice technique à réaliser.

Cette API expose une documentation swagger à l'adresse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

---

## Prérequis

- **Java 21**
- **Maven 3.8+**
- Un IDE tel que **IntelliJ IDEA**, **NetBeans** ou **Eclipse**

---

## Fonctionnalités

### Endpoints existants

#### Fermes (**Farm**)

1. **Liste des exploitations agricoles** :
    - **GET** `/farms`
    - Renvoie la liste de toutes les exploitations agricoles en base.

2. **Détails d'une exploitation agricole** :
    - **GET** `/farms/{id}`
    - Renvoie les détails d'une exploitation agricole en fonction de son ID.

3. **Créer une exploitation agricole** :
    - **POST** `/farms`
    - Crée une nouvelle exploitation agricole. Exemple de payload :
      ```json
      {
        "name": "Happy Farm",
        "type": "Organic",
        "addressLine1": "123 Green Road",
        "addressLine2": "",
        "city": "Farmington",
        "state": "NY",
        "postalCode": "12345",
        "country": "USA"
      }
      ```

---

## Exercice Technique

L'exercice suivant consiste à étendre cette API pour inclure la gestion des **animaux** avec les règles ci-dessous :

### Routes à développer

1. **Filtrer les animaux par sexe** :
    - **GET** `/animals?gender=F`
    - Filtre les animaux dont le genre correspond au paramètre `gender` fourni (`M` pour mâle, `F` pour femelle).

2. **Mettre à jour un animal** :
    - **PUT** `/animals/{id}`
    - Met à jour les informations d'un animal. Exemple de payload :
      ```json
      {
        "name": "brutus",
        "gender": "M",
        "nationalNumber": "FR123456789",
        "birthDate": "2024-10-15"
      }
      ```

### Règles de gestion

#### 1. Validation du nom de l’animal :
- Le nom doit être **unique** dans la base de données.
- Le nom doit être stocké en **minuscules**, sans accents ni caractères spéciaux (autres que `[a-z]`).

#### 2. Validation de la date de naissance :
- La date de naissance doit être **inférieure à la date actuelle**.

### Résultat attendu

À la fin de l'exercice, les deux endpoints demandés doivent être implémentés et répondre aux règles de gestion ci-dessus. Ajoutez des tests unitaires et d'intégration pour valider les fonctionnalités développées.

---

## Structure du Projet

- **`/src/main/java`** : Contient le code source de l'application.
- **`/src/main/resources`** :
    - **`application.yml`** : Configuration de l'application, y compris la base de données H2.
- **`/src/test`** : Contient les tests unitaires et d'intégration.

---

## Tester l'API

1. **Utiliser Swagger UI** :  
   Accédez à [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) pour interagir avec l'API directement via une interface graphique.

2. **Exemples de requêtes avec cURL** :

    - **Filtrer les animaux** :
      ```bash
      curl -X GET "http://localhost:8080/animals?gender=F"
      ```
---

## Ressources

- [Documentation Spring Boot](https://spring.io/projects/spring-boot)
- [Base de données H2](https://www.h2database.com/html/main.html)
- [Swagger UI Documentation](https://swagger.io/tools/swagger-ui/)
- [Lombok](https://projectlombok.org/)

