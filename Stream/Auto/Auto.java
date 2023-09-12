package Ingegneria_del_Software.Stream.Auto;

public class Auto {
    private String categoria;
    private String colore;
    private Double costo;
    private String modello;

    public Auto(String categoria, String colore, Double costo, String modello){
        this.categoria = categoria;
        this.colore = colore;
        this.costo = costo;
        this.modello = modello;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getColore(){
        return colore;
    }

    public Double getCosto(){
        return costo;
    }

    public String getModello(){
        return modello;
    }
}
