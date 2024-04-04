package tp.monopoly;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
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


    public void afficherPlateau(Joueurs joueur1, Joueurs joueur2) {
        System.out.println("------------------ Plateau de jeu ------------------");

        // Affichage des propriétés possédées par le joueur 1
        System.out.println(joueur1.getNom() + " possède : ");
        for (Cases propriete : joueur1.getProprietes()) {
            System.out.println("- " + propriete.getNom());
        }

        // Affichage des propriétés possédées par le joueur 2
        System.out.println(joueur2.getNom() + " possède : ");
        for (Cases propriete : joueur2.getProprietes()) {
            System.out.println("- " + propriete.getNom());
        }

        // Affichage du plateau de jeu avec les positions des joueurs
        for (int i = 0; i < 40; i++) {
            String symboleJoueur1 = (joueur1.getPlacement() == i) ? "X" : " ";
            String symboleJoueur2 = (joueur2.getPlacement() == i) ? "O" : " ";
            System.out.print("|" + symboleJoueur1 + symboleJoueur2);
        }
        System.out.println("|");
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
        int nbr_round = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nChoisir le nombre de rounds :");
                nbr_round = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                sc.next(); // consomme le jeton invalide
            } catch (NoSuchElementException e) {
                System.out.println("Aucune entrée trouvée. Veuillez réessayer.");
                sc = new Scanner(System.in); // crée un nouveau Scanner
            }
        }
        sc.nextLine(); // consomme le caractère de fin de ligne restant
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
        System.out.println(joueur.getNom() + " est à la case " + caseActuelle + "\n");
        System.err.println("il vous reste : " + joueur.getArgent() + "\n");
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

    public boolean demanderPayerAmende() {
        System.out.println("\nVoulez vous payer l'amende de 50 pour sortir de prison : ");
        System.out.println("\n1. Oui");
        System.out.println("\n2. Non");
        int choix = sc.nextInt();
        sc.nextLine(); // consomme le caractère de fin de ligne restant
        return choix == 1;
    }

    public void acheterMaison(Joueurs joueur) {
        List<Cases> proprietes = joueur.getProprietes();
        System.out.println("Sur quelle propriété voulez-vous acheter une maison ?");
        for (int i = 0; i < proprietes.size(); i++) {
            System.out.println((i + 1) + ". " + proprietes.get(i).getNom());
        }
        int choix = sc.nextInt() - 1;
        Cases proprieteChoisie = proprietes.get(choix);

        // Vérifie si le joueur possède toutes les propriétés du même groupe
        boolean possedeToutLeGroupe = true;
        for (Cases propriete : proprietes) {
            if (propriete.getGroupe().equals(proprieteChoisie.getGroupe()) && propriete.getProprietaire() != joueur) {
                possedeToutLeGroupe = false;
                break;
            }
        }

        if (possedeToutLeGroupe) {
            proprieteChoisie.acheterMaison(joueur);
        } else {
            System.out.println("Vous devez posséder toutes les propriétés du même groupe pour acheter une maison.");
        }
    }

    public void acheterHotel(Joueurs joueur) {
        List<Cases> proprietes = joueur.getProprietes();
        System.out.println("Sur quelle propriété voulez-vous acheter un hôtel ?");
        for (int i = 0; i < proprietes.size(); i++) {
            System.out.println((i + 1) + ". " + proprietes.get(i).getNom());
        }
        int choix = sc.nextInt() - 1;
        Cases proprieteChoisie = proprietes.get(choix);

        // Vérifie si la propriété a 4 maisons
        if (proprieteChoisie.getNbMaisons() == 4) {
            proprieteChoisie.acheterHotel(joueur);
        } else {
            System.out.println("Vous devez avoir 4 maisons sur cette propriété pour acheter un hôtel.");
        }
    }

    public void afficherOptionsAchat(Joueurs joueur, Cases caseActuelle) {
        if (joueur.possedeGroupeComplet(caseActuelle)) {
            int choix;
            do {
                System.out.println("Voulez-vous acheter une maison ou un hôtel sur cette propriété ?");
                System.out.println("1. Acheter une maison");
                System.out.println("2. Acheter un hôtel");
                System.out.println("3. Ne rien faire");
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        acheterMaison(joueur);
                        break;
                    case 2:
                        acheterHotel(joueur);
                        break;
                    default:
                        break;
                }
            } while (choix != 3);
        } else {
            System.out.println("Vous devez posséder toutes les propriétés d'un groupe pour acheter une maison ou un hôtel.");
        }
    }
}