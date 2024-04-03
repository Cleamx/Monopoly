package tp.monopoly;

public class CaseImpotsSurLeRevenu extends CaseSpeciale{
    public CaseImpotsSurLeRevenu(int id, String nom, int cout, String groupe){
        super(id, nom, cout, groupe);
    }

    @Override
    public void appliquerEffet(Joueurs joueurs){
        int montantImpots = 200; // Définissez le montant à déduire
        joueurs.deduireArgent(montantImpots);
        System.out.println("vous etes tombe sur une case impot ou taxe de luxe , vous avez paye " + montantImpots + " il vous reste : " + joueurs.getArgent());
    }
}