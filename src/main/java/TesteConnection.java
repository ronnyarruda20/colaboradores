import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteConnection {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/colaboradoresBD","postgres","123");
//		String sql = "INSERT INTO loja (nome,sobrenome,idade,salario) VALUES ('Mario','Corleone','28','2322.39')";
		String sql = "SELECT p FROM PESSOA p";
		//Prepara a instrução SQL
		PreparedStatement ps = conexao.prepareStatement(sql);
		//Executa a instrução SQL
		ps.execute();
		System.out.println("Conectado!");
		conexao.close();

	}

}
