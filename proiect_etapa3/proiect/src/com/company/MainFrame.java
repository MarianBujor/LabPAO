package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("Pagina principala");
        Panel p1 = new Panel();
        JButton button = new JButton("Afiseaza soferii");
        button.setBounds(80, 150, 150, 30);
        button.addActionListener(event -> {
            try {
                new Window("soferi");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        button.setBackground(Color.blue);

        JButton button_masini = new JButton("Afiseaza toate masinile");
        button_masini.setBounds(230,150,180,30);
        button_masini.addActionListener(event -> {
            try
            {
                new Window("masini");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });

        JButton button_adauga_masina = new JButton("Adauga masina noua");
        button_adauga_masina.setBounds(80, 200, 150, 30);
        JButton button_adauga_sofer = new JButton("Adauga sofer nou");
        button_adauga_sofer.setBounds(230, 200, 150, 30);
        button_adauga_sofer.setBackground(Color.blue);


        button_adauga_sofer.addActionListener(event -> {
            try
            {
                new Window("ad_sofer");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });
        button_adauga_masina.addActionListener(event -> {
            try
            {
                new Window("ad_masina");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });

        JButton button_cand = new JButton("Afiseaza candidati");
        button_cand.setBounds(155, 230, 150, 30);
        button_cand.addActionListener(event -> {
            try {
                new Window("cand");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        add(button_cand);
        add(button_adauga_masina);
        add(button_adauga_sofer);
        add(button_masini);
        add(button);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }
}
