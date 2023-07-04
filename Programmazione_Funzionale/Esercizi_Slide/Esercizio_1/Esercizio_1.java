package Ingegneria_del_Software.Programmazione_Funzionale.Esercizi_Slide.Esercizio_1;

import java.util.List;
import java.util.stream.Collectors;

public class Esercizio_1 {
    public static void main(String [] args){
        List<String> l1 = List.of("author", "auto","aucorrect","begin","big","bigger","biggish");

        final String pref = "aut";
        List<String> r = l1.stream()
                           .filter(s -> s.startsWith(pref))
                           .collect(Collectors.toList());

        r.forEach(System.out::println);
    }    
}
