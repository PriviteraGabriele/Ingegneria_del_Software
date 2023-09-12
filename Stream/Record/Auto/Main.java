package Ingegneria_del_Software.Stream.Record.Auto;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] argc){
        List<Auto> lista = List.of( new Auto("A", "BLU", 220.0, "Berlina"),
                                    new Auto("B", "ROSSO", 170.0, "Sportiva"),
                                    new Auto("C", "VERDE", 120.0, "SUV"));

        System.out.println("Lista Auto:");
        for (Auto i : lista) System.out.println(i);

        System.out.println("\n(Incremento 5% costo Auto):");
        for (Auto i : incremento(lista)) System.out.println(i);

        System.out.println("\nSomma dei costi di tutte le auto: " + somma(lista));

        System.out.println("\nTrovare il minimo dei costi delle istanze di auto: " + minimo(lista));

        System.out.println("\nTrovare il massimo dei costi delle istanze di auto: " + massimo(lista));

        System.out.println("\nOrdina la lista per costo:"); ordinaPerCosto(lista);

        System.out.print("\nLa lista è ordinata per costo? "); isOrdinata(lista);
    }

    // Incrementa il costo di ogni auto del 5%
    public static List<Auto> incremento(List<Auto> lista){
        return lista.stream()
                    .map(x -> new Auto(x.categoria(), x.colore(), x.costo() + (x.costo() * 0.05), x.modello()))
                    .toList();
    }

    // Somma dei costi di tutte le auto
    public static double somma(List<Auto> lista){
        return lista.stream()
                    .mapToDouble(a -> a.costo())
                    .sum();
    }

    // Trovare il minimo dei costi delle istanze di auto
    public static double minimo(List<Auto> lista){
        return lista.stream()
                    .mapToDouble(a -> a.costo())
                    .min()
                    .orElse(0.0);
    }

    // Trovare il massimo dei costi delle istanze di auto
    public static double massimo(List<Auto> lista){
        return lista.stream()
                    .mapToDouble(a -> a.costo())
                    .max()
                    .orElse(0.0);
    }

    // Ordinare la lista per costo
    public static void ordinaPerCosto(List<Auto> lista){
        List<Auto> riordina = lista.stream()
                                   .sorted(Comparator.comparing(Auto::costo))
                                   .toList();

        for(Auto a : riordina){
            System.out.println(a);
        }
    }

    // Verificare se la lista è ordinata per costo
    public static void isOrdinata(List<Auto> lista){
        Double first = lista.get(0).costo();
        
        boolean b = lista.stream()
                         .map(Auto::costo)
                         .filter(x -> x < first)
                         .findAny()
                         .isEmpty();

        if (b == true) System.out.println("Lista ordinata per costo!");
        else System.out.println("Lista non ordinata per costo!");
    }
}