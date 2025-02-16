package src.main.java.models;

import java.util.Date;

public class Nota {

    private int id;
    private Date data;
    private float valor;


    public Nota(int id, Date data, float valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }


    public float getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

}
