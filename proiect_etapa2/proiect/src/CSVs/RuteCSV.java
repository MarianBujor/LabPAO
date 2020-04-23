package CSVs;

import Angajati.Sofer;
import Rute.Cursa;
import Rute.Ruta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuteCSV
{
    ArrayList<Ruta> rutee;
    private static RuteCSV instance = null;
    private RuteCSV()
    {
        String csvFile = "rute.csv";
        String line = "";
        String csvSplit = ",";

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile)))
        {
            line = buffer.readLine();
            this.rutee = new ArrayList<Ruta>();
            while ((line = buffer.readLine()) != null)
            {

                String[] rute = line.split(csvSplit);
                Ruta aux = new Ruta(rute[0],rute[1]);
                this.rutee.add(aux);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static RuteCSV getInstance()
    {
        if(instance == null)
            instance = new RuteCSV();
        return instance;
    }

    public void RuteCSV_Write_To_File()
    {
        List<List<String>> data = Arrays.asList(
                Arrays.asList("Bucuresti","Barcelona"),
                Arrays.asList("Bucuresti","Viena"),
                Arrays.asList("Bucuresti","Sofia"),
                Arrays.asList("Bucuresti","Praga"),
                Arrays.asList("Bucuresti","Berna"),
                Arrays.asList("Bucuresti","Torino")

        );


        try
        {
            FileWriter csvWriter = new FileWriter("rute.csv");
            csvWriter.append("Plecare");
            csvWriter.append(",");
            csvWriter.append("Destinatie");
            csvWriter.append(",");
            csvWriter.append("Status");
            csvWriter.append("\n");
            for (List<String> rute : data)
            {
                csvWriter.append(String.join(",", rute));
                csvWriter.append("\n");
            }
            csvWriter.flush();

        }
        catch(java.io.IOException e)
        {
            System.out.println("Eroare");
        }
    }
    public ArrayList<Ruta> getRutee()
    {
        return rutee;
    }

}