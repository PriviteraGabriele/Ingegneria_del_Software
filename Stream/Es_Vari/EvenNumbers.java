package Ingegneria_del_Software.Stream.Es_Vari;

import java.util.*;
import java.util.stream.Collectors;

// Esercizio 2: Filtra i numeri pari
//
// Scrivi una funzione che prenda una lista di numeri interi e 
// restituisca una nuova lista contenente solo i numeri pari.

public class EvenNumbers {
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers);
    }
}
