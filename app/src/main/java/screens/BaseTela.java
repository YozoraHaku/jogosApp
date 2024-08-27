package screens;
import javax.swing.*;

import controllers.UserController;

// Esse bagulo de estender o controlador vai dar uma merda se for dois, então melhor transformar em um só
public class BaseTela extends UserController{

    protected JFrame tela;

    public BaseTela(String titulo, int h, int w){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
