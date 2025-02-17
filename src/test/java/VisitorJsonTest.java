package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;
import src.main.java.visitor.VisitorJSON;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class VisitorJsonTest {

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
    void RelatorioNotasEntradaJSON() {
        VisitorJSON visitor = new VisitorJSON();

        String esperado = "{\n" +
                "  \"Relatório de Notas de Entrada\": {\n" +
                "    \"Mês\": \"2\",\n" +
                "    \"Total de notas\": 3,\n" +
                "    \"Valor total\": 470,00,\n" +
                "    \"Notas\": [{\"id\": \"123\", \"data\": \"2025-02-16\", \"valor\": 120,00}, {\"id\": \"456\", \"data\": \"2025-02-16\", \"valor\": 300,00}, {\"id\": \"789\", \"data\": \"2025-02-16\", \"valor\": 50,00}]\n" +
                "  }\n" +
                "}";


        assertEquals(esperado, visitor.gerarRelatorioNotasEntrada(relatorioNotasEntrada));
    }

    @Test
    void RelatorioNotasSaidaJSON() {
        VisitorJSON visitor = new VisitorJSON();

        String esperado = "{\n" +
                "  \"Relatório de Notas de Saída\": {\n" +
                "    \"Mês\": \"2\",\n" +
                "    \"Total de notas\": 3,\n" +
                "    \"Valor total\": 580,00,\n" +
                "    \"Notas\": [{\"id\": \"147\", \"data\": \"2025-02-16\", \"valor\": 350,00}, {\"id\": \"258\", \"data\": \"2025-02-16\", \"valor\": 160,00}, {\"id\": \"369\", \"data\": \"2025-02-16\", \"valor\": 70,00}]\n" +
                "  }\n" +
                "}";

        assertEquals(esperado, visitor.gerarRelatorioNotasSaida(relatorioNotasSaida));
    }
}
