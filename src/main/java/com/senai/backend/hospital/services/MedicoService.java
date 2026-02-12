package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.backend.hospital.dto.MedicoRequestDTO;
import com.senai.backend.hospital.dto.MedicoResponseDTO;
import com.senai.backend.hospital.models.Medico;
import com.senai.backend.hospital.repositories.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    private MedicoRepository medicoRepository;

    // salvar - POST
public MedicoResponseDTO salvar(MedicoRequestDTO medicoDTO) {
    Medico medicoNovo = new Medico();

    medicoNovo.setNome(medicoDTO.getNome());
    medicoNovo.setEspecializacao(medicoDTO.getEspecializacao());
    medicoNovo.setLimiteDiario(medicoDTO.getLimiteDiario());

    Medico salvo = medicoRepository.save(medicoNovo);

    MedicoResponseDTO response = new MedicoResponseDTO();
    response.setId(salvo.getId());  // retorna o ID gerado pelo banco (útil para confirmar)

    return response;
}

    // buscar pelo id - GET
    public Medico buscarPorId(Integer id) {
        return medicoRepository.findById(id).get();
    }

    // listar todos - GET
    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return medicoRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        Medico med = medicoRepository.findById(id).get();
        if (med != null) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT
    public Medico atualizar(Integer id, Medico medico) {
        Medico med = medicoRepository.findById(id).get();
        if (medico != null) {
            medico.setId(med.getId());
            return medicoRepository.save(medico);
        }
        return null;
    }

}
