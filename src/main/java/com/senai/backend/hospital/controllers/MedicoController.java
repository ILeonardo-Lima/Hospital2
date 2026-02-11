package com.senai.backend.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.hospital.models.Agendamento;
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

    // buscar pelo id - GET
    @GetMapping("/buscarPorId/{id}")
    public Medico buscarPorId(@PathVariable Integer id) {
        return medicoService.buscarPorId(id);
    }

    // listar todos - GET
    @GetMapping("/listar")
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    // contar - GET
    @GetMapping("/contar")
    public long contar() {
        return medicoService.contar();
    }

    // remover pelo id - DELETE
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        if (medicoService.removerPorId(id)) {
            return "Medico removido com sucesso!";
        }
        return "Falha ao remover Medico!";
    }

    // atualizar - PUT
    @PutMapping("/salvar/{id}")
    public Medico atualizar(@PathVariable Integer id, @RequestBody Medico medico) {
        return medicoService.atualizar(id, medico);
    }

    
}
