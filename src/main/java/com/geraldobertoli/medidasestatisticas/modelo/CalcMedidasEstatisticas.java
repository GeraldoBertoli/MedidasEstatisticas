package com.geraldobertoli.medidasestatisticas.modelo;

import java.util.Collections;
import java.util.List;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
//import com.geraldobertoli.medidasestatisticas.modelo.AmostrasModelo;
//import com.geraldobertoli.medidasestatisticas.modelo.AmostrasTableModel;

public class CalcMedidasEstatisticas {
	
	public AmostrasTableModel getTableModel(){
		AmostrasTableModel amostrasTableModel = new AmostrasTableModel(AmostrasModelo.getAmostras());
		
		AmostrasModelo.setModeloAmostras(amostrasTableModel);
		
		return amostrasTableModel;
	}
	
	//#####################################################
	//Medidas de posição
	
	public double calcMediaAritmetica(Amostra amostra){
		List<Double> valores = amostra.getValor();
		double media = 0;
		
		for(int i = 0; i < valores.size(); i++){
			media += valores.get(i);
		}
		
		media /= valores.size();
		
		return media;
	}
	
	public double calcMediaGeometrica(Amostra amostra){
		List<Double> valores = amostra.getValor();
		double media = 1;
		
		for(int i = 0; i < valores.size(); i++){
			media *= valores.get(i);
		}
		
		media = Math.pow(media, 1.0/(valores.size()));
		
		return media;
	}

	public double calcMediaHarmonica(Amostra amostra){
		List<Double> valores = amostra.getValor();
		double media = 0;
		
		for(int i = 0; i < valores.size(); i++){
			media += 1/valores.get(i);
		}
		
		media = valores.size()/media;
		
		return media;
	}

	public double calcModa(Amostra amostra){
		List<Double> valores = amostra.getValor();
		int cont = 0;
		int aux = 1;
		double moda = 0;
		
		for(int i = 1; i < valores.size(); i++){
			double valor1 = valores.get(i-1);
			double valor2 = valores.get(i);
			if(valor1 == valor2){
				aux++;
				if(aux > cont){
					cont = aux;
					moda = valores.get(i);
				}
			}else{
				aux = 1;
			}
		}
		
		return moda;
	}
	
	public double calcMediana(Amostra amostra){
		List<Double> valores = amostra.getValor();
		double mediana = 0;
		
		if(valores.size() % 2 == 0){
			mediana = ((valores.get((valores.size()/2)) + (valores.get((valores.size()/2)-1)))/2);
		}else{
			mediana = valores.get(valores.size()/2);
		}
		
		return mediana;
	}
	
	//###########################################
	//Medidas de dispersão
	
	public double calcVariancia(Amostra amostra){
		List<Double> valores = amostra.getValor();
		double media = calcMediaAritmetica(amostra);
		double variancia = 0;
		
		for(int i = 0; i < valores.size(); i++){
			variancia += (Math.pow((valores.get(i)-media), 2));
		}
		
		variancia /= valores.size()-1.0;
		
		return variancia;
	}

	public double calcDesvPadrao(Amostra amostra){
		return Math.sqrt(calcVariancia(amostra));
	}

	public double calcCV(Amostra amostra){
		return calcDesvPadrao(amostra)/calcMediaAritmetica(amostra)*100;
	}

	public double calcEPX(Amostra amostra){
		return calcDesvPadrao(amostra)/Math.sqrt(amostra.getValor().size());
	}
	
	public double calcAT(Amostra amostra){
		List<Double> valores = amostra.getValor();
		return valores.get(valores.size()-1) - valores.get(0);
	}
	
}
