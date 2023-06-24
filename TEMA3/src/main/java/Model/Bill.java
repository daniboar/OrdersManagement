package Model;
public record Bill(String client, String produs, int cantitate, int pret, String date) {

    /** clasa record pentru bill */
    public Bill{
        if(client == null || produs == null || cantitate == 0 || pret == 0 || date == null){
            throw new IllegalArgumentException("Eroare la comanda");
        }
    }
}
