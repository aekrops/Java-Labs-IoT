package ua.lviv.iot.lawFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.iot.lawFirm.business.CustomersService;
import ua.lviv.iot.lawFirm.spring.model.Customer;

import java.util.List;

@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    public List<Customer> getAllFirms() {
        return customersService.findAll();
    }
}
