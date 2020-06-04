package Angajati;
import java.util.Arrays;
public class Candidat
{
    String nume;
    String categorie_permis;
    int vechime;

    public Candidat()
    {
        nume = "-";
        vechime = 0;
    }
    public Candidat(String Nume, String categorie, int Vechime)
    {
        nume = Nume;
        vechime = Vechime;
        categorie_permis = categorie;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getNume()
    {
        return nume;
    }

    public int getVechime()
    {
        return vechime;
    }
    public void setVechime(int vechime)
    {
        this.vechime = vechime;
    }

    public String getCategorie_permis()
    {
        return categorie_permis;
    }

    public void setCategorie_permis(String categorie_permis)
    {
        this.categorie_permis = categorie_permis;
    }

    @Override
    public String toString() {
        return  "nume=" + nume  +
                ", categorie_permis=" + categorie_permis  +
                ", vechime=" + vechime;
    }
}
