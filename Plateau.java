import java.util.ArrayList;

public class Plateau {
    ArrayList<Cases> liste = new ArrayList<Cases>();
    int CASES_MONOPOLY = 40;
    Joueurs joueur1, joueur2;
    

    public Plateau(Joueurs joueur1, Joueurs joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void setListeCases() {
        
        for (int i = 0; i < CASES_MONOPOLY; i++) {
            String nom_cases = "Cases";
            nom_cases = nom_cases.concat(String.valueOf(i));
            Cases cases_plateau = new Cases(i,nom_cases);
            this.liste.add(cases_plateau);
        }
    }

    public Cases getCases(int num_deplacement) {
        if (num_deplacement >= 0 && num_deplacement < liste.size()) {
            return liste.get(num_deplacement);
        } else {
            return null; 
        }
    }

    @Override
    public String toString() {
        return "Cases [liste=" + liste + "]";
    }
    
}
