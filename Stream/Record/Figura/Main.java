package W3_Learning.Java.Stream.Record.Figura;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] argc){
        List<Figura> figure = List.of(new Figura(12, 12, 12, 12, 45, 45, 135, 135),
                                      new Figura(2, 2, 2, 2, 90, 90, 90, 90),
                                      new Figura(1, 2, 1, 2, 90, 90, 90, 90));

        System.out.println("Lista figure:");
        for(Figura f : figure){
            System.out.println(f);
        }
        
        System.out.println("\nRestituire tutte le figure che siano rettangoli o quadrati (metodo1): "); metodo1(figure);

        System.out.println("\nRestituire uno stream che contenga il lato MINORE per ogni figura (metodo2): "); metodo2(figure);

        System.out.println("\nRestituire uno stream che contenga il lato MAGGIORE per ogni figura (metodo3): "); metodo3(figure);

        System.out.println("\nRestituire la lista dell'angolo MINORE per ogni figura (metodo4): "); metodo4(figure);

        System.out.println("\nRestituire il perimetro MINORE tra tutte le figure (metodo5): " + metodo5(figure));

        System.out.println("\nRestituire il perimetro MAGGIORE tra tutte le figure (metodo6): " + metodo6(figure));

        System.out.println("\nOttenere la somma del valore dei perimetri di tutte le figure (metodo7): " + metodo7(figure));

        System.out.println("\nOttenere la somma del valore dell'area di tutte le figure (metodo8): " + metodo8(figure));

        System.out.println("\nTornare una lista di figure copn perimetro doppio a partire da figure (metodo9):");
        for(Figura f : metodo9(figure)){
            System.out.println(f);
        }
    }

    // Restituire tutte le figure che siano rettangoli o quadrati (tutti gli angoli uguali)
    public static void metodo1(List<Figura> figure){
        List<Figura> rettangoliOQuadrati = figure.stream()
                                                 .filter(figura -> figura.a1() == figura.a2() &&
                                                                   figura.a2() == figura.a3() &&
                                                                   figura.a3() == figura.a4())
                                                 .collect(Collectors.toList());

        rettangoliOQuadrati.forEach(System.out::println);
    }

    // Restituire uno stream che contenga il lato minore per ogni figura
    public static void metodo2(List<Figura> figure){
        List<Integer> lMin = figure.stream()
                                   .map(x -> List.of(x.l1(), x.l2(), x.l3(), x.l4()))
                                   .map(x -> x.stream()
                                              .reduce(Integer::min)
                                              .get())
                                   .toList();

        for (Integer l : lMin){
            System.out.println("[" + l + "]");
        }  
    }

    // Restituire uno stream che contenga il lato maggiore per ogni figura
    public static void metodo3(List<Figura> figure){
        List<Integer> lMax = figure.stream()
                                   .map(x -> List.of(x.l1(), x.l2(), x.l3(), x.l4()))
                                   .map(x -> x.stream()
                                              .reduce(Integer::max)
                                              .get())
                                   .toList();

        for (Integer l : lMax){
            System.out.println("[" + l + "]");
        }  
    }

    // La lista dell'angolo minore per ogni figura
    public static void metodo4(List<Figura> figure){
        List<Integer> aMin = figure.stream()
                                   .map(f -> List.of(f.a1(), f.a2(), f.a3(), f.a4()))
                                   .map(x -> x.stream()
                                              .reduce(Integer::min)
                                              .get())
                                   .toList();

        for(Integer f : aMin){
            System.out.println("[" + f + "]");
        }
    }

    // Restituire il perimetro minore tra tutte le figure
    public static Integer metodo5(List<Figura> figure){ 
        return figure.stream()
                     .mapToInt(f -> f.l1() + f.l2() + f.l3() + f.l4())
                     .min()
                     .orElse(0);
    }

    // Restituire il perimetro maggiore tra tutte le figure
    public static Integer metodo6(List<Figura> figure){
        return figure.stream()
                     .mapToInt(f -> f.l1() + f.l2() + f.l3() + f.l4())
                     .max()
                     .orElse(0);
    }

    // Ottenere la somma del valore dei perimetri di tutte le figure
    public static Integer metodo7(List<Figura> figure){
        return figure.stream()
                     .mapToInt(f -> f.l1() + f.l2() + f.l3() + f.l4())
                     .sum();
    }

    // Ottenere la somma del valore dell'area di tutte le figure
    public static Integer metodo8(List<Figura> figure){
        return figure.stream()
                     .mapToInt(f -> f.l1() * f.l2())
                     .sum();
    }

    // Tornare una lista di figure copn perimetro doppio a partire da figure
    public static List<Figura> metodo9(List<Figura> figure){
        return figure.stream()
                     .map(f -> new Figura(f.l1()*2, f.l2()*2, f.l3()*2, f.l4()*2, f.a1(), f.a2(), f.a3(), f.a4()))
                     .toList();
    }
}
