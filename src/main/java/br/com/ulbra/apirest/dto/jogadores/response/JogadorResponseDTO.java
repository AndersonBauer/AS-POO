package br.com.ulbra.apirest.dto.jogadores.response;

public class JogadorResponseDTO {
    private String content;
    private JogadorTreinadorDTO treinador;

    public JogadorResponseDTO() {}
    public JogadorResponseDTO(String content, JogadorTreinadorDTO treinador){
        this.content = content;
        this.treinador = treinador;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JogadorTreinadorDTO getTreinador() {
        return treinador;
    }

    public void setTreinador(JogadorTreinadorDTO treinador) {
        this.treinador = treinador;
    }
}
