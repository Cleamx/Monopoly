public class Propriete {
    private String nom;
    private int prix;
    private int loyer;
    private boolean estAchetable;
    private Joueurs proprietaire;

    public Propriete(String nom, int prix, int loyer) {
        this.nom = nom;
        this.prix = prix;
        this.loyer = loyer;
        this.estAchetable = true;
        this.proprietaire = null;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPrix() {
        return this.prix;
    }

    public int getLoyer() {
        return this.loyer;
    }

    public boolean getEstAchetable() {
        return this.estAchetable;
    }

    public Joueurs getProprietaire() {
        return this.proprietaire;
    }

    public void setProprietaire(Joueurs proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setEstAchetable(boolean estAchetable) {
        this.estAchetable = estAchetable;
    }

    public boolean acheterPropriete(Joueurs acheteur) {
        if (estAchetable && acheteur.getArgent() >= prix) {
            acheteur.retirerArgent(prix);
            proprietaire = acheteur;
            estAchetable = false;
            return true; // L'achat a réussi
        }
        return false; // L'achat a échoué
    }

    public void payerLoyer(Joueurs locataire) {
        if (!estAchetable && proprietaire != null && !proprietaire.equals(locataire)) {
            locataire.retirerArgent(loyer);
            proprietaire.ajouterArgent(loyer);
        }
    }

    public String toString() {
        return "Nom : " + this.nom + " | Prix : " + this.prix + " | Loyer : " + this.loyer + " | Est achetable : " + this.estAchetable + " | Proprietaire : " + this.proprietaire;
    }
    
}
