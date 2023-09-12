// Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
// implemenate una classe con: 
// 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
// 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun 
//    genere di libri presenti in lib. 
// 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
// 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizioni

package W3_Learning.Java.Stream.Record.Libro;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc){
        List<Libro> lib = List.of(new Libro("Harry Potter", "J.K Rowling", "Fantasy", 15.6, 300), 
                                 new Libro("Il codice da Vinci", "Dan Brown", "Thriller" ,8.90, 300),
                                 new Libro("Il nome della rosa", "Umberto Ego", "Giallo", 7.30, 400),
                                 new Libro("Sherlock Holmes 1", "Conan Doyle", "Giallo", 14.15, 250), 
                                 new Libro("Sherlock Holmes 2", "Conan Doyle", "Giallo", 15.10, 350));

        System.out.println("Lista Libri:");
        for(Libro l : lib){
            System.out.println(l);
        }                         

        System.out.println("\nRestituisce una lista dei pesi dei libri presenti in lib (metodo1):");
        for(Double l : metodo1(lib)){
            System.out.println(l);
        }         
        
        System.out.println("\nRestituisce una lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib (metodo2):");
        for(Double l : metodo2(lib)){
            System.out.println(l);
        }

        System.out.println("\nRestituisce il libro di genere Giallo, che ha il costo maggiore (metodo3):\n" + metodo3(lib));

        System.out.println("\nRestitusice la lista di autori delle istanze di lib senza ripetizioni (metodo4):");
        for(String l : metodo4(lib)){
            System.out.println(l);
        }
    }

    // Un metodo che restituisce una lista dei pesi dei libri presenti in lib
    static List<Double> metodo1(List<Libro> lib){
        return lib.stream()
                  .map(l -> l.peso())
                  .collect(Collectors.toList());
    }

    // Un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib
    static List<Double> metodo2(List<Libro> lib){
        Map<String, Double> sommaPerGenere = lib.stream()
                                                .collect(Collectors.groupingBy(Libro::genere, Collectors.summingDouble(Libro::costo)));

        return sommaPerGenere.values().stream().collect(Collectors.toList());
    }

    // Un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore
    static Libro metodo3(List<Libro> lib){
        return lib.stream()
                  .filter(l -> l.genere() == "Giallo")
                  .max(Comparator.comparingDouble(Libro::costo))
                  .get();
    }

    // Un metodo che restitusice la lista di autori delle istanze di lib senza ripetizioni
    static List<String> metodo4(List<Libro> lib){
        return lib.stream()
                  .map(l -> l.autore())
                  .distinct()
                  .toList();
    }
}
