package tp.monopoly;

public class CaseAllerEnPrison extends CaseSpeciale{
    public CaseAllerEnPrison(int id, String nom, int cout, String groupe, int[] loyer, int coutMaison, int coutHotel){
        super(id, nom, cout, groupe, loyer, coutMaison, coutHotel);
    }

    @Override
    public void appliquerEffet(Joueurs joueurs){
        joueurs.envoyerEnPrison();
    }
    
}
