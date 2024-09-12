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
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // ******************************************** LISTA DE JOGOS ***********************************************************************
        listaJogos = new JList<>();
        listaJogos.addListSelectionListener(e -> {
            TelaDetalhesJogo abrirDetalhesJogo = new TelaDetalhesJogo(generico, listaJogos.getSelectedValue());
            abrirDetalhesJogo.iniciar();
            tela.dispose();
        });
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

        // editar perfil
        JMenuItem editarPerfil = new JMenuItem("Editar perfil");
        editarPerfil.addActionListener(e -> {
            TelaEditarUsuario editarUsuario = new TelaEditarUsuario(generico, this);
            editarUsuario.iniciar();
            
        });

        //excluir perfil 
        JMenuItem excluirPerfil = new JMenuItem("Excluir perfil");
        excluirPerfil.setBackground(Color.RED);
        excluirPerfil.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(excluirPerfil, "Tem certeza que quer excluir o perfil?", null, JOptionPane.OK_CANCEL_OPTION);
            if (a==0) {
                JOptionPane.showMessageDialog(tela, "Perfil excluído.", null, JOptionPane.INFORMATION_MESSAGE);
                tela.dispose();
                getObjectController().removeUsuarioLista(generico.getEmail());
                salvarArquivo(getObjectController());
                TelaLogin abrir = new TelaLogin();
                abrir.iniciar();
                
            }
        });
        configuracoes.add(editarPerfil);
        configuracoes.add(excluirPerfil);

        //jogos salvos
        JMenuItem meusJogos = new JMenuItem("Meus Jogos");
        meusJogos.addActionListener(e -> {
            TelaJogosSalvos abrirMeusJogos = new TelaJogosSalvos(generico, this);
            abrirMeusJogos.iniciar();
            tela.dispose();
        });

        // retornar ao login
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
        c.gridy = 4;
        tela.add(listaJogos, c);

        c.ipady = 10;
        c.ipadx = 20;
        c.gridy = 5;
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
