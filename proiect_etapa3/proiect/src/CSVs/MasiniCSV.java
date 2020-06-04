package CSVs;

import Masini.TipMasina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasiniCSV
{
    ArrayList<TipMasina> masinii;
    private static MasiniCSV instance = null;
    public void MasiniCSV_Write_To_File()
    {
        List<List<String>> data = Arrays.asList(
                Arrays.asList("tir","30L/100KM","iveco","B 112 MAI"),
                Arrays.asList("duba","20L/100KM","dacia","BR 99 MAI"),
                Arrays.asList("platforma","10L/100KM","renault","BZ 18 MAI"),
                Arrays.asList("camion","90L/100KM","scania","IS 15 MAI"),
                Arrays.asList("duba","15L/100KM","dacia","GL 22 MAI"),
                Arrays.asList("camion","18L/100KM","volvo","TM 34 MAI")
        );

        try
        {
            FileWriter csvWriter = new FileWriter("masini.csv");
            csvWriter.append("tip");
            csvWriter.append(",");
            csvWriter.append("consum");
            csvWriter.append(",");
            csvWriter.append("marca");
            csvWriter.append(",");
            csvWriter.append("nr_inmatriculare");
            csvWriter.append("\n");
            for (List<String> masini : data)
            {
                csvWriter.append(String.join(",", masini));
                csvWriter.append("\n");
            }
            csvWriter.flush();

        }
        catch(java.io.IOException e)
        {
            System.out.println("Eroare");
        }
    }
    private MasiniCSV()
    {
        String csvFile = "masini.csv";
        String line = "";
        String csvSplit = ",";

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile)))
        {
            line = buffer.readLine();
            this.masinii = new ArrayList<TipMasina>();
            while ((line = buffer.readLine()) != null)
            {

                String[] masina = line.split(csvSplit);
                TipMasina aux = new TipMasina(masina[0],masina[1],masina[2],masina[3]);
                this.masinii.add(aux);
            }

            //for(TipMasina m : this.masinii)
           // {
           //     System.out.println(m.getTip() + " | " + m.getMarca() + " | " + m.getNr_inmatriculare());
           // }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static MasiniCSV getInstance()
    {
        if(instance == null)
            instance = new MasiniCSV();
        return instance;
    }

    public ArrayList<TipMasina> getMasinii()
    {
        return masinii;
    }
}
