package DataAccess;

import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;
import Model.Bill;
import Model.Order;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class OrderDAO{
    private final static String stInsert = "INSERT INTO orders (id_client, id_product, cantitate, total) VALUES (?,?,?,?)"; //statement pentru inserarea valorilor in tabela orders
    private final static String stInsertBill = "INSERT INTO log (nume_client, nume_produs, cantitate, pret, data) VALUES (?,?,?,?,?)"; //statement pentru inserarea valorilor in tabela log

    /** constructor */
    public OrderDAO(){

    }

    /** metoda pentru a insera o comanda si un bill */
    public static void insertOrder(Order o) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement st = connection.prepareStatement(stInsert);
        st.setInt(1, o.getId_client());
        st.setInt(2, o.getId_product());
        st.setInt(3, o.getCantitate());
        st.setInt(4, o.getTotal());
        st.executeUpdate();
        //creez un obiect de tipul Bill si inserez elemente in tabela Log
        ClientBLL client = new ClientBLL();
        ProductBLL produs = new ProductBLL();
        Date currentDate = new Date();
        Bill bill = new Bill(client.findClientbyID(o.getId_client()), produs.getName(o.getId_product()), o.getCantitate(), o.getTotal(), currentDate.toString());
        PreparedStatement st2 = connection.prepareStatement(stInsertBill);
        st2.setString(1, bill.client());
        st2.setString(2, bill.produs());
        st2.setInt(3, bill.cantitate());
        st2.setInt(4, bill.pret());
        st2.setString(5, bill.date());
        st2.executeUpdate();
        ConnectionFactory.close(st);
        ConnectionFactory.close(st2);
        ConnectionFactory.close(connection);
    }
}
