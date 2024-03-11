package tp.monopoly;
public class Joueurs {
    String nom;
    int placement;
    int argent;
    int MAX_DEPLACEMENT = 39;

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

}
