package com.geraldobertoli.medidasestatisticas.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.geraldobertoli.medidasestatisticas.entidade.Amostra;

@SuppressWarnings("serial")
public class AmostrasTableModel extends AbstractTableModel{
	
	private List<Amostra> amostras;
	private String[] colunas = new String[]{
		"Descrição", "NT"	
	};
	
	public AmostrasTableModel(){
		amostras = new ArrayList<Amostra>();
	}
	
	public AmostrasTableModel(List<Amostra> amostra){
		amostras = amostra;
	}
	
	public void atualizaModelo(List<Amostra> amostraAtualizada){
		amostras = amostraAtualizada;
		
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return amostras.size();
	}
	
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
	}
	
	public void setValueAt(Amostra aValue, int rowIndex){
		Amostra amostra = amostras.get(rowIndex);
		
		amostra.setDescricao(aValue.getDescricao());
		amostra.setValor(aValue.getValor());
		
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Amostra n = amostras.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return n.getDescricao();
		case 1:
			return n.getNumTermos();
		}
		return null;
	}
	
	public Amostra getAmostra(int rowIndex){
		return amostras.get(rowIndex);
	}
	
	public void addAmostra(Amostra a){
		amostras.add(a);
		
		int ultimoIndice = getRowCount() - 1;
		
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void removeAmostra(int rowIndex){
		amostras.remove(rowIndex);
		
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	public void addListaDeAmostras(List<Amostra> novasAmostras){
		int tamanhoAntigo = getRowCount();
		amostras.addAll(novasAmostras);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}
	
	public void limpar(){
		amostras.clear();
		fireTableDataChanged();
	}
	
	public boolean isEmpty(){
		return amostras.isEmpty();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	 }
}
