package com.vending.system.persistence;

import com.vending.system.beans.AddOn;
import com.vending.system.beans.Size;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddOnDao {
    ArrayList<AddOn> getAllAddOns()throws SQLException, ClassNotFoundException;
    AddOn searchAddOn(String name)throws SQLException, ClassNotFoundException;
}
