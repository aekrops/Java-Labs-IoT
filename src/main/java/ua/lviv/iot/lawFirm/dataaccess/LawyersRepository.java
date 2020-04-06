package ua.lviv.iot.lawFirm.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.lawFirm.spring.model.Lawyer;

@Repository
public interface LawyersRepository extends JpaRepository<Lawyer, Integer> {

}
