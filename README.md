Le but de cet exercice est de déterminer la capacité du candidat à implementer une réponse complete à un besoin concret montrant ses capacités a produire une solution efficace avec un code de qualité. 


Enoncé:
--------

Nos magasins produisent tous les jours des fichiers de logs contenant les informations relatives a leur activité de vente journalière. De plus, chaque magasin possede son propre référentiel de prix journalier.


Le fichier des transactions journalières contient ces infos: `txId|datetime|magasin|produit|qte`
 
Et celui du référentiel produit: `produit|prix`

ou:
 - txId : id de transaction (nombre)
 - datetime : date et heure sous le format Iso 8601
 - magasin : UUID identifiant le magasin
 - produit : id du produit (nombre)
 - qte : quantité (nombre)  
 - prix : prix du produit en euros

Notre système collecte toutes les informations des transactions de tous les magasins en un seul fichier.
Par contre les fichiers de référentiels produits sont reçu par magasin.
Les règles de nommage de ces fichiers sont les suivantes:

  - les transactions : `transactions_YYYYMMDD.data`
  - les référentiels : `reference_prod_ID-MAGASIN_YYYYMMDD.data` ou ID_MAGASIN est un UUID.

vous trouverez joint à cet énoncé deux fichiers exemples qui vous permettront d'avoir une idée concrète de leur contenu.

Nous avons besoin de déterminer, chaque jour,les 100 produits qui ont les meilleures ventes et ceux qui génère le plus gros Chiffre d'affaire par magasin et en général.

De plus, on a besoin d'avoir ces mêmes indicateurs sur les 7 derniers jours.
Les resultats sont les fichiers:
	
1. `top_100_ventes_<MAGASIN_ID>_YYYYMMDD.data` 
2. `top_100_ventes_GLOBAL_YYYYMMDD.data`
3. `top_100_ca_<MAGASIN_ID>_YYYYMMDD.data`
4. `top_100_ca_GLOBAL_YYYYMMDD.data`
5. `top_100_ventes_<MAGASIN_ID>_YYYYMMDD-J7.data` 
6. `top_100_ventes_GLOBAL_YYYYMMDD-J7.data`
7. `top_100_ca_<MAGASIN_ID>_YYYYMMDD-J7.data`
8. `top_100_ca_<MAGASIN_ID>_YYYYMMDD-J7.data`

Contexte:
---------
	
* nb magasin = actuellement 1200, croit en moyenne de 10 par an.
* nb de produits actuels = quelques millions avec quelques milliers de plus par an.
* nb de tx/j actuel = quelques millions et augmente significativement chaque mois.

Contraintes:
------------

* 2 cpu - 512M ram - pas de contraintes sur les disques (aussi bien en quantité de données que en nombre de fichiers intermediaires)
* efficacité (temps d'execution % resources consommé)
* nombre de produit en constante évolution
* nombre de tx en grande évolution
* pas de backend (base de données, Hadoop, spark, ou autre)
* Languages: Scala, Java, Bash, Go.

Livrable:
----------

Application packagée et prête à être utilisée avec sa documentation.


Critères de sélection:
----------------------

	1. Réponse au besoin
	2. Qualité du code et du livrable en général
	3. Patterns/algorithmes implémentés
	4. Nombre de dépendences (le moins on utilise de frameworks le mieux c'est)
	5. Utilisabilité (fonctionnalité et exploitation)
	6. Maitrise des outils/environnement de developpement utilisées

