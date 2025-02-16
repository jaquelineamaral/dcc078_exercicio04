package src.main.java.models;

import java.util.ArrayList;


public class RelatorioNotasSaida {

    private int mes;
    private ArrayList<Nota> notas = new ArrayList<>();
    private float valorTotal;


    public RelatorioNotasSaida(int mes, ArrayList<Nota> notas, float valorTotal) {
        this.mes = mes;
        this.notas = notas;
        this.valorTotal = valorTotal;
    }


    public int getMes() {
        return mes;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public float getValorTotal() {
        return valorTotal;
    }

}
