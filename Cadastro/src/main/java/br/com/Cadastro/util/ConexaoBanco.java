package br.com.Cadastro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	 private Connection conexao = null;
	    public  Connection getConexao(){
	    	System.out.println("Inicio");
	    	
	    	if (conexao != null){
	            return conexao;
	        }
	        else{
	            try{
	                
	                String driver = "oracle.jdbc.driver.OracleDriver";
	                String url = "jdbc:oracle:thin:@localhost:1521:xe";
	                String user = "teste";
	                String password = "12345";

	                Class.forName(driver);
	                conexao = DriverManager.getConnection(url, user, password);
	                
	                System.out.println("Banco conectado com sucesso!");
	            }
	            catch(ClassNotFoundException e){
	                e.printStackTrace();
	                System.out.println("Erro: " + e);
	            }
	            catch(SQLException e){
	                e.printStackTrace();
	                System.out.println("Erro2: " + e);
	            }
	            return conexao;
	        }
	    }      
	
}
