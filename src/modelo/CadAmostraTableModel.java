package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CadAmostraTableModel extends AbstractTableModel{
	private List<Double> amostra;
	
	public CadAmostraTableModel(){
		super();
		amostra = new ArrayList<Double>();
	}
	
	public CadAmostraTableModel(List<Double> amostra){
		super();
		this.amostra = amostra;
	}
	
	public List<Double> getAmostra() {
		return amostra;
	}
	
	public void setAmostra(List<Double> amostra){
		this.amostra = amostra;
		
		if(this.amostra.size() > 1){
			Collections.sort(amostra);
		}
	}
	
	//##########################
	//Código a ser testado
	public void addValue(double valor) {
		this.amostra.add(valor);
		
		if(this.amostra.size() > 1){
			Collections.sort(amostra);
		}
		
		int ultimoIndice = getRowCount() - 1;
		
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	//##########################
	
	public void removeValor(int index){
		if(index < amostra.size()){
			amostra.remove(index);
			fireTableRowsInserted(index, index);
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return amostra.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		double n = amostra.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return n;
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Código";
		case 1:
			return "Valor";
		}
		return "";
	 }

}
