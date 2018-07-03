package json.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

public class DbOperations {

    private Connection conn;
    private final String url;
    private final String dbName;
    private final String driver;
    private final String userName;
    private final String password;
    Statement stmt;

    public DbOperations() {

        conn = null;
        url = "jdbc:mysql://localhost:3306/";
        dbName = "vt";
        driver = "com.mysql.jdbc.Driver";
        userName = "root";
        password = "";
        stmt = null;
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement baglantiAc() throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName, password);
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }

    public void baglantiKapat() throws Exception {
        conn.close();
    }

    public ResultSet veriGetir(String sql) throws SQLException {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;

    }

    public CachedRowSet createStatement() {
        Statement st1;
        CachedRowSet resWanted = null;

        try {
            st1 = conn.createStatement();
            resWanted = new com.sun.rowset.CachedRowSetImpl();
        } catch (SQLException ex) {
            Logger.getLogger(DbOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resWanted;
    }

}
