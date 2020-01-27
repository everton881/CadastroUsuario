package br.com.Cadastro.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.sun.faces.mgbean.ManagedBeanPreProcessingException.Type;

import br.com.Cadastro.util.ConexaoBanco;
import oracle.jdbc.OracleTypes;

public class CadastroUsuarioDAO {
	
	String sql;
	
	
	
	public void consulta() throws SQLException {
		
		Connection con = new ConexaoBanco().getConexao();
		
		sql = "Select nome from usuario where id = 5";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		//System.out.println(stmt.getResultSet().getString(2));
		
		ResultSet res= stmt.executeQuery();
		res.next();
		System.out.println(res.getString("nome"));
		stmt.close();
	}
	
	
	public void inserir(String nome , String cpf, String senha ) throws SQLException {
		Connection con = new ConexaoBanco().getConexao();
		String vErro = "Verro";
		//Chamada da procedure
		CallableStatement cs = con.prepareCall("call CRUD_USUARIO(?,?,?,?,?,?)");
		//setando os parametros
		cs.setString("tipo", "Insert");
		cs.setString("vNome", nome);
		cs.setString("vCPF", cpf);
		cs.setString("vSenha", senha);
		cs.setString("vcampo", null);
		cs.setString("vErro", vErro);
		//informar qual index da saida da procedure e o tipo
		cs.registerOutParameter(6, OracleTypes.VARCHAR);

		//Executa Procedure
		cs.execute();
		String res= cs.getString("vErro");
		//res.next();
		System.out.println(res);
		//stmt.close();
		cs.close();
	}
	
	public void atualizar(String id , String atualiza ) throws SQLException {
		Connection con = new ConexaoBanco().getConexao();
		String vErro = "Verro";
		//Chamada da procedure
		CallableStatement cs = con.prepareCall("call CRUD_USUARIO(?,?,?,?,?,?)");
		//setando os parametros
		cs.setString("tipo", "Update");
		cs.setString("vNome", id);
		cs.setString("vCPF", null);
		cs.setString("vSenha", null);
		cs.setString("vcampo", atualiza);
		cs.setString("vErro", vErro);
		//informar qual index da saida da procedure e o tipo
		cs.registerOutParameter(6, OracleTypes.VARCHAR);

		//Executa Procedure
		cs.execute();
		String res= cs.getString("vErro");
		//res.next();
		System.out.println(res);
		//stmt.close();
		cs.close();
	}
	
	
	
	public void deletar(String id) throws SQLException {
		Connection con = new ConexaoBanco().getConexao();
		String vErro = "Verro";
		//Criação da chamada da procedure
		CallableStatement cs = con.prepareCall("call CRUD_USUARIO(?,?,?,?,?,?)");
		//setando os parametros
		cs.setString("tipo", "Delete");
		cs.setString("vNome", id);
		cs.setString("vCPF", null);
		cs.setString("vSenha", null);
		cs.setString("vcampo", null);
		cs.setString("vErro", vErro);
		//Setando a saida
		cs.registerOutParameter(6, OracleTypes.VARCHAR);
        //Executando a procedure
		cs.execute();
		String res= cs.getString("vErro");
		//res.next();
		System.out.println(res);
		//stmt.close();
		cs.close();
	}
	
	
}
