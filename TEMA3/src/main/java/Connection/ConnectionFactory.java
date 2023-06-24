package Connection;

import java.sql.*;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/tema3_tp";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /** constructor pentru conexiune */
    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /** metoda de creare a conexiunii */
    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DBURL, USER, PASS);
        return connection;
    }

    public static Connection getConnection() throws SQLException {
        return singleInstance.createConnection();
    }

    public static void close(Connection connection) throws SQLException{
        if(connection != null)
            connection.close();
    }

    public static void close(Statement statement) throws SQLException {
        if(statement != null)
            statement.close();
    }

    public static void close(ResultSet resultSet) throws SQLException {
        if(resultSet != null)
            resultSet.close();
    }
}

