package Ingegneria_del_Software.Stream.Persona;

import java.util.*;

public class Main {
    public static void main(String[] argc){
        List<Persona> team = List.of(new Persona("Kent", 29, "CTO"),
                                     new Persona("Luigi", 25, "Programmer"),
                                     new Persona("Andrea", 26, "GrLeader"),
                                     new Persona("Sofia", 26, "Programmer"),
                                     new Persona("Alfio", 63, "Programmer"));

        System.out.println("- Nomi dei programmatori con eta' minore di 30 anni (metodo 1):");
        metodo1(team);

        System.out.println("\n\n- Trovare i diversi ruoli (metodo 2):");
        metodo2(team);
        System.out.println();
    }

    // Data una lista di persone, trovare i nomi dei programmatori con età minore di 30 anni.
    static void metodo1(List<Persona> team){
        team.stream()
            .filter(a -> a.getAge() < 30)
            .sorted(Comparator.comparing(Persona::getName))
            .forEach(p -> System.out.print(p.getName() + " "));
    }

    // Data una lista di istanze di Persona trovare i diversi ruoli.
    static void metodo2(List<Persona> team){
        team.stream()
            .map(p -> p.getRole())
            .distinct()
            .forEach(s -> System.out.print(s + " "));
    }
}