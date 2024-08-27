package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import objects.User;


public class UserController {
    private List<User> users = new ArrayList<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String directoryPath = ".\\files\\users_files";
    

    public void criarArquivo(){
        String json = gson.toJson(users);
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        File file = new File(directory, "users_file.json");
        if (file.exists()){
            atualizarArquivo();
        }else{
            try (FileWriter writer = new FileWriter(file)){
                writer.write(json);
            } catch (IOException e) {
                System.err.println("Erro ao salvar o arquivo Json: "+e.getMessage());
            }
        }
        
    }

    public void atualizarArquivo(){
        
    }

    public void lerArquivo(){

    }

    public void addUsuarioLista(User generico){
        users.add(generico);
        criarArquivo();
    }

    public void removeUsuarioLista(User generico){
        users.remove(generico);
        atualizarArquivo();
    }
}
