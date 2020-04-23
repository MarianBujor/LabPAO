package CSVs;

import Angajati.Sofer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoferiCSV
{
    ArrayList<Sofer> soferii;
    private static SoferiCSV instance = null;
    private SoferiCSV()
    {
        String csvFile = "soferi.csv";
        String line = "";
        String csvSplit = ",";

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile)))
        {
            line = buffer.readLine();
            this.soferii = new ArrayList<Sofer>();
            while ((line = buffer.readLine()) != null)
            {

                String[] soferi = line.split(csvSplit);
                Sofer aux = new Sofer(Integer.parseInt(soferi[0]),Integer.parseInt(soferi[1]),Integer.parseInt(soferi[2]),soferi[3]);
                this.soferii.add(aux);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static SoferiCSV getInstance()
    {
        if(instance == null)
            instance = new SoferiCSV();
        return instance;
    }

    public void SoferiCSV_Write_To_File()
    {
        List<List<String>> data = Arrays.asList(
                Arrays.asList("30", "5", "1", "Gigel"),
                Arrays.asList("40", "11", "2", "Ion"),
                Arrays.asList("28", "2", "3", "John"),
                Arrays.asList("31", "7", "4", "Piciu"),
                Arrays.asList("55", "25", "5", "King Kong"),
                Arrays.asList("43", "10", "6", "Jianu"),
                Arrays.asList("35", "9", "7", "Dante")
        );


        try
        {
            FileWriter csvWriter = new FileWriter("soferi.csv");
            csvWriter.append("varsta");
            csvWriter.append(",");
            csvWriter.append("vechime");
            csvWriter.append(",");
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("nume");
            csvWriter.append("\n");
            for (List<String> soferi : data)
            {
                csvWriter.append(String.join(",", soferi));
                csvWriter.append("\n");
            }
            csvWriter.flush();

        }
        catch(java.io.IOException e)
        {
            System.out.println("Eroare");
        }
    }
    public ArrayList<Sofer> getSoferii()
    {
        return soferii;
    }

}