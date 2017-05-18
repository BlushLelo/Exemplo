import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InterfaceRemoverCliente extends JFrame{
	
	private JLabel label1;
	
	private JLabel TextoNome;
	private JLabel TextoTel;
	private JLabel TextoAniversario;
	private JLabel TextoAniversario1;
	private JLabel TextoAniversario2;
	private JLabel TextoEmail;
	private JLabel TextoAba;
	
	private JTextField Nome;
	
	private JButton Cancelar;
	private JButton Procurar;
	private Statement statement;
	
	public InterfaceRemoverCliente()
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
		
		TextoAba = new JLabel ("Remover Cliente");
		TextoAba.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAba.setForeground(Color.WHITE);
		TextoAba.setVisible(true);
		TextoAba.setBounds(360,50,300,50);
		add(TextoAba);
		
		TextoNome = new JLabel ("Nome Completo:");
		TextoNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoNome.setForeground(new Color(0, 124, 175));
		TextoNome.setVisible(true);
		TextoNome.setBounds(50,140,300,50);
		add(TextoNome);
		
		//Caixa de texto para o nome
		
		Nome = new JTextField();
		Nome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		Nome.setBounds(290, 140, 450, 50);
		add(Nome);
				
		//

		
		
		//Botões Cancelar e Procurar
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(480, 230, 100, 25);
		Cancelar.setForeground(new Color(0, 124, 175));
		Cancelar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Cancelar);
		
		Procurar = new JButton("Excluir");
		Procurar.setBounds(350, 230, 100, 25);
		Procurar.setForeground(new Color(0, 124, 175));
		Procurar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Procurar);
		
		//
		
		Icon imagem = new ImageIcon(getClass().getResource( "Base.png" ));
		label1 = new JLabel ("", imagem, SwingConstants.RIGHT);
		label1.setBounds(0, 1, 819, 460);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.TOP);
		add(label1);
		
		//
		
		ButtonHandler handler = new ButtonHandler();
		Nome.addActionListener(handler);
		Cancelar.addActionListener(handler);
		Procurar.addActionListener(handler);
		
		
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(event.getSource() == Procurar) 
			{
				int erro = 0;
				String nome =  Nome.getText();
				nome = nome.toUpperCase();
				String sql = "Select * from CLIENTES where nome = '" + nome + "';";
				try{
            	 ResultSet rs =  statement.executeQuery(sql);
            	 if(rs.next() == false)	{JOptionPane.showMessageDialog(InterfaceRemoverCliente.this, "Nome não encontrado!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);
            	 	erro =1;
            	 }
            	 else{
            		 String nome_delete = nome;
                	 sql = "DELETE FROM CLIENTES WHERE nome = '" + nome_delete + "';";
                	 //se nao deleta, nao da erro...
                	 statement.executeUpdate(sql);
            	 }
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
            	 
				
				
				if(erro == 0)JOptionPane.showMessageDialog(InterfaceRemoverCliente.this, "Exclusão Realizada!", "Confirmação de Remoção", JOptionPane.WARNING_MESSAGE);
				dispose();
			}
			if(event.getSource() == Cancelar) 
			{
				dispose();
			}
	
		}	
	}
}
