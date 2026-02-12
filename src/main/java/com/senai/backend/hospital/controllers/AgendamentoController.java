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

import com.senai.backend.hospital.dto.AgendamentoRequestDTO;
import com.senai.backend.hospital.dto.AgendamentoResponseDTO;
import com.senai.backend.hospital.models.Agendamento;
import com.senai.backend.hospital.services.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService agendamentoService;

    
    // salvar - POST
    @PostMapping("/salvar")
    public AgendamentoResponseDTO salvar(@RequestBody AgendamentoRequestDTO agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    // buscar pelo id - GET
    @GetMapping("/buscarPorId/{id}")
    public Agendamento buscarPorId(@PathVariable Integer id) {
        return agendamentoService.buscarPorId(id);
    }

    // listar todos - GET
    @GetMapping("/listar")
    public List<Agendamento> listarTodos() {
        return agendamentoService.listarTodos();
    }

    // contar - GET
    @GetMapping("/contar")
    public long contar() {
        return agendamentoService.contar();
    }

    // remover pelo id - DELETE
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        if (agendamentoService.removerPorId(id)) {
            return "Agendamento removido com sucesso!";
        }
        return "Falha ao remover agendamento!";
    }

    // atualizar - PUT
    @PutMapping("/atualizar/{id}")
    public Agendamento atualizar(@PathVariable Integer id, @RequestBody Agendamento agendamento) {
        return agendamentoService.atualizar(id, agendamento);
    }

}