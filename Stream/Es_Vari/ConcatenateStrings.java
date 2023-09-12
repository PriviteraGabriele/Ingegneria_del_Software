package Ingegneria_del_Software.Stream.Es_Vari;

import java.util.List;
import java.util.stream.Collectors;

public class ConcatenateStrings {
    public static String concatenateStrings(List<String> strings) {
        return strings.stream()
                      .collect(Collectors.joining(", "));
    }
    
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        String result = concatenateStrings(strings);
        System.out.println("Concatenated string: " + result);
    }
}
