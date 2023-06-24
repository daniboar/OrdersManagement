package Model;

public class Product {
    private int id;
    private String nume;
    private int cantintate;
    private int pret;

    /** constructor */
    public Product(int id, String nume, int cantintate, int pret){
        this.id = id;
        this.nume = nume;
        this.cantintate = cantintate;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getCantintate() {
        return cantintate;
    }

    public int getPret() {
        return pret;
    }
}
