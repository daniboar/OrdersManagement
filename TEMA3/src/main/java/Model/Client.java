package Model;

public class Client {
    private int id;
    private String nume;

    /** constructor */
    public Client(int id, String nume){
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

}
