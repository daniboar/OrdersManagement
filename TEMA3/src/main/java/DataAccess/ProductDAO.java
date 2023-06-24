package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Model.Product;

public class ProductDAO{
    private final static String stFind = "SELECT * FROM product WHERE id = ?"; //statement pentru extragerea produselor cu id-ul dat
    private final static String stDelete = "DELETE FROM product WHERE id = ?"; //statement pentru delete produs din tabela
    private final static String stInsert = "INSERT INTO product (id, nume, cantitate, pret) VALUES(?,?,?,?)"; //statemenet pentru insert in tabela
    private final static String stUpdate = "UPDATE product SET nume = ?, cantitate = ?, pret = ? WHERE id = ?"; //statement pentru update la produsul cu id-ul dat

    /** constructor */
    public ProductDAO(){
    }

    /** metoda care ne returneaza un produs in functie de id */
    public static String getproductbyID(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(stFind);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return rs.getString("nume") + " | " +  Integer.parseInt(rs.getString("cantitate")) + " | " + Integer.parseInt(rs.getString("pret"));
        }else{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            return null;
        }
    }

    /** metoda care ne insereaza un produs in tabela */
    public static void insertProduct(Product p) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stInsert);
        st.setInt(1, p.getId());
        st.setString(2, p.getNume());
        st.setInt(3,p.getCantintate());
        st.setInt(4,p.getPret());
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }

    /** metoda care ne sterge un produs din tabela */
    public static void deleteProduct(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stDelete);
        st.setInt(1, id);
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }

    /** metoda care ne editeaza un produs din tabela */
    public static void updateProduct(int id, Product newProduct) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stUpdate);
        st.setString(1, newProduct.getNume());
        st.setInt(2,newProduct.getCantintate());
        st.setInt(3,newProduct.getPret());
        st.setInt(4, id);
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }

    /** metoda care ne afla numele unui produs */
    public static String getName(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT nume FROM product WHERE id = ?");
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

    /** metoda care ne afla cantitatea unui produs */
    public static int getCantitate(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT cantitate FROM product WHERE id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return Integer.parseInt(rs.getString("cantitate"));
        }else{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            return 0;
        }
    }

    /** metoda care ne afla pretul unui produs */
    public static int getPret(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT pret FROM product WHERE id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            return Integer.parseInt(rs.getString("pret"));
        }else{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            return 0;
        }
    }

    /** metoda care ne seteaza cantitatea unui produs */
    public void setCantitate(int id, int cantitate) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        st = connection.prepareStatement("UPDATE product SET cantitate = ? WHERE id = ?");
        st.setInt(1, cantitate);
        st.setInt(2, id);
        st.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(connection);
    }
}
