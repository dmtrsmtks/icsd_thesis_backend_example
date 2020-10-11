package com.icsd.icsd15123.viewmodel;

import com.icsd.icsd15123.model.PublicService;

import javax.persistence.Column;
import java.util.Set;

public class CountryViewModel {

    private String name;
    private String place;
    private Set<PublicServiceViewModel> publicServiceViewModels;

    public CountryViewModel(){

    }

    public CountryViewModel(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Set<PublicServiceViewModel> getPublicServiceViewModels() {
        return publicServiceViewModels;
    }

    public void setPublicServiceViewModels(Set<PublicServiceViewModel> publicServiceViewModels) {
        this.publicServiceViewModels = publicServiceViewModels;
    }
}
