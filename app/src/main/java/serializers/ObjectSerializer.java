package serializers;

import java.io.*;

import com.google.gson.*;

import controllers.UsersJogosController;

// Serializador finalizado caralhoooooooooooooooooooooooooooo (!!!falta editar a excessão da linha 20!!!)

public class ObjectSerializer{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    

    public void salvarArquivo(UsersJogosController dadosApp){
        String json = gson.toJson(dadosApp);
        try (FileWriter writer = new FileWriter("dados.json")){
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo Json: "+e.getMessage()); //essa aqui pra editar!!!!!
        }
         
    }

    

    public UsersJogosController lerArquivo(){
        try(FileReader fis = new FileReader("dados.json")) {
            UsersJogosController lida = gson.fromJson(fis, UsersJogosController.class);
            return lida;
        } catch (FileNotFoundException e) {
            salvarArquivo(new UsersJogosController());
            return lerArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } 
    }
    

}
