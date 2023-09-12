package Ingegneria_del_Software.Stream.Es_Slide;

import java.util.List;

public class Es1 {
    public static void main(String[] argc){
        List<String> l = List.of("author", "auto", "autocorrect", "begin", "big", "bigger", "biggish");

        String pref = "au";

        List<String> r = l.stream()
                          .filter(s -> s.startsWith(pref))
                          .toList();

        for(String i : r){
            System.out.println(i);
        }
    }
}
