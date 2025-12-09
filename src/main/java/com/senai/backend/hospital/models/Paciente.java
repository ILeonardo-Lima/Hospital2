package com.senai.backend.hospital.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="status")
    private boolean status;

    @Column(name="data_hora_criacao")
    private LocalDateTime dataHoraCriacao;

    @Column(name="data_hora_atualizacao")
    private LocalDateTime dataHoraAtualizacao;

    @OneToMany(mappedBy="paciente")
    private List<Agendamento> agendamentos;

    public Paciente() {
    }

    public Paciente(LocalDateTime dataHoraAtualizacao, LocalDateTime dataHoraCriacao, Integer id, String nome, boolean status, List<Agendamento> agendamentos) {
        this.dataHoraAtualizacao = LocalDateTime.now();
        this.dataHoraCriacao = LocalDateTime.now();
        this.id = id;
        this.nome = nome;
        this.status = true;
        this.agendamentos = agendamentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }

    public void setDataHoraAtualizacao(LocalDateTime dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

}
