package com.geraldobertoli.medidasestatisticas.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.geraldobertoli.medidasestatisticas.controle.ControleCadAmostra;
import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.AmostrasTableModel;
import com.geraldobertoli.medidasestatisticas.modelo.CadAmostraTableModel;

@SuppressWarnings("serial")
public class CadAmostraUI extends JFrame{
	private JPanel painelPrincipal;
	
	private JTable tabela;
	
	private ControleCadAmostra controleCadAmostra;
	
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtFreq;
	
	private JButton btnInserir;
	private JButton btnCancelar;
	
	private Amostra amostra;
	private CadAmostraTableModel modelo;
	private AmostrasTableModel tableModel;
	
	public CadAmostraUI(AmostrasTableModel medidasTableModel){
		this.tableModel = medidasTableModel;
		montaTela();
	}
	
	public CadAmostraUI(AmostrasTableModel medidasTableModel, Amostra amostra){
		this.amostra = amostra;
		this.txtDescricao = new JTextField(this.amostra.getDescricao());

		this.tableModel = medidasTableModel;
		
		montaTela();
	}
	
	public void montaTela(){
		preparaJanela();
		preparaPainelPrincipal();
		preparaPainelSuperior();
		preparaTabela();
		montaJanela();
	}
	
	private void preparaJanela(){
		this.setTitle("Cadastro de Amostra");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setResizable(false);
	    
	    controleCadAmostra = new ControleCadAmostra();
	}

	private void preparaPainelPrincipal(){
		painelPrincipal = new JPanel();
		this.add(painelPrincipal);
		
		painelPrincipal.setLayout(new BorderLayout());
	}
	
	private void preparaPainelSuperior() {
		JPanel painelSuperior = new JPanel();
		JPanel painelDescricao = new JPanel();
		JPanel painelForm = new JPanel();
		JPanel painelFreq = new JPanel();
		JPanel painelBotoes = new JPanel();
		
		JLabel lblDescricao = new JLabel("Descrição");
		JLabel lblValor = new JLabel("Valor");
		JLabel lblFreq = new JLabel("Frequência");
		
		if(txtDescricao == null){
			txtDescricao = new JTextField();
		}
		txtValor = new JTextField();
		txtFreq = new JTextField("1");
		
		btnInserir = new JButton("Inserir");
		btnCancelar = new JButton("Cancelar");
		
		painelPrincipal.add(painelSuperior, BorderLayout.NORTH);
		
		painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.LINE_AXIS));
		
		painelBotoes.setMaximumSize(new Dimension(100, 50));
		
		painelSuperior.add(painelDescricao);
		//painelSuperior.add(Box.createHorizontalGlue());
		painelSuperior.add(painelForm);
		//painelSuperior.add(Box.createHorizontalGlue());
		painelSuperior.add(painelFreq);
		//painelSuperior.add(Box.createHorizontalGlue());
		painelSuperior.add(painelBotoes);
		
		painelDescricao.setLayout(new GridLayout(2, 0));
		painelForm.setLayout(new GridLayout(2, 0));
		painelFreq.setLayout(new GridLayout(2, 0));
		painelBotoes.setLayout(new GridLayout(2, 0));
		
		painelDescricao.add(lblDescricao);
		painelDescricao.add(txtDescricao);
		
		painelForm.add(lblValor);
		painelForm.add(txtValor);
		
		painelFreq.add(lblFreq);
		painelFreq.add(txtFreq);
		
		painelBotoes.add(btnInserir);
		btnInserir.setMaximumSize(new Dimension(180, 25));
		painelBotoes.add(btnCancelar);
		btnCancelar.setMaximumSize(new Dimension(180, 25));
		
		//O primeiro foco na janela vai para o txtDescricao
		txtDescricao.requestFocus();
		
		//Eventos
		
		txtDescricao.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					txtValor.requestFocus();
					txtValor.selectAll();
				}
			}
		});
		
		txtValor.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					txtFreq.requestFocus();
					txtFreq.selectAll();
				}
			}
			
		});
		
		
		txtFreq.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					btnInserir.requestFocus();
				}
			}
			
		});
		
		btnInserir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				acaoBtnInserir();
			}
			
		});
		
		btnInserir.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					acaoBtnInserir();
				}
			}
			
		});
		
		btnCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				acaoBtnCancelar();
			}
			
		});
		
		btnCancelar.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					acaoBtnCancelar();
				}
			}
			
		});
	}
	
	private void acaoBtnInserir(){
		
		if((!txtValor.getText().equals("")) && (!txtFreq.getText().equals(""))){
			try{
				for(int i = 0; i < Integer.parseInt(txtFreq.getText()); i++){
					modelo.addValue(Double.parseDouble(txtValor.getText()));
					amostra.setDescricao(txtDescricao.getText()); //Bugfix-iss4
					controleCadAmostra.atualizaAmostra(amostra);
					tableModel.fireTableDataChanged();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		txtValor.setText("");
		txtValor.requestFocus();
		txtFreq.setText("1");
	}
	
	private void acaoBtnCancelar(){
		txtValor.setText("");
		txtValor.requestFocus();
		txtFreq.setText("1");
	}
	
	private void preparaTabela(){
		if(amostra != null){
			modelo = controleCadAmostra.getModelo(amostra.getValor());
		}else{
			amostra = new Amostra();
			modelo = new CadAmostraTableModel(amostra.getValor());
		}
		
		tabela = new JTable(modelo);
		
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);
		
		JScrollPane scroll = new JScrollPane(); 
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(tabela);
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		tabela.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				if(arg0.getClickCount() == 2){
					((CadAmostraTableModel)tabela.getModel()).removeValor(row);
					txtValor.requestFocus();
					tableModel.fireTableDataChanged();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
		});
		
	}
	
	private void montaJanela(){
		this.setMinimumSize(new Dimension(640, 480));
	    this.setSize(640, 480);
	    //this.setLocationRelativeTo(null);
	    this.pack();
	}
}
