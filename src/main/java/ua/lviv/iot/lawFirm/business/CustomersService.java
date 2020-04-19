package ua.lviv.iot.lawFirm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lawFirm.dataaccess.CustomersRepository;
import ua.lviv.iot.lawFirm.spring.model.Customer;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public List<Customer> findAll() {
        return customersRepository.findAll();
    }
}
