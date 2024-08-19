package screens;
import javax.swing.*;

public class BaseTela {

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
}
