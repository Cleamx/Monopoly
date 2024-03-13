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
            jouerTour(joueur1);
            jouerTour(joueur2);
        }
    }


    /**
    * Joue un tour pour le joueur donné.
    * Affiche le tour du joueur, lance les dés, déplace le joueur sur le plateau,
    * affiche la nouvelle position du joueur, et demande au joueur s'il veut acheter la case actuelle.
    *
    * @param joueur Le joueur qui joue ce tour.
    */
    private void jouerTour(Joueurs joueur) {
        menu.afficherTour(joueur);
        int deplacement = des.Lancer();
        menu.afficherResultatDes(deplacement);
        int case_actuelle = joueur.setPlacement(deplacement);
        menu.afficherPosition(joueur, plateau.getCases(case_actuelle));
        if (menu.demanderAchat()) {
            joueur.acheterPropriete(plateau.getCases(case_actuelle));
        }
    }
}