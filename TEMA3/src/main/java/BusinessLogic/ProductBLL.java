package BusinessLogic;

import DataAccess.ProductDAO;
import Model.Product;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class ProductBLL {
    private static ProductDAO product;

    /** constructor */
    public ProductBLL() {
        product = new ProductDAO();
    }

    /** metoda ce ne apeleaza metoda de insert produs */
    public void insertProduct(Product p) throws SQLException {
        product.insertProduct(p);
    }

    /** metoda ce ne apeleaza metoda de delete produs */
    public  void deleteProduct(int id) throws SQLException {
        String p = product.getproductbyID(id);
        if (p == null) {
            throw new NoSuchElementException("Produsul cu id = " + id + " nu a fost gasit");
        }
        product.deleteProduct(id);
    }

    /** metoda ce ne apeleaza metoda de update produs */
    public  void updateProduct(int id, Product newProduct) throws SQLException {
        String p = product.getproductbyID(id);
        if (p == null) {
            throw new NoSuchElementException("Produsul cu id = " + id + " nu a fost gasit");
        }
        product.updateProduct(id, newProduct);
    }

    /** metoda ce ne apeleaza metoda de aflare a numelui unui produs */
    public String getName(int id) throws SQLException {
        String p = product.getproductbyID(id);
        if (p == null) {
            throw new NoSuchElementException("Produsul cu id = " + id + " nu a fost gasit");
        }
        return product.getName(id);
    }

    /** metoda ce ne apeleaza metoda de aflare a cantitatii unui produs */
    public int getCantitate(int id) throws SQLException {
        String p = product.getproductbyID(id);
        if (p == null) {
            throw new NoSuchElementException("Produsul cu id = " + id + " nu a fost gasit");
        }
        return product.getCantitate(id);
    }

    /** metoda ce ne apeleaza metoda de aflare a pretului unui produs */
    public int getPret(int id) throws SQLException {
        String p = product.getproductbyID(id);
        if (p == null) {
            throw new NoSuchElementException("Produsul cu id = " + id + " nu a fost gasit");
        }
        return product.getPret(id);
    }

    /** metoda ce ne apeleaza metoda de setare a cantitatii unui produs */
    public void setCantitate(int id, int cantitate) throws SQLException {
        product.setCantitate(id, cantitate);
    }
}
