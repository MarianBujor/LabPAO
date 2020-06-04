package Rute;

import Masini.Masina;

public class Ruta
{
    Oras plecare, destinatie;
    public Ruta()
    {
        plecare = new Oras();
        destinatie = new Oras();
        plecare.setNume("-");
        destinatie.setNume("-");

    }
    public Ruta(String Plecare, String Destinatie)
    {
        plecare = new Oras();
        destinatie = new Oras();
        plecare.setNume(Plecare);
        destinatie.setNume(Destinatie);
    }

    public String getDestinatie() {
        return destinatie.getNume();
    }

    public String getPlecare() {
        return plecare.getNume();
    }

    public void setDestinatie(String destinatie)
    {
        this.destinatie.setNume(destinatie);
    }

    public void setPlecare(String plecare)
    {
        this.plecare.setNume(plecare);
    }

}
