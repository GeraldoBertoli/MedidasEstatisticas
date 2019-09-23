package com.geraldobertoli.medidasestatisticas.modelo;

import java.util.ArrayList;
import java.util.List;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;

public class AmostrasModelo {
	private static List<Amostra> amostras = new ArrayList<Amostra>();
	private static AmostrasTableModel modeloAmostras = new AmostrasTableModel();

	/*
	public AmostrasModelo(){
		amostras = new ArrayList<Amostra>();
		modeloAmostras = new AmostrasTableModel();
	}
	*/
	
	public static void addAmostra(Amostra amostra){
		amostras.add(amostra);
		modeloAmostras = new AmostrasTableModel();
	}
	
	public static void atualizaAmostra(Amostra amostra){
		if(amostras.contains(amostra)){
			int posicao = amostras.indexOf(amostra);
			amostras.remove(posicao);
			amostras.add(posicao, amostra);
		}else{
			amostras.add(amostra);
		}
		
		modeloAmostras.addAmostra(amostra);
		
		//modeloAmostras.atualizaModelo(amostras);
		
		//modeloAmostras.atualizaModelo(amostras);
		//MedidasEstatisticasUI.pesquisar(new AmostrasTableModel(amostras));
	}
	
	public static void removeAmostra(Amostra amostra){
		amostras.remove(amostra);
	}
	
	public static List<Amostra> getAmostras() {
		return amostras;
	}

	public static void setAmostras(List<Amostra> amostras) {
		AmostrasModelo.amostras = amostras;
	}

	public static AmostrasTableModel getModeloAmostras() {
		return modeloAmostras;
	}

	public static void setModeloAmostras(AmostrasTableModel modeloAmostras) {
		modeloAmostras = modeloAmostras;
	}
}
