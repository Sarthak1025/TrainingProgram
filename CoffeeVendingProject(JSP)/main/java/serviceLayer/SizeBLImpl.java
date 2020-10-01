package serviceLayer;

import beans.Size;
import persistenceLayer.SizeDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class SizeBLImpl implements SizeBL{
    private SizeDaoImpl sizeDao = new SizeDaoImpl();
    @Override
    public ArrayList<String> getAllSizeNames() throws SQLException, ClassNotFoundException {
        ArrayList<Size> sizes = sizeDao.getAllSizes();
        ArrayList<String> sizeList = new ArrayList<>();
        for (Size size: sizes){
            sizeList.add(size.getSizeName());
        }
        return  sizeList;
    }

    @Override
    public Double getSizeRatio(String name) throws SQLException, ClassNotFoundException {
        Size size = sizeDao.searchSize(name);
        return size.getRatio();
    }
}
