package br.com.ulbra.apirest.dto.jogadores.request;

public class JogadorRequest {
    private Long treinadorId;
    private String content;

    public JogadorRequest() {}

    public JogadorRequest(Long treinadorId, String content){
        this.treinadorId = treinadorId;
        this.content = content;
    }

    public Long getTreinadorId() {
        return treinadorId;
    }

    public void setTreinadorId(Long treinadorId) {
        this.treinadorId = treinadorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
