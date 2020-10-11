package com.icsd.icsd15123.viewmodel;


import java.util.HashSet;
import java.util.Set;

public class PublicServiceViewModel {


    private String name;
    private String digital;


    public PublicServiceViewModel(){

    }

    public PublicServiceViewModel(String name, String digital) {
        this.name = name;
        this.digital = digital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDigital() {
        return digital;
    }

    public void setDigital(String digital) {
        this.digital = digital;
    }


}
