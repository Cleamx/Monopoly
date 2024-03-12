package tp.monopoly;
import java.util.ArrayList;
import java.util.List;

public class Joueurs {
    String nom;
    int placement;
    int argent;
    int MAX_DEPLACEMENT = 39;
    private List<Cases> proprietes = new ArrayList<>();

    public Joueurs(String nom){
        this.nom = nom;
        this.argent = 1500;
        this.placement = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPlacement(){
        return this.placement;
    }

    public int setPlacement(int deplacement){
        this.placement += deplacement;
        if (this.placement >= MAX_DEPLACEMENT) {
            this.placement -= MAX_DEPLACEMENT;
            this.argent += 200;
        }
        return this.placement;
    }

    public void acheterPropriete(Cases propriete) {
        if (propriete.getProprietaire() == null && argent >= propriete.getCout()) {
            this.argent -= propriete.getCout();
            proprietes.add(propriete);
            propriete.setProprietaire(this);
            System.out.println("Vous avez bien acheté la propriété, il vous reste : " + this.argent );
        } else {
            System.out.println("Vous ne pouvez pas acheter cette propriété.");
        }
    }

}
