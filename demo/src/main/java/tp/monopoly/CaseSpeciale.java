package tp.monopoly;

public abstract class CaseSpeciale extends Cases{
    public CaseSpeciale(int id, String nom, int cout, String groupe){
        super(id, nom, cout, groupe);
    }
    public abstract void appliquerEffet(Joueurs joueurs);
    
}
