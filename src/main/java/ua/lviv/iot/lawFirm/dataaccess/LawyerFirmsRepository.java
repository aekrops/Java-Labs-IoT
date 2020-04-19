package ua.lviv.iot.lawFirm.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.lawFirm.spring.model.LawyerFirm;

public interface LawyerFirmsRepository extends JpaRepository<LawyerFirm,Integer> {

}
