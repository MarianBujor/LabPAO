package Service;
import Masini.TipMasina;
import Rute.*;

import java.util.ArrayList;
import java.util.Comparator;

public class RuteService
{
    public void infoCursa(Cursa C)
    {
        System.out.println(C.getPlecare() + "-" + C.getDestinatie() + " " + C.getStatus());
    }
    public void SorteazaCurseDesc(ArrayList<Cursa> curse)
    {
        System.out.println("----------------------------");
        Comparator<Cursa> dupaDist = Comparator.comparing(Cursa::getDistanta);
        for(Cursa c : curse)
        {
            System.out.println(c.getPlecare() + "-" + c.getDestinatie() + " " + c.getDistanta());
        }
        System.out.println("----------------------------");
    }
    public void AfiseazaCurseleLivrate(ArrayList<Cursa> C)
    {
        for(Cursa c : C)
        {
            if (c.getStatus().equals("livrat"))
            {
             System.out.println(c.getPlecare() +  "-" + c.getDestinatie() + "| data livrarii: " + c.getDeadline());
            }
        }
    }

    public void AfiseazaCurseleDisponibile(ArrayList<Cursa> C)
    {
        System.out.println("Curse pregatite pentru livrare: \n");
        for(Cursa c : C)
        {
            if (c.getStatus().equals("-"))
            {
                System.out.println(c.getPlecare() + "-" + c.getDestinatie());
            }
        }
    }


}
