package BusinessLogic;

import DataAccess.OrderDAO;
import Model.Order;

import java.sql.SQLException;

public class OrderBLL {
    private static OrderDAO orders;
    /** constructor */
    public OrderBLL(){
        orders = new OrderDAO();
    }

    /** metoda ce ne apeleaza metoda de inserare order */
    public void insertOrder(Order o) throws SQLException {
        orders.insertOrder(o);
    }
}
