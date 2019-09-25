package com.geraldobertoli.medidasestatisticas.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.CalcSeparatrizes;

public class TestCalcSeparatrizes
{
    @Test
    public void testCalcSeparatrizesQuartil()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(15.0, new CalcSeparatrizes().calcSeparatrizes(amostra, 0, 1), 0.1);
    }

    @Test
    public void testCalcSeparatrizesDecil()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(15.0, new CalcSeparatrizes().calcSeparatrizes(amostra, 1, 4), 0.1);
    }

    @Test
    public void testCalcSeparatrizesPercentil()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(15.0, new CalcSeparatrizes().calcSeparatrizes(amostra, 2, 49), 0.1);
    }
}