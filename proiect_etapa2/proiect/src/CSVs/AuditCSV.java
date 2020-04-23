package CSVs;

import java.io.FileWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AuditCSV
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    Timestamp timestamp;

    public AuditCSV()
    {
        timestamp = null;
    }
    public void addAction(int x)
    {
        timestamp = new Timestamp(System.currentTimeMillis());
        try
        {
            String msg;
            FileWriter csvWriter = new FileWriter("audit.csv",true);
            if(x == 1)
            {
                msg = "Am afisat soferii";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 2)
            {
                msg = "Am cautat sofer dupa ID";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 3)
            {
                msg = "Am adaugat o masina noua";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 4)
            {
                msg = "Am afisat toate masinile";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 5)
            {
                msg = "Am afisat toate masinile disponibile pentru transport";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 6)
            {
                msg = "Am ordonat si afisat masinile dupa tip";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 7)
            {
                msg = "Am afisat toate rutele";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 8)
            {
                msg = "Am afisat cursele finalizate";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 9)
            {
                msg = "Am adaugat un sofer";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            else if(x == 10)
            {
                msg = "Am vazut lista candidatilor";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
            if(x == 11)
            {
                msg = "Am inchis programul";
                csvWriter.append(msg);
                csvWriter.append(",");
                csvWriter.append(timestamp.toString());
                csvWriter.append("\n");
                csvWriter.flush();
            }
        }
        catch(java.io.IOException e)
        {
            System.out.println("Eroare");
        }
    }

}
