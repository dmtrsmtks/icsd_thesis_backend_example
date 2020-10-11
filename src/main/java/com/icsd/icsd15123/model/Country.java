package com.icsd.icsd15123.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String place;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "country_service",
            joinColumns = { @JoinColumn(name = "country_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") })
    private Set<PublicService> services = new HashSet<>();


    public  Country(){

    }

    public Country(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<PublicService> getServices() {
        return services;
    }

    public void setServices(Set<PublicService> services) {
        this.services = services;
    }
}
