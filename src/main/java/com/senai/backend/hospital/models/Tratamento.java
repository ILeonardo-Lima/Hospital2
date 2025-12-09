package com.senai.backend.hospital.models;

import java.time.LocalDateTime;
import java.util.List;

import com.senai.backend.hospital.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tratamento")
public class Tratamento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Column(name="descricao")
    private String descricao;

    @Column(name="custo")
    private Double custo;

    @Column(name="duracao_minutos")
    private int duracaoMinutos;

    @Column(name="data_hora_criacao")
    private LocalDateTime dataHoraCriacao;

    @Column(name="data_hora_atualizacao")
    private LocalDateTime dataHoraAtualizacao;

    @OneToMany(mappedBy="tratamento")
    private List<Categoria> categorias;

    @ManyToOne
    @JoinColumn(name="agendamento_id")
    private Agendamento agendamento;

    public Tratamento() {
    }

    public Tratamento(Double custo, LocalDateTime dataHoraAtualizacao, LocalDateTime dataHoraCriacao, String descricao, int duracaoMinutos, Integer id, Status status, List<Categoria> categorias, Agendamento agendamento) {
        this.custo = custo;
        this.dataHoraAtualizacao = LocalDateTime.now();
        this.dataHoraCriacao = LocalDateTime.now();
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.id = id;
        this.status = status;
        this.categorias = categorias;
        this.agendamento = agendamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

}
