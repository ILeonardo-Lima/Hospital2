package com.senai.backend.hospital.dto;

public class MedicoResponseDTO {

        private String observacoesMedicas;

    public MedicoResponseDTO() {
    }

    public MedicoResponseDTO(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

}
