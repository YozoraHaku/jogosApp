package screens.visualizacao_dados;

import objects.Jogo;
import objects.User;
import screens.BaseTela;
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

    
    public TelaDetalhesJogo(User generico, Jogo jogo, TelaInicial telaInicial){
        super(jogo.getNome(), 800, 800);
        tela.setExtendedState(tela.MAXIMIZED_BOTH);
        UIManager.put("Label.font", new Font("Arial", Font.CENTER_BASELINE, 25));

        // *************************************** PAINEL DE INFORMAÇÕES ***************************************************************
        mostrarNome = new JLabel(jogo.getNome());
        mostrarDesenvolvedor = new JLabel("Desenvolvedor(a): "+jogo.getDesenvolvedor());
        mostrarTamanhoJogo = new JLabel("Tempo total do jogo: "+ Integer.toString(jogo.getTamanhoJogo()));
        mostrarDataLancamento = new JLabel(jogo.getDataLancamento());
        mostrarCreatorEmail = new JLabel("Adicionado por: "+jogo.getCreatorEmail());

        painelInformaçoes = new JPanel();
        painelInformaçoes.setLayout(new BoxLayout(painelInformaçoes, BoxLayout.PAGE_AXIS));
        painelInformaçoes.setBorder(BorderFactory.createLineBorder(Color.darkGray));

        painelInformaçoes.add(mostrarNome);
        painelInformaçoes.add(mostrarDesenvolvedor);
        painelInformaçoes.add(mostrarTamanhoJogo);
        painelInformaçoes.add(mostrarDataLancamento);
        painelInformaçoes.add(mostrarCreatorEmail);


        // ************************************ PAINEL BOTÕES ADD REMOVE EDIT ********************************************************
        botaoAddMinhaLista = new JButton("Adicionar à lista");
        botaoAddMinhaLista.addActionListener(e -> {

        });
        botaoEditarJogo = new JButton("Editar");
        botaoEditarJogo.addActionListener(e -> {

        });

        botaoRemoverJogo = new JButton("Remover");
        botaoRemoverJogo.setBackground(Color.RED);
        botaoRemoverJogo.addActionListener(e -> {

        });

        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(botaoAddMinhaLista);

        // *************************************************** BOTÃO VOLTAR *********************************************************************

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setAlignmentX(JFrame.LEFT_ALIGNMENT);
        botaoVoltar.setSize(25, 15);
        botaoVoltar.addActionListener(e -> {
            telaInicial.iniciar();
            tela.dispose();
        });
        tela.add(botaoVoltar, JFrame.TOP_ALIGNMENT);

        // *************************************************** montando o grid ******************************************************************
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 400;
        c.ipadx = 400;
        tela.add(painelInformaçoes);

        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 15;
        c.ipadx = 40;
        if (jogo.getCreatorEmail().equals(generico.getEmail())) {
            painelBotoes.add(botaoEditarJogo);
            painelBotoes.add(botaoRemoverJogo);
            c.ipadx = 100;
        }
        tela.add(painelBotoes);

    }
}
