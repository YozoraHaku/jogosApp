package objects;
import java.util.UUID;

public class JogoSalvo {
    private UUID jogoID;
    private boolean finalizado; //transferir para um objeto filho
    private int tempoJogado; //transferir para um objeto filho
    public JogoSalvo(UUID jogoID){
        this.jogoID = jogoID;
        finalizado = false;
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

    // Id do jogo para manipular 
    public UUID getJogoSalvoId(){
        return jogoID;
    }

    
}
