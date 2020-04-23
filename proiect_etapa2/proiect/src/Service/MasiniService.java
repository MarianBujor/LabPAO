package Service;
import Masini.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MasiniService
{
    public void infoMasina(Masina M)
    {
        System.out.println("Model: " + M.getMarca());
        if (M.isDisponibil())
            System.out.println("Disponibil: DA");
        else {
            System.out.println("Disponibil: NU");
        }
    }
    public void  AfiseazaMasinile(ArrayList<TipMasina> M)
    {
        System.out.println("TIP MARCA NR_INMATRICULARE");
        System.out.println("----------------------------");
        for(TipMasina m : M)
        {
            System.out.println(m.getTip() + " | " + m.getMarca() + " | " + m.getNr_inmatriculare());
        }
        System.out.println("----------------------------");
    }
    public void AfiseazaMasinileDisponibile(ArrayList<TipMasina> M)
    {
        for(TipMasina m : M)
        {
            if (m.isDisponibil())
                System.out.println(m.getTip() + " " + m.getMarca());
        }
        System.out.println("----------------------------");
    }
    public void OrdoneazaDupaTip(ArrayList<TipMasina> M)
    {
        System.out.println("----------------------------");
        Comparator <TipMasina> dupaTip = Comparator.comparing(TipMasina::getTip);
        Collections.sort(M,dupaTip);
        for(TipMasina m : M)
        {
            System.out.println(m.getTip() + " | " + m.getMarca() + " | " + m.getNr_inmatriculare());
        }
        System.out.println("----------------------------");
    }

}
