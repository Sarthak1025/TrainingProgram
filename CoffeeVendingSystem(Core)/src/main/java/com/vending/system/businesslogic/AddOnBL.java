package com.vending.system.businesslogic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddOnBL {
   ArrayList<String> getAllAddOnNames() throws SQLException,ClassNotFoundException;
   int getAddOnPrice(String name) throws SQLException, ClassNotFoundException;
}
