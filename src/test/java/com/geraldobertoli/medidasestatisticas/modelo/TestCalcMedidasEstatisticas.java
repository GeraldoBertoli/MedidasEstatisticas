package com.geraldobertoli.medidasestatisticas.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.CalcMedidasEstatisticas;;

public class TestCalcMedidasEstatisticas
{
    @Test
    public void testCalcMediaAritmetica()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(15.0, new CalcMedidasEstatisticas().calcMediaAritmetica(amostra), 0.1);
    }
    
    @Test
    public void testCalcMediaGeometrica()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(14.1, new CalcMedidasEstatisticas().calcMediaGeometrica(amostra), 0.1);
    }
    
    @Test
    public void testCalcMediaHarmonica()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(13.3, new CalcMedidasEstatisticas().calcMediaHarmonica(amostra), 0.1);
    }
    
    @Test
    public void testCalcModa()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(0.0, new CalcMedidasEstatisticas().calcModa(amostra), 0.1);
    }
    
    @Test
    public void testCalcMediana()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(15.0, new CalcMedidasEstatisticas().calcMediana(amostra), 0.1);
    }
    
    @Test
    public void testCalcVariancia()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(50.0, new CalcMedidasEstatisticas().calcVariancia(amostra), 0.1);
    }
    
    @Test
    public void testCalcDesvPadrao()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(7.1, new CalcMedidasEstatisticas().calcDesvPadrao(amostra), 0.1);
    }
    
    @Test
    public void testCalcCV()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(47.1, new CalcMedidasEstatisticas().calcCV(amostra), 0.1);
    }
    
    @Test
    public void testCalcEPX()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(5.0, new CalcMedidasEstatisticas().calcEPX(amostra), 0.1);
    }
    
    @Test
    public void testCalcAT()
    {
        Amostra amostra = new Amostra();
        amostra.addValor(10);
        amostra.addValor(20);
        assertEquals(10.0, new CalcMedidasEstatisticas().calcAT(amostra), 0.1);
    }
}