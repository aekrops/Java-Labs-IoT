package ua.lviv.iot.lawFirm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lawFirm.dataaccess.LawyerFirmsRepository;
import ua.lviv.iot.lawFirm.spring.model.LawyerFirm;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LawyerFirmsService {

    @Autowired
    private LawyerFirmsRepository lawyerFirmsRepository;

    public List<LawyerFirm> getAllFirms() {
        return lawyerFirmsRepository.findAll();
    }
    
    public LawyerFirm getFirmById(Integer firmId) {
        try {
            return lawyerFirmsRepository.findById(firmId).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    
    public LawyerFirm createFirm(LawyerFirm firm) {
        return lawyerFirmsRepository.save(firm);
    }
    
    public LawyerFirm updateFirm(Integer firmId, LawyerFirm firm) {
        firm.setId(firmId);
        return lawyerFirmsRepository.save(firm);
    }
    
    public void deleteFirm(Integer firmId) {
        lawyerFirmsRepository.deleteById(firmId);
    }
    
}
