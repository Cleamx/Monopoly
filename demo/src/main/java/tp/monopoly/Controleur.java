package tp.monopoly;


public class Controleur {
    private Plateau plateau;
    private Menu menu;
    private Des des;
    private Joueurs joueur1;
    private Joueurs joueur2;

    public Controleur() {
        menu = new Menu();
        des = new Des();
        String nomJ1 = menu.demanderNomJoueur(1);
        String nomJ2 = menu.demanderNomJoueur(2);
        joueur1 = new Joueurs(nomJ1); // ici
        joueur2 = new Joueurs(nomJ2); // et ici
        plateau = new Plateau(joueur1, joueur2);
        jouer();
    }

    private void jouer() {
        int nbr_round = menu.demanderNombreRounds();
        for (int i = 0; i < nbr_round; i++) {
            jouerTour(joueur1);
            jouerTour(joueur2);
        }
    }

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