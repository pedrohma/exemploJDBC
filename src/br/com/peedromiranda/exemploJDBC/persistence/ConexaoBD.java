package br.com.peedromiranda.exemploJDBC.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	
	//Constantes
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE = "jdbc:mysql://localhost:3306/exemploJDBC";
	private static final String USER = "root";
	private static final String PASSWORD = "227";
	
	//Atributos para manipulação do banco
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	//Método para abrir conexão com o banco de dados
	protected void abrirConexao() throws Exception{
		try{
			Class.forName(DRIVER);
			con = (Connection) DriverManager.getConnection(DATABASE, USER, PASSWORD);
		}
		catch(SQLException sql){
			System.out.println("Ocorreu um erro de SQL. Erro -> " + sql.getMessage());
		}
		
	}
	
	//Método para fechar conexão com o banco de dados
	public void fecharConexao() throws Exception{
		con.close();
	}

}
