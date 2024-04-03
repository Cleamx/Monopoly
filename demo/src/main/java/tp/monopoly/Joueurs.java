package tp.monopoly;
import java.util.ArrayList;
import java.util.List;

public class Joueurs {
    String nom;
    int placement;
    int argent;
    int MAX_DEPLACEMENT = 40;
    private List<Cases> proprietes = new ArrayList<>();
    private int toursEnPrison = 0;
    private boolean enPrison = false;

    public Joueurs(String nom){
        this.nom = nom;
        this.argent = 1500;
        this.placement = 0;
    }

    public String getNom() {
        return this.nom;
    }

    public List<Cases> getProprietes() {
        return this.proprietes;
    }

    public int getPlacement(){
        return this.placement;
    }

    public int getArgent(){
        return this.argent;
    }

    public int setPlacement(int deplacement){
        this.placement += deplacement;
        if (this.placement >= MAX_DEPLACEMENT) {
            this.placement -= MAX_DEPLACEMENT;
            this.argent += 200;
            System.out.println("Vous avez passé la case départ, vous recevez 200 !");
        }
        return this.placement;
    }

    public void envoyerEnPrison(){
        this.placement = 10;
        this.enPrison = true;
        this.toursEnPrison = 0;

    }

    public boolean estEnPrison(){
        return this.enPrison;
    }

    public void essayerSortirDePrison() {
        // Crée une instance de la classe Des
        Des des = new Des();
        Menu menu = new Menu();
    
        // Lance les dés
        des.lancerDes();
        int desUn = des.getDesUn();
        int desDeux = des.getDesDeux();
    
        // Vérifie si le joueur a fait un double
        if (desUn == desDeux) {
            this.enPrison = false;
            System.out.println("Vous avez fait un double, vous sortez de prison !");
        } else if (this.argent >= 50 && menu.demanderPayerAmende()) {
            // Le joueur a la possibilité de payer une amende de 50 pour sortir de prison
            this.argent -= 50;
            this.enPrison = false;
            System.out.println("Vous avez payé une amende de 50, vous sortez de prison !");
        } else {
            this.toursEnPrison++;
            if (this.toursEnPrison >= 3) {
                // Le joueur est libéré après 3 tours en prison
                this.enPrison = false;
                System.out.println("Vous avez passé 3 tours en prison, vous êtes libéré !");
            }
        }
    }


    /**
    * Permet au joueur d'acheter une propriété.
    * Si la propriété n'a pas de propriétaire et que le joueur a assez d'argent, le joueur achète la propriété.
    * Le coût de la propriété est déduit de l'argent du joueur, la propriété est ajoutée à la liste des propriétés du joueur,
    * et le joueur est défini comme le nouveau propriétaire de la propriété.
    * Si la propriété a déjà un propriétaire ou si le joueur n'a pas assez d'argent, un message est affiché indiquant que le joueur ne peut pas acheter la propriété.
    *
    * @param propriete La propriété que le joueur souhaite acheter.
    */
    public void acheterPropriete(Cases propriete) {
        if (propriete.getProprietaire() == null && argent >= propriete.getCout()) {
            this.argent -= propriete.getCout();
            proprietes.add(propriete);
            propriete.setProprietaire(this);
            System.out.println("Vous avez bien acheté la propriété, il vous reste : " + this.argent );
        } else {
            if (propriete.getProprietaire() != null) {
                System.out.println("La propriété appartient déjà à quelqu'un d'autre.");
            } else {
                System.out.println("Vous n'avez pas assez d'argent pour acheter cette propriété.");
            }
        }
    }

}
