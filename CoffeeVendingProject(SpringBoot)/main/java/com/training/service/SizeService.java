package com.training.service;

import com.training.beans.Size;

import java.util.ArrayList;

public interface SizeService {
    ArrayList<String> getAllSizes();
    double getSizeRatio(String name);
    Size getSize(String name);
}
