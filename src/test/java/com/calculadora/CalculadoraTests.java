package com.calculadora;


import com.jayway.jsonpath.internal.filter.ValueNodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java .awt.event.FocusEvent;

public class CalculadoraTests {

    @Test
    public void deveRetornarAreaDoTriangulo() throws LadosInvalidosException {
        double valor_a=3;
        double valor_b=4;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        double resultado = calc.areaTriangulo(valor_a,valor_b,valor_c);
        double esperado = 6;
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    public void deveLancarLadosInvalidosException_quandoLadosNaoFormamUmTriangulo() throws LadosInvalidosException {
        double valor_a=100;
        double valor_b=4;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        Exception e = Assertions.assertThrows(LadosInvalidosException.class,() -> {calc.areaTriangulo(valor_a,valor_b,valor_c);});
    }

    @Test
    public void deveRetornarSemiperimetro() {
        double valor_a=3;
        double valor_b=4;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        double resultado = calc.semiPerimetro(valor_a, valor_b, valor_c);
        double esperado = 6;
        Assertions.assertEquals(esperado, resultado);

    }


    @Test
    public void deveRetornarVerdadeiro_quandoLadosFormamUmTriangulo() {
        double valor_a=3;
        double valor_b=4;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void deveRetornarFalso_quandoLadoAMaiorOuIgualSomaDosDemaisLados() {
        double valor_a=10;
        double valor_b=4;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void deveRetornarFalso_quandoLadoBMaiorOuIgualSomaDosDemaisLados() {
        double valor_a=4;
        double valor_b=10;
        double valor_c=5;
        Calculadora calc = new Calculadora();
        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void deveRetornarFalso_quandoLadoCMaiorOuIgualSomaDosDemaisLados() {
        double valor_a=3;
        double valor_b=4;
        double valor_c=7;
        Calculadora calc = new Calculadora();
        Boolean resultado = calc.isTriangulo(valor_a, valor_b, valor_c);
        Assertions.assertFalse(resultado);
    }
}
