package br.com.ulbra.apirest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_treinadores")
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String titulos;
    private String premiosIndividuais;

    @OneToMany(mappedBy = "treinador")
    @JsonManagedReference
    private List<Jogador> jogadores = new ArrayList<>();

    public Treinador() {
    }

    public Treinador(Long id, String nome, String titulos, String premiosIndividais) {
        this.id = id;
        this.nome = nome;
        this.titulos = titulos;
        this.premiosIndividuais = premiosIndividais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getPremiosIndividuais() {
        return premiosIndividuais;
    }

    public void setPremiosIndividuais(String premiosIndividuais) {
        this.premiosIndividuais = premiosIndividuais;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}