package ua.lviv.iot.lawFirm.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.lawFirm.spring.model.Customer;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer> {

}
