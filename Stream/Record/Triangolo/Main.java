package Ingegneria_del_Software.Stream.Record.Triangolo;

import java.util.List;

public class Main {
    public static void main(String[] argc){
        List<Triangolo> t = List.of(new Triangolo(3, 4, 5, 30, 60, 90),
                                    new Triangolo(4, 5, 4, 30, 30, 120),
                                    new Triangolo(13, 5, 12, 30, 60, 90),
                                    new Triangolo(17, 15, 8, 30, 60, 90),
                                    new Triangolo(23, 15, 23, 30, 30, 120));

        System.out.println("Lista Triangoli:");
        for(Triangolo i : t){
            System.out.println(i);
        }
        
        System.out.println("\nRestituire la lista di lati maggiori dei triangoli (metodo1):"); metodo1(t);

        System.out.println("\nRestituire una lista di triangoli isosceli (metodo2):");
        for(Triangolo i : metodo2(t)){
            System.out.println(i);
        }

        System.out.println("\nRestituire il perimetro maggiore dei triangoli (metodo3): " + metodo3(t));

        System.out.println("\nRestituire una lista di triangoli rettangoli (metodo4):");
        for(Triangolo i : metodo4(t)){
            System.out.println(i);
        }

        System.out.println("\nRestituire le aree dei triangoli rettangoli (metodo5):");
        for(Integer i : metodo5(t)){
            System.out.println(i);
        }
    }

    // Restituire la lista di lati maggiori dei triangoli
    public static void metodo1(List<Triangolo> t){
        List<Integer> lMax = t.stream()
                              .map(x -> List.of(x.l1(), x.l2(), x.l3()))
                              .map(x -> x.stream()
                                         .reduce(Integer::max)
                                         .get())
                              .toList();

        for(Integer i : lMax){
            System.out.println("[" + i + "]");
        }
    }

    // Restituire una lista di triangoli isosceli. Un triangolo è isoscele se due suoi lati sono uguali
    public static List<Triangolo> metodo2(List<Triangolo> t){
        return t.stream()
                .filter(x -> x.l1() == x.l2() || x.l2() == x.l3() || x.l1() == x.l3())
                .toList();
    }

    // Il perimetro maggiore dei triangoli
    public static Integer metodo3(List<Triangolo> t){
        return t.stream()
                .mapToInt(x -> x.l1() + x.l2() + x.l3())
                .max()
                .orElse(0);
    }

    // Tornare una lista di tutti triangoli rettangoli
    public static List<Triangolo> metodo4(List<Triangolo> t){
        return t.stream()
                .filter(x -> x.a1() == 90 || x.a2() == 90 || x.a3() == 90)
                .toList();
    }

    // Le aree dei triangoli rettangoli
    public static List<Integer> metodo5(List<Triangolo> t){
        return t.stream()
                .filter(x -> x.a1() == 90 || x.a2() == 90 || x.a3() == 90)
                .map(x -> area(x.l1(), x.l2(), x.l3()))
                .toList();
    }

    public static int area(int l1, int l2, int l3) {
        if (l1 > l2 && l1 > l3) return (l2 * l3) / 2;
        else if (l2 > l1 && l2 > l3) return (l1 * l3) / 2;
        else return (l1 * l2) / 2;
    }
}
