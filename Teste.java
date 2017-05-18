import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
public class Teste {
	public static void main(String[] args)
	{	
		
		InterfaceMenuInicial menu = new InterfaceMenuInicial();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(0,0,819,490);
		menu.setResizable(false);
		menu.setVisible(true);
		System.out.println("Loucura");
		System.out.println();
	}
	
}
