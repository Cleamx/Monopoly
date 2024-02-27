import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        int nbr_round, deplacement, case_actuelle;
        String couleurJ1, couleurJ2;
        Des des = new Des();

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Séléctionnez la couleur du joueur 1 (rouge, bleu, vert, ...) : ");
            couleurJ1 = sc.nextLine();
            Joueurs joueur1 = new Joueurs(couleurJ1);

            System.out.println("\nSéléctionnez la couleur du joueur 2 (rouge, bleu, vert, ...) : ");
            couleurJ2 = sc.nextLine();
            Joueurs joueur2 = new Joueurs(couleurJ2);

            Plateau plateau = new Plateau(joueur1, joueur2);
            plateau.setListeCases();

            System.out.println("\nChoisir le nombre de rounds :");
            nbr_round = sc.nextInt();
            System.out.println("Vous avez saisi : " + nbr_round);

            for (int i = 0; i < nbr_round; i++) {
                System.out.println("Le joueur 1 tire les dés");
                deplacement = des.Lancer();
                System.out.println("Les dés sont égaux à " + deplacement);
                
                case_actuelle = joueur1.setPlacement(deplacement);
                
                System.out.println("Le joueur1 est à la case " + plateau.getCases(case_actuelle) + "\n");

                System.out.println("Le joueur 2 tire les dés");
                deplacement = des.Lancer();
                System.out.println("Les dés sont égaux à " + deplacement);
                
                case_actuelle = joueur2.setPlacement(deplacement);
                
                System.out.println("Le joueur1 est à la case " + plateau.getCases(case_actuelle) + "\n");


            }
        }

    }
}
