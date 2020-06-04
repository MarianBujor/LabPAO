package Masini;

import Angajati.Sofer;


public class Masina extends Sofer
{

    boolean disponibil;
    String marca;
    String nr_inmatriculare;
    public Masina()
    {
        disponibil = true;
        marca ="-";
        nr_inmatriculare = "-";
        this.setNume("-");
    }
    public Masina(String Marca, String Nr_inmatriculare)
    {
        marca = Marca;
        disponibil = true;
        nr_inmatriculare = Nr_inmatriculare;
    }
    public boolean isDisponibil() {
        return disponibil;
    }

    public String getMarca() {
        return marca;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare)
    {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void adaugaSofer(Sofer S)
    {
        this.setID(S.getID());
        this.setNume(S.getNume());
        this.setVarsta(S.getVarsta());
        this.setVechime(S.getVechime());
        this.setSalariu(S.getSalariu());
        this.disponibil = false;
    }

}
