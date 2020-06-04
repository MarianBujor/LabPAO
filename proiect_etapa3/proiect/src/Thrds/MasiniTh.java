package Thrds;

import Angajati.Sofer;
import Masini.TipMasina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasiniTh extends Thread
{

    String option;
    TipMasina M;
    List<TipMasina> masini = new ArrayList<>();
    private final Connection connection;
    public MasiniTh(Connection connection,TipMasina M,String option)
    {
        this.M = M;
        this.connection = connection;
        this.option = option;
    }
    public void run()
    {
        if (this.option.equals("add") == true)
        {
            try
            {
                String sqlADD = "INSERT INTO `masini` (`tip`, `consum`, `marca`, `nr_inmatriculare`) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlADD);
                statement.setString(1,M.getTip());
                statement.setString(2, M.getconsum());
                statement.setString(3, M.getMarca());
                statement.setString(4, M.getNr_inmatriculare());

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
                List<TipMasina> masini = new ArrayList<>();
                String sql = "SELECT * FROM `masini`";
                System.out.println("SELECT");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                while(resultSet.next())
                {
                    TipMasina M = new TipMasina(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                    masini.add(M);
                }
                this.masini = masini;
                for(TipMasina m : masini)
                    System.out.print(m.toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (this.option.equals("update"))
        {
                String sqlUpdate = "UPDATE masini SET tip = 'camion' WHERE tip ='-'";
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
                String sqlDelete = "DELETE FROM masini WHERE marca = ?";
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setString(1, "tir");
                statement.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public List<TipMasina> getMasini()
    {
        return masini;
    }


}
