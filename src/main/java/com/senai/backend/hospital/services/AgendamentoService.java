package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.hospital.dto.AgendamentoRequestDTO;
import com.senai.backend.hospital.dto.AgendamentoResponseDTO;
import com.senai.backend.hospital.models.Agendamento;
import com.senai.backend.hospital.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // salvar - POST
    public AgendamentoResponseDTO salvar(AgendamentoRequestDTO agendamento) {
        Agendamento agendamentoNovo = new Agendamento();
        agendamentoNovo.setDataHora(agendamento.getDataHora());
        agendamentoNovo.setObservacoesMedicas(agendamento.getObservacoesMedicas());
        agendamentoNovo.setStatus(agendamento.getStatus());
        agendamentoRepository.save(agendamentoNovo);

        AgendamentoResponseDTO aResDTO = new AgendamentoResponseDTO();
        aResDTO.setObservacoesMedicas(agendamentoNovo.getObservacoesMedicas());
        return aResDTO;
    }

    // buscar pelo id - GET
    public Agendamento buscarPorId(Integer id) {
        return agendamentoRepository.findById(id).get();
    }

    // listar todos - GET
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return agendamentoRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        Agendamento agen = agendamentoRepository.findById(id).get();
        if (agen != null) {
            agendamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT
    public Agendamento atualizar(Integer id, Agendamento agendamento) {
        Agendamento age = agendamentoRepository.findById(id).get();
        if (agendamento != null) {
            agendamento.setId(age.getId());
            return agendamentoRepository.save(agendamento);
        }
        return null;
    }

}
