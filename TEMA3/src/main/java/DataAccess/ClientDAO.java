package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Model.Client;

public class ClientDAO{
    private final static String stFind = "SELECT * FROM client WHERE id = ?"; //statement pentru extragerea clientului cu id-ul dat
    private final static String stDelete = "DELETE FROM client WHERE id = ?"; //statement pentru delete client din tabela
    private final static String stInsert = "INSERT INTO client (id, nume) VALUES(?,?)"; //statemenet pentru insert in tabela
    private final static String stUpdate = "UPDATE client SET nume = ? WHERE id = ?"; //statement pentru update la clientul cu id-ul dat

    /** constructor */
    public ClientDAO(){
    }

    /** metoda care ne returneaza numele unui client */
    public static String getclientbyID(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(stFind);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return rs.getString("nume");
        }else{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            return null;
        }
    }

    /** metoda care ne insereaza un client in tabela */
    public static void insertClient(Client client) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stInsert);
        st.setInt(1, client.getId());
        st.setString(2, client.getNume());
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }

    /** metoda care ne sterge un client din tabela */
    public static void deleteClient(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stDelete);
        st.setInt(1, id);
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }

    /** metoda care ne editeaza un client din tabela */
    public static void updateClient(int id, Client newClient) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stUpdate);
        st.setString(1, newClient.getNume());
        st.setInt(2, id);
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }
}
