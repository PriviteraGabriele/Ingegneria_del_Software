package Ingegneria_del_Software.Stream.Record.People;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc){
        int min = 20, max = 40;
        List<People> lista = List.of(new People("p1", 10, "n1"),
                                     new People("p2", 20, "n1"),
                                     new People("p3", 30, "n2"),
                                     new People("p4", 40, "n3"),
                                     new People("p5", 50, "n3"));

        System.out.println("Lista People: ");
        for(People p : lista){
            System.out.println(p);
        }

        System.out.println("\nRestituisce una lista di istanze di persona costituita da elementi di gente che hanno età compresa fra min e max (metodo1): ");
        for(People p : metodo1(lista, min, max)){
            System.out.println(p);
        }

        System.out.println("\nSomma delle età di tutte le persone nella lista (metodo2): " + metodo2(lista));

        System.out.println("\nLista di nazioni senza ripetizioni presenti in una lista di gente (metodo3): ");
        for(String n : metodo3(lista)){
            System.out.println(n);
        }

        System.out.println("\nRestituire una mappa contenente le coppie (nome persone - nazione) (metodo4): " + metodo4(lista));
    }

    // Creare un metodo che prende in ingresso due parametri, min e max, e restituisce una lista di 
    // istanze di persona costituita da elementi di gente che hanno età compresa fra min e max.
    public static List<People> metodo1(List<People> lista, int min, int max){
        return lista.stream()
                    .filter(p -> p.eta() >= min)
                    .filter(p -> p.eta() <= max)
                    .toList();
    }

    // Calcolare la somma delle età di tutte le persone nella lista
    public static Integer metodo2(List<People> lista){
        return lista.stream()
                    .mapToInt(p -> p.eta())
                    .sum();
    }

    // Restituire la lista di nazioni senza ripetizioni presenti in una lista di gente
    public static List<String> metodo3(List<People> lista){
        return lista.stream()
                    .map(p -> p.nazione())
                    .distinct()
                    .toList();
    }

    // Restituire una mappa contenente le coppie (nome persone - nazione)
    public static Map<String, String> metodo4(List<People> lista){
        return lista.stream()
                    .collect(Collectors.toMap(People::nome, People::nazione));
    }
}
