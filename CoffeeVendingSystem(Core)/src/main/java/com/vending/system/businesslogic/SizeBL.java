package com.vending.system.businesslogic;

import com.vending.system.beans.Size;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SizeBL {
    ArrayList<String> getAllSizeNames() throws SQLException, ClassNotFoundException;
    Double getSizeRatio(String name) throws SQLException, ClassNotFoundException;
}
