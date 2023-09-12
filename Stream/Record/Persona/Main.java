package Ingegneria_del_Software.Stream.Record.Persona;

import java.util.*;

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
        
        System.out.println("Data una lista di persone, trovare i nomi dei programmatori con età minore di 30 anni (metodo1): ");
        metodo1(team);

        System.out.println("Data una lista di istanze di Persona trovare i diversi ruoli (metodo2): ");
        metodo2(team);
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
}
