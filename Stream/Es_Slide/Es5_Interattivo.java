package Ingegneria_del_Software.Stream.Es_Slide;

import java.util.*;
import java.util.stream.IntStream;

public class Es5_Interattivo {
    public static void main(String[] argc){
        int[] array = inputTastiera();

        System.out.print("\nArray: ");
        for(Integer i : array){
            System.out.print(i + " ");
        }
        System.out.print("\n");

        boolean ordinata = isOrdinata(array);
        System.out.println("La lista è ordinata: " + ordinata);
    }

    public static int[] inputTastiera(){
        Scanner in = new Scanner(System.in);

        System.out.print("Inserire il numero di elementi da inserire nell'array: ");
        int n = in.nextInt();
        
        int[] array = new int[n];

        System.out.println("\nInserisci gli elementi dell'array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = in.nextInt();
        }
        in.close();
        return array;
    }

    public static boolean isOrdinata(int[] numeri) {
        return IntStream.rangeClosed(0, numeri.length - 2)
                        .filter(i -> numeri[i] > numeri[i + 1])
                        .peek(v -> System.out.print(numeri[v] + " > " + numeri[v + 1] + " -> "))
                        .findAny()
                        .isEmpty();
    }
}
