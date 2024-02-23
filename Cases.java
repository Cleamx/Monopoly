public class Cases {
    int num_cases;
    String nom;

    public Cases(int num_cases, String nom){
        this.num_cases = num_cases;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Cases [num_cases=" + num_cases + ", nom=" + nom + "]";
    }
    
}
