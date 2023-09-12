// Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
// implemenate una classe con: 
// 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
// 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun 
//    genere di libri presenti in lib. 
// 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
// 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizioni

package Ingegneria_del_Software.Stream.Libro;

import java.util.*;
import java.util.stream.Collectors;

public class Libreria {
    private List<Libro> lib;

    public Libreria(List<Libro> lib){
        this.lib = lib;
    }

    // 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib.
    public List<Double> pesiLibri(List<Libro> lib){
        return lib.stream()
                  .map(Libro::getPeso)
                  .collect(Collectors.toList());
    }

    // 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib. 
    public List<Double> costiPerGenere(List<Libro> lib){
        return lib.stream()
                .collect(Collectors.groupingBy(Libro::getGenere, Collectors.summingDouble(Libro::getCosto)))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    // 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
    public Libro getLibroConCostoMaggioreDelGenere(){
        return lib.stream()
                 .filter(libro -> "Giallo".equals(libro.getGenere()))
                 .max(Comparator.comparingDouble(Libro::getCosto))
                 .get();
    }

    // 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizioni
    public List<String> getAutoriSenzaRipetizione() {
        return lib.stream()
                .map(Libro::getAutore)
                .distinct()
                .collect(Collectors.toList());
    }
}
