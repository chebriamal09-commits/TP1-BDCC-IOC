# TP1 - Framework Injection de Dépendances (IOC)

## Réalisé par
**Amal Chebri**

## Description

Ce projet a été réalisé dans le cadre du TP sur l'Injection de Dépendances (IOC).

L'objectif est de comprendre le principe du couplage faible et de mettre en œuvre différentes techniques d'injection des dépendances.

---

# Partie 1

Les fonctionnalités réalisées :

- Création de l'interface IDao
- Création d'une implémentation DaoImpl
- Création de l'interface IMetier
- Création de l'implémentation MetierImpl
- Injection par instanciation statique
- Injection par instanciation dynamique
- Injection avec Spring XML
- Injection avec les annotations Spring

---

# Partie 2

Développement d'un mini Framework d'Injection de Dépendances.

Fonctionnalités développées :

- Création des annotations personnalisées
- Gestion des Beans
- Lecture d'un fichier XML de configuration
- Injection des dépendances
- Utilisation de Reflection
- Chargement automatique des composants

---

# Technologies utilisées

- Java 21
- Maven
- Spring Framework
- JAXB
- IntelliJ IDEA
- Git
- GitHub

---

# Structure du projet

```
src
 ├── dao
 ├── metier
 ├── pres
 └── framework
      ├── annotations
      ├── context
      ├── injector
      ├── scanner
      └── xml
```

---

# Exécution

Le projet s'exécute à partir de :

```
Pres1.java
```

Résultat obtenu :

```
Version base de données
Res = ...
Process finished with exit code 0
```

---

# Captures d'écran

Les captures d'écran de l'exécution et de la structure du projet sont disponibles dans le dossier **captures**.

---

# Repository GitHub

Le projet est disponible sur GitHub.
