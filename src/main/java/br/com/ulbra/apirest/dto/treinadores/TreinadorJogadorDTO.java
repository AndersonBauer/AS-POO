package br.com.ulbra.apirest.dto.treinadores;

public class TreinadorJogadorDTO {
    private Long id;
    private String content;

    public TreinadorJogadorDTO(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
