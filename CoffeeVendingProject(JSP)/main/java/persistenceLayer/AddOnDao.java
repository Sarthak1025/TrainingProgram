package persistenceLayer;

import beans.AddOn;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddOnDao {
    ArrayList<AddOn> getAllAddOns()throws SQLException, ClassNotFoundException;
    AddOn searchAddOn(String name)throws SQLException, ClassNotFoundException;
}
