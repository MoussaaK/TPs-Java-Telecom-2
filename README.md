#							Réponse aux questions#

* Question 7 :
	On surcharge la méthode **toString** pour quelle retourne nom pas la réference de l'objet instancié mais plutôt le **nom**, **prenom** et **salaire** donnés à l'objet lors de son instanciation.

* Question 8 :
	Pour comparer deux instances de Marin on utilise la méthode **equals**

* Question 9 :
	m1 et m2 sont égales par contre elles sont différentes de m3

* Question 10 :
	Les hashCodes de m1 et m2 doivent être égales car **deux Objets sont égales au sens de equals s'ils ont mêmes hashCodes**; m3 a un hashCode différent de celui de m1 ou m2

* Question 11 :
	* Java utilise les **interfaces** pour réaliser ce genre de comparaison

##Exercice 14 (Série 06)


* Question 1 :
	Il comporte **19672** lignes
	
* Question 2 :
	Il y a **16299** lignes non vides
	
* Question 3 :
	Le mot **bonjour** apparait **7 fois**
	
* Question 6
	les caractères suivants ne sont pas des lettres : **[,'.;:?!16<>2570849_*\\-]**
	
* Question 7 :
	Germinal comporte **177183 mots**, **13933 mots différents**
	
* Question 8 :
	* La longeur du **mot le plus long** utiiisé est **19**
	* Germinal contient 2 mots de cette longeur
	* Ces mots sont : **"revolutionnairement"** et **"proportionnellement"**
	
* Question 9 :
	* La longueur de mot la plus **fréquente** est **7**
  	* **2403** mots ont cette longeur
  	
* Question 10 :
 	* La longeur du mot **median** est **10**
  	* Et **1347** mots ont cette longeur.

##Exercice 15 (Série 07)

* Question 1 :
	* L'interface Stream étend **AutoClosable** => AutoClosable est la superinterface de stream
	* On en deduit que la fermeture d'un stream ouvert sur un fichier ne necessite pas un apple é la méthode close
	
* Question 2 : 

##Exercice 16 (Série 08)

* Question 1 :
	* La Classe **ByteArrayOutputStream** permet de créer de sbuffer en mémoire
	* On doit utiliser le flux DataOutputStream pour écrire des types primitifs en Java

* Question 3 : 
	* Non on n'a pas besoin de relire le tableau objet par objet
	* On a besoin du **nombre d'instances** de Person dans le fichier pour lire correctement le bon nombre de person

##Exercice 17 (Série 08)		
	
* Question 1 :
	On doit utiliser le flux **ObjectOutputStream** pour écrire des Objets Java dans des fichiers binaires

* Question 2 :
	On doit rendre la classe Person Seriazable, en le faisant implémenter l'interface  **Serializable**
	
* Question 6 :
	La classe est **Person**
	
##Exercice 18 (Série 09)	

* Question 2 :
	La classe peut étre instanciée par cette méthode si et seulement si elle a un **constructeur vide explicite**
	
* Question 4 :
	Cette méthode doit retourner un **Object**
