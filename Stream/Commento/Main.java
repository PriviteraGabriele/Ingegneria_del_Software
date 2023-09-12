package Ingegneria_del_Software.Stream.Commento;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] argc){
        LocalDate date = LocalDate.of(2021, 1, 3);

        List<Utente> utenti = List.of(new Utente("u1", List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                                                                    new Commento("c1", LocalDate.of(2021, 1, 1)),
                                                                    new Commento("c5", LocalDate.of(2021, 1, 5)))),
                                      new Utente("u2", List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                                                                    new Commento("c3", LocalDate.of(2021, 1, 3)))));

        System.out.print("Restituire tutti i loro commenti ordinati per data: ");
        metodo1(utenti);

        System.out.print("\nRestituire gli utenti che hanno pubblicato almeno un commento prima di una certa data: ");
        metodo2(utenti, date);

        // System.out.print("\nRestituire l'utente che ha pubblicato il commento piu' recente: ");
        // metodo3(utenti);
        System.out.print("\n");
    }

    // Data una lista di utenti, restituire tutti i loro commenti ordinati per data.
    static void metodo1(List<Utente> utenti){
        utenti.stream()
              .flatMap(u -> u.getCommenti().stream())
              .sorted(Comparator.comparing(Commento::getDate))
              .forEach(p -> System.out.print(p.getText() + " "));
    }

    // Restituire gli utenti che hanno pubblicato almeno un commento prima di una certa data
    static void metodo2(List<Utente> utenti, LocalDate date){
        utenti.stream()
              .filter(utente -> utente.getCommenti().stream().anyMatch(commento -> commento.getDate().isBefore(date)))
              .forEach(p -> System.out.print(p.getName() + " "));    
    }

    // // Restituire l'utente che ha pubblicato il commento più recente
    // static void metodo3(List<Utente> utenti){
    //     utenti.stream()
    //           .filter(utente -> utente.getCommenti().max(Comparator.comparing(Utente::getCommenti)
    //                 .stream()
    //                 .map(Commento::getData)
    //                 .max(LocalDate::compareTo)
    //                 .orElse(LocalDate.MIN)));

}
