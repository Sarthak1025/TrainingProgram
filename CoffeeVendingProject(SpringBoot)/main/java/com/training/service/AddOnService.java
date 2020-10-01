package com.training.service;

import com.training.beans.AddOn;

import java.util.ArrayList;

public interface AddOnService {
    ArrayList<String> getAllAddOns();
    int getAddOnPrice(String name);
    AddOn getAddOn(String name);
}
