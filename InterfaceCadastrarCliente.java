import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InterfaceCadastrarCliente extends JFrame{
	
	
	
	private JLabel label1;
	
	private JLabel TextoNome;
	private JLabel TextoTel;
	private JLabel TextoAniversario;
	private JLabel TextoAniversario1;
	private JLabel TextoAniversario2;
	private JLabel TextoEmail;
	private JLabel TextoAba;
	
	private JTextField Nome;
	private JTextField Telefone;
	private JTextField Email;
	
	private JButton Cancelar;
	private JButton Concluir;
	
	private JComboBox comboBoxDia;
	private static final String[] dias = 
		{"01",
				"02",
				"03",
				"04",
				"05",
				"06",
				"07",
				"08",
				"09",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20",
				"21",
				"22",
				"23",
				"24",
				"25",
				"26",
				"27",
				"28",
				"29",
				"30",
				"31"};
	
	private JComboBox comboBoxMes;
	private static final String[] meses = 
		{"01","02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	
	private JComboBox comboBoxAno;
	private static final String[] anos = {
			"2020",
			"2019",
			"2018",
			"2017",
			"2016",
			"2015",
			"2014",
			"2013",
			"2012",
			"2011",
			"2010",
			"2009",
			"2008",
			"2007",
			"2006",
			"2005",
			"2004",
			"2003",
			"2002",
			"2001",
			"2000",
			"1999",
			"1998",
			"1997",
			"1996",
			"1995",
			"1994",
			"1993",
			"1992",
			"1991",
			"1990",
			"1989",
			"1988",
			"1987",
			"1986",
			"1985",
			"1984",
			"1983",
			"1982",
			"1981",
			"1980",
			"1970",
			"1969",
			"1968",
			"1967",
			"1966",
			"1965",
			"1964",
			"1963",
			"1962",
			"1961",
			"1960",
			"1959",
			"1958",
			"1957",
			"1956",
			"1955",
			"1954",
			"1953",
			"1952",
			"1951",
			"1950",
	};
	private Statement statement;
	
	public InterfaceCadastrarCliente()
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
		
		TextoAba = new JLabel ("Adicionar Cliente");
		TextoAba.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAba.setForeground(Color.WHITE);
		TextoAba.setVisible(true);
		TextoAba.setBounds(360,50,300,50);
		add(TextoAba);
		
		TextoNome = new JLabel ("Nome Completo*:");
		TextoNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoNome.setForeground(new Color(0, 124, 175));
		TextoNome.setVisible(true);
		TextoNome.setBounds(40,140,300,50);
		add(TextoNome);
		
		TextoTel = new JLabel ("Telefone:");
		TextoTel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoTel.setForeground(new Color(0, 124, 175));
		TextoTel.setVisible(true);
		TextoTel.setBounds(157,210,300,50);
		add(TextoTel);
		
		TextoAniversario = new JLabel ("Data Aniversário:");
		TextoAniversario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAniversario.setForeground(new Color(0, 124, 175));
		TextoAniversario.setVisible(true);
		TextoAniversario.setBounds(40,280,300,50);
		add(TextoAniversario);
		TextoAniversario1 = new JLabel ("/");
		TextoAniversario1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAniversario1.setForeground(new Color(0, 124, 175));
		TextoAniversario1.setVisible(true);
		TextoAniversario1.setBounds(350,280,300,50);
		add(TextoAniversario1);
		TextoAniversario2 = new JLabel ("/");
		TextoAniversario2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoAniversario2.setForeground(new Color(0, 124, 175));
		TextoAniversario2.setVisible(true);
		TextoAniversario2.setBounds(415,280,300,50);
		add(TextoAniversario2);
		
		TextoEmail = new JLabel ("Email:");
		TextoEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		TextoEmail.setForeground(new Color(0, 124, 175));
		TextoEmail.setVisible(true);
		TextoEmail.setBounds(190,345,300,50);
		add(TextoEmail);
			
		//Caixa de texto para o nome
		
		Nome = new JTextField();
		Nome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		Nome.setBounds(290, 140, 450, 50);
		add(Nome);
				
		//
		
		//Caixa de texto para o telefone
		
		Telefone = new JTextField();
		Telefone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		Telefone.setBounds(290, 210, 450, 50);
		add(Telefone);
						
		//
		
		//Combos box para a data de aniversário
			
		comboBoxDia = new JComboBox(dias);
		comboBoxDia.setMaximumRowCount(7);
		comboBoxDia.setBounds(290, 290, 50, 30);
		add (comboBoxDia);
		
		comboBoxMes = new JComboBox(meses);
		comboBoxMes.setMaximumRowCount(6);
		comboBoxMes.setBounds(363, 290, 50, 30);
		add (comboBoxMes);
		
		comboBoxAno = new JComboBox(anos);
		comboBoxAno.setMaximumRowCount(10);
		comboBoxAno.setBounds(430, 290, 70, 30);
		add (comboBoxAno);
								
		//
		
		//Caixa de texto para o email
		
		Email = new JTextField();
		Email.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		Email.setBounds(290, 345, 450, 50);
		add(Email);
										
		//
		
		//Botões Cancelar e Concluir
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(380, 410, 100, 25);
		Cancelar.setForeground(new Color(0, 124, 175));
		Cancelar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Cancelar);
		
		Concluir = new JButton("Concluir");
		Concluir.setBounds(260, 410, 100, 25);
		Concluir.setForeground(new Color(0, 124, 175));
		Concluir.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		add(Concluir);
		
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
		Telefone.addActionListener(handler);
		Email.addActionListener(handler);
		comboBoxDia.addActionListener(handler);
		comboBoxMes.addActionListener(handler);
		comboBoxAno.addActionListener(handler);
		Cancelar.addActionListener(handler);
		Concluir.addActionListener(handler);
		
		
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{		
			if(event.getSource() == Concluir) 
			{
				String nome = Nome.getText();
				nome = nome.toUpperCase();
				System.out.println("teteste"+nome);
				String telefone=Telefone.getText();
				String email= Email.getText();
				String dia = String.valueOf(comboBoxDia.getSelectedItem());
				String mes = String.valueOf(comboBoxMes.getSelectedItem());
				String ano = String.valueOf(comboBoxAno.getSelectedItem());
				
				String data;
				data =  ano +   "-"  + mes +  "-" +  dia ;
				///////////////////////////////////////////////////////////////////////////////
				 String nome_insert = nome;
            	 String telefone_insert = telefone;
            	 String data_insert = data;
            	 String email_insert = email;
            	
            	int erro_ja_existe = 0;
            	
            	if(nome.isEmpty())JOptionPane.showMessageDialog(InterfaceCadastrarCliente.this, "Algo de errado aconteceu, o campo de nome deve ser preenchido!","ERRO!", JOptionPane.ERROR_MESSAGE);
            	else
            	 if(validar(email) == false) JOptionPane.showMessageDialog(InterfaceCadastrarCliente.this, "Algo de errado aconteceu, verifique se o Email foi inserido maneira correta! Exemplo: email@email.com","ERRO!", JOptionPane.ERROR_MESSAGE);
            	 else if(isTelefone(telefone) == false)JOptionPane.showMessageDialog(InterfaceCadastrarCliente.this, "Algo de errado aconteceu, verifique se o Telefone foi inserido maneira correta! Exemplo (XX) XXXX-XXXX ou (XX) XXXXX-XXXX","ERRO!", JOptionPane.ERROR_MESSAGE);
            	 else
            	 {
            	 
            	String sql = "INSERT INTO CLIENTES Values('" + nome_insert + "' , '"+ telefone_insert + "','" +data_insert +"','" +email_insert+ "');";
            	try{
            		statement.executeUpdate(sql);
            	}
            	catch(SQLException e)
            	{
            		System.out.println(e);
    				JOptionPane.showMessageDialog(InterfaceCadastrarCliente.this, "Algo de errado aconteceu, verifique se o nome foi inserido maneira correta ou se esse nome já não existe!","ERRO!", JOptionPane.ERROR_MESSAGE);
    				erro_ja_existe = 1;
            		
            	}
				///////////////////////////////////////////////////////////////////////////////////
				
				if(erro_ja_existe == 0){JOptionPane.showMessageDialog(InterfaceCadastrarCliente.this,"Cadastro realizado com sucesso!", "Confirmação de Cadastro", JOptionPane.PLAIN_MESSAGE);
				dispose();}
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
