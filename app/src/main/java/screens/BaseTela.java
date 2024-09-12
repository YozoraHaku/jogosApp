package screens;
import javax.swing.*;

import controllers.UsersJogosController;
import serializers.ObjectSerializer;


// ver como colocar para extender o JFrame e transformar o serializer em um atributo!!!!!!!!!!
public class BaseTela extends ObjectSerializer{

    protected JFrame tela;
    private UsersJogosController objectController;

    public BaseTela(String titulo, int h, int w){
        objectController = lerArquivo();
        tela = new JFrame();
        tela.setTitle(titulo);
        tela.setSize(w, h);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public void iniciar(){
        tela.setVisible(true);
    }
    public boolean isManipulavel(){
        return tela.isEnabled();
    }
    public void setManipulavel(){
        tela.setEnabled(!isManipulavel());
    }
    public UsersJogosController getObjectController() {
        return objectController;
    }
}
