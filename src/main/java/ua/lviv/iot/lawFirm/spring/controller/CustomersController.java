package ua.lviv.iot.lawFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.lawFirm.business.CustomersService;
import ua.lviv.iot.lawFirm.spring.model.Customer;
import ua.lviv.iot.lawFirm.spring.model.Lawyer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/customers")
@RestController
public class CustomersController {
    
    private Map<Integer, Customer> customers = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private CustomersService customersService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customersService.getAllCustomers();
    }
    
    @GetMapping(path = "/{id}")
    public Customer getCustomerById(final @PathVariable("id") Integer customerId) {
        return customersService.getCustomerById(customerId);
    }
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Customer createCustomer(final @RequestBody Customer customer) {
        customer.setId(IdCounter.incrementAndGet());
        customers.put(customer.getId(), customer);
        customersService.createCustomer(customer);
        return customer;
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Lawyer> deleteCustomer(@PathVariable("id") Integer customerId) {
        if(customersService.customerExists(customerId)) {
            customersService.deleteCustomer(customerId);
            return ResponseEntity.status(HttpStatus.OK).build();
            // also we can make it like this
            //return ResponseEntity.ok().build();
        }else {
            //or like this
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Lawyer> updateLawyer(final @PathVariable("id") Integer customerId,
            final @RequestBody Customer customer) {
        HttpStatus status;
        customer.setId(customerId);
        if (customers.containsKey(customerId)) {
            customers.put(customerId, customer);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        customersService.updateCustomer(customerId, customer);
        return ResponseEntity.status(status).build();
    }
}
