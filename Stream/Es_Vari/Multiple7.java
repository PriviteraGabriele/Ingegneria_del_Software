package Ingegneria_del_Software.Stream.Es_Vari;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Produrre una lista contenente i primi n multipli di 7

public class Multiple7 {
    public static void main(String[] argc){
        int n = 5;

        List<Integer> multipliDi7 = IntStream.rangeClosed(1, n)
                                             .mapToObj(i -> i * 7)
                                             .collect(Collectors.toList());

        System.out.println("I primi " + n + " multipli di 7 sono: " + multipliDi7);
    }
}
