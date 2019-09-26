package com.geraldobertoli.medidasestatisticas.controle;

import java.util.Collections;
import java.util.List;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.AmostrasModelo;
import com.geraldobertoli.medidasestatisticas.modelo.AmostrasTableModel;
import com.geraldobertoli.medidasestatisticas.modelo.CalcMedidasEstatisticas;

public class ControleMedidasEstatisticas {
	
	public AmostrasTableModel getTableModel(){
		return new CalcMedidasEstatisticas().getTableModel();
	}
	
	//#####################################################
	//Medidas de posição
	
	public double calcMediaAritmetica(Amostra amostra){
		return new CalcMedidasEstatisticas().calcMediaAritmetica(amostra);
	}
	
	public double calcMediaGeometrica(Amostra amostra){
		return new CalcMedidasEstatisticas().calcMediaGeometrica(amostra);
	}

	public double calcMediaHarmonica(Amostra amostra){
		return new CalcMedidasEstatisticas().calcMediaHarmonica(amostra);
	}

	public double calcModa(Amostra amostra){
		return new CalcMedidasEstatisticas().calcModa(amostra);
	}
	
	public double calcMediana(Amostra amostra){
		return new CalcMedidasEstatisticas().calcMediana(amostra);
	}
	
	//###########################################
	//Medidas de dispersão
	
	public double calcVariancia(Amostra amostra){
		return new CalcMedidasEstatisticas().calcVariancia(amostra);
	}

	public double calcDesvPadrao(Amostra amostra){
		return new CalcMedidasEstatisticas().calcDesvPadrao(amostra);
	}

	public double calcCV(Amostra amostra){
		return new CalcMedidasEstatisticas().calcCV(amostra);
	}

	public double calcEPX(Amostra amostra){
		return new CalcMedidasEstatisticas().calcEPX(amostra);
	}
	
	public double calcAT(Amostra amostra){
		return new CalcMedidasEstatisticas().calcAT(amostra);
	}
	
}
