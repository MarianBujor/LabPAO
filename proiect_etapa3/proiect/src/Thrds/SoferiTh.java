package Thrds;

import Angajati.Sofer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoferiTh extends Thread
{
    String option;
    Sofer S;
    List<Sofer> soferi = new ArrayList<>();
    private final Connection connection;
    public SoferiTh(Connection connection,Sofer S,String option)
    {
        this.S = S;
        this.connection = connection;
        this.option = option;
    }
    public void run()
    {
        if (this.option.equals("add") == true)
        {
            try
            {
                String sqlADD = "INSERT INTO `soferi` (`id`, `varsta`, `vechime`, `nume`) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlADD);
                statement.setLong(1, S.getID());
                statement.setInt(2, S.getVarsta());
                statement.setInt(3, S.getVechime());
                statement.setString(4, S.getNume());

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
                List<Sofer> soferi = new ArrayList<>();
                String sql = "SELECT * FROM `soferi`";
                System.out.println("SELECT");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                while(resultSet.next())
                {
                    Sofer S = new Sofer(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4));
                    soferi.add(S);
                }
                this.soferi = soferi;
                    for(Sofer s : soferi)
                       System.out.print(s.getNume() + " " + s.getVarsta());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (this.option.equals("update"))
        {

            String sqlUpdate = "UPDATE `soferi` SET `varsta` = `varsta` + 1";
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
                String sqlDelete = "DELETE FROM soferi WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setInt(1, 1);
                statement.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public List<Sofer> getSoferi()
    {
        return soferi;
    }
}
