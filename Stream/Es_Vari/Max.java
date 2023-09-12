package Ingegneria_del_Software.Stream.Es_Vari;

// Data una lista di numeri, trovare il numero col valore massimo.

import java.util.*;

public class Max {
    public static void main(String[] argc){
        List<Integer> numbers = List.of(1, 5, 3, 8, 5, 9, 0);

        int max = numbers.stream()
                         .max(Integer::compareTo)
                         .orElseThrow();

        System.out.println("Il numero con il valore maggiore è: " + max);

    }
}
