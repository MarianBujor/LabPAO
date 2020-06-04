package Thrds;

import Masini.TipMasina;
import Rute.Ruta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RuteTh extends Thread
{

    String option;
    Ruta R;
    List<Ruta> rute = new ArrayList<>();
    private final Connection connection;

    public RuteTh(Connection connection,Ruta R,String option)
    {
        this.R = R;
        this.connection = connection;
        this.option = option;
    }

    public void run()
    {
        if (this.option.equals("add") == true)
        {
            try
            {
                String sqlADD = "INSERT INTO `rute` (`plecare`, `destinatie`) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlADD);
                statement.setString(1,R.getPlecare());
                statement.setString(2, R.getDestinatie());
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
                String sql = "SELECT * FROM `rute`";
                System.out.println("SELECT");
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                while(resultSet.next())
                {
                    Ruta R = new Ruta(resultSet.getString(1),resultSet.getString(2));
                    rute.add(R);
                }
                for(Ruta r : rute)
                    System.out.print(r.getPlecare() + " " + r.getDestinatie());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (this.option.equals("update"))
        {
            String sqlUpdate = "UPDATE rute SET plecare = 'Bucuresti' WHERE plecare <> 'Bucuresti'";
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
                String sqlDelete = "DELETE FROM rute WHERE destinatie = ?";
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setString(1, "Craiova");
                statement.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public List<Ruta> getRute() {
        return rute;
    }
}
