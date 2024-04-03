package tp.monopoly;


public class Controleur {
    private Plateau plateau;
    private Menu menu;
    private Des des;
    private Joueurs joueur1;
    private Joueurs joueur2;


    /**
    * Constructeur de la classe Controleur.
    * Initialise le jeu en créant un menu, un dé, deux joueurs et un plateau.
    * Démarre ensuite le jeu en appelant la méthode jouer().
    */
    public Controleur() {
        menu = new Menu();
        des = new Des();
        String nomJ1 = menu.demanderNomJoueur(1);
        String nomJ2 = menu.demanderNomJoueur(2);
        joueur1 = new Joueurs(nomJ1); 
        joueur2 = new Joueurs(nomJ2); 
        plateau = new Plateau(joueur1, joueur2);
        jouer();
    }


    /**
    * Démarre le jeu en demandant le nombre de rounds et en faisant jouer chaque joueur à tour de rôle.
    * Un round consiste en un tour de chaque joueur.
    */
    private void jouer() {
        int nbr_round = menu.demanderNombreRounds();
        for (int i = 0; i < nbr_round; i++) {
            menu.afficherPlateau(joueur1, joueur2);
            jouerTour(joueur1);
            menu.afficherPlateau(joueur1, joueur2);
            jouerTour(joueur2);
        }
    }


    /**
     * Fait jouer un tour à un joueur.
     * Le joueur lance les dés, se déplace sur le plateau, affiche sa position, et achète la propriété sur laquelle il se trouve si possible.
     * Si le joueur ne peut pas acheter la propriété, un message est affiché.
     * @param joueur Le joueur qui joue le tour.
     */
    private void jouerTour(Joueurs joueur) {
        menu.afficherTour(joueur);
    
        if (joueur.estEnPrison()) {
            joueur.essayerSortirDePrison();
        } else {
            des.lancerDes();
            int desUn = des.getDesUn();
            int desDeux = des.getDesDeux();
            int deplacement = desUn + desDeux;
            menu.afficherResultatDes(deplacement);
            int case_actuelle = joueur.setPlacement(deplacement);
            Cases caseActuelle = plateau.getCases(case_actuelle);
            menu.afficherPosition(joueur, caseActuelle);
    
            // Vérifie si la case actuelle est une CaseSpeciale
            if (caseActuelle instanceof CaseSpeciale) {
                ((CaseSpeciale) caseActuelle).appliquerEffet(joueur);
            } else if (caseActuelle.getCout() != 0 && menu.demanderAchat()) {
                // Le joueur est sur une case normale et peut acheter la propriété
                joueur.acheterPropriete(caseActuelle);
            }
        }
    }
}