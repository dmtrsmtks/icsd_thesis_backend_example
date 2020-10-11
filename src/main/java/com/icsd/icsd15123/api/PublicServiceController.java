package com.icsd.icsd15123.api;

import com.icsd.icsd15123.model.Country;
import com.icsd.icsd15123.model.PublicService;
import com.icsd.icsd15123.repository.CountryRepository;
import com.icsd.icsd15123.repository.PublicServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class PublicServiceController {


    @Autowired
    private PublicServiceRepository publicServiceRepository;

    @GetMapping("/all")
    public List<PublicService> getAll(HttpServletRequest request){

        return this.publicServiceRepository.findAll();
    }

}
