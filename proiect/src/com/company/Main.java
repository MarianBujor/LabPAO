package com.company;
import Service.*;
import Angajati.*;
import Repository.*;
import Masini.*;
import java.io.*;
import Rute.*;
import java.time.Instant;
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
        System.out.println("1.Afiseaza toti soferii");
        System.out.println("2.Cauta sofer dupa ID(pus implicit in apel)");
        System.out.println("3.Adauga o masina noua(implicit din nou)");
        System.out.println("4.Afiseaza masinile");
        System.out.println("5.Afiseaza masinile disponibile pentru transport");
        System.out.println("6.Ordoneaza si afiseaza masinile dupa tip");
        System.out.println("7.Afiseaza toate cursele");
        System.out.println("8.Afiseaza cursele livrate");
        System.out.println("9.Inchide");
        int i = 0;
        while (1 == 1)
        {
            System.out.println("1.Afiseaza toti soferii");
            System.out.println("2.Cauta sofer dupa ID(pus implicit in apel)");
            System.out.println("3.Adauga o masina noua(implicit din nou)");
            System.out.println("4.Afiseaza masinile");
            System.out.println("5.Afiseaza masinile disponibile pentru transport");
            System.out.println("6.Ordoneaza si afiseaza masinile dupa tip");
            System.out.println("7.Afiseaza toate cursele");
            System.out.println("8.Afiseaza cursele livrate");
            System.out.println("9.Inchide");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();


            if (i == 1)
            {
                for (Sofer s : SoferRep.ListaSoferi()) {
                    AngajatiS.infoSofer(s);
                }
            }
            else if(i == 2)
            {
                AngajatiS.CautaSofer_ID(1, SoferRep.ListaSoferi());
            }
            else if(i == 3)
            {
                masiniS.AfiseazaMasinile(masiniRep.ListaMasini());
            }
            else if(i == 4)
            {
                TipMasina T = new TipMasina("duba", "20L/100KM", "mercedes", "PH 11 FOC");
                masiniRep.AdaugaMasina(T);
                masiniS.AfiseazaMasinile(masiniRep.ListaMasini());
            }
            else if(i == 5) {
                masiniS.AfiseazaMasinileDisponibile(masiniRep.ListaMasini());
            }
            else if (i == 6) {
                masiniS.OrdoneazaDupaTip(masiniRep.ListaMasini());
            }
            else if(i == 7) {
                for (Cursa c : ruteRep.ListaCurse()) {
                    ruteS.infoCursa(c);
                }
            }
            else if (i == 8)
            {
                ruteS.AfiseazaCurseleLivrate(ruteRep.ListaCurse());
            }
            else if (i == 9)
            {
                break;
            }
        }
    }
}
