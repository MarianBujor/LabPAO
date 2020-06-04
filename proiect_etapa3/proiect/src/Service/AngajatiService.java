package Service;
import Angajati.*;

import java.util.ArrayList;

public class AngajatiService
{
    public void infoSofer(Sofer S)
    {
        System.out.println("Nume: " +  S.getNume());
        System.out.println("Varsta: " + S.getVarsta());
        System.out.println("Vechime: " + S.getVechime());
        System.out.println("ID: " + S.getID());
        System.out.println("Salariu: " + S.getSalariu() + "$");
        System.out.println("--------------------------------------------------");
    }
    public void CautaSofer_ID(long ID, ArrayList<Sofer> soferii)
    {
        for(Sofer s : soferii)
        {
            if (s.getID() == ID)
            {
                System.out.println("Soferul cu ID -ul: " + ID + " este " + s.getNume());
                System.out.println("Detalii: ");
                infoSofer(s);
                break;
            }
        }
    }
}
