package Ingegneria_del_Software.Stream.Es_Lore;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creiamo una nuova istanza della classe GestoreLibri
        GestoreLibro gestoreLibri = new GestoreLibro();

        // Test dei metodi
        List<Double> pesiLibri = gestoreLibri.estraiPesoLibri();
        System.out.println("Pesi dei libri: " + pesiLibri);

        List<Double> sommaCostiPerGenere = gestoreLibri.getSommaCostiPerGenere();
        System.out.println("Somma dei costi per genere: " + sommaCostiPerGenere);

        Libro libroGialloCostoMaggiore = gestoreLibri.getLibroGialloCostoMaggiore();
        if (libroGialloCostoMaggiore != null) {
            System.out.println("Libro Giallo con costo maggiore: " + libroGialloCostoMaggiore.getTitolo());
        } else {
            System.out.println("Nessun libro Giallo presente.");
        }

        List<String> autoriSenzaRipetizione = gestoreLibri.getAutoriSenzaRipetizioni();
        System.out.println("Autori senza ripetizione: " + autoriSenzaRipetizione);
    }
}
