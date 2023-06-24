package DataAccess;

import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectionFactory;

public class AbstractDAO {

        /** constructor */
        public AbstractDAO(){
        }

    /** metoda de reflection care extrage datele din tabele */
        public static DefaultTableModel getTableModel(String table) {
            try {
                Connection connection = ConnectionFactory.getConnection(); //conexiune
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData metaData = rs.getMetaData();
                int coloane = metaData.getColumnCount();
                List<String> colName = new ArrayList<>();
                for (int i = 1; i <= coloane; i++) { //adaug numele coloanelor din tabela intr-o lista
                    colName.add(metaData.getColumnName(i));
                }
                List<List<Object>> data = new ArrayList<>();
                while (rs.next()) { //adaug datele din fiecare coloana intr-o lista ce contine lista de obiecte
                    List<Object> randuri = new ArrayList<>();
                    for (int i = 1; i <= coloane; i++) {
                        randuri.add(rs.getObject(i));
                    }
                    data.add(randuri);
                }

                Object[][] matrice = new Object[data.size()][coloane]; //creez o matrice de obiecte si copiez lista de obiecte in matrice
                for(int i = 0; i  < data.size(); i++){
                    List<Object> rand = data.get(i);
                    for(int j = 0; j < coloane; j++){
                        matrice[i][j] = rand.get(j);
                    }
                }
                ConnectionFactory.close(rs);
                ConnectionFactory.close(st);
                ConnectionFactory.close(connection);
                DefaultTableModel tableModel = new DefaultTableModel(matrice, colName.toArray()); //creez un tablemodel in functie de tabela mea
                return tableModel;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
