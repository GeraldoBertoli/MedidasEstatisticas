package com.geraldobertoli.medidasestatisticas.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.geraldobertoli.medidasestatisticas.controle.ControleMedidasEstatisticas;
import com.geraldobertoli.medidasestatisticas.entidade.Amostra;
import com.geraldobertoli.medidasestatisticas.modelo.AmostrasTableModel;

import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MedidasEstatisticasUI{
	private JFrame janela;
	
	private JPanel painelPrincipal;
	
	private static JTable tabela;
	private AmostrasTableModel tableModel;
	private ControleMedidasEstatisticas controleMedidasEstatisticas;
	
	private JMenuBar barraMenu;
	private JMenu meAmostra;
	private JMenu meGrafico;
	private JMenuItem miNovaAmostra;
	private JMenuItem miEditarAmostra;
	private JMenuItem miExcluirAmostra;
	private JMenuItem miCalcSeparatriz;
	
	private CadAmostraUI cadAmostra;
	private CalcSeparatrizesUI calcSeparatrizes;
	
	private JTextField txtMAritmetica, txtMGeometrica, txtMHarmonica;
	private JTextField txtModa, txtMediana;
	private JTextField txtVariancia, txtDPadrao, txtCVariacao, txtEPX, txtAT;
	
	//Construtor
	public MedidasEstatisticasUI(){
		montaTela();
	}
	
	public void montaTela(){
		preparaJanela();
		preparaPainelPrincipal();
		preparaMenu();
		preparaPainelMedidas();
		preparaTabela();
		mostraJanela();
	}
	
	private void preparaJanela(){
		janela = new JFrame("Medidas Estatísticas");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public boolean estaVisivel(){
		return janela.isVisible();
	}

	private void preparaPainelPrincipal(){
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
		
		painelPrincipal.setLayout(new BorderLayout());
		
	}
	
	private void preparaMenu(){
		barraMenu = new JMenuBar();
		janela.setJMenuBar(barraMenu);
		
		meAmostra = new JMenu("Amostra");
		barraMenu.add(meAmostra);
		meGrafico = new JMenu("Gráfico");
		barraMenu.add(meGrafico);
		
		miNovaAmostra = new JMenuItem("Nova");
		miNovaAmostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadAmostra == null){
					cadAmostra = new CadAmostraUI(tableModel);
					cadAmostra.setLocationRelativeTo(janela);
				}else{
					cadAmostra.dispose();
					cadAmostra = new CadAmostraUI(tableModel);
				}
				cadAmostra.setVisible(true);
			}
		});
		meAmostra.add(miNovaAmostra);
		
		miEditarAmostra = new JMenuItem("Editar");
		miEditarAmostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mesma coisa que a opção NOVA, porém passando a amostra selecionada
				if(tabela.getSelectedRow() != -1){
					if(cadAmostra == null){
						cadAmostra = new CadAmostraUI(tableModel, tableModel.getAmostra(tabela.getSelectedRow()));
						cadAmostra.setLocationRelativeTo(janela);
					}else{
						cadAmostra.dispose();
						cadAmostra = new CadAmostraUI(tableModel, tableModel.getAmostra(tabela.getSelectedRow()));
						//tableModel.getAmostra(tabela.getSelectedRow())
						//cadAmostra.setExtendedState(JFrame.NORMAL);  
					    //cadAmostra.toFront();
					}
					cadAmostra.setVisible(true);
				}
			}
		});
		meAmostra.add(miEditarAmostra);
		
		miExcluirAmostra = new JMenuItem("Excluir");
		miExcluirAmostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getSelectedRow() != -1){
					tableModel.removeAmostra(tabela.getSelectedRow());
				}
			}
		});
		meAmostra.add(miExcluirAmostra);
		
		meAmostra.addSeparator();
		
		miCalcSeparatriz = new JMenuItem("Separatrizes");
		miCalcSeparatriz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getSelectedRow() != -1){
					calcSeparatrizes = new CalcSeparatrizesUI(tableModel.getAmostra(tabela.getSelectedRow()));
					calcSeparatrizes.setLocationRelativeTo(janela);
					/*
					if(calcSeparatrizes == null){
						calcSeparatrizes = new CalcSeparatrizesUI(tableModel.getAmostra(tabela.getSelectedRow()));
						calcSeparatrizes.setLocationRelativeTo(janela);
						
					}else{
						calcSeparatrizes.setExtendedState(JFrame.NORMAL);  
						calcSeparatrizes.toFront();

					} */
					calcSeparatrizes.setVisible(true);
				}
			}
		});
		meAmostra.add(miCalcSeparatriz);
		
	}
	
	private void preparaPainelMedidas(){
		JPanel painelMedidas = new JPanel();
		JPanel painelPosicao = new JPanel();
		JPanel painelDispersao = new JPanel();
		
		JPanel pnlMAritmetica = new JPanel();
		JPanel pnlMGeometrica = new JPanel();
		JPanel pnlMHarmonica = new JPanel();
		JPanel pnlModa = new JPanel();
		JPanel pnlMediana = new JPanel();
		
		JPanel pnlVariancia = new JPanel();
		JPanel pnlDesvPadrao = new JPanel();
		JPanel pnlCV = new JPanel();
		JPanel pnlEPX = new JPanel();
		JPanel pnlAT = new JPanel();
		
		txtMAritmetica = new JTextField();
		txtMAritmetica.setEditable(false);
		txtMGeometrica = new JTextField();
		txtMGeometrica.setEditable(false);
		txtMHarmonica = new JTextField();
		txtMHarmonica.setEditable(false);
		txtModa = new JTextField();
		txtModa.setEditable(false);
		txtMediana = new JTextField();
		txtMediana.setEditable(false);
		txtVariancia = new JTextField();
		txtVariancia.setEditable(false);
		txtDPadrao = new JTextField();
		txtDPadrao.setEditable(false);
		txtCVariacao = new JTextField();
		txtCVariacao.setEditable(false);
		txtEPX = new JTextField();
		txtEPX.setEditable(false);
		txtAT = new JTextField();
		txtAT.setEditable(false);
		
		painelMedidas.setLayout(new BoxLayout(painelMedidas, BoxLayout.PAGE_AXIS));
		painelMedidas.add(painelPosicao);
		painelMedidas.add(painelDispersao);
		
		//painelPosicao.setLayout(new BoxLayout(painelPosicao, BoxLayout.LINE_AXIS));
		painelPosicao.setLayout(new GridLayout(0, 5, 1, 2));
		painelPosicao.add(pnlMAritmetica);
		painelPosicao.add(pnlMGeometrica);
		painelPosicao.add(pnlMHarmonica);
		painelPosicao.add(pnlModa);
		painelPosicao.add(pnlMediana);
		
		//painelDispersao.setLayout(new BoxLayout(painelDispersao, BoxLayout.LINE_AXIS));
		painelDispersao.setLayout(new GridLayout(0, 5, 1, 2));
		painelDispersao.add(pnlVariancia);
		painelDispersao.add(pnlDesvPadrao);
		painelDispersao.add(pnlCV);
		painelDispersao.add(pnlEPX);
		painelDispersao.add(pnlAT);
		
		pnlMAritmetica.setLayout(new BoxLayout(pnlMAritmetica, BoxLayout.PAGE_AXIS));
		pnlMAritmetica.add(new JLabel("Média Aritmética"));
		pnlMAritmetica.add(txtMAritmetica);
		
		pnlMGeometrica.setLayout(new BoxLayout(pnlMGeometrica, BoxLayout.PAGE_AXIS));
		pnlMGeometrica.add(new JLabel("Média Geométrica"));
		pnlMGeometrica.add(txtMGeometrica);
		
		pnlMHarmonica.setLayout(new BoxLayout(pnlMHarmonica, BoxLayout.PAGE_AXIS));
		pnlMHarmonica.add(new JLabel("Média Harmônica"));
		pnlMHarmonica.add(txtMHarmonica);
		
		pnlModa.setLayout(new BoxLayout(pnlModa, BoxLayout.PAGE_AXIS));
		pnlModa.add(new JLabel("Moda"));
		pnlModa.add(txtModa);
		
		pnlMediana.setLayout(new BoxLayout(pnlMediana, BoxLayout.PAGE_AXIS));
		pnlMediana.add(new JLabel("Mediana"));
		pnlMediana.add(txtMediana);
		
		pnlVariancia.setLayout(new BoxLayout(pnlVariancia, BoxLayout.PAGE_AXIS));
		pnlVariancia.add(new JLabel("Variância"));
		pnlVariancia.add(txtVariancia);
		
		pnlDesvPadrao.setLayout(new BoxLayout(pnlDesvPadrao, BoxLayout.PAGE_AXIS));
		pnlDesvPadrao.add(new JLabel("Desvio Padrão"));
		pnlDesvPadrao.add(txtDPadrao);
		
		pnlCV.setLayout(new BoxLayout(pnlCV, BoxLayout.PAGE_AXIS));
		pnlCV.add(new JLabel("Coeficiente de Variação"));
		pnlCV.add(txtCVariacao);
		
		pnlEPX.setLayout(new BoxLayout(pnlEPX, BoxLayout.PAGE_AXIS));
		pnlEPX.add(new JLabel("Erro Padrão da Média"));
		pnlEPX.add(txtEPX);
		
		pnlAT.setLayout(new BoxLayout(pnlAT, BoxLayout.PAGE_AXIS));
		pnlAT.add(new JLabel("Amplitude Total"));
		pnlAT.add(txtAT);
		
		painelPrincipal.add(painelMedidas, BorderLayout.NORTH);
	}
	
	private void preparaTabela(){
		controleMedidasEstatisticas = new ControleMedidasEstatisticas();
		tableModel = controleMedidasEstatisticas.getTableModel();
		
		tabela = new JTable(controleMedidasEstatisticas.getTableModel());
		
		tabela.getColumnModel().getColumn(1).setMinWidth(150);
		tabela.getColumnModel().getColumn(1).setMaxWidth(200);
		
		// por padrão, vem sem bordas, então colocamos:
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);
		
		tabela.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.rowAtPoint(arg0.getPoint());
				
				txtMAritmetica.setText(String.valueOf(controleMedidasEstatisticas.calcMediaAritmetica(tableModel.getAmostra(row))));
				txtMGeometrica.setText(String.valueOf(controleMedidasEstatisticas.calcMediaGeometrica(tableModel.getAmostra(row))));
				txtMHarmonica.setText(String.valueOf(controleMedidasEstatisticas.calcMediaHarmonica(tableModel.getAmostra(row))));
				txtModa.setText(String.valueOf(controleMedidasEstatisticas.calcModa(tableModel.getAmostra(row))));
				txtMediana.setText(String.valueOf(controleMedidasEstatisticas.calcMediana(tableModel.getAmostra(row))));
				txtVariancia.setText(String.valueOf(controleMedidasEstatisticas.calcVariancia(tableModel.getAmostra(row))));
				txtDPadrao.setText(String.valueOf(controleMedidasEstatisticas.calcDesvPadrao(tableModel.getAmostra(row))));
				txtCVariacao.setText(String.valueOf(controleMedidasEstatisticas.calcCV(tableModel.getAmostra(row))));
				txtEPX.setText(String.valueOf(controleMedidasEstatisticas.calcEPX(tableModel.getAmostra(row))));
				txtAT.setText(String.valueOf(controleMedidasEstatisticas.calcAT(tableModel.getAmostra(row))));
				
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
				
		JScrollPane scroll = new JScrollPane(); 
		scroll.setSize(new Dimension(640, 320));
		scroll.getViewport().setBorder(null);
		scroll.getViewport().add(tabela);
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		pesquisar(tableModel);
	}
	
	public static void pesquisar(AmostrasTableModel modelo){
		tabela.setModel(modelo);
	}

	private void mostraJanela(){
		janela.setMinimumSize(new Dimension(800, 320));
	    janela.setSize(800, 320);
	    janela.setLocationRelativeTo(null);
	    janela.pack();
	    janela.setExtendedState(Frame.MAXIMIZED_BOTH);
	    //A SplashScreen vai aqui
	    
	    janela.setVisible(true);
		
	}
	
}
