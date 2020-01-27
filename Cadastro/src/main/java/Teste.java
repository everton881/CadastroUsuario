import java.sql.SQLException;

import br.com.Cadastro.controller.CadastroUsuarioDAO;
import br.com.Cadastro.util.ConexaoBanco;

public class Teste {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        CadastroUsuarioDAO cadastro= new CadastroUsuarioDAO();
        
        //       cadastro.inserir("Lula", "098775454", "765433"); 
       // cadastro.deletar("23");   
        
        String atualiza = "senha = '345788'";
        System.out.println(atualiza);
        cadastro.atualizar("3", atualiza);
	}

}
