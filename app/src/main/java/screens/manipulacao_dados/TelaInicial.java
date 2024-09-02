package screens.manipulacao_dados;

import javax.swing.*;

import objects.Jogo;
import objects.User;
import screens.BaseTela;

public class TelaInicial extends BaseTela{
    private JScrollPane mostrarJogosPanel;
    private JList listaJogos;
    public TelaInicial(User generico){//Colocar pra iniciar somente com User generico
        super("main", 800, 800);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        listaJogos = new JList<>(new DefaultListModel<>());
        DefaultListModel<Jogo> elementosLista = (DefaultListModel<Jogo>) listaJogos.getModel();
        for (Jogo jogo : generico.getListaJogos()){
            elementosLista.addElement(jogo);
        }
        mostrarJogosPanel = new JScrollPane(listaJogos);
        tela.add(mostrarJogosPanel);
        
    }
}
