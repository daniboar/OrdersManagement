package Presentation;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {

    private JPanel contentPane;
    public Home() {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 575, 456);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Clienti");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {//la apasarea butonului intram in interfata de clienti
            public void actionPerformed(ActionEvent e) {
                ClientiGUI c = null;
                try {
                    c = new ClientiGUI();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                c.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setBounds(47, 151, 162, 56);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Plaseaza o comanda");
        btnNewButton_2.addActionListener(new ActionListener() {//la apasarea butonului intram in interfata de plasare a comenzii
            public void actionPerformed(ActionEvent e) {
                ComenziGUI comenzi = new ComenziGUI();
                comenzi.setVisible(true);
                dispose();
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_2.setBounds(168, 266, 222, 68);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Produse");
        btnNewButton_1.addActionListener(new ActionListener() {//la apasarea butonului intram in interfata de produse
            public void actionPerformed(ActionEvent e) {
                ProduseGUI p = new ProduseGUI();
                p.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(344, 150, 170, 59);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("Bine ai venit!");
        lblNewLabel.setFont(new Font("MingLiU_HKSCS-ExtB", Font.PLAIN, 22));
        lblNewLabel.setBounds(202, 26, 275, 68);
        contentPane.add(lblNewLabel);
    }
}
