package tp.monopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DesTest {

    @Test
    public void testLancerDes() {
        // Créez une instance de Des
        Des des = new Des();

        // Lancez les dés
        des.lancerDes();

        // Vérifiez que les valeurs des dés sont entre 1 et 6
        assertTrue(des.getDesUn() >= 1 && des.getDesUn() <= 6, "Le dé un devrait avoir une valeur entre 1 et 6 après le lancement");
        assertTrue(des.getDesDeux() >= 1 && des.getDesDeux() <= 6, "Le dé deux devrait avoir une valeur entre 1 et 6 après le lancement");
    }
}
