package controllers;

import java.io.*;
import objects.Jogo;
import objects.User;

import java.util.*;

public class UsersJogosController implements Serializable{
    private ArrayList<Jogo> listaJogos = new ArrayList<>();
    private ArrayList<User> listaUsers = new ArrayList<>();

    // MANIPULAR LISTA JOGOS **************************************************************************************************
    public void addJogoLista(Jogo jogo){
        listaJogos.add(jogo);
    }
    public void removeJogoLista(UUID idGenerico){
        for (Jogo jogo : listaJogos) {
            if(jogo.getId()==idGenerico){
                listaJogos.remove(jogo);
                continue;
            }
        }
    }
    public List getListaJogos() {
        return listaJogos;
    }

    // MANIPULAR LISTA USUARIOS **********************************************************************************************
    public void addUsuarioLista(User usuario){
        listaUsers.add(usuario);
    }
    public void removeUsuarioLista(String email){
        for (User user : listaUsers) {
            if(user.getEmail()==email){
                listaUsers.remove(user);
                continue;
            }
        }
    }
    public List getListaUsers() {
        return listaUsers;
    }

}
