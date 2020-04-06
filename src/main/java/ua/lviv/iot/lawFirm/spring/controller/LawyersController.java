package ua.lviv.iot.lawFirm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lawFirm.business.LawyersService;
import ua.lviv.iot.lawFirm.spring.model.Lawyer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RequestMapping("/lawyers")
@RestController
public class LawyersController {

    private Map<Integer, Lawyer> lawyers = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();
    @Autowired
    private LawyersService lawyersService;

    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return new LinkedList<>(lawyers.values());
    }

    @GetMapping(path = "/{id}")
    public Lawyer getStudent(final @PathVariable("id") Integer lawyerId) {
        return lawyers.get(lawyerId);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Lawyer createLawyer(final @RequestBody Lawyer lawyer) {
        lawyer.setId(IdCounter.incrementAndGet());
        lawyers.put(lawyer.getId(), lawyer);
        lawyersService.createLawyer(lawyer);
        return lawyer;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Lawyer> deleteLawyer(@PathVariable("id") Integer lawyerId) {
        HttpStatus status = lawyers.remove(lawyerId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        lawyersService.deleteLawyer(lawyerId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Lawyer> updateLawyer(final @PathVariable("id") Integer lawyerId,
            final @RequestBody Lawyer lawyer) {
        HttpStatus status;
        lawyer.setId(lawyerId);
        if (lawyers.containsKey(lawyerId)) {
            lawyers.put(lawyerId, lawyer);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        lawyersService.updateLawyer(lawyerId, lawyer);
        return ResponseEntity.status(status).build();
    }
}
