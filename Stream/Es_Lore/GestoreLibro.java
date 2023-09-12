package Ingegneria_del_Software.Stream.Es_Lore;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
 * implemenate una classe con: 
 * 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
 * 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib. 
 * 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
 * 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizione
 */

public class GestoreLibro {
    private List<Libro> l1 = Arrays.asList(new Libro("Harry Potter", 300, 15.6, "Fantast", "J.K Rowling"), 
    new Libro("Il codice da Vinci", 300, 8.90 ,"Thriller", "Dan Brown"),
    new Libro("Il nome della rosa", 400, 7.30, "Giallo", "Umberto Ego"),
    new Libro("Sherlock Holmes1", 250, 14.15, "Giallo", "Conan Doyle"), 
    new Libro("Sherlock Holmes2", 350, 15.10, "Giallo", "Conan Doyle"));

    public List<Double> estraiPesoLibri(){
        return l1.stream()
                .map(x->x.getPeso())
                .collect(Collectors.toList());
    }

    public List<Double> getSommaCostiPerGenere() {
        Map<String, Double> sommaPerGenere = l1.stream()
                .collect(Collectors.groupingBy(Libro::getGenere, Collectors.summingDouble(Libro::getCosto)));

        return sommaPerGenere.values().stream().collect(Collectors.toList());
    }

    public Libro getLibroGialloCostoMaggiore(){
        return l1.stream()
                 .filter(libro -> "Giallo".equals(libro.getGenere()))
                 .max(Comparator.comparingDouble(Libro::getCosto))
                 .get();
    }

    public List<String> getAutoriSenzaRipetizioni(){
        return l1.stream()
                 .map(Libro::getAutore)
                 .distinct()
                 .collect(Collectors.toList());
    }
}
