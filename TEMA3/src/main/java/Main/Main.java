package Main;

import Presentation.Home;

import java.sql.SQLException;

public class Main {
    /** clasa main de unde pornesc aplicatia */
    public static void main(String[] args) throws SQLException {
        Home h = new Home();
        h.setVisible(true);
    }
}
