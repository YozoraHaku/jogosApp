package screens;
import javax.swing.*;

import controllers.UsersJogosController;
import serializers.ObjectSerializer;


// Esse bagulo de estender o controlador vai dar uma merda se for dois, então melhor transformar em um só ------>(!!!Transformei em um só, só falta editar o objectSerializer!!!)<------
public class BaseTela extends ObjectSerializer{

    protected JFrame tela;
    private UsersJogosController objectController;

    public BaseTela(String titulo, int h, int w){
        objectController = lerArquivo();
        tela = new JFrame();
        // tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setTitle(titulo);
        tela.setSize(w, h);
        tela.setLocationRelativeTo(null);
        
        
    }
    public void iniciar(){
        tela.setVisible(true);
    }

    public void dispose(){
        tela.setVisible(false);
    }

    public UsersJogosController getObjectController() {
        return objectController;
    }
}
