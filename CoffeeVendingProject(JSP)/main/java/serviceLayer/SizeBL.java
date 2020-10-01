package serviceLayer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SizeBL {
    ArrayList<String> getAllSizeNames() throws SQLException, ClassNotFoundException;
    Double getSizeRatio(String name) throws SQLException, ClassNotFoundException;
}
