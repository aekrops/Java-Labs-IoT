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

import ua.lviv.iot.lawFirm.business.LawyerFirmsService;
import ua.lviv.iot.lawFirm.spring.model.LawyerFirm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/firms")
@RestController
public class LawyerFirmsController {
    
    private Map<Integer, LawyerFirm> firms = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
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
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public LawyerFirm createCustomer(final @RequestBody LawyerFirm firm) {
        firm.setId(IdCounter.incrementAndGet());
        firms.put(firm.getId(), firm);
        lawyerFirmsService.createFirm(firm);
        return firm;
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<LawyerFirm> deleteFirm(final @PathVariable("id") Integer firmId) {
        if (lawyerFirmsService.firmExists(firmId)) {
            lawyerFirmsService.deleteFirm(firmId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<LawyerFirm> updateFirm(final @PathVariable("id") Integer firmId,
            final @RequestBody LawyerFirm firm) {
        firm.setId(firmId);
        if (firms.containsKey(firmId)) {
            firms.put(firmId, firm);
            lawyerFirmsService.updateFirm(firmId, firm);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
