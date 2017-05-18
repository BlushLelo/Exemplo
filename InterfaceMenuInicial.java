import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMenuInicial extends JFrame{
	
	private JLabel label1;
	
	private JLabel TextoAba;
	
	private JButton Clientes;
	private JButton Produtos;
	private JButton Mat�riasPrimas;
	private JButton Fornecedores;
	private JButton Encomendas;
	private JButton Fabrica��es;
	private JButton Relat�rios;
	private JButton Estoques;
	private JButton ImpostoRenda;
	private JButton Compras;
	private JButton Vendas;
	private JButton ControleValidade;
	
	public InterfaceMenuInicial()
	{
		super("Doces da Mamma");
		setLayout(null);
		
		TextoAba = new JLabel ("Menu Inicial");
		TextoAba.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAba.setForeground(Color.WHITE);
		TextoAba.setVisible(true);
		TextoAba.setBounds(375,50,300,50);
		add(TextoAba);
		
		//
		
		Clientes = new JButton("Clientes");
		Clientes.setBounds(50, 150, 175, 75);
		Clientes.setForeground(new Color(0, 124, 175));
		Clientes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Clientes);
		
		Produtos = new JButton("Produtos");
		Produtos.setBounds(50, 250, 175, 75);
		Produtos.setForeground(new Color(0, 124, 175));
		Produtos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Produtos);
		
		Mat�riasPrimas = new JButton("Mat�rias Primas");
		Mat�riasPrimas.setBounds(50, 350, 175, 75);
		Mat�riasPrimas.setForeground(new Color(0, 124, 175));
		Mat�riasPrimas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Mat�riasPrimas);
		
		//
		
		Fornecedores = new JButton("Fornecedores");
		Fornecedores.setBounds(235, 150, 175, 75);
		Fornecedores.setForeground(new Color(0, 124, 175));
		Fornecedores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Fornecedores);
		
		Encomendas = new JButton("Encomendas");
		Encomendas.setBounds(235, 250, 175, 75);
		Encomendas.setForeground(new Color(0, 124, 175));
		Encomendas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Encomendas);
		
		Fabrica��es = new JButton("Fabrica��es");
		Fabrica��es.setBounds(235, 350, 175, 75);
		Fabrica��es.setForeground(new Color(0, 124, 175));
		Fabrica��es.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Fabrica��es);
		
		//
		
		Relat�rios = new JButton("Relat�rios");
		Relat�rios.setBounds(420, 150, 175, 75);
		Relat�rios.setForeground(new Color(0, 124, 175));
		Relat�rios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Relat�rios);
		
		Estoques = new JButton("Estoques");
		Estoques.setBounds(420, 250, 175, 75);
		Estoques.setForeground(new Color(0, 124, 175));
		Estoques.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Estoques);
		
		ImpostoRenda = new JButton("Imposto de Renda");
		ImpostoRenda.setBounds(420, 350, 175, 75);
		ImpostoRenda.setForeground(new Color(0, 124, 175));
		ImpostoRenda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(ImpostoRenda);
		
		//
		
		Compras = new JButton("Compras");
		Compras.setBounds(605, 150, 175, 75);
		Compras.setForeground(new Color(0, 124, 175));
		Compras.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Compras);
		
		Vendas = new JButton("Vendas");
		Vendas.setBounds(605, 250, 175, 75);
		Vendas.setForeground(new Color(0, 124, 175));
		Vendas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Vendas);
		
		ControleValidade = new JButton("Controle de \nValidade");
		ControleValidade.setBounds(605, 350, 175, 75);
		ControleValidade.setForeground(new Color(0, 124, 175));
		ControleValidade.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(ControleValidade);
		
		//
		
		Icon imagem = new ImageIcon(getClass().getResource( "Base.png" ));
		label1 = new JLabel ("", imagem, SwingConstants.RIGHT);
		label1.setBounds(0, 1, 819, 460);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.TOP);
		add(label1);
		
		//
		
		ButtonHandler handler = new ButtonHandler();
		Clientes.addActionListener(handler);
		Produtos.addActionListener(handler);
		Mat�riasPrimas.addActionListener(handler);
		Fornecedores.addActionListener(handler);
		Encomendas.addActionListener(handler);
		Fabrica��es.addActionListener(handler);
		Relat�rios.addActionListener(handler);
		Estoques.addActionListener(handler);
		ImpostoRenda.addActionListener(handler);
		Vendas.addActionListener(handler);
		ControleValidade.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(event.getSource() == Clientes) 
			{
				InterfaceClientes menu = new InterfaceClientes();
				menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menu.setBounds(0,0,819,490);
				menu.setResizable(false);
				menu.setVisible(true);
			}
		}
	}
}
