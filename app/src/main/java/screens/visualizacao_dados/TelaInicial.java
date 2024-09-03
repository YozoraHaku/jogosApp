package screens.visualizacao_dados;

import java.awt.*;
import javax.swing.*;

import objects.Jogo;
import objects.User;
import screens.BaseTela;
import screens.cadastramento.TelaCadastrarJogo;

public class TelaInicial extends BaseTela{
    private JScrollPane mostrarJogosPanel;
    private JList listaJogos;
    private JButton btnCadJogo;
    public TelaInicial(User generico){  //Lembrar de sempre voltar para essa tela com o usuario
        super("Main", 800, 800);

        // ******************************************* Botão para cadastrar um jogo novo *****************************************************
        btnCadJogo = new JButton("Cadastrar novo jogo");
        btnCadJogo.addActionListener(e -> {
            TelaCadastrarJogo abrirCadastroJogo = new TelaCadastrarJogo();
            abrirCadastroJogo.iniciar();

        });

        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        listaJogos = new JList<>(new DefaultListModel<>());
        DefaultListModel<Jogo> elementosLista = (DefaultListModel<Jogo>) listaJogos.getModel();
        for (Jogo jogo : getObjectController().getListaJogos()){
            elementosLista.addElement(jogo);
        }
        mostrarJogosPanel = new JScrollPane(listaJogos);

        
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridwidth = 1;
        c.gridheight = 1;
        // !!!Colocar a barra lateral aqui no inicio para configurar melhor o grid!!!

        c.ipadx = 400;
        c.ipady = 600;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 8;
        tela.add(mostrarJogosPanel, c);

        c.ipady = 10;
        c.ipadx = 20;
        c.gridy = 9;
        tela.add(btnCadJogo, c);
        
    }
}
