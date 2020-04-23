package Repository;
import java.util.ArrayList;
import Rute.*;

public class RuteRep
{
    Cursa C1 = new Cursa("Bucuresti","Barcelona","20/09/2020","-",1500);
    Cursa C2 = new Cursa("Bucuresti","Viena","01/10/2020","-",1356);
    Cursa C3 = new Cursa("Bucuresti","Sofia","03/03/2020","livrat",1132);
    Cursa C4 = new Cursa("Bucuresti","Praga","01/02/2020","livrat",1853);
    Cursa C5 = new Cursa("Bucuresti","Berna","20/04/2020","livreaza",1069);
    Cursa C6 = new Cursa("Bucuresti","Torino","20/01/2020","livrat",1071);

    ArrayList<Cursa> curse = new ArrayList<Cursa>();

    public ArrayList<Cursa> ListaCurse()
    {
        curse.add(C1);
        curse.add(C2);
        curse.add(C3);
        curse.add(C4);
        curse.add(C5);
        curse.add(C6);

        return curse;
    }
    public void AdaugaCursa(Cursa C)
    {
        curse.add(C);
    }
}
