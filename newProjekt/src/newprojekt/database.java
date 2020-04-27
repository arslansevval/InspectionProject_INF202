package newprojekt;

import java.sql.*;


public class database {

        private static final String dburl = "jdbc:mysql://localhost:3306/deneme?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	private static final String username = "root"; // my  username is ken
	private static final String password = "1521698"; // my password is null
	static Connection connect;
        Statement myStmt;
        ResultSet myRs;
        
	public database() {

	}

	public static Connection getConnection() {
		try {
                    connect = DriverManager.getConnection(dburl, username, password);

		}catch(Exception e) {
                    e.printStackTrace();
		}

		return connect;
	}

	public void close(Connection connect, Statement myStmt, ResultSet myRs) {
		try {
			if(connect != null)
				connect.close();
			if(myStmt != null)
				myStmt.close();
			if(myRs != null)
				myRs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection connect, Statement myStmt) {
		try {
			close(connect, myStmt, null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Statement myStmt) {
		try {
			close(null, myStmt, null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}

