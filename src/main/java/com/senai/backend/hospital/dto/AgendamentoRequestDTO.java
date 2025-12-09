package com.senai.backend.hospital.dto;

import java.time.LocalDateTime;

import com.senai.backend.hospital.enums.Status;

public class AgendamentoRequestDTO {
    
    private LocalDateTime dataHora;
    private String observacoesMedicas;
    private Status status;

    public AgendamentoRequestDTO() {
    }

    public AgendamentoRequestDTO(Status status, LocalDateTime dataHora, String observacoesMedicas) {
        this.status = status;
        this.dataHora = dataHora;
        this.observacoesMedicas = observacoesMedicas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
