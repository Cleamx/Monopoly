package tp.monopoly;

public abstract class CaseSpeciale extends Cases{
    public CaseSpeciale(int id, String nom, int cout, String groupe, int[] loyer, int coutMaison, int coutHotel){
        super(id, nom, cout, groupe, new int[0], 0, 0);
    }
    public abstract void appliquerEffet(Joueurs joueurs);
    
}
