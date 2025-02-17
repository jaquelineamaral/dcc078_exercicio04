package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;
import src.main.java.visitor.VisitorCSV;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class VisitorCsvTest {

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
    void RelatorioNotasEntradaCSV() {
        VisitorCSV visitor = new VisitorCSV();

        String esperado = "Relatório de Notas de Entrada\n" +
                "Mês,Total de notas,Valor total\n" +
                "2,3,470,00\n" +
                "\n" +
                "Notas de Entrada\n" +
                "ID,Data,Valor\n" +
                "123,2025-02-16,120,00\n" +
                "456,2025-02-16,300,00\n" +
                "789,2025-02-16,50,00\n";

        assertEquals(esperado, visitor.gerarRelatorioNotasEntrada(relatorioNotasEntrada));
    }

    @Test
    void RelatorioNotasSaidaCSV() {
        VisitorCSV visitor = new VisitorCSV();

        String esperado = "Relatório de Notas de Saída\n" +
                "Mês,Total de notas,Valor total\n" +
                "2,3,580,00\n" +
                "\n" +
                "Notas de Saída\n" +
                "ID,Data,Valor\n" +
                "147,2025-02-16,350,00\n" +
                "258,2025-02-16,160,00\n" +
                "369,2025-02-16,70,00\n";

        assertEquals(esperado, visitor.gerarRelatorioNotasSaida(relatorioNotasSaida));
    }

}
