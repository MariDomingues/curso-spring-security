package br.com.alura.mvc.mudi.model.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class AcessoDto {

    private String path;
    private LocalDateTime dataHora;
    private Duration duracao;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
}
