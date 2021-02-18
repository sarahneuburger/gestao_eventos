<<<<<<< HEAD
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static void main(String[] args) {

		Conexao c = new Conexao();
		c.conectar();
	}

	public Connection conectar() {


		Connection retornoConexao = null;

		try {

			String url = "jdbc:mysql://localhost:3306/gestaoEventos";
			String usuario = "root";
			String senha = "123456";

			retornoConexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");

		} catch (Exception erro) {
			System.out.println("Falha ao conectar:");
			System.out.println(erro.getMessage());

			erro.printStackTrace();

		}

		return retornoConexao;

	}

}
=======
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static void main(String[] args) {

		Conexao c = new Conexao();
		c.conectar();
	}

	public Connection conectar() {


		Connection retornoConexao = null;

		try {

			String url = "jdbc:mysql://localhost:3306/gestaoEventos";
			String usuario = "root";
			String senha = "123456";

			retornoConexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");

		} catch (Exception erro) {
			System.out.println("Falha ao conectar:");
			System.out.println(erro.getMessage());

			erro.printStackTrace();

		}

		return retornoConexao;

	}

}
>>>>>>> 51895fd3468c1e415dac0dcdfad9f47959b0ea87
