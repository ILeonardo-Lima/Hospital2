package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senai.backend.hospital.dto.AgendamentoRequestDTO;
import com.senai.backend.hospital.dto.AgendamentoResponseDTO;
import com.senai.backend.hospital.models.Agendamento;
import com.senai.backend.hospital.models.Medico;
import com.senai.backend.hospital.models.Paciente;
import com.senai.backend.hospital.repositories.AgendamentoRepository;
import com.senai.backend.hospital.repositories.MedicoRepository;
import com.senai.backend.hospital.repositories.PacienteRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Agendamento criarAgendamento(AgendamentoRequestDTO dto) {

        Medico medico = medicoRepository.findById(dto.getMedicoId())
            .orElseThrow(() -> new RuntimeException("Médico não encontrado: " + dto.getMedicoId()));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + dto.getPacienteId()));

        Agendamento agendamentoNovo = new Agendamento();
        agendamentoNovo.setMedico(medico);                
        agendamentoNovo.setPaciente(paciente);
        agendamentoNovo.setDataHora(dto.getDataHora());
        agendamentoNovo.setObservacoesMedicas(dto.getObservacoesMedicas());
        agendamentoNovo.setStatus(dto.getStatus());

        Agendamento salvo = agendamentoRepository.save(agendamentoNovo);

        // Retorna a entidade salva (ou mapeie para ResponseDTO se preferir)
        return salvo;
    }

    // salvar - POST
    @Transactional
    public AgendamentoResponseDTO salvar(AgendamentoRequestDTO agendamento) {
        Agendamento agendamentoNovo = new Agendamento();

        // Busca as entidades (agora dentro do método, pois não tem variáveis externas)
        Medico medico = medicoRepository.findById(agendamento.getMedicoId())
            .orElseThrow(() -> new RuntimeException("Médico não encontrado: " + agendamento.getMedicoId()));

        Paciente paciente = pacienteRepository.findById(agendamento.getPacienteId())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + agendamento.getPacienteId()));

        agendamentoNovo.setMedico(medico);                
        agendamentoNovo.setPaciente(paciente);
        agendamentoNovo.setDataHora(agendamento.getDataHora());
        agendamentoNovo.setObservacoesMedicas(agendamento.getObservacoesMedicas());
        agendamentoNovo.setStatus(agendamento.getStatus());

        Agendamento salvo = agendamentoRepository.save(agendamentoNovo);

        AgendamentoResponseDTO aResDTO = new AgendamentoResponseDTO();
        aResDTO.setObservacoesMedicas(salvo.getObservacoesMedicas());
        // Se quiser, adicione mais campos no ResponseDTO aqui
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