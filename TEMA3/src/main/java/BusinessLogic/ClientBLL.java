package BusinessLogic;

import DataAccess.ClientDAO;
import Model.Client;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class ClientBLL {
    private static ClientDAO clientDAO;

    /** constructor */
    public ClientBLL(){

        clientDAO = new ClientDAO();
    }

    /** metoda care ne apeleaza metoda de gasire client */
    public String findClientbyID(int id) throws SQLException {

        String c = clientDAO.getclientbyID(id);
        if(c == null){
            throw new NoSuchElementException("Clientul cu id = "+id+" nu a fost gasit");
        }
        return c;
    }

    /** metodata care ne apeleaza metoda de insert client */
    public void insertClient(Client client) throws SQLException {
        clientDAO.insertClient(client);
    }

    /** metoda care ne apeleaza metoda de delete client */
    public void deleteClient(int id) throws SQLException{
        String c = clientDAO.getclientbyID(id);
        if(c == null){
            throw new NoSuchElementException("Clientul cu id = "+id+" nu a fost gasit");
        }
        clientDAO.deleteClient(id);
    }

    /** metoda care ne apeleaza metoda de update client */
    public  void updateClient(int id, Client newClient) throws SQLException {
        String c = clientDAO.getclientbyID(id);
        if(c == null){
            throw new NoSuchElementException("Clientul cu id = "+id+" nu a fost gasit");
        }
        ClientDAO.updateClient(id, newClient);
    }
}