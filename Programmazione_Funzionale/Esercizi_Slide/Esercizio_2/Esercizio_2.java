package Ingegneria_del_Software.Programmazione_Funzionale.Esercizi_Slide.Esercizio_2;

import java.util.List;
import java.util.stream.Collectors;

public class Esercizio_2 {
    public static void main(String [] args){
        List<String> l1 = List.of("to", "speak","the","teuth","and","pay","your", "debts");

        String r = l1.stream()
                     .map(s -> s.substring(0, 1))
                     .reduce("", (r, v) -> r.concat(v));



        
    }    
}