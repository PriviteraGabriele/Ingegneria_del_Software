package Ingegneria_del_Software.Programmazione_Funzionale.Esercizi_Slide.Esercizio_4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Esercizio4 {
    public static void main(String [] args){
        List<Integer> lista = List.of(2, 2, 4, 6, 3, 6, 3, 3, 4, 5);

        IntStream.rangeClosed(0, lista.size() - 3)
                            .mapToObj(i -> new int[]{lista.get(i), lista.get(i+1), lista.get(i+2)})
                            .filter(t -> t[0] < t[1] + t[2])
                            .filter(t -> t[1] < t[0] + t[2])
                            .filter(t -> t[2] < t[0] + t[1])
                            .collect(Collectors.toList());

    }
}


