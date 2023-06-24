package Presentation;

import BusinessLogic.ProductBLL;
import DataAccess.AbstractDAO;
import Model.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProduseGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTable table;
    private JTextField textField_4;
    private JTextField textField_5;

    public ProduseGUI() {
        setTitle("Produse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 575, 456);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JButton btnNewButton = new JButton("Insert");
        btnNewButton.addActionListener(new ActionListener() {/**cand apas butonul insert imi insereaza produsul in tabela**/
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                String nume = textField_3.getText();
                int cantitate = Integer.parseInt(textField_4.getText());
                int pret = Integer.parseInt(textField_5.getText());
                ProductBLL product = new ProductBLL();
                try {
                    product.insertProduct(new Product(id, nume, cantitate, pret));
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("product");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(ProduseGUI.this, "Produsul a fost adaugat!");

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(10, 352, 128, 57);
        contentPane.add(btnNewButton);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {//cand apas butonul delete imi sterge produsul in tabela
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                ProductBLL product = new ProductBLL();
                try {
                    product.deleteProduct(id);
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("product");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(ProduseGUI.this, "Produsul a fost sters!");
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.setBounds(163, 352, 128, 57);
        contentPane.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnUpdate.addActionListener(new ActionListener() {//cand apas butonul update imi editeaza produsul in tabela
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                String nume = textField_3.getText();
                int cantitate = Integer.parseInt(textField_4.getText());
                int pret = Integer.parseInt(textField_5.getText());
                ProductBLL product = new ProductBLL();
                try {
                    product.updateProduct(id, new Product(id, nume, cantitate, pret));
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("product");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(ProduseGUI.this, "Update reusit!");
            }
        });
        btnUpdate.setBounds(312, 352, 128, 57);
        contentPane.add(btnUpdate);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.addActionListener(new ActionListener() {//buton de back care ne intoarce pe pagina principala
            public void actionPerformed(ActionEvent e) {
                    Home h = new Home();
                    h.setVisible(true);
                    dispose();
            }
        });
        btnNewButton_1.setBounds(487, 383, 64, 26);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(20, 258, 64, 26);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Nume");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(20, 304, 64, 26);
        contentPane.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setBounds(94, 251, 70, 33);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(94, 297, 96, 33);
        contentPane.add(textField_3);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cantitate");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1_1.setBounds(240, 258, 80, 26);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Pret");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1_2.setBounds(256, 304, 64, 26);
        contentPane.add(lblNewLabel_1_1_2);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(330, 251, 70, 33);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(330, 304, 70, 33);
        contentPane.add(textField_5);

        DefaultTableModel tableModel = AbstractDAO.getTableModel("product");//aici creez tabela de tip produs si o inseram in interfata
        table = new JTable(tableModel);
        JScrollPane scrollPanel = new JScrollPane(table);
        contentPane.add(scrollPanel, BorderLayout.CENTER);
    }
}
