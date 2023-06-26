package com.ikm.Citizen.service;


import com.ikm.Citizen.model.Citizen;
import com.ikm.Citizen.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService implements CitizenInterface {
   CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository arisingFileRepository) {
        this.citizenRepository = arisingFileRepository;
    }

    @Override
    public Citizen save(Citizen ariseFile){
        return citizenRepository.save(ariseFile);
    }
}
