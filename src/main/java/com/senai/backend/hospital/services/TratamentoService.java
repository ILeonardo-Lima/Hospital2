package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.hospital.models.Tratamento;
import com.senai.backend.hospital.repositories.TratamentoRepository;

@Service
public class TratamentoService {
    
    @Autowired
    private TratamentoRepository tratamentoRepository;

    // salvar - POST
    public Tratamento salvar(Tratamento tratamento) {
        return tratamentoRepository.save(tratamento);
    }

    // buscar pelo id - GET
    public Tratamento buscarPorId(Integer id) {
        return tratamentoRepository.findById(id).get();
    }

    // listar todos - GET
    public List<Tratamento> listarTodos() {
        return tratamentoRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return tratamentoRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        Tratamento trata = tratamentoRepository.findById(id).get();
        if (trata != null) {
            tratamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT
    public Tratamento atualizar(Integer id, Tratamento tratamento) {
        Tratamento trata = tratamentoRepository.findById(id).get();
        if (tratamento != null) {
            tratamento.setId(trata.getId());
            return tratamentoRepository.save(tratamento);
        }
        return null;
    }

}
