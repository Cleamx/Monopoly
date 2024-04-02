package tp.monopoly;

public class Des {
    int lancer_nbr;

    private int desUn;
    private int desDeux;

    public int getDesUn() {
        return desUn;
    }

    public int getDesDeux() {
        return desDeux;
    }

    public void lancerDes() {
        this.desUn = (int)(Math.random() * 6) + 1;;
        this.desDeux = (int)(Math.random() * 6) + 1;;
    }

}
