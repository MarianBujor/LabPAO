package Repository;
import Angajati.*;

import java.util.ArrayList;

public class SoferiRep
{
    Sofer S = new Sofer(30, 5, 1, "Gigel");
    Sofer S1 = new Sofer(31, 4, 2, "Ionel");
    Sofer S2 = new Sofer(32, 3, 3, "Cornel");
    Sofer S3 = new Sofer(33, 2, 4, "Fanel");
    ArrayList<Sofer> soferii = new ArrayList<Sofer>();
    public ArrayList<Sofer> ListaSoferi()
    {
        soferii.add(S);
        soferii.add(S2);
        soferii.add(S1);
        soferii.add(S3);
        return soferii;
    }
    public void AdaugaSofer(Sofer S)
    {
        soferii.add(S);
    }
}
