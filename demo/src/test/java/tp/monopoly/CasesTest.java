package tp.monopoly;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CasesTest {

    @Test
    public void testConstructor() {
        // Créez une instance de Cases
        int[] loyer = {10, 20, 30, 40, 50, 60};
        Cases propriete = new Cases(1, "Test", 100, "Test", loyer, 50, 100);

        // Vérifiez les valeurs initiales
        assertEquals(1, propriete.getPosition(), "La position devrait être 1");
        assertEquals("Test", propriete.getNom(), "Le nom devrait être 'Test'");
        assertEquals(100, propriete.getCout(), "Le coût devrait être 100");
        assertEquals("Test", propriete.getGroupe(), "Le groupe devrait être 'Test'");
        assertNull(propriete.getProprietaire(), "Le propriétaire devrait être null");
        assertEquals(10, propriete.getLoyer(), "Le loyer devrait être 10");
        assertEquals(0, propriete.getNbMaisons(), "Le nombre de maisons devrait être 0");
        assertFalse(propriete.aHotel(), "Il ne devrait pas y avoir d'hôtel");
        assertEquals(50, propriete.getCoutMaison(), "Le coût de la maison devrait être 50");
        assertEquals(100, propriete.getCoutHotel(), "Le coût de l'hôtel devrait être 100");
    }

}