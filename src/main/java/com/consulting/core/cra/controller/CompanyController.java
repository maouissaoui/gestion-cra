package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Company;
import com.consulting.core.cra.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nizaraouissaoui on 21/04/2018.
 */

@RestController
@RequestMapping("/api/clients")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Company> getCompanies() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company addCompany(Company company) {
        return repository.save(company);
    }
}
