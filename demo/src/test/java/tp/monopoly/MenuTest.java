package tp.monopoly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MenuTest {

    @Test
    public void testConstructor() {
        Menu menu = new Menu();
        assertNotNull(menu);
    }

    @Test
    void testAfficherPosition() {
        
    }

    @Test
    void testAfficherResultatDes() {
        
    }

    @Test
    void testAfficherTour() {
        
    }

    @Test
    void testDemanderAchat() {
        String input = "1\n"; // L'utilisateur choisit "Oui"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Menu menu = new Menu();
        boolean veutAcheter = menu.demanderAchat();
        assertEquals(true, veutAcheter);
    }

    @Test
    void testDemanderNomJoueur() {
        String input = "John Doe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Menu menu = new Menu();
        String nom = menu.demanderNomJoueur(1);
        assertEquals("John Doe", nom);
    }

    @Test
    void testDemanderNombreRounds() {
        String input = "10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Menu menu = new Menu();
        int rounds = menu.demanderNombreRounds();
        assertEquals(10, rounds);
    }
}