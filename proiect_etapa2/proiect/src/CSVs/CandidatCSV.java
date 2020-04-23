package CSVs;

import Angajati.Candidat;
import Rute.Ruta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidatCSV
{
    ArrayList<Candidat> candidatt;
    private static CandidatCSV instance = null;
    private CandidatCSV()
    {
        String csvFile = "candidati.csv";
        String line = "";
        String csvSplit = ",";

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile)))
        {
            line = buffer.readLine();
            this.candidatt = new ArrayList<Candidat>();
            while ((line = buffer.readLine()) != null)
            {

                String[] candidati = line.split(csvSplit);
                Candidat aux = new Candidat(candidati[0],candidati[1],Integer.parseInt(candidati[2]));
                this.candidatt.add(aux);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void CandidatCSV_Write_To_File()
    {
        List<List<String>> data = Arrays.asList(
                Arrays.asList("Paul","C","2"),
                Arrays.asList("Mike","D","5"),
                Arrays.asList("Michael","C","10"),
                Arrays.asList("Alejandro","D","7"),
                Arrays.asList("Miguel","D","3"),
                Arrays.asList("Carlos","C","8")

        );


        try
        {
            FileWriter csvWriter = new FileWriter("candidati.csv");
            csvWriter.append("Nume:");
            csvWriter.append(",");
            csvWriter.append("Categorie permis:");
            csvWriter.append(",");
            csvWriter.append("Ani vechime:");
            csvWriter.append("\n");
            for (List<String> candidati : data)
            {
                csvWriter.append(String.join(",", candidati));
                csvWriter.append("\n");
            }
            csvWriter.flush();

        }
        catch(java.io.IOException e)
        {
            System.out.println("Eroare");
        }
    }
    public static CandidatCSV getInstance()
    {
        if(instance == null)
            instance = new CandidatCSV();
        return instance;
    }
    public ArrayList<Candidat> getCandidatt()
    {
        return candidatt;
    }
}
