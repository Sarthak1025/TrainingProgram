package com.vending.system.persistence;

import com.vending.system.beans.Size;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SizeDao {
    ArrayList<Size> getAllSizes() throws SQLException, ClassNotFoundException;
    Size searchSize(String name) throws SQLException, ClassNotFoundException;
}
