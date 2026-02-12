package com.senai.backend.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.hospital.dto.PacienteRequestDTO;
import com.senai.backend.hospital.dto.PacienteResponseDTO;
import com.senai.backend.hospital.models.Paciente;
import com.senai.backend.hospital.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Método de salvar - POST (corrigido e funcionando)
    @PostMapping("/salvar")
    public PacienteResponseDTO salvar(@RequestBody PacienteRequestDTO paciente) {
        return pacienteService.salvar(paciente);
    }

    // buscar pelo id - GET
    @GetMapping("/buscarPorId/{id}")
    public Paciente buscarPorId(@PathVariable Integer id) {
        return pacienteService.buscarPorId(id);
    }

    // listar todos - GET
    @GetMapping("/listar")
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    // contar - GET
    @GetMapping("/contar")
    public long contar() {
        return pacienteService.contar();
    }

    // remover pelo id - DELETE
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        if (pacienteService.removerPorId(id)) {
            return "Paciente removido com sucesso!";
        }
        return "Falha ao remover Paciente!";
    }

    // atualizar - PUT (corrigido: movido para dentro do controller e usando o service)
@PutMapping("/atualizar/{id}")
public Paciente atualizar(@PathVariable Integer id, @RequestBody Paciente paciente) {
    return pacienteService.atualizar(id, paciente);
}
}