package com.company;
import CSVs.*;
import Service.*;
import Angajati.*;
import Repository.*;
import Masini.*;
import java.io.*;
import Rute.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main
{

    public static void main(String[] args) {
        MasiniRep masiniRep = new MasiniRep();
        MasiniService masiniS = new MasiniService();

        SoferiRep SoferRep = new SoferiRep();
        AngajatiService AngajatiS = new AngajatiService();

        RuteRep ruteRep = new RuteRep();
        RuteService ruteS = new RuteService();

        // clasaCSV_Write_To_File le-am apelat initial pentru a crea fisierele .csv si pentru a putea scrie mai usor in ele

        MasiniCSV m = MasiniCSV.getInstance();
       // m.MasiniCSV_Write_To_File();
        ArrayList<TipMasina> ListaMasini = m.getMasinii();

        SoferiCSV sof = SoferiCSV.getInstance();
        //sof.SoferiCSV_Write_To_File();
        ArrayList<Sofer> ListaSoferi = sof.getSoferii();

        RuteCSV rut = RuteCSV.getInstance();
        //rut.RuteCSV_Write_To_File();
        ArrayList<Ruta> ListaRute = rut.getRutee();

        CandidatCSV cand = CandidatCSV.getInstance();
       // cand.CandidatCSV_Write_To_File();
        ArrayList<Candidat> ListaCandidati = cand.getCandidatt();

        System.out.println("1.Afiseaza toti soferii");
        System.out.println("2.Cauta sofer dupa ID");
        System.out.println("3.Adauga o masina noua");
        System.out.println("4.Afiseaza masinile");
        System.out.println("5.Afiseaza masinile disponibile pentru transport");
        System.out.println("6.Ordoneaza si afiseaza masinile dupa tip");
        System.out.println("7.Afiseaza toate rutele");
        System.out.println("8.Afiseaza cursele finalizate");
        System.out.println("9.Adauga sofer");
        System.out.println("10.Vezi lista candidatilor");
        System.out.println("11.Inchide");

        AuditCSV audit = new AuditCSV();

        int i = 0;
        while (1 == 1)
        {


            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            audit.addAction(i);
            if (i == 1)
            {
                for (Sofer S : ListaSoferi)
                {
                    System.out.println("Nume: " +  S.getNume());
                    System.out.println("Varsta: " + S.getVarsta());
                    System.out.println("Vechime: " + S.getVechime());
                    System.out.println("ID: " + S.getID());
                    System.out.println("Salariu: " + S.getSalariu() + "$");
                    System.out.println("--------------------------------------------------");
                }



            }
            else if (i == 2)
            {
                AngajatiS.CautaSofer_ID(1, SoferRep.ListaSoferi());
            }
            else if (i == 3)
            {

                System.out.print("Tip(camion,duba,etc.):");
                String tip = sc.next();
                System.out.print("Consum(L/100KM):");
                String consum = sc.next();
                System.out.print("Marca(dacia,iveco,man,etc):");
                String marca = sc.next();
                System.out.print("Numar inmatriculare:");
                String nr = sc.next();
                consum = consum + "/100KM";
                TipMasina T = new TipMasina(tip, consum, marca, nr);
                masiniRep.AdaugaMasina(T);
                System.out.println("MASINA ADAUGATA");
                try
                {
                    FileWriter csvWriter = new FileWriter("masini.csv", true);
                    csvWriter.append(String.join(",", tip, consum, marca, nr));
                    csvWriter.flush();
                    csvWriter.close();
                } catch (java.io.IOException e) {
                    System.out.println("Eroare");
                }

            } else if (i == 4)
            {
                masiniS.AfiseazaMasinile(ListaMasini);
            } else if (i == 5)
            {
                masiniS.AfiseazaMasinileDisponibile(masiniRep.ListaMasini());
            } else if (i == 6)
            {
                masiniS.OrdoneazaDupaTip(masiniRep.ListaMasini());
            } else if (i == 7)
            {
                for (Ruta r : ListaRute)
                {
                    System.out.println(r.getPlecare() + "-" + r.getDestinatie());
                }
            } else if (i == 8)
            {
                ruteS.AfiseazaCurseleLivrate(ruteRep.ListaCurse());
            } else if (i == 9)
            {
                System.out.print("Vechime");
                String vechime = sc.next();
                System.out.print("Varsta");
                String varsta = sc.next();
                System.out.print("ID");
                String id = sc.next();
                System.out.print("Nume");
                String nume = sc.next();
                try
                {
                    FileWriter csvWriter = new FileWriter("soferi.csv", true);
                    csvWriter.append(String.join(",",vechime,varsta,id,nume));
                    csvWriter.flush();
                    csvWriter.close();
                    System.out.println("MASINA ADAUGATA");
                }
                catch (java.io.IOException e)
                {
                    System.out.println("Eroare");
                }
            }
            else if(i == 10)
            {
                System.out.println("NUME CATEGORIE_PERMIS VECHIME");
                for(Candidat c : ListaCandidati)
                {
                    System.out.println(c.getNume() + " " + c.getCategorie_permis() + " " + c.getVechime());
                }
            }
            else if (i == 11)
            {
                break;
            }
            System.out.println("1.Afiseaza toti soferii");
            System.out.println("2.Cauta sofer dupa ID");
            System.out.println("3.Adauga o masina noua");
            System.out.println("4.Afiseaza masinile");
            System.out.println("5.Afiseaza masinile disponibile pentru transport");
            System.out.println("6.Ordoneaza si afiseaza masinile dupa tip");
            System.out.println("7.Afiseaza toate rutele");
            System.out.println("8.Afiseaza cursele finalizate");
            System.out.println("9.Adauga sofer");
            System.out.println("10.Vezi lista candidatilor");
            System.out.println("11.Inchide");
        }
    }
}
