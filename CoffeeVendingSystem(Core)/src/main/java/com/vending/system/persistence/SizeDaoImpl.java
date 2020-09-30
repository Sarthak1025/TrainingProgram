package com.vending.system.persistence;

import com.vending.system.beans.Coffee;
import com.vending.system.beans.Size;
import com.vending.system.helpers.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SizeDaoImpl implements SizeDao{
    @Override
    public ArrayList<Size> getAllSizes() throws SQLException, ClassNotFoundException {
        ArrayList<Size> sizeList = new ArrayList<>();
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SIZE");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("sizeid");
            String name = resultSet.getString("sizename");
            double ratio = resultSet.getDouble("ratio");
            sizeList.add(new Size(id,name,ratio));
        }
        connection.close();
        return sizeList;
    }

    @Override
    public Size searchSize(String name) throws SQLException, ClassNotFoundException {
        Size size = null;
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SIZE WHERE SIZENAME = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("sizeid");
            String name1 = resultSet.getString("sizename");
            double ratio = resultSet.getDouble("ratio");
            size = new Size(id, name1, ratio);
        }
        connection.close();
        return size;
    }
}
