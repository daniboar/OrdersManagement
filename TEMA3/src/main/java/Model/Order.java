package Model;

public class Order {
    private int id_client;
    private int id_product;
    private int cantitate;
    private int total;

    /** constructor */
    public Order(int id_client, int id_product, int cantitate, int total){
        this.id_client = id_client;
        this.id_product = id_product;
        this.cantitate = cantitate;
        this.total = total;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_product() {
        return id_product;
    }

    public int getCantitate() {
        return cantitate;
    }

    public int getTotal() {
        return total;
    }

}
