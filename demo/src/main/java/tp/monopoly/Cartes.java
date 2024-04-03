package tp.monopoly;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class Cartes {

    private int id;
    private String description;
    private String action;
    private int montant;
    private static List<Cartes> cartesChance = new ArrayList<>();
    private List<Cartes> cartesCommunaute = new ArrayList<>();

    public Cartes(int id, String description, String action, int montant) {
        this.id = id;
        this.description = description;
        this.action = action;
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public String getAction() {
        return action;
    }

    public int getMontant() {
        return montant;
    }
    public List<Cartes> getCartesChance(){
        return cartesChance;
    }
    
    public List<Cartes> getCartesCommunaute(){
        return cartesCommunaute;
    }

    public Cartes() {

    }

    public void initialise_Cartes() {
        try {
            String fichier = new String(Files.readAllBytes(Paths.get(getClass().getResource("cartes.json").toURI())));
            JSONObject obj = new JSONObject(fichier);
            JSONArray cartesChanceJson = obj.getJSONArray("cartes_chance");
            JSONArray cartesCommunauteJson = obj.getJSONArray("caisse_communaute");

            for (int i = 0; i < cartesChanceJson.length(); i++) {
                JSONObject carteJson = cartesChanceJson.getJSONObject(i);

                int id = carteJson.getInt("id");
                String description = carteJson.getString("description");
                String action = carteJson.getString("action");
                Integer montant = carteJson.getInt("montant");
                Cartes carte = new Cartes(id, description, action, montant);
                cartesChance.add(carte);
            }
            for (int i = 0; i < cartesCommunauteJson.length(); i++) {
                JSONObject carteJson = cartesCommunauteJson.getJSONObject(i);
                int id = carteJson.getInt("id");
                String description = carteJson.getString("description");
                String action = carteJson.getString("action");
                Integer montant = carteJson.getInt("montant");
                Cartes carte = new Cartes(id, description, action, montant);
                cartesCommunaute.add(carte);
            }
            System.err.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void piocherCarte(String type) {
    System.out.println("Vous piochez une carte " + type + " : ");
    Cartes deck = new Cartes();
    List<Cartes> deck_cartes = type.equals("Caisse de Communauté") ? deck.getCartesCommunaute() : deck.getCartesChance();

    if (!deck_cartes.isEmpty()) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(deck_cartes.size());
        Cartes carte_tire = deck_cartes.get(randomIndex);
        System.out.println(carte_tire.getDescription());
        
    } else {
        System.out.println("La liste de cartes est vide !");
    }
}

    @Override
    public String toString() {
        return "Cartes [id=" + id + ", description=" + description + ", action=" + action + ", montant=" + montant
                +"]";
    }
}
