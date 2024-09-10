package objects;
import java.util.*;


public class Jogo {
    private UUID id; //ok
    private String nome; //ok
    private int tamanhoJogo; //ok
    private String dataLancamento; //ok
    private String desenvolvedor; //ok
    private String creatorEmail; //ok
    
    public Jogo(String nome, String dataLancamento, int tamanhoJogo, String desenvolvedor, String creatorEmail){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.tamanhoJogo = tamanhoJogo;
        this.dataLancamento = dataLancamento;
        this.desenvolvedor = desenvolvedor;
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

    // Email da pessoa que pode manipular ***************************************************************************************************
    public String getCreatorEmail() {
        return creatorEmail;
    }
    public void setCreatorID(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    

    //*******************************************************************************************************************************
    @Override
    public String toString(){
        return nome+"                "+dataLancamento;
    }

}
