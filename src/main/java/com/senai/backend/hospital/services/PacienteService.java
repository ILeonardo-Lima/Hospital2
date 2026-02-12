package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.hospital.dto.PacienteRequestDTO;
import com.senai.backend.hospital.dto.PacienteResponseDTO;
import com.senai.backend.hospital.models.Paciente;
import com.senai.backend.hospital.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // método para PUT / atualizar

public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
    // código que transforma DTO em Paciente, salva e retorna ResponseDTO
    Paciente pacienteNovo = new Paciente();
    pacienteNovo.setNome(dto.getNome());
    pacienteNovo.setIdade(dto.getIdade());
    // ... outros sets

    Paciente salvo = pacienteRepository.save(pacienteNovo);

    PacienteResponseDTO response = new PacienteResponseDTO();
    response.setId(salvo.getId());
    // ... outros campos se quiser

    return response;
}
    // buscar pelo id - GET
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    // listar todos - GET
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return pacienteRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        Paciente pac = pacienteRepository.findById(id).get();
        if (pac != null) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT (versão antiga que você tinha, mantive para referência)
    public Paciente atualizar(Integer id, Paciente paciente) {
        Paciente pac = pacienteRepository.findById(id).get();
        if (paciente != null) {
            paciente.setId(pac.getId());
            return pacienteRepository.save(paciente);
        }
        return null;
    }
}