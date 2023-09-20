package Ingegneria_del_Software.Stream.Record.LibroFacile;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] argc){
        List<Libro> lib = List.of(new Libro("Harry Potter", "J.K Rowling", "Fantasy", 15.6, 300), 
                                 new Libro("Il codice da Vinci", "Dan Brown", "Thriller" ,8.90, 300),
                                 new Libro("Il nome della rosa", "Umberto Ego", "Giallo", 7.30, 400),
                                 new Libro("Sherlock Holmes 1", "Conan Doyle", "Giallo", 14.15, 250), 
                                 new Libro("Sherlock Holmes 2", "Conan Doyle", "Giallo", 15.10, 350));
    
        System.out.println("Restituire una lista contenente i libri di genere Giallo col costo minore di 15 (metodo1): ");
        for(Libro l : metodo1(lib)){
            System.out.println(l);
        }

        System.out.println("\nRestituire una lista contenente i diversi generi (senza ripetizioni) (metodo2): ");
        for(String l : metodo2(lib)){
            System.out.println(l);
        }

        System.out.println("\nRestituire il libro di genere Giallo col costo minore (metodo3): ");
        System.out.println(metodo3(lib));

        System.out.println("\nRestituire la somma del costo di tutte le istanze di libro (metodo4): " + metodo4(lib));
        
    }

    // Restituire una lista contenente i libri di genere Giallo col costo minore di 15
    static List<Libro> metodo1(List<Libro> lib){
        return lib.stream()
                  .filter(x -> x.genere() == "Giallo")
                  .filter(x -> x.costo() < 15)
                  .toList();
    }

    // Restituire una lista contenente i diversi generi (senza ripetizioni)
    static List<String> metodo2(List<Libro> lib){
        List<String> rit = lib.stream()
                              .map(x -> x.genere())
                              .distinct()
                              .toList();

        return rit;
    }

    // Restituire il libro di genere Giallo col costo minore
    static Libro metodo3(List<Libro> lib){
        return lib.stream()
                  .filter(x -> x.genere() == "Giallo")
                  .min(Comparator.comparingDouble(Libro::costo))
                  .get();
    }

    // Restituire la somma del costo di tutte le istanze di libro
    static Double metodo4(List<Libro> lib){
        return lib.stream()
                  .mapToDouble(x -> x.costo())
                  .sum();
    }
    
}
