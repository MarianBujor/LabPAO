package Angajati;

public class Angajat
{
    double salariu;
    public Angajat()
    {
        salariu = 0;
    }

    public Angajat(double Salariu)
    {
        salariu = Salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
}
