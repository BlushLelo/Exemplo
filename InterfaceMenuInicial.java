import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMenuInicial extends JFrame{
	
	private JLabel label1;
	
	private JLabel TextoAba;
	
	private JButton Clientes;
	private JButton Produtos;
	private JButton MatériasPrimas;
	private JButton Fornecedores;
	private JButton Encomendas;
	private JButton Fabricações;
	private JButton Relatórios;
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
		
		MatériasPrimas = new JButton("Matérias Primas");
		MatériasPrimas.setBounds(50, 350, 175, 75);
		MatériasPrimas.setForeground(new Color(0, 124, 175));
		MatériasPrimas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(MatériasPrimas);
		
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
		
		Fabricações = new JButton("Fabricações");
		Fabricações.setBounds(235, 350, 175, 75);
		Fabricações.setForeground(new Color(0, 124, 175));
		Fabricações.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Fabricações);
		
		//
		
		Relatórios = new JButton("Relatórios");
		Relatórios.setBounds(420, 150, 175, 75);
		Relatórios.setForeground(new Color(0, 124, 175));
		Relatórios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		add(Relatórios);
		
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
		MatériasPrimas.addActionListener(handler);
		Fornecedores.addActionListener(handler);
		Encomendas.addActionListener(handler);
		Fabricações.addActionListener(handler);
		Relatórios.addActionListener(handler);
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
