package src.main.java.visitor;

import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;


public interface Visitor {

    String gerarRelatorioNotasEntrada(RelatorioNotasEntrada relatorioNotasEntrada);
    String gerarRelatorioNotasSaida(RelatorioNotasSaida relatorioNotasSaida);

}
