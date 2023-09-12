package Ingegneria_del_Software.Stream.Record.Commento;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] argc){
        LocalDate date = LocalDate.of(2021, 1, 3);

        List<Utente> utenti = List.of( new Utente("u1",
                                            List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                                                    new Commento("c1", LocalDate.of(2021, 1, 1)),
                                                    new Commento("c5", LocalDate.of(2021, 1, 5)))),
                                  new Utente("u2",
                                            List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                                                    new Commento("c3", LocalDate.of(2021, 1, 3)))));
    
        System.out.println("Restituire tutti i loro commenti ordinati per data (metodo1): ");
        metodo1(utenti);
    
        System.out.println("\n\nRestituire gli utenti che hanno pubblicato almeno un commento prima di una certa data (metodo2): ");
        metodo2(utenti, date);

        System.out.println("\n\nRestituire l'utente che ha pubblicato il commento più recente (metodo3): ");
        metodo3(utenti);
    }

    // Data una lista di utenti, restituire tutti i loro commenti ordinati per data.
    static void metodo1(List<Utente> utenti){
        utenti.stream()
              .flatMap(u -> u.commenti().stream())
              .sorted(Comparator.comparing(Commento::data))
              .forEach(p -> System.out.print(p.testo() + " "));
    }

    // Restituire gli utenti che hanno pubblicato almeno un commento prima di una certa data
    static void metodo2(List<Utente> utenti, LocalDate date){
        utenti.stream()
              .filter(utente -> utente.commenti().stream().anyMatch(commento -> commento.data().isBefore(date)))
              .forEach(p -> System.out.print(p.nome() + " "));    
    }

    // Restituire l'utente che ha pubblicato il commento più recente
    static void metodo3(List<Utente> utenti){
        Optional<Utente> utenteConCommentoPiuRecente = utenti.stream()
            .flatMap(utente -> utente.commenti().stream())
            .max((c1, c2) -> c1.data().compareTo(c2.data()))
            .map(commentoPiuRecente -> utenti.stream()
                .filter(utente -> utente.commenti().contains(commentoPiuRecente))
                .findFirst()
                .orElse(null));

        utenteConCommentoPiuRecente.ifPresentOrElse(
            utente -> System.out.println(utente.nome()),
            () -> System.out.println("Nessun commento trovato.")
        );
    }
}
