package Ingegneria_del_Software.Stream.Es_Vari;

// Esercizio 3: Calcola la lunghezza delle stringhe
//
// Scrivi una funzione che prenda una lista di stringhe e restituisca una 
// nuova lista contenente le lunghezze corrispondenti delle stringhe.

import java.util.*;
import java.util.stream.Collectors;

public class LengthStrings {
    public static List<Integer> stringLengths(List<String> strings) {
        return strings.stream()
                      .map(String::length)
                      .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        List<Integer> lengths = stringLengths(strings);
        System.out.println("String lengths: " + lengths);
    }
}
