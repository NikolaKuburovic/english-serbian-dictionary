package recnik;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikola Kuburovic 1095
 */
public class Recnik {

    private Map<String, ArrayList<String>> recnikMapa;

    /**
     * Prazan konstruktor
     */
    public Recnik() {
        recnikMapa = new TreeMap<String, ArrayList<String>>();
        ucitajRecnik();
    }

    /**
     * Metoda pomocu koje se unosi nova rec u niz listu, a zatim i u mapu.
     *
     * @param rec
     * @param prevod
     */
    public void unesiRec(String rec, String prevod) {

        if (recnikMapa.containsKey(rec)) {
            ArrayList<String> a1 = recnikMapa.get(rec);
            if(!a1.contains(prevod)){
                a1.add(prevod);
            }
        } else {
            ArrayList<String> a1 = new ArrayList<String>();
            a1.add(prevod);
            recnikMapa.put(rec, a1);
        }
    }//kraj metode unesiRec

    /**
     * Metoda pomocu koje se uklanja rec iz mape
     *
     * @param rec
     */
    public void ukloniRec(String rec) {
        if (recnikMapa.containsKey(rec)) {
            recnikMapa.remove(rec);
        } else {
            JOptionPane.showMessageDialog(null, "Не може се уклонити реч која"
                    + " не постоји у речнику", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }//kraj metode ukloniRec

    /**
     * Metoda koja vraca recnik mapu
     *
     * @return
     */
    public Map<String, ArrayList<String>> getRecnik() {
        return recnikMapa;
    }

    /**
     * Metoda pomocu koje se podaci iz fajla prebacuju u mapu
     */
    public void ucitajRecnik() {
        try {
            FileInputStream fis = new FileInputStream("recnik.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            recnikMapa = (Map<String, ArrayList<String>>) ois.readObject();
            ois.close();

        } catch (Exception e) {
        }
    }//kraj metode ucitajRecnik

    /**
     * Metoda pomocu koje se sadrzaj mape snima u fajl
     */
    public void snimiRecnik() {
        try {
            FileOutputStream fos = new FileOutputStream("recnik.ser");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(recnikMapa);
            os.close();

        } catch (Exception e) {
        }
    }//kraj metode snimiRecnik

    @Override
    public String toString() {
        return recnikMapa.toString();
    }
}//kraj Recnik