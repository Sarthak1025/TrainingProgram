package com.training.service;

import com.training.beans.Coffee;
import com.training.beans.Size;
import com.training.persistence.SizeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SizeServiceImpl implements SizeService{
    @Autowired
    private SizeDao sizeDao;
    @Override
    public ArrayList<String> getAllSizes() {
        ArrayList<Size> sizes = (ArrayList<Size>) sizeDao.findAll();
        ArrayList<String> sizeNames = new ArrayList<>();
        for (Size size: sizes)
            sizeNames.add(size.getSizeName());
        return sizeNames;
    }

    @Override
    public double getSizeRatio(String name) {
        ArrayList<Size> sizes = (ArrayList<Size>) sizeDao.findAll();
        double ratio = 0;
        for (Size size: sizes){
            if (size.getSizeName().equalsIgnoreCase(name)){
                ratio = size.getRatio();
                break;
            }
        }
        return ratio;
    }

    @Override
    public Size getSize(String name) {
        return sizeDao.getSizeBySizeName(name);
    }
}
