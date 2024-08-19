package objects;
import java.time.*;
import java.util.*;

public class Jogo {
    private UUID id; //ok
    private String nome; //ok
    private boolean finalizado; //ok
    private int tempoJogado; //ok
    private int tamanhoJogo; //ok
    private LocalDate dataLancamento; //ok
    private int avaliacao;//ok
    
    public Jogo(String nome, LocalDate dataLancamento, int tamanhoJogo){
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

    // Tamanho do jogo (int hrs) ****************************************************************************************************
    public int getTamanhoJogo() {
        return tamanhoJogo;
    }
    public void setTamanhoJogo(int tamanhoJogo) {
        this.tamanhoJogo = tamanhoJogo;
    }

    // Tempo jogado (int hrs) *******************************************************************************************************
    public int getTempoJogado() {
        return tempoJogado;
    }
    public void setTempoJogado(int tempoJogado) {
        this.tempoJogado = tempoJogado;
    }

    // Finalizado (sim ou não) *******************************************************************************************************
    public boolean isFinalizado(){
        return finalizado;
    }
    public void setFinalizado(){
        this.finalizado = !finalizado;
    }

    // ID ****************************************************************************************************************************
    public UUID getId() {
        return id;
    }

}
