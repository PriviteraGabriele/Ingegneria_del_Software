package Ingegneria_del_Software.Stream.Commento;

import java.util.*;

public class Utente {
    String name;
    List<Commento> commenti;

    public Utente(String name, List<Commento> commenti) {
        this.name = name;
        this.commenti = commenti;
    }

    public String getName() {
        return name;
    }

    public List<Commento> getCommenti() {
        return commenti;
    }
}
