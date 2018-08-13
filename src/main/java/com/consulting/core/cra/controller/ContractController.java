package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Contract;
import com.consulting.core.cra.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by nizaraouissaoui on 21/04/2018.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class ContractController {

    @Autowired
    private ContratRepository contratRepository;

    //get all
    @RequestMapping(value = "contrats", method = RequestMethod.GET)
    public Collection<Contract> getContrats() {
        return contratRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //post
    @RequestMapping(value = "contrat", method = RequestMethod.POST)
    public Contract addContract(@Valid @RequestBody Contract contract) {
        return contratRepository.save(contract);
    }

    //get by id
    @RequestMapping("contrats/{id}")
    public Contract getContractById(@PathVariable(value = "id") Long contractId) {
        return contratRepository.findById(contractId)
                .orElseThrow(() -> new ResourceNotFoundException("contractId"));
    }

    //delete
    @RequestMapping(value = "contrat/{id}", method = RequestMethod.DELETE)
    public void deleteContract(@PathVariable("id") long id) {
        Optional<Contract> currentContrat = null;
        currentContrat = contratRepository.findById(id);
        if (!currentContrat.equals("null")) {
            contratRepository.deleteById(id);
        }
    }
    //update
    @RequestMapping(value = "contrat/{id}", method = RequestMethod.PUT)
    public Contract updateContract (@PathVariable(value = "id") String contractId,
                                 @Valid @RequestBody Contract contractDetails) {

        Contract contract = contratRepository.findById(Long.parseLong(contractId))
                .orElseThrow(() -> new ResourceNotFoundException("companyId"));
        System.out.println(contract);
        contract.setContractId(contractDetails.getContractId());
        contract.setTjm(contractDetails.getTjm());
        contract.setStartDate(contractDetails.getStartDate());
        contract.setEndDate(contractDetails.getEndDate());
        contract.setPaiementPeriod(contractDetails.getPaiementPeriod());
        contract.setComment(contractDetails.getComment());
        contract.setActive(contractDetails.getActive());


        Contract updatedContract = contratRepository.save(contract);
        System.out.println(updatedContract);

        return updatedContract;
    }

}