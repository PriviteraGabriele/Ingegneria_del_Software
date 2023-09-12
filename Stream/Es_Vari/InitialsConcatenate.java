package Ingegneria_del_Software.Stream.Es_Vari;

// Data una lista di stringhe, ritornare una stringa formata dalle iniziali di tutte le stringhe della lista 

import java.util.List;
import java.util.Optional;

public class InitialsConcatenate {
    public static void main(String[] argc){
        List<String> list = List.of("author", "banana", "cane");

        Optional<String> str = list.stream()
                                   .filter(s -> s.length() > 0)
                                   .map(s -> s.substring(0, 1))
                                   .reduce(String::concat);

        if(str.isPresent())
            System.out.println("Risultato: " + str.get());
    }
}

