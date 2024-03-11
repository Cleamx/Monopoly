package tp.monopoly;
public class Cases {
    String nom;
    int cout;
    int id;
    String groupe;
    Joueurs proprietaire;

    public Cases(int id, String nom, int cout, String groupe){
        this.id = id;
        this.nom = nom;
        this.cout = cout;  
        this.groupe = groupe;
        this.proprietaire = null;
    }

    public int getPosition() {
        return this.id;
    }
    
    public Joueurs getProprietaire() {
        return proprietaire;
    }
    
    public void setProprietaire(Joueurs proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    public boolean estAchetable() {
        return proprietaire == null;
    }


    @Override
    public String toString() {
        return "Cases [nom = " + nom + ", cout = " + cout + ", id = " + id + ", groupe = " + groupe + "]";
    }


    
}
