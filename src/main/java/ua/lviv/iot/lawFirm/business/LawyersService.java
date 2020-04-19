package ua.lviv.iot.lawFirm.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lawFirm.dataaccess.LawyersRepository;
import ua.lviv.iot.lawFirm.spring.model.Lawyer;

@Service
public class LawyersService {
    @Autowired
    private LawyersRepository lawyerRepository;

    public Lawyer createLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    public void deleteLawyer(Integer id) {
        lawyerRepository.deleteById(id);
    }

    public boolean lawyerExists(Integer id) {
        return lawyerRepository.existsById(id);
    }

    public Lawyer updateLawyer(Integer id, Lawyer newLawyer) {
        Lawyer lawyer = lawyerRepository.getOne(id);
        lawyer = newLawyer;
        return lawyerRepository.save(lawyer);
    }

    public List<Lawyer> findAll() {
        return lawyerRepository.findAll();
    }
}
