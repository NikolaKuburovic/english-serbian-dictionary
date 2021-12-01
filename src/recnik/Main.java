package recnik;

import java.io.IOException;
import javax.swing.JFrame;
import recnikGui.RecnikGuiFrame;

/**
 * CS112 - Projektni zadatak - Rečnik<br /> <strong>Zadatak:</strong> Napisati 
 * program za rečnik koji za svaku reč može da sadrži više prevoda.
 * Program treba da obezbedi: čitanje rečnika iz datoteke, snimanje rečnika u 
 * datoteku, dodavanje, brisanje i pregled reči i prevoda, pretragu rečnika.
 * Implementirati povezanu listu (ili sličnu strukturu podataka) i izvršiti 
 * obradu svih izuzetaka.
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class Main {

    /**
     * Pazan konstruktor
     */
    public Main() {
    }

    /**
     * @param args the command line arguments
     * @throws IOException  
     */
    public static void main(String[] args) throws IOException {

        RecnikGuiFrame frame = new RecnikGuiFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}//kraj Main