package Presentation;

import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class ComenziGUI extends JFrame {
    private JPanel contentPane;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;

    public ComenziGUI() {
        setTitle("Comanda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 575, 456);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//buton de back care ne intoarce la pagina principala
                Home h = new Home();
                h.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(476, 371, 64, 26);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("ID Client");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(29, 149, 89, 26);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("ID Produs");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(29, 206, 89, 26);
        contentPane.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setBounds(144, 149, 70, 33);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cantitate");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1_1.setBounds(29, 260, 80, 26);
        contentPane.add(lblNewLabel_1_1_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(144, 260, 70, 33);
        contentPane.add(textField_4);

        JLabel lblNewLabel = new JLabel("Comanda un tip de produs/client");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(154, 10, 352, 69);
        contentPane.add(lblNewLabel);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(144, 199, 70, 33);
        contentPane.add(textField_5);

        JButton btnNewButton = new JButton("Comanda!");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {//cand apas butonul comanda imi insereaza comanda in tabela
            public void actionPerformed(ActionEvent e) {
                int id_client, id_produs, cantitate, pret;
                id_client = Integer.parseInt(textField_2.getText());
                id_produs = Integer.parseInt(textField_5.getText());
                cantitate = Integer.parseInt(textField_4.getText());
                ProductBLL produs = new ProductBLL();
                try {
                    pret = produs.getPret(id_produs) * cantitate;
                    int cantitateSQL = produs.getCantitate(id_produs);
                    if(cantitate > cantitateSQL){ //verific daca avem destule produse cat este cantitatea din comanda
                        JOptionPane.showMessageDialog(ComenziGUI.this, "Stoc depasit!");
                    }else{
                        OrderBLL comanda = new OrderBLL();
                        comanda.insertOrder(new Order(id_client,id_produs,cantitate, pret));
                        produs.setCantitate(id_produs, cantitateSQL - cantitate);
                        JOptionPane.showMessageDialog(ComenziGUI.this, "Comanda a fost efectuata!\nPretul total este: " + pret + " RON");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnNewButton.setBounds(137, 335, 134, 49);
        contentPane.add(btnNewButton);
    }
}
