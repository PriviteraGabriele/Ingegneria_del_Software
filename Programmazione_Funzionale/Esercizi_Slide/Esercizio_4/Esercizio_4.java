// Data una lista di numeri interi
// • Verificare se ciascuna terna formata prendendo dalla lista tre numeri contigui costituisce un triangolo
// • Esempio: lista {2, 3, 5, 7, 8}, terne {2, 3, 5}, {3, 5, 7}, {5, 7, 8}
// • Restituire la lista delle terne che rappresentano triangoli
// • Esempio: terne {3, 5, 7}, {5, 7, 8}
// 
// Suggerimenti
// • In un triangolo, ciascun lato è minore della somma degli altri due
// • Si generano gli indici da 0 a n-2
// • Si conserva in un array di tre elementi, per ciascun indice i, l’elemento i, ed i due successivi elementi, così da formare una terna

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Esercizio_4 {
    public static void main(String[] argc){
        List<Integer> lista = List.of(2, 3, 5, 7, 8);

        List<int[]> ris = IntStream.rangeClosed(0, lista.size() - 3)
                                      .mapToObj(i -> new int[]{lista.get(i), lista.get(i + 1), lista.get(i + 2)})
                                      .filter(v -> v[0] < v[1] + v[2])
                                      .filter(v -> v[1] < v[0] + v[2])
                                      .filter(v -> v[2] < v[0] + v[1])
                                      .collect(Collectors.toList());

        for(int[] x : ris){
            System.out.println(Arrays.toString(x));
        }
    } 
}