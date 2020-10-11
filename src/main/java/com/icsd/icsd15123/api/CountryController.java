package com.icsd.icsd15123.api;

import com.icsd.icsd15123.exception.CountryIdMismatchException;
import com.icsd.icsd15123.exception.CountryNotFoundException;
import com.icsd.icsd15123.model.Country;
import com.icsd.icsd15123.model.PublicService;
import com.icsd.icsd15123.repository.CountryRepository;
import com.icsd.icsd15123.repository.PublicServiceRepository;
import com.icsd.icsd15123.viewmodel.CountryViewModel;
import com.icsd.icsd15123.viewmodel.PublicServiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;


    @GetMapping("/all")
    public List<CountryViewModel> getAll(){

        List<Country> countries = this.countryRepository.findAll();
        List<CountryViewModel> countryViewModels = countries.stream().map(this::convertToCountryViewModel).collect(Collectors.toList());

        return countryViewModels;
    }

    @GetMapping("/{id}")
    public CountryViewModel findOne(@PathVariable Long id) {


        CountryViewModel countryViewModel = convertToCountryViewModel(this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException("Country not found",new Throwable())));

        return countryViewModel;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country create(@RequestBody Country country) {
        return this.countryRepository.save(country);
    }


    @PutMapping("/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable Long id) {
        if (country.getId() != id) {
            throw new CountryIdMismatchException("Id not match",new Throwable());
        }
        this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException("Id not match",new Throwable()));
        return this.countryRepository.save(country);
    }

    protected CountryViewModel convertToCountryViewModel(Country entity) {

        CountryViewModel viewModel = new CountryViewModel();
        viewModel.setName(entity.getName());
        viewModel.setPlace(entity.getPlace());

        Set<PublicService> publicServices = entity.getServices();

        Set<PublicServiceViewModel> publicServiceViewModels = publicServices.stream().map(this::convertToServiceViewModel).collect(Collectors.toSet());
        viewModel.setPublicServiceViewModels(publicServiceViewModels);


        return viewModel;
    }

    protected PublicServiceViewModel convertToServiceViewModel(PublicService publicService){

        PublicServiceViewModel publicServiceViewModel = new PublicServiceViewModel();
        publicServiceViewModel.setName(publicService.getName());
        publicServiceViewModel.setDigital(publicService.getDigital());

        return  publicServiceViewModel;
    }

}
