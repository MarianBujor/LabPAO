package com.company;

import Angajati.Candidat;
import Angajati.Sofer;
import CSVs.AuditCSV;
import Masini.TipMasina;
import Thrds.CandidatTh;
import Thrds.MasiniTh;
import Thrds.SoferiTh;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Window extends JFrame
{
    public Window(String title) throws SQLException
    {
        this.setVisible(true);
        this.setTitle(title);
        this.setSize(800,600);
        this.setLayout(null);

        Connection connection = JBDCTransport.getDBConnection();
        AuditCSV audit = new AuditCSV();
        if (title.equals("soferi"))
        {
            JPanel pan = new JPanel();
            pan.setBackground(Color.WHITE);
            this.setContentPane(pan);
            System.out.print(1);
            JLabel listLabel = new JLabel("Toti soferii din baza de date");
            listLabel.setHorizontalAlignment(JLabel.CENTER);
            listLabel.setForeground(Color.blue);
            listLabel.setBounds(0, 200, 200, 20);

            JList<Sofer> soferJlist = new JList<>();
            soferJlist.setBounds(0, 100, 400, 200);
            SoferiTh s_t = new SoferiTh(connection, null, "select");
            s_t.run();
            List<Sofer> listasoferi = s_t.getSoferi();
            Sofer[] soferi_array = listasoferi.toArray(new Sofer[0]);
            soferJlist.setListData(soferi_array);
            add(listLabel);
            add(soferJlist);
            audit.addAction(1,s_t.getName());
        }
        else if (title.equals("masini"))
        {
            JPanel pan = new JPanel();
            pan.setBackground(Color.WHITE);
            this.setContentPane(pan);
            System.out.print(1);
            JLabel listLabel = new JLabel("Masinile din baza de date:");
            listLabel.setHorizontalAlignment(JLabel.CENTER);
            listLabel.setForeground(Color.blue);
            listLabel.setBounds(0, 200, 200, 20);


            JList<Sofer> masiniJList = new JList<>();
            masiniJList.setBounds(0, 100, 400, 200);
            MasiniTh s_t = new MasiniTh(connection, null, "select");
            s_t.run();
            List<TipMasina> listasoferi = s_t.getMasini();
            Sofer[] masini_array = listasoferi.toArray(new TipMasina[0]);
            masiniJList.setListData(masini_array);
            add(listLabel);
            add(masiniJList);
            audit.addAction(4,s_t.getName());
        }
        else if (title.equals("ad_sofer"))
        {
            JLabel idLabel = new JLabel("id: " );
            JTextField id = new JTextField();
            idLabel.setBounds(0, 50, 200, 30);
            id.setBounds(60, 50, 200, 30);

            JLabel varstaLabel = new JLabel("Varsta: " );
            JTextField varsta = new JTextField();
            varstaLabel.setBounds(0, 100, 200, 30);
            varsta.setBounds(60, 100, 200, 30);


            JLabel vechimeLabel = new JLabel("Vechime: " );
            JTextField vechime = new JTextField();
            vechimeLabel.setBounds(0, 150, 200, 30);
            vechime.setBounds(60, 150, 200, 30);


            JLabel numeLabel = new JLabel("Nume: " );
            JTextField nume = new JTextField();
            numeLabel.setBounds(0, 200, 200, 30);
            nume.setBounds(60, 200, 200, 30);
            nume.setVisible(true);

            JButton button = new JButton("Adauga sofer");
            button.setBounds(80, 350, 150, 30);
            button.addActionListener(event -> {
                    String numeS = nume.getText();
                    String vechimeS = vechime.getText();
                    String varstaS = varsta.getText();
                    String idS = id.getText();

                    Sofer aux = new Sofer(Integer.parseInt(varstaS),Integer.parseInt(vechimeS),Long.parseLong(idS),numeS);
                    SoferiTh s_t = new SoferiTh(connection,aux,"add");
                    s_t.run();


                audit.addAction(9,s_t.getName());
            });
            add(idLabel);
            add(varstaLabel);
            add(vechimeLabel);
            add(numeLabel);
            add(id);
            add(varsta);
            add(vechime);
            add(nume);
            add(button);
        }
        else if (title.equals("ad_masina"))
        {
            JLabel tipLabel = new JLabel("Tip: " );
            JTextField tip = new JTextField();
            tipLabel.setBounds(0, 50, 200, 30);
            tip.setBounds(60, 50, 200, 30);

            JLabel consumLabel = new JLabel("Consum: " );
            JTextField consum = new JTextField();
            consumLabel.setBounds(0, 100, 200, 30);
            consum.setBounds(60, 100, 200, 30);


            JLabel marcaLabel = new JLabel("Marca: " );
            JTextField marca = new JTextField();
            marcaLabel.setBounds(0, 150, 200, 30);
            marca.setBounds(60, 150, 200, 30);


            JLabel nr_inmatriculareLabel = new JLabel("Nr_inmatriculare: " );
            JTextField nr_inmatriculare = new JTextField();
            nr_inmatriculareLabel.setBounds(0, 200, 200, 30);
            nr_inmatriculare.setBounds(60, 200, 200, 30);
            nr_inmatriculare.setVisible(true);

            JButton button = new JButton("Adauga masina");
            button.setBounds(80, 350, 150, 30);
            button.addActionListener(event -> {
                String tipS = tip.getText();
                String consumS = consum.getText();
                String marcaS = marca.getText();
                String nr_inmatriculareS = nr_inmatriculare.getText();

                TipMasina aux = new TipMasina(tipS,consumS,marcaS,nr_inmatriculareS);
                MasiniTh s_t = new MasiniTh(connection,aux,"add");
                s_t.run();

                audit.addAction(3,s_t.getName());
            });
            add(tipLabel);
            add(consumLabel);
            add(marcaLabel);
            add(nr_inmatriculareLabel);
            add(tip);
            add(consum);
            add(marca);
            add(nr_inmatriculare);
            add(button);
        }
        else if (title.equals("cand"))
        {
            JPanel pan = new JPanel();
            pan.setBackground(Color.WHITE);
            this.setContentPane(pan);
            System.out.print(1);
            JLabel listLabel = new JLabel("Toti candidatii din baza de date");
            listLabel.setHorizontalAlignment(JLabel.CENTER);
            listLabel.setForeground(Color.blue);
            listLabel.setBounds(0, 200, 200, 20);

            JList<Candidat> candidatJList = new JList<>();
            candidatJList.setBounds(0, 100, 400, 200);
            CandidatTh s_t = new CandidatTh(connection, null, "select");
            s_t.run();
            List<Candidat> listacandidati = s_t.getCandidati();
            Candidat[] candidati_array = listacandidati.toArray(new Candidat[0]);
            candidatJList.setListData(candidati_array);
            add(listLabel);
            add(candidatJList);
            audit.addAction(12,s_t.getName());
        }
    }

}
