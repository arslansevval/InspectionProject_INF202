package newprojekt;

import java.sql.*;


public class database {

        public static Connection getConnection() throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "1521698";
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from calisanlar");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("calisan_ad") + ", " + myRs.getString("calisan_soyad"));
            }
            return myConn;

        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
            return null;
    }
}

