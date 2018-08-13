package com.consulting.core.cra.controller;

import com.consulting.core.cra.model.Bill;
import com.consulting.core.cra.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class BillController
{
    @Autowired
    private BillRepository billRepository;

    //get all
    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public Collection<Bill> getBills() {
        return billRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //post
    @RequestMapping(value = "bill", method = RequestMethod.POST)
    public Bill addBill(@Valid @RequestBody Bill Bill) {
        return billRepository.save(Bill);
    }

    //get by id
    @RequestMapping("bills/{id}")
    public Bill getBillById(@PathVariable(value = "id") Long BillId) {
        return billRepository.findById(BillId)
                .orElseThrow(() -> new ResourceNotFoundException("BillId"));
    }

    //delete
    @RequestMapping(value = "bill/{id}", method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable("id") long id) {
        Optional<Bill> currentContrat = null;
        currentContrat = billRepository.findById(id);
        if (!currentContrat.equals("null")) {
            billRepository.deleteById(id);
        }
    }
    //update
    @RequestMapping(value = "bill/{id}", method = RequestMethod.PUT)
    public Bill updateBill (@PathVariable(value = "id") String BillId,
                                    @Valid @RequestBody Bill BillDetails) {

        Bill Bill = billRepository.findById(Long.parseLong(BillId))
                .orElseThrow(() -> new ResourceNotFoundException("companyId"));
        System.out.println(Bill);
        Bill.setTva(BillDetails.getTva());
        Bill.setPaid(BillDetails.getPaid());
        Bill.setGlobalAmount(BillDetails.getGlobalAmount());

        Bill updatedBill = billRepository.save(Bill);
        System.out.println(updatedBill);

        return updatedBill;
    }

}
