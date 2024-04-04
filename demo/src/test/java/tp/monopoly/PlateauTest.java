package tp.monopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlateauTest {

    @Test
    public void testInitialiseCases() {
        // Créez une instance de Plateau
        Plateau plateau = new Plateau(null, null);

        // Appelez une méthode publique qui appelle initialise_Cases
        plateau.initialise_Cases();

        // Vérifiez que liste n'est pas vide
        assertFalse(plateau.getListe().isEmpty(), "La liste ne devrait pas être vide après l'initialisation");
    }

}
