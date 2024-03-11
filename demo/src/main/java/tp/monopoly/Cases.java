package tp.monopoly;
public class Cases {
    String nom;
    int cout;
    int id;
    String groupe;

    public Cases(int id, String nom, int cout, String groupe){
        this.id = id;
        this.nom = nom;
        this.cout = cout;  
        this.groupe = groupe;
    }

    public int getPosition() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Cases [nom = " + nom + ", cout = " + cout + ", id = " + id + ", groupe = " + groupe + "]";
    }


    
}
