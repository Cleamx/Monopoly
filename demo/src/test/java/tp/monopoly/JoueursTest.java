package tp.monopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoueursTest {

    @Test
    public void testAcheterPropriete() {
        // Créez une instance de Joueurs
        Joueurs joueur = new Joueurs("Test");

        // Créez une instance de Cases
        Cases propriete = new Cases(1, "Test", 100, "Test");

        // Appelez acheterPropriete
        joueur.acheterPropriete(propriete);

        // Vérifiez que le joueur a bien acheté la propriété
        assertTrue(joueur.getProprietes().contains(propriete), "Le joueur devrait posséder la propriété après l'achat");
        assertEquals(joueur, propriete.getProprietaire(), "Le joueur devrait être le propriétaire de la propriété après l'achat");
        assertEquals(1400, joueur.getArgent(), "Le joueur devrait avoir 1400 d'argent après l'achat");

        // Essayez d'acheter une propriété que le joueur ne peut pas se permettre
        Cases proprieteChere = new Cases(2, "Test", 2000, "Test");
        joueur.acheterPropriete(proprieteChere);

        // Vérifiez que le joueur n'a pas acheté la propriété
        assertFalse(joueur.getProprietes().contains(proprieteChere), "Le joueur ne devrait pas posséder la propriété après un achat échoué");
        assertNull(proprieteChere.getProprietaire(), "La propriété ne devrait pas avoir de propriétaire après un achat échoué");
    }

    @Test
    public void testEnvoyerEnPrison() {
        // Créez une instance de Joueurs
        Joueurs joueur = new Joueurs("Test");

        // Appelez envoyerEnPrison
        joueur.envoyerEnPrison();

        // Vérifiez que le joueur est en prison
        assertTrue(joueur.estEnPrison(), "Le joueur devrait être en prison après avoir été envoyé en prison");
        assertEquals(10, joueur.getPlacement(), "Le joueur devrait être à la position 10 après avoir été envoyé en prison");
    }

}