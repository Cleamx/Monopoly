package tp.monopoly;

public class CaseAllerEnPrison extends CaseSpeciale{
    public CaseAllerEnPrison(int id, String nom, int cout, String groupe){
        super(id, nom, cout, groupe);
    }

    @Override
    public void appliquerEffet(Joueurs joueurs){
        joueurs.envoyerEnPrison();
    }
    
}
