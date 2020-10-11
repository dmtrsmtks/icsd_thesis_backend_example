package com.icsd.icsd15123.repository;

import com.icsd.icsd15123.model.Country;
import com.icsd.icsd15123.model.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@ConditionalOnProperty(name = "icsd.repo.recreate", havingValue = "true")
public class DatabaseInsert implements CommandLineRunner {


    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PublicServiceRepository publicServiceRepository;

    @Override
    public void run(String... args) throws Exception {


        Country greece = new Country("Greece","27");
        Country bulgaria = new Country("Bulgaria","28");

        this.countryRepository.save(greece);
        this.countryRepository.save(bulgaria);

        PublicService taxis = new PublicService("taxis","true");
        PublicService hospitality = new PublicService("hospitality","false");

        this.publicServiceRepository.save(taxis);
        this.publicServiceRepository.save(hospitality);


        Set<PublicService> publicServices = new HashSet<>();

        publicServices.add(taxis);
        publicServices.add(hospitality);

        greece.setServices(publicServices);

        this.countryRepository.save(greece);

    }
}
