package Ingegneria_del_Software.Stream.Es_Vari;

// Esercizio 1: Somma degli elementi di una lista
//
// Scrivi una funzione che prenda una lista di numeri interi e restituisca la somma di 
// tutti gli elementi utilizzando approcci di programmazione funzionale come Stream.

import java.util.*;

public class Sum {
    public static int sumList(List<Integer> numbers) {
        return numbers.stream()
                      .mapToInt(Integer::intValue)
                      .sum();
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = sumList(numbers);
        System.out.println("Sum: " + sum);
    }
}
