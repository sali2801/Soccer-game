# Soccer-game
 Une UI composée de :
	un menu pour lancer une nouvelle partie ou pour quitter le jeu
	une barre en haut pour afficher le score des deux équipes à côté de leurs noms.
	deux barres de boutons à droite et à gauche de l'écran comportant la liste des boutons permettant de contrôler les joueurs de chaque équipe.
	Une barre de boutons en bas de la fenêtré dédiée à l'arbitre pour lancer et arrêter le match, ou pour donner un carton jaune ou rouge à un joueur des deux équipe.
	Un terrain de foot de couleur verte et de dimension 120m sur 90 (à vous d'adapter sur une échelle) au centre de la fenêtre sur lequel se déplacent les joueurs et interagissent avec la balle. Il comporte les filets sur les côtés.

Pour simplifier, nous considérons que chaque équipe est composée de trois joueurs : un attaquant, un défenseur et un gardien. Ces joueurs seront représentés sur le terrain par un avatar consistant en un triangle avec la couleur de l'équipe. Nous supposons également que chacun dispose d'un périmètre de déplacement : 
	le gardien ne peut pas sortir de la zone de réparation (il ne peut pas avancer plus de 16,5m en avant ou plus de 20m sur les côtés).
	Le défenseur ne peut pas sortir de la zone de son équipe.

La balle est représentée par un cercle gris. Si la balle est à une distance égale à 0 d'un joueur, elle est en sa possession. Il peut avancer avec dans sa zone autorisée ou la tirer à une distance donnée, la passer vers un autre joueur, marquer un but s'il atteint les filets de l'autre équipe, comme il risque de la perdre si un joueur de l'équipe adversaire l'empêche (distance entre ce joueur et la balle égale à 0).

Si un but est marqué, le score est incrémenté ce qui déclenche les cris de joie des supporteurs de l'équipe qui a marqué le but et de désespoir des supporters de l'autre équipe. Nous représentons cette réaction par une boite de dialogue comportant les messages adéquats. 
Pour permettre aux entraineurs d'exprimer leur avis, nous prévoyons un bouton qui affiche une boite de dialogue affichant le message d'hurlement et provoquant l'avancement de chaque joueur sa manière selon son rôle dans l'équipe.
