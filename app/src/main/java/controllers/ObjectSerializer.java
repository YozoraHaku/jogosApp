package controllers;

import java.io.*;

import com.google.gson.*;



public class ObjectSerializer{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    

    public void salvarArquivo(UsersJogosController dadosApp){
        String json = gson.toJson(dadosApp);
        try (FileWriter writer = new FileWriter("dados.json")){
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo Json: "+e.getMessage());
        }
         
    }

    

    public UsersJogosController lerArquivo(){
        try(FileInputStream fis = new FileInputStream("dados.json");
            ObjectInputStream in = new ObjectInputStream(fis);) {


            UsersJogosController lida = (UsersJogosController) in.readObject();
            return lida;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            salvarArquivo(new UsersJogosController());
            return lerArquivo();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    

}
