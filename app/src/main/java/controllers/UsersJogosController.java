package controllers;

import java.io.*;
import objects.Jogo;
import objects.User;

import java.util.*;

//Controlador não finalizado drogaaaaaaaa!!!!!!!!!!
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
    public void editJogoLista(Jogo jogo){
        for (int i = 0; i < listaUsers.size(); i++) {
            if (jogo.getId().equals(listaJogos.get(i).getId())) {
                listaJogos.set(i, jogo);
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
    public void editUsuarioLista(User generico){
        for (int i = 0; i < listaUsers.size(); i++) {
            if (generico.getEmail().equals(listaUsers.get(i).getEmail())) {
                listaUsers.set(i, generico);
                continue;
            }
        }
    }
    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

}
