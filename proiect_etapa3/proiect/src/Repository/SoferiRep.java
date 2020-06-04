package Repository;
import Angajati.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SoferiRep
{
    private final Connection connection;

    public SoferiRep(Connection connection)
    {
        this.connection = connection;
    }
    Sofer S = new Sofer(30, 5, 1, "Gigel");
    Sofer S1 = new Sofer(31, 4, 2, "Ionel");
    Sofer S2 = new Sofer(32, 3, 3, "Cornel");
    Sofer S3 = new Sofer(33, 2, 4, "Fanel");
    ArrayList<Sofer> soferii = new ArrayList<Sofer>();
    public ArrayList<Sofer> ListaSoferi()
    {
        soferii.add(S);
        soferii.add(S2);
        soferii.add(S1);
        soferii.add(S3);
        return soferii;
    }
    public void AdaugaSofer(Sofer S)
    {
        soferii.add(S);
    }
    public void addSofer(Sofer S) throws SQLException
    {
        String sqlADD = "INSERT INTO `soferi` (`id`, `varsta`, `vechime`, `nume`) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sqlADD);
        statement.setLong(1,S.getID());
        statement.setInt(2,S.getVarsta());
        statement.setInt(3,S.getVechime());
        statement.setString(4,S.getNume());

        statement.executeUpdate();
    }
    public void run()
    {

    }

}
