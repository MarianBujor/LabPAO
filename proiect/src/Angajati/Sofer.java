package Angajati;

public class Sofer extends Angajat
{
    String nume;
    int varsta, vechime;
    long ID;
    public Sofer()
    {
        nume = "";
        varsta = 0;
        vechime = 0;
        ID = -1;
    }
    public Sofer(int Varsta, int Vechime, long id, String Nume)
    {
        this.setSalariu(1350);
        varsta = Varsta;
        vechime = Vechime;
        ID = id;
        nume = Nume;
    }


    public int getVarsta()
    {
        return varsta;
    }

    public void setVarsta(int varsta)
    {
        this.varsta = varsta;
    }

    public void setVechime(int vechime)
    {
        this.vechime = vechime;
    }

    public int getVechime() {
        return vechime;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


}
