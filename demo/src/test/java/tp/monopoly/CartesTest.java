package tp.monopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartesTest {

    @Test
    public void testConstructor() {
        // Créez une instance de Cartes
        Cartes carte = new Cartes(1, "Test", "recevoir", 100);

        assertEquals("Test", carte.getDescription(), "La description devrait être 'Test'");
        assertEquals("recevoir", carte.getAction(), "L'action devrait être 'recevoir'");
        assertEquals(100, carte.getMontant(), "Le montant devrait être 100");
    }

    @Test
    public void testInitialiseCartes() {
        // Créez une instance de Cartes
        Cartes carte = new Cartes();

        // Initialisez les cartes
        carte.initialise_Cartes();

        // Vérifiez que les cartes ont été initialisées
        assertFalse(carte.getCartesChance().isEmpty(), "La liste des cartes de chance ne devrait pas être vide");
        assertFalse(carte.getCartesCommunaute().isEmpty(), "La liste des cartes de communauté ne devrait pas être vide");
    }

    @Test
    public void testPiocherCarte() {
        // Créez une instance de Cartes
        Cartes carte = new Cartes();

        // Piochez une carte
        int montant = carte.piocherCarte("Caisse de Communauté");

        // Vérifiez que le montant est correct
        assertTrue(montant != 0, "Le montant devrait être supérieur ou égal à 0");
    }
}
