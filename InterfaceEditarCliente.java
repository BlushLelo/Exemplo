import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfaceEditarCliente extends JFrame{
	
	private JLabel label1;
	
	private JLabel TextoAba;
	private JLabel TextoCliente;
	private JLabel TextoEdição;
	
	private JTextField Nome;
	
	private JComboBox comboBoxAtributos;
	private static final String[] atributos = {"Todos","Nome", "Telefone", "Data de Aniversário", "Email"};
	
	private JButton Cancelar;
	private JButton Confirmar;
	private Statement statement;
	
	public InterfaceEditarCliente()
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
		
		TextoAba = new JLabel ("Editar Cliente");
		TextoAba.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAba.setForeground(Color.WHITE);
		TextoAba.setVisible(true);
		TextoAba.setBounds(380,50,300,50);
		add(TextoAba);
		
		TextoCliente = new JLabel ("Cliente:");
		TextoCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoCliente.setForeground(new Color(0, 124, 175));
		TextoCliente.setVisible(true);
		TextoCliente.setBounds(150,140,300,50);
		add(TextoCliente);
		
		//Combos box para os clientes
		
		Nome = new JTextField();
		Nome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		Nome.setBounds(290, 140, 450, 50);
		add(Nome);
				
		//
		
		TextoEdição = new JLabel ("Escolha o atributo a ser alterado:");
		TextoEdição.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoEdição.setForeground(new Color(0, 124, 175));
		TextoEdição.setVisible(true);
		TextoEdição.setBounds(150,200,500,50);
		add(TextoEdição);
		
		//Combos box para os clientes
		
		comboBoxAtributos = new JComboBox(atributos);
		comboBoxAtributos.setMaximumRowCount(4);
		comboBoxAtributos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		comboBoxAtributos.setBounds(150, 240, 300, 50);
		add (comboBoxAtributos);
		//
		
		//Botões Cancelar e Concluir
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(380, 320, 100, 25);
		Cancelar.setForeground(new Color(0, 124, 175));
		Cancelar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Cancelar);
		
		Confirmar = new JButton("Confirmar");
		Confirmar.setBounds(260, 320, 100, 25);
		Confirmar.setForeground(new Color(0, 124, 175));
		Confirmar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Confirmar);
		
		//
		
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
		comboBoxAtributos.addActionListener(handler);
		Confirmar.addActionListener(handler);
		Cancelar.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(event.getSource() == Confirmar) 
			{
				String cliente = Nome.getText();
				cliente = cliente.toUpperCase();
				String nome_update = cliente;
				int erro = 0; //caso aconteça um erro, impede que outros comandos executem;
				String atributo =  String.valueOf(comboBoxAtributos.getSelectedItem()) ;
				String sql = "Select * from CLIENTES where nome = '" + nome_update + "';";
				try{
            	 ResultSet rs =  statement.executeQuery(sql);
            	 if(rs.next() == false)	{
            		 JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Nome não encontrado!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);
            	 	
            	 }
            	 else{
            		 if(atributo == "Nome")
     				{
 
     					String nome = JOptionPane.showInputDialog("Entre com o novo nome:");
     					nome = nome.toUpperCase();
     					String nome_novo = nome;
     					sql = "UPDATE CLIENTES SET nome = '" + nome_novo+"' WHERE nome = '" + nome_update + "';";
     					try{statement.executeUpdate(sql);dispose();}catch(SQLException e){JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Esse nome já existe!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
     				
     				}
     				else if(atributo == "Telefone")
     				{
     					String telefone = JOptionPane.showInputDialog("Entre com o novo telefone:");
     					String telefone_novo = telefone;
     					if(isTelefone(telefone) == false)JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Verifique se o Telefone foi inserido maneira correta! Exemplo (XX) XXXX-XXXX ou (XX) XXXXX-XXXX", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);
 					else{
     	             	sql = "UPDATE CLIENTES SET telefone = '" + telefone_novo+"' WHERE nome = '" + nome_update + "';";
     	             	try{statement.executeUpdate(sql);dispose();}catch(SQLException e){JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o telefone inserido!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
 					}
     				}
     				else if(atributo == "Data de Aniversário")
     				{
     					String data = JOptionPane.showInputDialog("Entre com a nova data de aniversário em um desses formatos (dd-mm-aaaa ou aaaa-mm-dd):");
     					String aniversario_novo = data;
     	              	sql = "UPDATE CLIENTES SET aniversario = '" + aniversario_novo+"' WHERE nome = '" + nome_update + "';";
     	              	try{statement.executeUpdate(sql);dispose();}catch(SQLException e){ JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Verfique o formato da data!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);
};
     					
     				}
     				else if(atributo == "Email")
     				{
     	                 
     					String email = JOptionPane.showInputDialog("Entre com o novo email:");
     					String email_novo =  email;
     					if(validar(email) == false)JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o email inserido! Verifiquei se o email foi corretamente inserido. Exemplo: email@email.com", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);
     					else{
     					sql = "UPDATE CLIENTES SET email = '" + email_novo+"' WHERE nome = '" + nome_update + "';";
     					try{statement.executeUpdate(sql);}catch(SQLException e){JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o email inserido!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
     					dispose();
     					}
     				}
     				else if(atributo == "Todos")
     				{
     					//nome
     					String nome_novo;
     					int erro_todos = 0;
     					do{
     					String nome = JOptionPane.showInputDialog("Entre com o novo nome:");
     					nome = nome.toUpperCase();
     					nome_novo = nome;
     					sql = "UPDATE CLIENTES SET nome = '" + nome_novo+"' WHERE nome = '" + nome_update + "';";
     					try{statement.executeUpdate(sql); erro_todos = 0;}catch(SQLException e){erro_todos = 1;JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Esse nome já existe!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
     					}while(erro_todos != 0);//
     					
     				if(erro_todos != 1){
     					do{
     					String telefone = JOptionPane.showInputDialog("Entre com o novo telefone:");
     					String telefone_novo = telefone;
     					if(isTelefone(telefone) == false){erro_todos = 1;JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Verifique se o Telefone foi inserido maneira correta! Exemplo (XX) XXXX-XXXX ou (XX) XXXXX-XXXX", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);}
     					else
     					{
     	             	sql = "UPDATE CLIENTES SET telefone = '" + telefone_novo+"' WHERE nome = '" + nome_novo + "';";
     	             	try{statement.executeUpdate(sql);erro_todos = 0;}catch(SQLException e){erro_todos = 1;JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o telefone inserido!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
     					}
     					}while(erro_todos != 0);
     					}//
     					
     				
     					//data
     				if(erro_todos != 1){
     					do{
     	             	String data = JOptionPane.showInputDialog("Entre com a nova data de aniversário em um desses formatos (dd-mm-aaaa ou aaaa-mm-dd):");
     	             	String aniversario_novo = data;
     	             	sql = "UPDATE CLIENTES SET aniversario = '" + aniversario_novo+"' WHERE nome = '" + nome_novo + "';";
     	             	try{statement.executeUpdate(sql);erro_todos = 0;}catch(SQLException e){erro_todos = 1; JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Verfique o formato da data!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);}
     					}while(erro_todos != 0);
     					}//
     					
     					//email
     				if(erro_todos != 1){
     					do{
     	             	String email = JOptionPane.showInputDialog("Entre com o novo email:");
     					String email_novo =  email;
     					sql = "UPDATE CLIENTES SET email = '" + email_novo+"' WHERE nome = '" + nome_novo + "';";
     					if(validar(email) == false){erro_todos = 1;JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o email inserido! Verifiquei se o email foi corretamente inserido. Exemplo: email@email.com", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);}
     					else try{statement.executeUpdate(sql);erro_todos = 0;}catch(SQLException g){erro_todos = 1;JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Problemas com o email inserido!", "Confirmação de Remoção", JOptionPane.ERROR_MESSAGE);};
     					}while(erro_todos != 0);
     					}//
     					
     				if(erro_todos != 1)JOptionPane.showMessageDialog(InterfaceEditarCliente.this, "Dados atualizados!", "Confirmação de alteração", JOptionPane.PLAIN_MESSAGE);dispose();
     				}
     			
            	 }
            }
				catch(SQLException f)
				{
					
					System.out.println(f);
				}
				
				
			
			
		
	}
			if(event.getSource() == Cancelar) 
			{
				dispose();
			}
		}
		}
	public static boolean validar(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
	public boolean isTelefone(String numeroTelefone) {
		//return true;
        return numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}") ||
                numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
    }
}
