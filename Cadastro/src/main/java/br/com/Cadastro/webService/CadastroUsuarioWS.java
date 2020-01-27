package br.com.Cadastro.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.Cadastro.view.CadastroUsuario;

@WebService
public class CadastroUsuarioWS {

	@WebMethod
	public CadastroUsuario PegaDados(@WebParam(name="nome") String nome, @WebParam(name="cpf") String cpf, @WebParam(name="senha") String senha) {
		
		CadastroUsuario cadastro = new CadastroUsuario();
		cadastro.setNome(nome);
		cadastro.setCpf(cpf);
		cadastro.setSenha(senha);
		return cadastro;
	}
	
	
}
