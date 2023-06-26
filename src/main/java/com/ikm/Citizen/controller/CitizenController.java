package com.ikm.Citizen.controller;

import com.ikm.Citizen.model.Citizen;
import com.ikm.Citizen.repository.CitizenRepository;
import com.ikm.Citizen.service.CitizenService;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizenapi/v1")
public class CitizenController {
    CitizenRepository citizenRepository;
    CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenRepository citizenRepository, CitizenService citizenService) {
        this.citizenRepository = citizenRepository;
        this.citizenService = citizenService;
    }

    @PostMapping(value = "/citizen")

    public ResponseEntity<String> createCitizen(@RequestBody Citizen citizen) {
        if (citizen.getName() == null || citizen.getName() == "") {
            return new ResponseEntity("Name can't be blank", HttpStatus.BAD_REQUEST);
        }
        if (citizen.getAddress() == null || citizen.getName() == "") {
            return new ResponseEntity("Address can't be blank", HttpStatus.BAD_REQUEST);
        }
        else {
            Citizen saveCitizen = citizenRepository.save(citizen);
            int id = saveCitizen.getId();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", "/citizenapi/v1/citizen/" + id)
                    .body("Citizen data saved successfully");

        }
    }
}

