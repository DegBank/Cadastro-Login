package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	public Connection conectaBD() {
		
		Connection con = null;
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=@zulej0O";
			con = DriverManager.getConnection(url);
			
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null, erro.getMessage());
		}
		
		return con;
	}

}
