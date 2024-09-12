package screens.visualizacao_dados;

import objects.Jogo;
import objects.JogoSalvo;
import objects.User;
import screens.BaseTela;
import screens.cadastramentos.TelaEditarJogo;

import javax.swing.*;
import java.awt.*;

public class TelaDetalhesJogo extends BaseTela{
    private JPanel painelInformaçoes;
    private JLabel mostrarNome;
    private JLabel mostrarDesenvolvedor;
    private JLabel mostrarTamanhoJogo;
    private JLabel mostrarDataLancamento;
    private JLabel mostrarCreatorEmail;

    private JPanel painelBotoes;
    private JButton botaoAddMinhaLista;
    private JButton botaoEditarJogo;
    private JButton botaoRemoverJogo;

    private JButton botaoVoltar;

    
    public TelaDetalhesJogo(User generico, Jogo jogo){
        super(jogo.getNome(), 800, 800);
        tela.setExtendedState(tela.MAXIMIZED_BOTH);

        // *************************************** PAINEL DE INFORMAÇÕES ***************************************************************
        mostrarNome = new JLabel(jogo.getNome());
        mostrarDesenvolvedor = new JLabel("Desenvolvedor(a): "+jogo.getDesenvolvedor());
        mostrarTamanhoJogo = new JLabel("Tempo total do jogo: "+ Integer.toString(jogo.getTamanhoJogo())+"h");
        mostrarDataLancamento = new JLabel(jogo.getDataLancamento());
        mostrarCreatorEmail = new JLabel("Adicionado por: "+jogo.getCreatorEmail());

        painelInformaçoes = new JPanel();
        painelInformaçoes.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        painelInformaçoes.setLayout(new BoxLayout(painelInformaçoes, BoxLayout.Y_AXIS));

        painelInformaçoes.add(mostrarNome);
        painelInformaçoes.add(mostrarDesenvolvedor);
        painelInformaçoes.add(mostrarTamanhoJogo);
        painelInformaçoes.add(mostrarDataLancamento);
        painelInformaçoes.add(mostrarCreatorEmail);

        // *************************************************** BOTÃO VOLTAR *********************************************************************

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setSize(25, 15);
        botaoVoltar.addActionListener(e -> {
            TelaInicial telaInicial = new TelaInicial(generico);
            telaInicial.iniciar();
            tela.setVisible(false);
        });

        // ************************************ PAINEL BOTÕES ADD REMOVE EDIT ********************************************************
        botaoAddMinhaLista = new JButton("Adicionar à lista");
        botaoAddMinhaLista.addActionListener(e -> {
            for (JogoSalvo i : generico.getListaJogos()) {
                if (i.getJogoSalvoId().equals(jogo.getId())) {
                    JOptionPane.showConfirmDialog(tela, "Jogo já adicionado!", null, JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            JogoSalvo salvarJogo = new JogoSalvo(jogo.getId());
            generico.addJogo(salvarJogo);
            getObjectController().editUsuarioLista(generico);
            salvarArquivo(getObjectController());
        });
        botaoEditarJogo = new JButton("Editar");
        botaoEditarJogo.addActionListener(e -> {
            TelaEditarJogo telaEditarJogo = new TelaEditarJogo(this, jogo);
            telaEditarJogo.iniciar();
        });

        botaoRemoverJogo = new JButton("Remover");
        botaoRemoverJogo.setBackground(Color.RED);
        botaoRemoverJogo.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(tela, "Excluir jogo?", null, JOptionPane.YES_NO_OPTION);
            if (a==0) {
                for (User user : getObjectController().getListaUsers()) {
                    user.removeJogo(jogo.getId());
                }
                generico.removeJogo(jogo.getId());
                getObjectController().removeJogoLista(jogo.getId());
                salvarArquivo(getObjectController());
                TelaInicial telaInicial = new TelaInicial(generico);
                telaInicial.iniciar();
                tela.setVisible(false);
            }
        });

        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoAddMinhaLista);

        // *************************************************** montando o grid ******************************************************************
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 400;
        c.ipadx = 400;
        tela.add(painelInformaçoes, c);

        c.gridy = 1;
        c.ipady = 15;
        c.ipadx = 40;
        if (jogo.getCreatorEmail().equals(generico.getEmail())) {
            painelBotoes.add(botaoEditarJogo);
            painelBotoes.add(botaoRemoverJogo);
            c.ipadx = 100;
        }
        tela.add(painelBotoes, c);

        c.gridy = 2;
        c.ipady = 20;
        tela.add(botaoVoltar, c);

    }
}
