package Masini;

public class TipMasina extends Masina
{
    String tip, consum;
    public TipMasina()
    {
        tip = "-";
        consum = "-";
        this.marca = "-";
        this.disponibil = true;
        this.nr_inmatriculare = "-";
    }
    public TipMasina(String Tip, String Consum, String Marca, String Nr_inmatriculare)
    {
        tip = Tip;
        consum = Consum;
        this.setMarca(Marca);
        this.setNr_inmatriculare(Nr_inmatriculare);
    }

    public void setconsum(String consum) {
        this.consum = consum;
    }

    public String getconsum()
    {
        return consum;
    }

    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }
}
