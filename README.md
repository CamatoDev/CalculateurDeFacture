# 🧾 Calculateur de Facture – Java Swing/AWT

## 🧩 Présentation

Ce projet est une application de gestion de commande et de calcul de facture, réalisée en **Java** avec les bibliothèques **Swing** et **AWT** pour l’interface graphique.

L’utilisateur peut :
- Sélectionner des **articles** dans une **liste prédéfinie**
- Indiquer la **quantité** souhaitée pour chaque article
- Visualiser une **facture générée dynamiquement**
- **Valider** ou **annuler** la commande
- Recevoir une **confirmation** de livraison si la commande est validée

## 🎯 Objectif

Offrir une application simple et intuitive pour simuler une **commande avec aperçu de facture**, utile pour :
- Des démonstrations de concepts Java GUI
- Des simulations de panier d’achat
- De petites solutions internes pour boutiques locales

## 🧰 Technologies utilisées

- 💻 Java
- 🧱 Swing (fenêtres, boutons, champs texte, tableaux)
- 🎨 AWT (gestion d’événements, composants graphiques de base)

## 📸 Fonctionnalités principales

| Fonction                   | Description |
|----------------------------|-------------|
| ✅ Sélection d’articles     | Interface graphique avec liste d’articles (nom + prix + quantité en stock) |
| ➕ Choix de quantité        | L’utilisateur entre la quantité désirée pour chaque article |
| 🧾 Aperçu de la facture     | Résumé des articles commandés, prix unitaire, total par ligne et total général |
| 📨 Confirmation de commande| Message de validation et information de livraison |
| ❌ Annulation              | Possibilité de réinitialiser les choix ou quitter l'application |

## 📸 Interface

![Fenêtre Principale](<Capture d'écran 2025-04-19 204457.png>)
![Espace de paiement](<Capture d'écran 2025-04-19 204522.png>)
![Confirmation du client](<Capture d'écran 2025-04-19 204541.png>)
![Notification de succès](<Capture d'écran 2025-04-19 204552.png>)

## 🏁 Lancement de l'application

1. Compiler avec :
   ```bash
   javac CalculateurDeFacture.java
   ```
2. Lancer avec :
   ```bash
   java CalculateurDeFacture
   ```

> Le nom `CalculateurDeFacture` est à adapter selon le fichier principal.

## 🎓 Ce que j’ai appris

- Création d’**interfaces utilisateur interactives** avec Swing
- Gestion des **événements (actions boutons, entrées utilisateur)**
- Structuration de code Java orienté objet pour des petites apps fonctionnelles

## ✅ Statut

Projet terminé et fonctionnel ✅
