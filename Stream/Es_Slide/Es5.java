package Ingegneria_del_Software.Stream.Es_Slide;

// Data una lista di numeri interi positivi
// • Verificare se la lista è ordinata
// 
// Suggerimenti
// • Si generano gli indici da 0 a n-1
// • Per ciascun valore dell’indice i, si confrontano l’elemento con indice i ed il successivo, 
//   se il secondo è minore del primo la lista non è ordinata e si può fermare la verifica

import java.util.*;
import java.util.stream.IntStream;

public class Es5 {
    public static void main(String[] argc){
        List<Integer> numeri = List.of(1, 2, 3, 4, 15, 6, 7, 8, 9);

        System.out.print("Lista: ");
        for(Integer i : numeri){
            System.out.print(i + " ");
        }
        System.out.println("\n");

        boolean ordinata = isOrdinata(numeri);
        System.out.println("La lista è ordinata: " + ordinata);
    }

    public static boolean isOrdinata(List<Integer> numeri) {
        return IntStream.rangeClosed(0, numeri.size() - 2)
                        .filter(i -> numeri.get(i) > numeri.get(i + 1))
                        .peek(v -> System.out.print(numeri.get(v) + " > " + numeri.get(v + 1) + " -> "))
                        .findAny()
                        .isEmpty();
    }
}


