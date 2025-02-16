package src.main.java.models;

import java.util.ArrayList;


public class RelatorioNotasEntrada {

    private int mes;
    private ArrayList<Nota> notas = new ArrayList<>();
    private float valorTotal;


    public RelatorioNotasEntrada(int mes, ArrayList<Nota> notas, float valorTotal) {
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

    /*
    @Override
    public String aceitar(Visitor visitor) {
        return "";
    }

     */
}
