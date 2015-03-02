Le but de cet exercice est de determiner la capacité du candidat à implementer une reponse complete a un besoin concret montrant ses capacités a produire une solution efficace avec un code de qualité. 


Enoncé:
--------

Nos magasins produisent tous les jours des fichiers de logs contenant les informations relatives a leur activité de vente journaliere. De plus, chaque magasin possede son propre referentiel de prix journalier.


Le fichier des transactions journalieres contient ces infos: `txId|datetime|magasin|produit|qte`
 
Et celui du referencetiel produit: `produit|prix`

ou:
 - txId : id de transaction (nombre)
 - datetime : date et heure sous le format Iso 8601
 - magasin : UUID identifiant le magasin
 - produit : id du produit (nombre)
 - qte : quantité (nombre)  
 - prix : prix du produit en euros

Notre systeme collecte toutes les informations des transactions de tous les magasins en un seul fichier.
Par contre les fichiers de referentiels produits sont recu par magasin.
Les regles de nommage de ces fichiers sont les suivantes:

  - les transactions : `transactions_YYYYMMDD.data`
  - les referentiels : `reference_prod_ID-MAGASIN_YYYYMMDD.data` ou ID_MAGASIN est un UUID.

vous trouverez joint a cet énoncer deux fichiers exemples qui vous permetterons d'avoir une idée concrete de leur contenu.


Nous avons besoin de determiner, chaque jour,les 100 produits qui ont les meilleures ventes et ceux qui genere le plus gros Chiffre d'affaire par magasin et en general.
De plus, on besoin d'avoir ces memes indicateurs sur les 7 derniers jours.
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
* nb de produits actuel = quelques millions avec quelques milliers en plus par an.
* nb de tx/j actuel = quelques millions et augmente significativement chaque mois.

Contraintes:
------------


* 2 cpu - 1G ram - pas de contraintes sur les disques (aussi bien en quantité de données que en nombre de fichiers intermediaire)
* efficacité (temps d'execution % resources consommé)
* nombre de produit en constante evolution
* nombre de tx en grande evolution
* pas de backend (base de données, Hadoop, spark, ou autre)

Livrable:
----------

Application packagées et prete a etre utilisée avec sa documentation.


Criteres de selection:
----------------------

	1. Reponse au besoin enoncé
	2. Qualité du code et du livrabe en général
	3. Patterns/algorithmes implémentés
	4. Nombre de dépendences (le moins on utilise de fwrk le mieux c'est)
	5. Usabilité (fonctionnalité et exploitation)
	6. Maitrise des outils/environnement de developpement utilisées


Les candidats ayant reussient ce test  viendront nous rencontrer pour discuter de leur solution et nous leur presenterons notre projet.
