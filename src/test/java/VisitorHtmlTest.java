package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;
import src.main.java.visitor.VisitorHTML;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class VisitorHtmlTest {

    Nota nota;
    ArrayList<Nota> notasEntrada = new ArrayList<>();
    ArrayList<Nota> notasSaida = new ArrayList<>();
    RelatorioNotasEntrada relatorioNotasEntrada;
    RelatorioNotasSaida relatorioNotasSaida;


    @BeforeEach
    public void setUp() {

        nota = new Nota(123, LocalDate.of(2025, 2, 16), 120);
        notasEntrada.add(nota);
        nota = new Nota(456, LocalDate.of(2025, 2, 16), 300);
        notasEntrada.add(nota);
        nota = new Nota(789, LocalDate.of(2025, 2, 16), 50);
        notasEntrada.add(nota);
        relatorioNotasEntrada = new RelatorioNotasEntrada(2, notasEntrada, 470);

        nota = new Nota(147, LocalDate.of(2025, 2, 16), 350);
        notasSaida.add(nota);
        nota = new Nota(258, LocalDate.of(2025, 2, 16), 160);
        notasSaida.add(nota);
        nota = new Nota(369, LocalDate.of(2025, 2, 16), 70);
        notasSaida.add(nota);
        relatorioNotasSaida = new RelatorioNotasSaida(2, notasSaida, 580);

    }


    @Test
    void RelatorioNotasEntradaHTMl() {
        VisitorHTML visitor = new VisitorHTML();

        String esperado = "<html>\n" +
                "<body>\n" +
                "<h1>Relatorio de Notas de Entrada</h1>\n" +
                "<p>Mês: 2</p>\n" +
                "<p>Total de notas: 3</p>\n" +
                "<p>Valor total: R$470,00</p>\n" +
                "<h2>Notas de entrada</h2>\n" +
                "<ul>\n" +
                "<li>123   2025-02-16   120.0   </li>\n" +
                "<li>456   2025-02-16   300.0   </li>\n" +
                "<li>789   2025-02-16   50.0   </li>\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";

        assertEquals(esperado, visitor.gerarRelatorioNotasEntrada(relatorioNotasEntrada));
    }

    @Test
    void RelatorioNotasSaidaHTMl() {
        VisitorHTML visitor = new VisitorHTML();

        String esperado = "<html>\n" +
                "<body>\n" +
                "<h1>Relatorio de Notas de Saída</h1>\n" +
                "<p>Mês: 2</p>\n" +
                "<p>Total de notas: 3</p>\n" +
                "<p>Valor total: R$580,00</p>\n" +
                "<h2>Notas de saída</h2>\n" +
                "<ul>\n" +
                "<li>147   2025-02-16   350.0   </li>\n" +
                "<li>258   2025-02-16   160.0   </li>\n" +
                "<li>369   2025-02-16   70.0   </li>\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";

        assertEquals(esperado, visitor.gerarRelatorioNotasSaida(relatorioNotasSaida));
    }

}