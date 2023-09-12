// Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
// implemenate una classe con: 
// 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
// 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun 
//    genere di libri presenti in lib. 
// 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
// 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizioni

package Ingegneria_del_Software.Stream.Libro;

public class Libro {
    private String titolo;
    private String autore;
    private String genere;
    private double costo;
    private double peso;
    
    public Libro(String titolo, String autore, String genere, double costo, double peso){
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.costo = costo;
        this.peso = peso;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getAutore(){
        return autore;
    }

    public String getGenere(){
        return genere;
    }

    public double getCosto(){
        return costo;
    }

    public double getPeso(){
        return peso;
    }

    public void setTitotlo(String titolo){
        this.titolo = titolo;
    }

    public void setAutore(String autore){
        this.autore = autore;
    }

    public void setGenere(String genere){
        this.genere = genere;
    }

    public void setCosto(double costo){
        this.costo = costo;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }
}
