package com.training.service;

import com.training.beans.AddOn;
import com.training.beans.Coffee;
import com.training.persistence.AddOnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddOnServiceImpl implements AddOnService{
    @Autowired
    private AddOnDao addOnDao;
    @Override
    public ArrayList<String> getAllAddOns() {
        ArrayList<AddOn> addOns = (ArrayList<AddOn>) addOnDao.findAll();
        ArrayList<String> addOnNames = new ArrayList<>();
        for (AddOn addOn: addOns)
            addOnNames.add(addOn.getAddOnName());
        return addOnNames;
    }

    @Override
    public int getAddOnPrice(String name) {
        ArrayList<AddOn> addOns = (ArrayList<AddOn>) addOnDao.findAll();
        int price =0;
        for (AddOn addOn: addOns){
            if (addOn.getAddOnName().equalsIgnoreCase(name)){
                price = addOn.getPrice();
                break;
            }
        }
        return price;
    }

    @Override
    public AddOn getAddOn(String name) {
        /*AddOn addOnRec = null;
        ArrayList<AddOn> addOns = addOnDao.getAllRecords();
        for (AddOn addOn: addOns){
            if (addOn.getAddOnName().equals(name)){
                addOnRec = addOn;
                break;
            }
        }
        return addOnRec;*/
        return addOnDao.getAddOnByAddOnName(name);
    }
}
