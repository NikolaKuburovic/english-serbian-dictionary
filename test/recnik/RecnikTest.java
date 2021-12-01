package recnik;

import java.util.Map;
import org.junit.Test;

/**
 *
 * @author Nikola Kuburovic 1095 - Informacione tehnologije
 */
public class RecnikTest {

    /**
     * Test of unesiRec method, of class Recnik.
     */
    @Test
    public void testUnesiRec() {
        System.out.println("Metoda - unesiRec");
        String rec = "dictionary";
        String prevod = "recnik";
        Recnik instance = new Recnik();
        instance.unesiRec(rec, prevod);
        System.out.println(instance.getRecnik().get(rec));
        System.out.println("------------------");

    }

    /**
     * Test of ukloniRec method, of class Recnik.
     */
    @Test
    public void testUkloniRec() {
        System.out.println("Metoda - ukloniRec");
        String rec = "line";
        String prevod = "linija";
        Recnik instance = new Recnik();
        instance.unesiRec(rec, prevod);
        System.out.println(instance.getRecnik().get(rec));
        instance.ukloniRec(rec);
        System.out.println(instance.getRecnik().get(rec));
        System.out.println("------------------");

    }

    /**
     * Test of getRecnik method, of class Recnik.
     */
    @Test
    public void testGetRecnik() {
        System.out.println("Metoda - getRecnik");
        Recnik instance = new Recnik();
        Map result = instance.getRecnik();
        System.out.println(result);
        System.out.println("------------------");
    }

    /**
     * Test of ucitajRecnik method, of class Recnik.
     */
    @Test
    public void testUcitajRecnik() {
        System.out.println("Metoda - ucitajRecnik");
        Recnik instance = new Recnik();
        instance.ucitajRecnik();
        System.out.println(instance);
        System.out.println("------------------");
    }

    /**
     * Test of snimiRecnik method, of class Recnik.
     * Napomena:
     * Da bi test dao dokaz da metoda snima trenutno stanje recnika, potrebno
     * je sa svakim novim testiranjem da se unesu nove vrednosti i za promenljivu
     * "rec" i za promenljivu "prevod". Moguce je i za vec postojecu englesku rec
     * dodati novi prevod.
     */
    @Test
    public void testSnimiRecnik() {
        System.out.println("Metoda - snimiRecnik");
        Recnik instance = new Recnik();
        System.out.println("Pre dodavanja novog prevoda: " + instance.getRecnik().get("argument"));
        String rec = "argument";
        String prevod = "дискусија";
        instance.unesiRec(rec, prevod);
        instance.snimiRecnik();
        System.out.println("Posle dodavanja novog prevoda: " + instance.getRecnik().get("argument"));
        System.out.println("------------------");
    }
}//kraj RecnikTest