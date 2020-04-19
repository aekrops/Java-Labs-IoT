package ua.lviv.iot.lawFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.lawFirm.business.LawyerFirmsService;
import ua.lviv.iot.lawFirm.spring.model.LawyerFirm;

import java.util.List;

@RequestMapping("/firms")
@RestController
public class LawyerFirmsController {
    @Autowired
    private LawyerFirmsService lawyerFirmsService;

    @GetMapping
    public List<LawyerFirm> getAllFirms() {
        return lawyerFirmsService.getAllFirms();
    }
    
    @GetMapping(path = "/{id}")
    public LawyerFirm getFirm(Integer firmId) {
        return lawyerFirmsService.getFirmById(firmId);
    }
    
//    @PostMapping
//    public ResponseEntity<LawyerFirm> deleteFirm(final @PathVariable("id") Integer firmId) {
//    
//    }
    
}
