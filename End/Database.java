package End;

import java.sql.*;

public class Database {
    String url;
    String username;
    String password;
    public Database(String url, String username, String password) {
        this.url = "jdbc:postgresql://localhost:5432/Endterm_Java";
        this.username = "postgres";
        this.password = "1234";
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con=null;
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, username, password);
        System.out.println("The connection is established" );
        return con;
    }
    public void closeConnection(Connection con, Statement stmt) {
        try {
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NullPointerException throwables) {
            throwables.printStackTrace();
        }
    }
}
