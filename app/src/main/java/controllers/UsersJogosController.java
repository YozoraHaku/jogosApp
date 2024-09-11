package controllers;

import java.io.*;
import objects.Jogo;
import objects.User;

import java.util.*;

//Controlador finalizado!!!!!!!!!!
public class UsersJogosController implements Serializable{
    private ArrayList<Jogo> listaJogos = new ArrayList<>();
    private ArrayList<User> listaUsers = new ArrayList<>();

    // MANIPULAR LISTA JOGOS **************************************************************************************************
    public void addJogoLista(Jogo jogo){
        listaJogos.add(jogo);
    }
    public void removeJogoLista(UUID idGenerico){
        for (int index = 0; index < listaJogos.size(); index++) {
            if (listaJogos.get(index).getId().equals(idGenerico)) {
                listaJogos.remove(listaJogos.get(index));
                continue;
            }
        }
    }
    public ArrayList<Jogo> getListaJogos() {
        return listaJogos;
    }

    // MANIPULAR LISTA USUARIOS **********************************************************************************************
    public void addUsuarioLista(User usuario){
        listaUsers.add(usuario);
    }
    public void removeUsuarioLista(String email){
        for (int index = 0; index < listaUsers.size(); index++) {
            if (listaUsers.get(index).getEmail().equals(email)) {
                listaUsers.remove(listaUsers.get(index));
                continue;
            }
        }
    }
    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

}
