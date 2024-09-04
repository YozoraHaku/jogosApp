package objects;
import java.util.*;

public class Jogo {
    private UUID id; //ok
    private String nome; //ok
    private boolean finalizado; //ver como atribuir individualmente por usuario
    private int tempoJogado; //ver como atribuir individualmente por usuario
    private int tamanhoJogo; //ok
    private String dataLancamento; //ok
    private String desenvolvedor;
    
    public Jogo(String nome, String dataLancamento, int tamanhoJogo, String desenvolvedor){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.tamanhoJogo = tamanhoJogo;
        this.dataLancamento = dataLancamento;
        this.desenvolvedor = desenvolvedor;
        finalizado = false;
    }

    // Nome ********************************************************************************************************************
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Data de lançamento ******************************************************************************************************
    public String getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(String dataLancamento) {
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

    // Desenvolvedor(a) **************************************************************************************************************
    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }
    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    // ID ****************************************************************************************************************************
    public UUID getId() {
        return id;
    }

}
