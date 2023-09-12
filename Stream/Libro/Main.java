package Ingegneria_del_Software.Stream.Libro;

// import W3_Learning.Java.Stream.Libro.Libro;
// import W3_Learning.Java.Stream.Libro.Libreria;

import java.util.*;

public class Main {
    public static void main(String[] argc){
        // Esempio di utilizzo della classe GestoreLibri
        List<Libro> libri = new ArrayList<>();
        libri.add(new Libro("Il nome della rosa", "Umberto Ego", "Giallo", 7.30, 400));
        libri.add(new Libro("Il codice da Vinci", "Dan Brown", "Thriller" ,8.90, 300));
        libri.add(new Libro("Harry Potter e la pietra filosofale",  "J.K. Rowling", "Fantasy" ,9.50, 300));
        libri.add(new Libro("Sherlock Holmes 1", "Conan Doyle", "Giallo", 14.15, 250));
        libri.add(new Libro("Sherlock Holmes 2", "Conan Doyle", "Giallo", 15.10, 350));
        // Aggiungere i libri alla lista "libri"

        Libreria gestoreLibri = new Libreria(libri);

        // Test dei metodi
        List<Double> pesiLibri = gestoreLibri.pesiLibri(libri);
        System.out.println("Pesi dei libri: " + pesiLibri);

        List<Double> sommaCostiPerGenere = gestoreLibri.costiPerGenere(libri);
        System.out.println("Somma dei costi per genere: " + sommaCostiPerGenere);

        // Libro libroGialloCostoMaggiore = gestoreLibri.getLibroConCostoMaggioreDelGenere("Giallo");
        // System.out.println("Libro Giallo con costo maggiore: " + libroGialloCostoMaggiore);

        Libro libroGialloCostoMaggiore = gestoreLibri.getLibroConCostoMaggioreDelGenere();
        if (libroGialloCostoMaggiore != null) {
            System.out.println("Libro Giallo con costo maggiore: " + libroGialloCostoMaggiore.getTitolo());
        } else {
            System.out.println("Nessun libro Giallo presente.");
        }

        List<String> autoriSenzaRipetizione = gestoreLibri.getAutoriSenzaRipetizione();
        System.out.println("Autori senza ripetizione: " + autoriSenzaRipetizione);
    }
}
