package Ingegneria_del_Software.Stream.Es_Slide;

// Data una lista di stringhe, produrre una stringa contenente le iniziali di ciascuna stringa della lista

import java.util.*;

public class Es2 {
    public static void main(String[] argc){
        List<String> l = List.of("to", "speak", "the", "truth", "and", "pay", "your", "debts");
        // List<String> l = List.of("pasta", "orata", "razzo", "cavallo", "oro", " ", "dinosauro", "internet", "odio");

        System.out.println("Lista:");
        for(String i : l){
            System.out.println(i);
        }

        System.out.println("\nRisultato:");

        String ris = l.stream()
                      .map(s -> s.substring(0, 1))
                      .reduce("", (r, v) -> r.concat(v));
        
        System.out.println(ris);
    }
}
