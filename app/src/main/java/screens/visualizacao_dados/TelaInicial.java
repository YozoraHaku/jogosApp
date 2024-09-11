package screens.visualizacao_dados;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import objects.Jogo;
import objects.User;
import screens.BaseTela;
import screens.cadastramentos.TelaCadastrarJogo;
import screens.cadastramentos.TelaEditarUsuario;
import screens.cadastramentos.TelaLogin;

public class TelaInicial extends BaseTela{
    private JList<Jogo> listaJogos;
    private JButton btnCadJogo;
    private JMenuBar barra;
    public TelaInicial(User generico){  //Lembrar de sempre voltar para essa tela com o usuario
        super("Main", 800, 800);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // ******************************************** LISTA DE JOGOS ***********************************************************************
        listaJogos = new JList<>();
        updateList();

        // ******************************************* Botão para cadastrar um jogo novo *****************************************************
        btnCadJogo = new JButton("Cadastrar novo jogo");
        btnCadJogo.addActionListener(e -> {
            TelaCadastrarJogo abrirCadastroJogo = new TelaCadastrarJogo(this, generico);
            abrirCadastroJogo.iniciar();

        });

        // *************************************************** BARRA LATERAL ****************************************************************
            barra = new JMenuBar();
            tela.setJMenuBar(barra);
            JMenu menu = new JMenu("Usuário");
            barra.add(menu);

            JMenu configuracoes = new JMenu("Configurações");
            JMenuItem editarPerfil = new JMenuItem("Editar perfil");
            editarPerfil.addActionListener(e -> {
                TelaEditarUsuario editarUsuario = new TelaEditarUsuario(generico);
                editarUsuario.iniciar();
                
            });
            JMenuItem excluirPerfil = new JMenuItem("Excluir perfil");
            excluirPerfil.addActionListener(e -> {

            });
            configuracoes.add(editarPerfil);
            configuracoes.add(excluirPerfil);

            JMenuItem meusJogos = new JMenuItem("Meus Jogos");
            meusJogos.addActionListener(e -> {

            });
            JMenuItem sair = new JMenuItem("Fazer log-out");
            sair.addActionListener(e -> {
                TelaLogin logout = new TelaLogin();
                logout.iniciar();
                tela.dispose();
            });
            
            menu.add(meusJogos);
            menu.add(configuracoes);
            menu.addSeparator();
            menu.add(sair);


        // ******************************************** MONTANDO O GRID *********************************************************************
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipadx = 400;
        c.ipady = 600;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 8;
        tela.add(listaJogos, c);

        c.ipady = 10;
        c.ipadx = 20;
        c.gridy = 9;
        tela.add(btnCadJogo, c);

        
    }
    public void updateList(){
        getObjectController().getListaJogos().sort(new Comparator<Jogo>() {
            @Override
            public int compare(Jogo o1, Jogo o2) {
                String nome1 = o1.getNome();
                String nome2 = o2.getNome();

                return nome1.compareTo(nome2);
            }
        });
        listaJogos.setListData(getObjectController().getListaJogos().toArray(new Jogo[0]));

    }
}
