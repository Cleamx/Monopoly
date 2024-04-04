package tp.monopoly;
public class Cases {
    String nom;
    int cout;
    int id;
    String groupe;
    Joueurs proprietaire;
    private int maisons;
    private boolean hotel;
    private int[] loyer;
    private int coutMaison;
    private int coutHotel;

    public Cases(int id, String nom, int cout, String groupe, int[] loyer, int coutMaison, int coutHotel){
        this.id = id;
        this.nom = nom;
        this.cout = cout;  
        this.groupe = groupe;
        this.proprietaire = null;
        this.maisons = 0;
        this.hotel = false;
        this.loyer = loyer;
        this.coutMaison = coutMaison;
        this.coutHotel = coutHotel;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPosition() {
        return this.id;
    }
    
    public Joueurs getProprietaire() {
        return proprietaire;
    }

    public int getCout() {
        return cout;
    }

    public String getGroupe() {
        return groupe;
    }
    
    public void setProprietaire(Joueurs proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    public boolean estAchetable() {
        return proprietaire == null;
    }

    public int getLoyer() {
        return loyer[maisons];
    }

    public int getNbMaisons() {
        return maisons;
    }

    public boolean aHotel() {
        return hotel;
    }

    public int getCoutMaison() {
        return coutMaison;
    }

    public int getCoutHotel() {
        return coutHotel;
    }

    public void acheterMaison(Joueurs joueur) {
        if (maisons < 4) {
            if (joueur.getArgent() >= coutMaison) {
                maisons++;
                joueur.deduireArgent(coutMaison);
            } else {
                System.out.println("Vous n'avez pas assez d'argent pour acheter une maison.");
            }
        } else {
            System.out.println("Vous ne pouvez pas avoir plus de 4 maisons sur une propriété.");
        }
    }

    public void acheterHotel(Joueurs joueur) {
        if (hotel) {
            System.out.println("Vous ne pouvez pas acheter un autre hôtel sur cette propriété.");
        } else if (maisons == 4) {
            if (joueur.getArgent() >= coutHotel) {
                hotel = true;
                joueur.deduireArgent(coutHotel);
            } else {
                System.out.println("Vous n'avez pas assez d'argent pour acheter un hôtel.");
            }
        } else {
            System.out.println("Vous devez avoir 4 maisons pour acheter un hôtel.");
        }
    }

    public void payerLoyer(Joueurs joueur) {
        int loyerActuel;
        if (hotel) {
            loyerActuel = loyer[5];
            System.out.println("Vous avez payé le loyer d'un hôtel.");
        } else if (maisons > 0) {
            loyerActuel = loyer[maisons];
            System.out.println("Vous avez payé le loyer d'une maison.");
        } else {
            loyerActuel = loyer[0]; // loyer de base
            System.out.println("Vous avez payé le loyer de base.");
        }
        joueur.deduireArgent(loyerActuel);
    }
    @Override
    public String toString() {
        return "Cases [nom = " + nom + ", cout = " + cout + ", id = " + id + ", groupe = " + groupe + "]";
    }


    
}
