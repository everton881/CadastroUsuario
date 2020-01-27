package br.com.Cadastro.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class testeWebService {

	@WebMethod
	public String ping(@WebParam(name="nome") String nome) {
		
		return "pong1" + nome;
	}
	
}
