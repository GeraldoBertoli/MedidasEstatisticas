package com.geraldobertoli.medidasestatisticas.visao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalcSeparatrizesUI extends JFrame{
	private JPanel painelPrincipal;
	
	private JComboBox cbMedida;
	private JComboBox cbPosicao;
	
	private JTextField txtValor;
	
	public CalcSeparatrizesUI(){
		preparaJanela();
		preparaComponentes();
		montaJanela();
		
	}
	
	private void preparaJanela() {
		this.setTitle("Cálculo de Separatrizes");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    
	    painelPrincipal = new JPanel();
	    this.add(painelPrincipal);
	    
	    painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.PAGE_AXIS));
	}

	private void preparaComponentes() {
		cbMedida = new JComboBox();
		cbPosicao = new JComboBox();
		txtValor = new JTextField("0,0");
		txtValor.setEnabled(false);
		
		cbMedida.addItem(new String("Quartil"));
		
		cbMedida.addItem(new String("Decil"));
		cbMedida.addItem(new String("Percentil"));
		
		cbMedida.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				switch(cbMedida.getSelectedIndex()){
				case 0:
					cbPosicao.addItem(new String("1"));
					cbPosicao.addItem(new String("2"));
					cbPosicao.addItem(new String("3"));
					break;
				case 1:
					for(int i = 0; i < 9; i++){
						cbPosicao.addItem(new String(""+(i+1)));
					}
					break;
				case 2:
					for(int i = 0; i < 99; i++){
						cbPosicao.addItem(new String(""+(i+1)));
					}
					break;
				}
				
				cbPosicao.setSelectedIndex(0);
			}
		});
		
		cbPosicao.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(((String)cbMedida.getSelectedItem()).equalsIgnoreCase("Quartil")){
					if(((String)cbMedida.getSelectedItem()).equalsIgnoreCase("1")){
						txtValor.setText("Teste");
					}
				}
			}
		});
		
		painelPrincipal.add(new JLabel("Medida separatriz"));
		painelPrincipal.add(Box.createVerticalGlue());
		
		painelPrincipal.add(cbMedida);
		painelPrincipal.add(Box.createVerticalGlue());
		
		painelPrincipal.add(new JLabel("Posição da medida"));
		painelPrincipal.add(Box.createVerticalGlue());
		
		painelPrincipal.add(cbPosicao);
		painelPrincipal.add(Box.createVerticalGlue());
		
		painelPrincipal.add(new JLabel("Valor"));
		painelPrincipal.add(Box.createVerticalGlue());
		
		painelPrincipal.add(txtValor);
	}
	
	private void montaJanela() {
		this.setMinimumSize(new Dimension(300, 150));
	    this.pack();
	}

}
