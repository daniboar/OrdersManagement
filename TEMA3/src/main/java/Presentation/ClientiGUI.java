package Presentation;

import BusinessLogic.ClientBLL;
import DataAccess.AbstractDAO;
import Model.Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientiGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTable table;

    public ClientiGUI() throws SQLException {
        setTitle("Clienti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 575, 456);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JButton btnNewButton = new JButton("Insert");
        btnNewButton.addActionListener(new ActionListener() {//cand apas butonul insert imi insereaza clientul in tabela
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                String nume = textField_3.getText();

                ClientBLL client = new ClientBLL();
                try {
                    client.insertClient(new Client(id, nume));
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("client");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(ClientiGUI.this, "Clientul a fost adaugat!");
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(10, 345, 128, 57);
        contentPane.add(btnNewButton);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {//cand apas butonul delete imi sterge clientul in tabela
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                ClientBLL client = new ClientBLL();
                try {
                    client.deleteClient(id);
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("client");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(ClientiGUI.this, "Clientul a fost sters!");

            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.setBounds(180, 345, 128, 57);
        contentPane.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnUpdate.addActionListener(new ActionListener() {//cand apas butonul update imi editeaza clientul in tabela
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField_2.getText());
                String nume = textField_3.getText();
                ClientBLL client = new ClientBLL();
                try {
                    client.updateClient(id, new Client(id,nume));
                    DefaultTableModel tableModel = AbstractDAO.getTableModel("client");
                    table.setModel(tableModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(ClientiGUI.this, "Update reusit!");
            }
        });
        btnUpdate.setBounds(357, 345, 128, 57);
        contentPane.add(btnUpdate);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.addActionListener(new ActionListener() {//buton de back care ne intoarce la pagina principala
            public void actionPerformed(ActionEvent e) {
                Home h = new Home();
                h.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(495, 377, 64, 26);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(56, 216, 64, 26);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Nume");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(56, 277, 64, 26);
        contentPane.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setBounds(130, 216, 70, 33);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(130, 277, 107, 33);
        contentPane.add(textField_3);

        DefaultTableModel tableModel = AbstractDAO.getTableModel("client");//aici creez tabela de tip client si o inseram in interfata
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }
}
