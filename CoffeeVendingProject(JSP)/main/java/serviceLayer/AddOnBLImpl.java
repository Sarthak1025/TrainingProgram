package serviceLayer;

import beans.AddOn;
import persistenceLayer.AddOnDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddOnBLImpl implements AddOnBL {
    private AddOnDaoImpl addOnDao = new AddOnDaoImpl();
    @Override
    public ArrayList<String> getAllAddOnNames() throws SQLException, ClassNotFoundException {
        ArrayList<AddOn> addOns = addOnDao.getAllAddOns();
        ArrayList<String> addOnList = new ArrayList<>();
        for (AddOn addOn: addOns){
            addOnList.add(addOn.getAddOnName());
        }
        return  addOnList;
    }

    @Override
    public int getAddOnPrice(String name) throws SQLException, ClassNotFoundException {
        AddOn addOn = addOnDao.searchAddOn(name);
        return addOn.getPrice();
    }
}
