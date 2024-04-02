package tp.monopoly;

import java.util.Scanner;

public class Menu {
    private Scanner sc;


    /**
    * Constructeur de la classe Menu.
    * Initialise un nouvel objet Scanner pour lire les entrées de l'utilisateur.
    */
    public Menu() {
        sc = new Scanner(System.in);
    }


    /**
    * Demande à l'utilisateur d'entrer le nom du joueur.
    *
    * @param numero Le numéro du joueur pour lequel le nom est demandé.
    * @return Le nom du joueur entré par l'utilisateur.
    */
    public String demanderNomJoueur(int numero) {
        System.out.println("Entrez le nom du joueur " + numero + " : ");
        return sc.nextLine();
    }



    /**
    * Demande à l'utilisateur de choisir le nombre de rounds pour le jeu.
    *
    * @return Le nombre de rounds choisi par l'utilisateur.
    */
    public int demanderNombreRounds() {
        System.out.println("\nChoisir le nombre de rounds :");
        int nbr_round = sc.nextInt();
        sc.nextLine(); // consomme le caractère de fin de ligne restant
        System.out.println("Vous avez saisi : " + nbr_round);
        return nbr_round;
    }

    

    /**
    * Affiche le tour du joueur actuel.
    *
    * @param joueur Le joueur dont le tour est actuellement en cours.
    */
    public void afficherTour(Joueurs joueur) {
        System.out.println(joueur.getNom() +" tire les dés");
    }



    /**
    * Affiche le résultat du lancer de dés.
    *
    * @param deplacement Le nombre obtenu après le lancer de dés.
    */
    public void afficherResultatDes(int deplacement) {
        System.out.println("Les dés sont égaux à " + deplacement);
    }



    /**
    * Affiche la position actuelle du joueur sur le plateau.
    *
    * @param joueur Le joueur dont la position est à afficher.
    * @param caseActuelle La case sur laquelle le joueur se trouve actuellement.
    */
    public void afficherPosition(Joueurs joueur, Cases caseActuelle) {
        System.out.println("Le " + joueur.getNom() + " est à la case " + caseActuelle + "\n");
    }


    /**
    * Demande à l'utilisateur s'il souhaite acheter la case actuelle.
    *
    * @return Un booléen indiquant si l'utilisateur a choisi d'acheter la case (true) ou non (false).
    */
    public boolean demanderAchat() {
        System.out.println("\nVoulez vous acheter cette cases : ");
        System.out.println("\n1. Oui");
        System.out.println("\n2. Non");
        int choix = sc.nextInt();
        sc.nextLine(); // consomme le caractère de fin de ligne restant
        return choix == 1;
    }
}