package persistenceLayer;

import beans.AddOn;
import persistenceLayer.GetConnection.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddOnDaoImpl implements AddOnDao {
    @Override
    public ArrayList<AddOn> getAllAddOns() throws SQLException, ClassNotFoundException {
        ArrayList<AddOn> addOnList = new ArrayList<>();
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDON");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("addonid");
            String name = resultSet.getString("addonname");
            int price = resultSet.getInt("price");
            addOnList.add(new AddOn(id,name,price));
        }
        connection.close();
        return addOnList;
    }

    @Override
    public AddOn searchAddOn(String name) throws SQLException, ClassNotFoundException {
        AddOn addOn = null;
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDON WHERE ADDONNAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("addonid");
            String name1 = resultSet.getString("addonname");
            int price = resultSet.getInt("price");
            addOn = new AddOn(id, name1, price);
        }
        connection.close();
        return addOn;
    }
}
