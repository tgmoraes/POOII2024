package parte4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class TestaCon {
	public static void main(String[] args)  {
		ConBD tc = new ConBD();
		System.out.println(tc.getConexao());
		System.out.println(tc.getLinha(2));
		
		System.out.println(tc.getLinha(1));
		
	}
}
