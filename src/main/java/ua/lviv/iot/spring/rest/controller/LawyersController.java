package ua.lviv.iot.spring.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

import ua.lviv.iot.lawFirm.model.Lawyer;

@RequestMapping("/lawyers")
@RestController
public class LawyersController {

    private Map<Integer, Lawyer> lawyers = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    
    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return new  LinkedList<>(lawyers.values());
    }
    
    @GetMapping(path = "/{id}")
    public Lawyer getStudent(final @PathVariable("id") Integer lawyerId) {
        return lawyers.get(lawyerId);
    }
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Lawyer createLawyer(final @RequestBody Lawyer lawyer) {
        lawyer.setId(IdCounter.incrementAndGet());
        lawyers.put(lawyer.getId(), lawyer);
        return lawyer;
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Lawyer> deleteLawyer(@PathVariable("id") Integer lawyerId) {
        HttpStatus status = lawyers.remove(lawyerId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Lawyer> updateLawyer(final @PathVariable("id") Integer lawyerId,
            final @RequestBody Lawyer lawyer) {
        HttpStatus status = lawyers.put(lawyerId, lawyer) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }
}
