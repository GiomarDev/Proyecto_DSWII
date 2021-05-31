package utils;
import java.sql.Connection;
import java.sql.DriverManager;
public class MysqlDBConexion {
	public static Connection getConexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/bd_farmacia_servicio?serverTimezone=UTC","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;	
	}
}

