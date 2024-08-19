package objects;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nome;
    private String email;
    private String senha;
    // private List<Jogo> listaJogos;

    // Adicionar Polimorfismo (usar @Override e relacionados)

    public User(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        // listaJogos = new ArrayList<>();
    }

    // ********* NOME ******************************************
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // ********* EMAIL *****************************************
    public String getEmail() {
        return email;
    }

    // ******** SENHA ******************************************
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // ********* MANIPULAR LISTA JGS (UserAdmi) ****************************
    public void addJogo(){

    }
    public void removeJogo(){

    }


}
