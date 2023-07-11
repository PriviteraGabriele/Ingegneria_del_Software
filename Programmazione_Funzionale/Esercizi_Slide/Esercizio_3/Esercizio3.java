package Ingegneria_del_Software.Programmazione_Funzionale.Esercizi_Slide.Esercizio_3;

import java.util.List;

public class Esercizio3 {
    public static void main(String [] args){
        List<int[]> terne = List.of(new int[] { 2, 2, 3 },
            new int[] { 3, 2, 3 }, new int[] { 3, 3, 3 }, 
            new int[] { 3, 4, 5 }, new int[] { 5, 2, 3 });

        List<Integer> i = terne.stream()
                               .filter(t -> t[0]<t[1]+t[2])
                               .filter(t -> t[1]<t[0]+t[2])
                               .filter(t -> t[2]<t[0]+t[1])
                               .map(t -> t[0] + t[1] + t[2])
                               .toList();

        for(Integer s : i){
            System.out.println(s);
        }
    }
}
