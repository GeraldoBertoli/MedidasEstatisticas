package com.geraldobertoli.medidasestatisticas.controle;

import java.util.List;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.CadAmostraTableModel;
import com.geraldobertoli.medidasestatisticas.modelo.AmostrasModelo;

public class ControleCadAmostra {
	
	public CadAmostraTableModel getModelo(List<Double> amostra){
		
		return new CadAmostraTableModel(amostra);
	}
	
	public void atualizaAmostra(Amostra amostra){
		AmostrasModelo.atualizaAmostra(amostra);
	}
	
	public CadAmostraTableModel getModelo(){
		return new CadAmostraTableModel();
	}
}
