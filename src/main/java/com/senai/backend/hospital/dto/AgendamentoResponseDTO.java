package com.senai.backend.hospital.dto;

public class AgendamentoResponseDTO {
    
    private String observacoesMedicas;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

}
