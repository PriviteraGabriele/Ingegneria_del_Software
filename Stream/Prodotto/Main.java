package Ingegneria_del_Software.Stream.Prodotto;

import java.util.*;

public class Main {
    public static void main(String[] argc){
        List<Prodotto> l = List.of(new Prodotto("p1", 5.0), 
                                   new Prodotto("p2", 10.0),
                                   new Prodotto("p3", 15.0),
                                   new Prodotto("p4", 20.0));

        System.out.println("Il costo totale dei prodotti che hanno un prezzo maggiore di 10: " + metodo1(l));
    }

    // Data una lista di prodotti, restituire il costo totale dei prodotti che hanno un prezzo maggiore di 10
    static double metodo1(List<Prodotto> lista){
        return lista.stream()
                .filter(p -> p.getPrice() > 10)
                .mapToDouble(p -> p.getPrice())
                .sum();
    }
}
