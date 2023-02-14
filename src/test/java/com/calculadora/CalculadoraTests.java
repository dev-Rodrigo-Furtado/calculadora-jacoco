package com.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTests {

    public Calculadora calc;

    @BeforeEach
    public void init(){
        calc = spy(new Calculadora());
    }

    @Test
    public void deveRetornarAreaDoTriangulo() throws LadosInvalidosException {
        double valor_a = 3;
        double valor_b = 4;
        double valor_c = 5;

        double resultado = calc.areaTriangulo(valor_a, valor_b, valor_c);
        double esperado = 6;

        assertEquals(esperado,resultado);
        verify(calc, times(1)).isTriangulo(valor_a, valor_b, valor_c);
        verify(calc, times(1)).semiPerimetro(valor_a, valor_b, valor_c);
    }

    @Test
    public void deveLancarLadosInvalidosException_quandoLadosNaoFormamUmTriangulo() throws LadosInvalidosException {
        double valor_a = 100;
        double valor_b = 4;
        double valor_c = 5;

        assertThrows(LadosInvalidosException.class,() -> {calc.areaTriangulo(valor_a,valor_b,valor_c);});
    }

    @Test
    public void deveRetornarSemiperimetro() {
        double valor_a = 3;
        double valor_b = 4;
        double valor_c = 5;

        double resultado = calc.semiPerimetro(valor_a, valor_b, valor_c);
        double esperado = 6;
        assertEquals(esperado, resultado);


    }


    @Test
    public void deveRetornarVerdadeiro_quandoLadosFormamUmTriangulo() {
        double valor_a = 3;
        double valor_b = 4;
        double valor_c = 5;

        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        assertTrue(resultado);
    }


    @ParameterizedTest(name = "Lado {0} maior")
    @CsvSource({
        "A, 10, 4, 5",
        "B, 4, 10, 5",
        "C, 3, 4, 7"

    })
    public void deveRetornarFalso_quandoUmLadosLadosAMaiorOuIgualSomaDosDemaisLados
            (final String nomeTeste, final double valor_a, final double valor_b, final double valor_c ) {
        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        assertFalse(resultado);

    }

}
