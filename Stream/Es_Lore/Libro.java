package Ingegneria_del_Software.Stream.Es_Lore;
/*
 * Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
 * implemenate una classe con: 
 * 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
 * 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib. 
 * 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
 * 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizione
 */

public class Libro {
    private String titolo, genere, autore;
    private double peso, costo;

    public Libro(String titolo, double peso, double costo, String genere, String autore){
        this.titolo = titolo;
        this.peso = peso;
        this.costo = costo;
        this.autore = autore;
        this.genere = genere;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getGenere(){
        return genere;
    }

    public String getAutore(){
        return autore;
    }

    public double getPeso(){
        return peso;
    }

    public double getCosto(){
        return costo;
    }
}


