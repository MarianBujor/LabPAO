package Repository;

import Masini.TipMasina;

import java.util.ArrayList;

public class MasiniRep
{
    TipMasina M = new TipMasina("tir","30L/100KM","iveco","B 112 MAI");
    TipMasina M1 = new TipMasina("duba","20L/100KM","dacia","BR 99 MAI");
    TipMasina M2 = new TipMasina("platforma","10L/100KM","renault","BZ 18 MAI");
    TipMasina M3= new TipMasina("camion","90L/100KM","scania","IS 15 MAI");
    TipMasina M4 = new TipMasina("duba","15L/100KM","dacia","GL 22 MAI");
    TipMasina M5 = new TipMasina("camion","18L/100KM","volvo","TM 34 MAI");
    ArrayList<TipMasina> masinii = new ArrayList<TipMasina>();


    public ArrayList<TipMasina> ListaMasini()
    {
        masinii.add(M);
        masinii.add(M1);
        masinii.add(M2);
        masinii.add(M3);
        masinii.add(M4);
        masinii.add(M5);

        return masinii;
    }
    public void AdaugaMasina(TipMasina M)
    {

        masinii.add(M);
    }
}
