package com.senai.backend.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.hospital.models.Medico;
import com.senai.backend.hospital.services.MedicoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // salvar - POST
    @PostMapping("/salvar")
    public Medico salvar(@RequestBody Medico medico) {
        return medicoService.salvar(medico);
    }
    
}
