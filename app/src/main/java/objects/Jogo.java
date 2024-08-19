package objects;
import java.time.*;
import java.util.*;

public class Jogo {
    private UUID id;
    private String nome;
    private boolean finalizado;
    private LocalTime tempoDeJogo;
    private LocalTime tamanhoJogo;
    private LocalDate dataLancamento;
    private int avaliacao;
    
    public Jogo(String nome, LocalDate dataLancamento, LocalTime tamanhoJogo){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.tamanhoJogo = tamanhoJogo;
        this.dataLancamento = dataLancamento;
    }

    // Avaliação ****************************************************************************************************************
    public int getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    // Nome ********************************************************************************************************************
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Data de lançamento ******************************************************************************************************
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    // Tamanho do jogo (Hrs) ****************************************************************************************************
    public LocalTime getTamanhoJogo() {
        return tamanhoJogo;
    }
    public void setTamanhoJogo(LocalTime tamanhoJogo) {
        this.tamanhoJogo = tamanhoJogo;
    }

    // Tempo de jogo (Hrs) *******************************************************************************************************
    public LocalTime getTempoDeJogo() {
        return tempoDeJogo;
    }
    public void setTempoDeJogo(LocalTime tempoDeJogo) {
        this.tempoDeJogo = tempoDeJogo;
    }

    // Finalizado (sim ou não)
    public boolean isFinalizado(){
        return finalizado;
    }
    public void setFinalizado(){
        this.finalizado = !finalizado;
    }

    // ID
    public UUID getId() {
        return id;
    }

}
