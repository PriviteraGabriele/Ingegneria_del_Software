package Ingegneria_del_Software.Stream.Auto;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc){
        List<Auto> lista = List.of( new Auto("A", "BLU", 220.0, "Berlina"),
                                    new Auto("B", "ROSSO", 170.0, "Sportiva"),
                                    new Auto("C", "VERDE", 120.0, "SUV"));

        System.out.println("Lista Auto:");
        for(Auto a : lista){
            System.out.println(a.getCategoria() + ", " + a.getColore() + ", " + a.getCosto() + ", " + a.getModello());
        }
    
        System.out.println("\nIncrementa il costo di ogni auto del 5% (metodo1):");
        for(Auto a : metodo1(lista)){
            System.out.println(a.getCategoria() + ", " + a.getColore() + ", " + a.getCosto() + ", " + a.getModello());
        }

        System.out.println("\nSomma dei costi di tutte le auto (metodo2): " + metodo2(lista));
        
        System.out.println("\nSomma dei costi di tutte le auto (metodo2_2): " + metodo2_2(lista));

        System.out.println("\nTrovare il minimo dei costi delle istanze di auto (metodo3): " + metodo3(lista));

        System.out.println("\nTrovare il minimo dei costi delle istanze di auto (metodo3_2): " + metodo3_2(lista));

        System.out.println("\nTrovare il massimo dei costi delle istanze di auto (metodo4): " + metodo4(lista));

        metodo5(lista);

        metodo6(lista);
    }

    // Incrementa il costo di ogni auto del 5%
    public static List<Auto> metodo1(List<Auto> lista){
        return lista.stream()
                    .map(a -> new Auto(a.getCategoria(), a.getColore(), a.getCosto()*(1.05), a.getModello()))
                    .collect(Collectors.toList());
    }
    
    // Somma dei costi di tutte le auto
    public static Double metodo2(List<Auto> lista){
        return lista.stream()
                    .map(a -> a.getCosto())
                    .reduce(0.0, (a, v) -> a + v);
    }

    public static Double metodo2_2(List<Auto> lista){
        return lista.stream()
                 .mapToDouble(Auto::getCosto)
                 .sum();
    }

    // Trovare il minimo dei costi delle istanze di auto
    public static Double metodo3(List<Auto> lista){
        return lista.stream()
                 .mapToDouble(Auto::getCosto)
                 .min()
                 .orElse(0.0);
    }    

    // Trovare il minimo dei costi delle istanze di auto
    public static Double metodo3_2(List<Auto> lista){
        return lista.stream()
                 .map(Auto::getCosto)
                 .sorted()
                 .findFirst()
                 .orElse(0.0);
    }    

    // Trovare il massimo dei costi delle istanze di auto
    public static Double metodo4(List<Auto> lista){
        return lista.stream()
                    .mapToDouble(Auto::getCosto)
                    .max()
                    .orElse(0.0);
    }

    // Ordinare la lista per costo
    public static void metodo5(List<Auto> lista){
        List<Auto> sort = lista.stream()
                            .sorted(Comparator.comparing(Auto::getCosto))
                            .toList();

        System.out.println("\nOrdinare la lista per costo (metodo5): ");
        for(Auto a : sort)
            System.out.println(a.getCategoria() + ", " + a.getColore() + ", " + a.getCosto() + ", " + a.getModello());
    }

    // Auto di costo maggiore
    public static void metodo6(List<Auto> lista){        
        Auto maxPrice = lista.stream()
                             .max(Comparator.comparing(Auto::getCosto))
                             .orElse(null);

        System.out.println("\nAuto di costo maggiore (metodo6): ");
        System.out.println(maxPrice.getCategoria() + ", " + maxPrice.getColore() + ", " + maxPrice.getCosto() + ", " + maxPrice.getModello());             
    }
}
