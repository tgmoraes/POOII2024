package parte4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaBD {
	public static void main(String[] args) throws SQLException {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/aulapoo2";
		
		Connection con = DriverManager.getConnection(urlcon, login, senha);
		
		System.out.println(con);
	}
}
