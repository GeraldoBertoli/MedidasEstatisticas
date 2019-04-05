package entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amostra {
	private String descricao;
	private List<Double> valor;
	
	public Amostra(String descricao, List<Double> valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Amostra(){
		this.descricao = "";
		this.valor = new ArrayList<Double>();
	}
	
	public void addValor(double valor){
		this.valor.add(valor);
		if(this.valor.size() > 1){
			Collections.sort(this.valor);
		}
	}
	
	public void addValor(double valor, int freq){
		if(freq > 0){
			for(int i = 0; i < freq; i ++){
				this.valor.add(valor);
			}
		}
		if(this.valor.size() > 1){
			Collections.sort(this.valor);
		}
	}
	
	public void removeValor(int index){
		this.valor.remove(index);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorAt(int posicao) {
		return valor.get(posicao);
	}
	public void setValorAt(int posicao, double valor) {
		this.valor.set(posicao, valor);
	}
	
	public List<Double> getValor(){
		return this.valor;
	}
	
	public void setValor(List<Double> valor){
		this.valor = valor;
	}
	
	public int getNumTermos(){
		return valor.size();
	}
	
}
