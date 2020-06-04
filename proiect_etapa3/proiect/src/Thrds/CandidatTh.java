package Thrds;

import Angajati.Candidat;
import Masini.TipMasina;
import Rute.Ruta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatTh extends Thread
{

    String option;
    Candidat C;
    List<Candidat> candidati = new ArrayList<>();
    private final Connection connection;

    public CandidatTh(Connection connection,Candidat C,String option)
    {
        this.C = C;
        this.connection = connection;
        this.option = option;
    }

    public void run()
    {
        if (this.option.equals("add") == true)
        {
            try
            {
                String sqlADD = "INSERT INTO `candidati` (`vechime`, `nume`,`categorie_permis`) VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlADD);
                statement.setInt(1,C.getVechime());
                statement.setString(2, C.getNume());
                statement.setString(3,C.getCategorie_permis());
                statement.executeUpdate();
                // System.out.print(getName());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (this.option.equals("select"))
        {
            try {
                List<Candidat> candidati = new ArrayList<>();
                String sql = "SELECT * FROM `candidati`";
                System.out.println("SELECT");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                while(resultSet.next())
                {
                    Candidat C = new Candidat(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(1));
                    candidati.add(C);
                }
                this.candidati = candidati;
                for(Candidat c : candidati)
                    System.out.print(c.getNume() + " " + c.getCategorie_permis() + " " + c.getVechime());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (this.option.equals("update"))
        {
            String sqlUpdate = "UPDATE candidati SET vechime = 1 WHERE vechime = 0";
            PreparedStatement statement = null;
            try
            {
                statement = connection.prepareStatement(sqlUpdate);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
            try
            {
                statement.executeUpdate(sqlUpdate);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if (this.option.equals("delete"))
        {
            try
            {
                String sqlDelete = "DELETE FROM candidati WHERE nume = ?";
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setString(1, "Mirel");
                statement.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public List<Candidat> getCandidati()
    {
        return candidati;
    }
}
