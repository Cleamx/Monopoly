package tp.monopoly;
import java.util.ArrayList;
import java.util.List;

public class Joueurs {
    String nom;
    int placement;
    int argent;
    int MAX_DEPLACEMENT = 40;
    private List<Cases> proprietes = new ArrayList<>();

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
