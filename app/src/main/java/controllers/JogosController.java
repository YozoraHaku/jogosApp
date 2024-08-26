package serializers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import objects.Jogo;

public class JogosController {
    private List<Jogo> jogos = new ArrayList<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String directoryPath = "app\\files\\jogos_files";
    

    public void criarArquivo(){
        String json = gson.toJson(jogos);
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        File file = new File(directory, "games_file.json");

        try (FileWriter writer = new FileWriter(file)){
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo Json: "+e.getMessage());
        }
    }

    public void atualizarArquivo(Jogo generico){
        
    }

    public void lerArquivo(Jogo generico){

    }

    public void addJogoLista(Jogo generico){
        jogos.add(generico);
    }
    
    public void removeJogoLista(Jogo generico){
        jogos.remove(generico);
    }
}
