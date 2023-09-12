package W3_Learning.Java.Stream.Record.Prodotto;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] argc){
        List<Prodotto> lista = List.of(new Prodotto("p1", 5.0), 
                                       new Prodotto("p2", 10.0),
                                       new Prodotto("p3", 15.0), 
                                       new Prodotto("p4", 20.0));

        System.out.println("Costo totale dei prodotti che hanno un prezzo maggiore di 10 (metodo1): " + metodo1(lista) + "\n");

        System.out.print("Restituire il prodotto più economico (metodo2): ");
        metodo2(lista);

        System.out.println("\nRestituire la somma totale dei costi dei 2 prodotti meno cari (metodo3): " + metodo3(lista) + "\n");
    }

    // Data una lista di prodotti, restituire il costo totale dei prodotti che hanno un prezzo maggiore di 10.
    public static double metodo1(List<Prodotto> lista){
        return lista.stream()
                    .filter(p -> p.prezzo() > 10)
                    .mapToDouble(p -> p.prezzo())
                    .sum();
    }

    public static double minimo(List<Prodotto> lista){
        return lista.stream()
                    .map(p -> p.prezzo())
                    .min(Comparator.naturalOrder())
                    .orElse(0.0);
    }

    // Restituire il prodotto più economico
    public static void metodo2(List<Prodotto> lista){
        lista.stream()
             .filter(p -> p.prezzo() == minimo(lista))
             .forEach(p -> System.out.println(p));
    }

    // Restituire la somma totale dei costi dei 2 prodotti meno cari
    public static double metodo3(List<Prodotto> lista){
        double somma = lista.stream()
                             .filter(p -> p.prezzo() > minimo(lista))
                             .map(p -> p.prezzo())
                             .min(Comparator.naturalOrder())
                             .orElse(0.0);

        return somma += minimo(lista);
    }

    

    
}
