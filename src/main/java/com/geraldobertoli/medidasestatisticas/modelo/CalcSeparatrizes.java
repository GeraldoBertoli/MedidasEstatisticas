package com.geraldobertoli.medidasestatisticas.modelo;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;

public class CalcSeparatrizes {
    public double calcSeparatrizes(Amostra amostra, int medida, int posicao)
    {
        double resultado = 0.0;

        switch(medida)
        {
            case 0:
                //Quartil
                resultado = ( ( ( amostra.getValorAt(amostra.getNumTermos()-1) - amostra.getValorAt(0) ) / 4 ) * (posicao + 1) ) + amostra.getValorAt(0);
                break;
            case 1:
                //Decil
                resultado = ( ( ( amostra.getValorAt(amostra.getNumTermos()-1) - amostra.getValorAt(0) ) / 10 ) * (posicao + 1) ) + amostra.getValorAt(0);
                break;
            case 2:
                //Percentil
                resultado = ( ( ( amostra.getValorAt(amostra.getNumTermos()-1) - amostra.getValorAt(0) ) / 100 ) * (posicao + 1) ) + amostra.getValorAt(0);
                break;
        }

        return resultado;
    }
}