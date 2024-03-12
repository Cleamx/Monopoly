package tp.monopoly;
import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {

        int nbr_round, deplacement, case_actuelle, choix;
        String nomJ1, nomJ2;
        Des des = new Des();

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Entrez le nom du joueur 1 : ");
            nomJ1 = sc.nextLine();
            Joueurs joueur1 = new Joueurs(nomJ1);

            System.out.println("\nEntrez le nom  du joueur 2 : ");
            nomJ2 = sc.nextLine();
            Joueurs joueur2 = new Joueurs(nomJ2);

            Plateau plateau = new Plateau(joueur1, joueur2);

            System.out.println("\nChoisir le nombre de rounds :");
            nbr_round = sc.nextInt();
            System.out.println("Vous avez saisi : " + nbr_round);


            for (int i = 0; i < nbr_round; i++) {
                System.out.println("Le "+ joueur1.getNom() +" tire les dés");
                deplacement = des.Lancer();
                System.out.println("Les dés sont égaux à " + deplacement);
                
                case_actuelle = joueur1.setPlacement(deplacement);
                System.out.println("Le " + joueur1.getNom() + " est à la case " + plateau.getCases(case_actuelle) + "\n");
                System.out.println("\nVoulez vous acheter cette cases : ");
                System.out.println("\n1. Oui");
                System.out.println("\n2. Non");
                choix = sc.nextInt();
                if(choix == 1){
                    joueur1.acheterPropriete(plateau.getCases(case_actuelle));
                }
                else if (choix == 2){
                    continue;
                }

                System.out.println("Le " + joueur2.getNom() + " tire les dés");
                deplacement = des.Lancer();
                System.out.println("Les dés sont égaux à " + deplacement);
                
                case_actuelle = joueur2.setPlacement(deplacement);
                
                System.out.println("Le " + joueur2.getNom() + " est à la case " + plateau.getCases(case_actuelle) + "\n");
                System.out.println("\nVoulez vous acheter cette cases : ");
                System.out.println("\n1. Oui");
                System.out.println("\n2. Non");
                choix = sc.nextInt();
                if(choix == 1){
                    joueur2.acheterPropriete(plateau.getCases(case_actuelle));
                }
                else if (choix == 2){
                    continue;
                }


            }
        }

    }
}
