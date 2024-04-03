package tp.monopoly;

public class CaseTaxeDeLuxe extends CaseSpeciale{
    public CaseTaxeDeLuxe(int id, String nom, int cout, String groupe){
        super(id, nom, cout, groupe);
    }

    @Override
    public void appliquerEffet(Joueurs joueurs){
        int montantTaxe = 100; // Définissez le montant à déduire
        joueurs.deduireArgent(montantTaxe);
        System.out.println("vous etes tombe sur une case impot ou taxe de luxe , vous avez paye " + montantTaxe + " il vous reste : " + joueurs.getArgent());
    }
}
