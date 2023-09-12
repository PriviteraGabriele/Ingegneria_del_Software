package Ingegneria_del_Software.Stream.Es_Slide;

// Data una lista di terne di numeri interi:
// • Per ciascuna terna verificare se essa costituisce un triangolo
// • Restituire la lista dei perimetri per le terne che rappresentano triangoli
//
// Suggerimenti:
// • In un triangolo, ciascun lato è minore della somma degli altri due

import java.util.*;

public class Es3 {
    public static void main(String[] argc){
        List<int[]> terne = List.of(new int[] { 2, 2, 3 }, new int[] { 3, 2, 3 }, 
                                    new int[] { 3, 3, 3 }, new int[] { 3, 4, 5 }, 
                                    new int[] { 5, 2, 3 });

        List<Integer> ris = terne.stream()
                             .filter(t -> t[0] < t[1] + t[2])
                             .filter(t -> t[1] < t[2] + t[0])
                             .filter(t -> t[2] < t[0] + t[0])
                             .map(t -> t[0] + t[1] + t[2])
                             .toList();

        for(Integer i: ris){
            System.out.println(i);
        }
    }
}
