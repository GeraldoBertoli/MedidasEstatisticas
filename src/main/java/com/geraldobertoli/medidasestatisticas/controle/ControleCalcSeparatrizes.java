package com.geraldobertoli.medidasestatisticas.controle;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.CalcSeparatrizes;

public class ControleCalcSeparatrizes {
    public double calcSeparatrizes(Amostra amostra, int medida, int posicao){
        return new CalcSeparatrizes().calcSeparatrizes(amostra, medida, posicao);
    }
}
