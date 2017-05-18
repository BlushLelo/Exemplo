import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InterfaceClientes extends JFrame{
	
	private JLabel label1;
	
	private JLabel TextoAba;
	
	private JButton AdicionarClientes;
	private JButton RemoverClientes;
	private JButton EditarClientes;
	private JButton ListarClientes;
	
	private JButton Voltar;
	private Statement statement;
	
	
	
	public InterfaceClientes()
	{
		super("Doces da Mamma");
		 String connectionUrl = "jdbc:sqlserver://localhost:3310;"
			        + "databaseName=DOCES MAMMA;integratedSecurity=true;";
			         try {
			               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			               Connection conn = DriverManager.getConnection(connectionUrl);
			        
			               System.out.println("Conexão obtida com sucesso.");
			               
			               statement = conn.createStatement();
			               
			               String sql ="IF NOT EXISTS (select * from sysobjects where name='CLIENTES' and xtype='U') " + 
			               "CREATE TABLE CLIENTES " +
			                       "( " +
			                       " nome VARCHAR(55) not NULL, " +  
			                       " telefone VARCHAR(15), " + 
			                       " aniversario date, " +
			                       " email VARCHAR(55), " +
			                       " PRIMARY KEY ( nome ))"; 

			               statement.executeUpdate(sql);
			               
			               
			         } catch (SQLException ex) {
			               System.out.println("SQLException: " + ex.getMessage());
			               System.out.println("SQLState: " + ex.getSQLState());
			               System.out.println("VendorError: " + ex.getErrorCode());
			             } catch (Exception e) {
			       System.out.println("Problemas ao tentar conectar com o banco de dados: "+ e);
			              }
		setLayout(null);
		
		TextoAba = new JLabel ("Clientes");
		TextoAba.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAba.setForeground(Color.WHITE);
		TextoAba.setVisible(true);
		TextoAba.setBounds(400,50,300,50);
		add(TextoAba);
		
		AdicionarClientes = new JButton("Adicionar Cliente");
		AdicionarClientes.setBounds(320, 150, 250, 50);
		AdicionarClientes.setForeground(new Color(0, 124, 175));
		AdicionarClientes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(AdicionarClientes);
		
		RemoverClientes = new JButton("Remover Cliente");
		RemoverClientes.setBounds(320, 210, 250, 50);
		RemoverClientes.setForeground(new Color(0, 124, 175));
		RemoverClientes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(RemoverClientes);
		
		EditarClientes = new JButton("Editar Cliente");
		EditarClientes.setBounds(320, 270, 250, 50);
		EditarClientes.setForeground(new Color(0, 124, 175));
		EditarClientes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(EditarClientes);
		
		ListarClientes = new JButton("Listar Clientes");
		ListarClientes.setBounds(320, 330, 250, 50);
		ListarClientes.setForeground(new Color(0, 124, 175));
		ListarClientes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(ListarClientes);
		
		Voltar = new JButton("Voltar");
		Voltar.setBounds(650, 370, 100, 50);
		Voltar.setForeground(new Color(0, 124, 175));
		Voltar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(Voltar);
		
		
		//
		
		Icon imagem = new ImageIcon(getClass().getResource( "Base.png" ));
		label1 = new JLabel ("", imagem, SwingConstants.RIGHT);
		label1.setBounds(0, 1, 819, 460);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.TOP);
		add(label1);
		
		//
		ButtonHandler handler = new ButtonHandler();
		AdicionarClientes.addActionListener(handler);
		RemoverClientes.addActionListener(handler);
		EditarClientes.addActionListener(handler);
		ListarClientes.addActionListener(handler);
		Voltar.addActionListener(handler);
		
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(event.getSource() == AdicionarClientes) 
			{
				InterfaceCadastrarCliente icc = new InterfaceCadastrarCliente();
				icc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				icc.setBounds(0,0,819,490);
				icc.setResizable(false);
				icc.setVisible(true);
				
			}
			if(event.getSource() == RemoverClientes) 
			{
				InterfaceRemoverCliente icc = new InterfaceRemoverCliente();
				icc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				icc.setBounds(0,0,819,490);
				icc.setResizable(false);
				icc.setVisible(true);
			}
			if(event.getSource() == EditarClientes) 
			{
				InterfaceEditarCliente icc = new InterfaceEditarCliente();
				icc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				icc.setBounds(0,0,819,490);
				icc.setResizable(false);
				icc.setVisible(true);
			}
			if(event.getSource() == ListarClientes) 
			{
				// pegar todos os clientes do banco de dados
				String sql = "Select * from CLIENTES;";
				String aux = "";
				try{
				 ResultSet rs =  statement.executeQuery(sql);
            	 while (rs.next()) { //oq cadastrou por ultimo sai primeiro
              	  String nome_aux = rs.getString("nome"); //tem que ser o nome doq quero
              	  aux += "Nome: " + nome_aux;
              	 aux += "\n";
              	   System.out.println(nome_aux);
              	   String tel_aux = rs.getString("telefone");
              	 aux += "Telefone: " +tel_aux;
              	aux += "\n";
            	   System.out.println(tel_aux);
              	   String email_aux = rs.getString("email");
              	 aux += "Email: " + email_aux;
              	aux += "\n";
              	   System.out.println(email_aux);
              	   String data_aux = rs.getString("aniversario");
              	 aux += "Data: " + data_aux;
              	aux += "\n";
              	   System.out.println(data_aux);
              	   aux += "\n";
              	
              	   System.out.println();
              	}
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
				
				JTextArea textArea = new JTextArea(aux);
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
				scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Lista de Clientes",  
				                                       JOptionPane.PLAIN_MESSAGE);
			}
			if(event.getSource() == Voltar) 
			{
				dispose();
			}

		}
		
	}
}
