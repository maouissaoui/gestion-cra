package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Cra;
import com.consulting.core.cra.repository.CraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class CraController {
    @Autowired
    private CraRepository craRepository;

    //get all
    @RequestMapping(value = "cras", method = RequestMethod.GET)
    public Collection<Cra> getCras() {
        return craRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //post
    @RequestMapping(value = "cra", method = RequestMethod.POST)
    public Cra addCra(@Valid @RequestBody Cra Cra) {
        return craRepository.save(Cra);
    }

    //get by id
    @RequestMapping("cras/{id}")
    public Cra getCraById(@PathVariable(value = "id") Long CraId) {
        return craRepository.findById(CraId)
                .orElseThrow(() -> new ResourceNotFoundException("CraId"));
    }

    //delete
    @RequestMapping(value = "cra/{id}", method = RequestMethod.DELETE)
    public void deleteCra(@PathVariable("id") long id) {
        Optional<Cra> currentContrat = null;
        currentContrat = craRepository.findById(id);
        if (!currentContrat.equals("null")) {
            craRepository.deleteById(id);
        }
    }
    //update
    @RequestMapping(value = "cra/{id}", method = RequestMethod.PUT)
    public Cra updateCra (@PathVariable(value = "id") String CraId,
                            @Valid @RequestBody Cra CraDetails) {

        Cra Cra = craRepository.findById(Long.parseLong(CraId))
                .orElseThrow(() -> new ResourceNotFoundException("companyId"));
        System.out.println(Cra);
        Cra.setYear(CraDetails.getYear());
        Cra.setMonth(CraDetails.getMonth());
        Cra.setDays(CraDetails.getDays());
        Cra.setStatus(CraDetails.getStatus());

        Cra updatedCra = craRepository.save(Cra);
        System.out.println(updatedCra);

        return updatedCra;
    }

}
