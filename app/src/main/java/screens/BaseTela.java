package screens;
import javax.swing.*;

public class BaseTela {
    private JFrame tela;
    private String titulo;
    private int h;
    private int w;
    public BaseTela(String titulo){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setTitle(titulo);
        
    }
}
