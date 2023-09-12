package Ingegneria_del_Software.Stream.Es_Slide;

// Data una lista di stringhe, Produrre una lista che contiene solo le stringhe che cominciano con un certo prefisso noto.
// OTTIMIZZATO con input da tastiera per la selezione del prefisso

import java.util.*;

public class Es1_Interattivo {
    public static void main(String[] argc){
        List<String> l = List.of("author", "auto", "autocorrect", "begin", "big", "bigger", "biggish");

        System.out.println("Lista:");
        for (String i : l) {
            System.out.println(i);
        } 

        Scanner in = new Scanner(System.in);

        System.out.println("\nInserire prefisso per la ricerca:");


        final String pref = in.nextLine();
        in.close();

        System.out.println("\nRisultato:");

        List<String> r = l.stream()
                          .filter(s -> s.startsWith(pref))
                          .toList();
        
        r.forEach(System.out::println);
    }
}
