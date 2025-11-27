package br.com.ulbra.apirest.dto.jogadores.response;

public class JogadorTreinadorDTO {
    private String nome;
    public JogadorTreinadorDTO(){}
    public JogadorTreinadorDTO(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
