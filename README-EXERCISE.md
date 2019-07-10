Le but de cet exercice est de déterminer la capacité du candidat à implémenter une réponse complète à un besoin concret, avec une solution efficace respectant les contraintes, et un code de qualité. 


Énoncé:
--------

Nos magasins produisent tous les jours des fichiers de logs contenant les informations relatives à leur activité de vente journalière. De plus, chaque magasin possède son propre référentiel de prix journalier.


Le fichier des transactions journalières contient ces infos: `txId|datetime|magasin|produit|qte`
 
Et celui du référentiel produit: `produit|prix`

où:
 - txId : id de transaction (nombre)
 - datetime : date et heure au format ISO 8601
 - magasin : UUID identifiant le magasin
 - produit : id du produit (nombre)
 - qte : quantité (nombre)
 - prix : prix du produit en euros

Notre système collecte toutes les informations des transactions de tous les magasins en un seul fichier.
Par contre les fichiers de référentiels produits sont reçu par magasin.
Les règles de nommage de ces fichiers sont les suivantes:

  - les transactions : `transactions_YYYYMMDD.data`
  - les référentiels : `reference_prod-ID_MAGASIN_YYYYMMDD.data` où ID_MAGASIN est un UUID identifiant le magasin.

Vous trouverez dans le répertoire /data/ des fichiers exemples qui vous permettront d'avoir une idée concrète de leur contenu.

Nous avons besoin de déterminer, chaque jour, les 100 produits qui ont les meilleures ventes et ceux qui génèrent le plus gros Chiffre d'Affaire par magasin et en général.

De plus, on a besoin d'avoir ces mêmes indicateurs sur les 7 derniers jours.

Les résultats sont les fichiers:
	
1. `top_100_ventes_<ID_MAGASIN>_YYYYMMDD.data` 
2. `top_100_ventes_GLOBAL_YYYYMMDD.data`
3. `top_100_ca_<ID_MAGASIN>_YYYYMMDD.data`
4. `top_100_ca_GLOBAL_YYYYMMDD.data`
5. `top_100_ventes_<ID_MAGASIN>_YYYYMMDD-J7.data` 
6. `top_100_ventes_GLOBAL_YYYYMMDD-J7.data`
7. `top_100_ca_<ID_MAGASIN>_YYYYMMDD-J7.data`
8. `top_100_ca_GLOBAL_YYYYMMDD-J7.data`

Contexte:
---------
	
* nb magasin = actuellement 1200, croît en moyenne de 10 par an.
* nb de produits actuels = quelques millions avec quelques milliers de plus par an.
* nb de tx/j actuel = quelques millions et augmente significativement chaque mois.

Contraintes:
------------

* 2 cpu - 512M ram - pas de contraintes sur les disques (aussi bien en quantité de données qu'en nombre de fichiers intermédiaires)
* efficacité (temps d'exécution % ressources consommées)
* nombre de produits en constante évolution
* nombre de transactions en grande évolution
* pas de backend (base de données, Hadoop, Spark, Kafka, etc.)
* languages: Scala, Java, Bash, Go

**_Attention: les fichiers exemples dans le répertoire /data/ contiennent peu de données. Vous pouvez éventuellement générer vos propres fichiers pour simuler la volumétrie attendue._**

Livrable:
----------

Application packagée et prête à être utilisée avec sa documentation.


Critères de sélection:
----------------------

	1. Réponse au besoin et en particulier aux contraintes
	2. Qualité du code, des tests, et du livrable en général
	3. Patterns / algorithmes implémentés
	4. Nombre de dépendances maîtrisé (préférer les librairies ciblées aux gros frameworks)
	5. Utilisabilité (fonctionnalitées et exploitation)
	6. Maîtrise des outils / environnement de développement utilisés

