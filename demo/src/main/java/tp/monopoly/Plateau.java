package tp.monopoly;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Plateau {
    ArrayList<Cases> liste = new ArrayList<Cases>();
    int CASES_MONOPOLY = 40;
    Joueurs joueur1, joueur2;
    

    public Plateau(Joueurs joueur1, Joueurs joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        initialise_Cases();
    }


    /**
    * Initialise les cases du plateau à partir d'un fichier JSON.
    * Le fichier JSON doit contenir un tableau de "Groupes", chaque groupe contenant un tableau d'"Emplacements".
    * Chaque emplacement doit avoir une "Propriete" (nom), un "Cout", et une "Position".
    * Pour chaque emplacement, une nouvelle case est créée et ajoutée à la liste des cases du plateau.
    */
    private void initialise_Cases() {
        String fichier;
        try {
            fichier = new String(Files.readAllBytes(Paths.get(getClass().getResource("propriete.json").toURI())));
            JSONObject obj = new JSONObject(fichier);
            JSONArray groupes = obj.getJSONArray("Groupes");
           
            for (int i = 0; i < groupes.length(); i++) {

                JSONObject groupe = groupes.getJSONObject(i);
                JSONArray emplacements = groupe.getJSONArray("Emplacements");
                System.out.println(groupe.getString("Nom"));

                for (int j = 0; j < emplacements.length(); j++) {

                    JSONObject emplacement = emplacements.getJSONObject(j);
                    String nom = emplacement.getString("Propriete");
                    int cout = emplacement.getInt("Cout");
                    int position = emplacement.getInt("Position");
                    Cases cases = new Cases(position, nom, cout, groupe.getString("Nom"));
                    this.liste.add(cases);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    /**
    * Récupère la case à une position spécifique sur le plateau.
    *
    * @param position La position de la case à récupérer.
    * @return La case à la position spécifiée, ou null si aucune case n'est trouvée à cette position.
    */
    public Cases getCases(int position) {
        for (Cases c : this.liste) {
            if (c.getPosition() == position) {
                return c;
            }
        }
        return null; 
    }


    @Override
    public String toString() {
        return "Cases [liste=" + liste + "]";
    }
    
}
