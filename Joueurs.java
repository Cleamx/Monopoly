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

    public String getNom(){
        return this.nom;
    }

    public int getPlacement(){
        return this.placement;
    }

    public int getArgent(){
        return this.argent;
    }

    public int setArgent(int argent){
        this.argent += argent;
        return this.argent;
    }

    public int setPlacement(int placement){
        this.placement += placement;
        if (this.placement >= MAX_DEPLACEMENT) {
            this.placement -= MAX_DEPLACEMENT;
        }
        return this.placement;
    }

    public void retirerArgent(int montant) {
        if (montant > 0 && montant <= argent) {
            argent -= montant;
            System.out.println("Retrait de " + montant + " euros effectué avec succès.");
        } else {
            System.out.println("Impossible de retirer " + montant + " euros. Montant insuffisant.");
        }
    }

    public void ajouterArgent(int montant) {
        if (montant > 0) {
            argent += montant;
            System.out.println("Ajout de " + montant + " euros effectué avec succès.");
        } else {
            System.out.println("Impossible d'ajouter un montant négatif ou nul.");
        }
    }

}
