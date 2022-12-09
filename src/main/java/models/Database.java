package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static Connection conn;
	private static final String url="jdbc:mysql://localhost:3306/qlbansua?useUnicode=true&characterEncoding=UTF-8";
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection(url,"root", "");
		} catch (Exception e) {
			return null;
		}
		return conn;
	}
	public static void main(String[] args) {
		Connection kn = getConnect();
		if(kn!=null)
			System.out.println("kết nối thành công");
		else
			System.out.println("kết nối thất bại");
	}
}
