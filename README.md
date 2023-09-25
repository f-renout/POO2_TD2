**Programmation**

Le but de ce TD est de définir les classes et méthodes nécessaires pour programmer un jeu de
Morpion à un joueur, avec une intelligence artificielle pour lui faire face.

**La classe Morpion**

Questions
1. Définissez une classe Morpion contenant notamment une grille 3 X 3 de jetons, et une
   fonction affchant la grille.
2. L'utilisation d'une IA nécessite l'ajout des méthodes suivantes dans la classe Grille:
    - void jouerCoup(Coup c);
    - void annulerCoup();
    - List<Coup> coupsPossibles(Joueur j);

Écrivez ces trois méthodes. Pour le morpion, un coup est la donnée d'une position dans
   la grille, et du joueur jouant le coup. Pour le morpion, un joueur peut simplement être
   caractérisé par son type de jeton.


**La classe IA**

Décrivez la classe IA qui comporte en particulier les méthodes suivantes :
 - int évaluer();
 - int max(int profondeur)
 - int min(int prof);

Ces méthodes sont la base de l'algorithme Min-Max. Si l'on se situe sur une feuille de
l'arbre (si la partie est terminée, il n'y a plus de coups possibles), ou si la profondeur
demandée vaut 0, ces fonctions renvoient la valeur du noeud. Sinon, il s'agit de calculer la
valeur de chaque fils du noeud courant, et de renvoyer la valeur maximale pour max()
ou minimale pour min()
- la méthode void Jouer(Morpion m);, seule méthode publique utilisée pour faire jouer
l'IA.
- 
Le noeud de départ est un noeud Max (l'IA va choisir le déplacement qui maximise son
  score). La méthode prochainCoup() devra donc trouver le coup correspondant à un déplacement
  optimal.

Questions
1. Une idée pour une fonction d'évaluation plus performante ?
2. Un facteur important de l'algorithme est la profondeur maximale que l'on utilise pour
   chercher une solution. Quels sont les critères à prendre en compte pour choisir la valeur
   de ce facteur ?
