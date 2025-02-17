package src.main.java.models;

import java.time.LocalDate;


public class Nota {

    private int id;
    private LocalDate data;
    private float valor;


    public Nota(int id, LocalDate data, float valor) {
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

    public LocalDate getData() {
        return data;
    }

}
