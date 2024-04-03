package tp.monopoly;

public class CaseImpotsSurLeRevenu extends CaseSpeciale{
    public CaseImpotsSurLeRevenu(int id, String nom, int cout, String groupe){
        super(id, nom, cout, groupe);
    }

    @Override
    public void appliquerEffet(Joueurs joueurs){
        int montantImpots = 200; // Définissez le montant à déduire
        joueurs.deduireArgent(montantImpots);
    }
}
