package br.com.ulbra.apirest.dto.treinadores;

import java.util.ArrayList;
import java.util.List;

public class TreinadorResponseDTO {
    private String nome;
    private String titulos;
    private List<TreinadorJogadorDTO> jogadores = new ArrayList<>();

    public TreinadorResponseDTO(String nome, String titulos, String premiosIndividuais, List<TreinadorJogadorDTO> jogadores){
        this.nome = nome;
        this.titulos = titulos;
        this.jogadores = jogadores;
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

    public List<TreinadorJogadorDTO> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<TreinadorJogadorDTO> jogadores) {
        this.jogadores = jogadores;
    }
}
