package Rute;
import java.time.LocalDate;
import Rute.Ruta;
public class Cursa extends Ruta
{
    String deadline, status;
    long distanta;
    public Cursa()
    {
        distanta = 0;
        this.setPlecare("-");
        this.setDestinatie("-");
        deadline = "-";
        status = "-";
    }
    public Cursa(String Plecare, String Destinatie, String Deadline, String Status, long Distanta)
    {
        deadline = Deadline;
        status = Status;
        this.setDestinatie(Destinatie);
        this.setPlecare(Plecare);
        distanta = Distanta;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getDeadline()
    {
        return deadline;
    }

    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }

    public void setDistanta(long distanta)
    {
        this.distanta = distanta;
    }

    public long getDistanta()
    {
        return distanta;
    }
}
