package Ingegneria_del_Software.Stream.Record.Persona;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc){
        List<Persona> team = List.of(new Persona("Kent", 29, "CTO"),
                                     new Persona("Luigi", 25, "Programmer"),
                                     new Persona("Andrea", 26, "GrLeader"),
                                     new Persona("Sofia", 26, "Programmer"),
                                     new Persona("Alfio", 63, "Programmer"));

        System.out.println("Lista Persone:");
        for(Persona p : team){
            System.out.println(p);
        }
        System.out.print("\n");
        
        System.out.println("Data una lista di Persone, trovare i nomi dei programmatori con età minore di 30 anni (metodo1): ");
        metodo1(team);

        System.out.println("Data una lista di istanze di Persona, trovare i diversi ruoli (metodo2): ");
        metodo2(team);

        System.out.println("\nData una lista di istanze di Persone, tornare la somma delle loro età (metodo3): ");
        System.out.println(metodo3(team));

        System.out.println("\nData una lista di istanze di Persone, tornare la somma delle loro età (metodo3_2): ");
        System.out.println(metodo3_2(team));

        System.out.println("\nData una lista di istanze di Persona, Tornare una mappa di Nome, Ruolo (metodo4): ");
        metodo4(team);
    }

    // Data una lista di persone, trovare i nomi dei programmatori con età minore di 30 anni.
    public static void metodo1(List<Persona> team){
        team.stream()
            .filter(p -> p.role() == "Programmer")
            .filter(p -> p.age() < 30)
            .forEach(p -> System.out.print(p.name() + " "));

        System.out.println("\n");
    }

    // Data una lista di istanze di Persona trovare i diversi ruoli.
    public static void metodo2(List<Persona> team){
        team.stream()
            .map(p -> p.role())
            .distinct()
            .forEach(p -> System.out.print(p + " "));

        System.out.print("\n"); 
    }

    // Somma delle età delle persone
    public static Integer metodo3(List<Persona> team){
        return team.stream()
                   .mapToInt(p -> p.age())
                   .sum();
    }

    // Somma delle età delle persone (ALTERNATIVE)
    public static Integer metodo3_2(List<Persona> team){
        return team.stream()
                   .mapToInt(p -> p.age())
                   .reduce(0, (accum, v) -> (accum + v));
    }

    // Tornare una mappa di Nome, Ruolo
    public static void metodo4(List<Persona> team){
        Map<String, String> m = team.stream()
                                    .collect(Collectors.toMap(Persona::name, Persona::role));

        System.out.println(m);
    }
}
