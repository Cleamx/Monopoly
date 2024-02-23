public class Joueurs {
    String couleur;
    int placement = 0;
    int MAX_DEPLACEMENT = 39;

    public Joueurs(String couleur){
        this.couleur = couleur;
    }

    public int setPlacement(int placement){
        this.placement += placement;
        if (this.placement >= MAX_DEPLACEMENT) {
            this.placement -= MAX_DEPLACEMENT;
        }
        return this.placement;
    }
}
