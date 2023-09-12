package Ingegneria_del_Software.Stream.Commento;

import java.time.LocalDate;

public class Commento {
    String text;
    LocalDate date;

    public Commento(String text, LocalDate date){
        this.text = text;
        this.date = date;
    }

    public String getText(){
        return text;
    }

    public LocalDate getDate(){
        return date;
    }
}
