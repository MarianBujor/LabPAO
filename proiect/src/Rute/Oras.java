package Rute;

public class Oras
{
    String nume;
    Oras()
    {
        nume = "-";

    }
    public Oras(String Nume)
    {
        nume = Nume;

    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getNume()
    {
        return nume;
    }
}
