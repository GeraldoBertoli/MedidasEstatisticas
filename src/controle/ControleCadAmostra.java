package controle;

import java.util.List;

import entidade.Amostra;
import modelo.CadAmostraTableModel;
import modelo.AmostrasModelo;

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
