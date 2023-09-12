package Ingegneria_del_Software.Stream.Es_Vari;

// Data una lista di numeri, trovare il numero col valore minimo.

import java.util.*;

public class Min {
    public static void main(String[] argc){
        List<Integer> numbers = List.of(1, 5, 3, 8, 5, 9, 4);

        int min = numbers.stream()
                         .min(Integer::compareTo)
                         .orElseThrow();

        System.out.println("Il numero con il valore minore è: " + min);

    }
}