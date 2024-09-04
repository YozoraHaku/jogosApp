package screens.cadastramentos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;

import objects.User;
import screens.BaseTela;
import screens.visualizacao_dados.TelaInicial;

public class TelaCadastrarJogo extends BaseTela{
    private JLabel nmNomeJogo;
    private JTextField fillNomeJogo;
    private JLabel nmDataLancamento;
    private JFormattedTextField fillDataLancamento;
    private JLabel nmTamanhoJogo;
    private JTextField fillTamanhoJogo;
    private JLabel nmDesenvolvedor;
    private JTextField fillDesenvolvedor;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JPanel painelBotoes;

    
    public TelaCadastrarJogo(TelaInicial telaInicial){
        super("Cadastrar Jogo", 600, 800);
        telaInicial.setManipulavel();
        tela.setResizable(false);
        tela.setDefaultCloseOperation(0);
        //sessão nome do jogo *************************************************************************************************************************
        nmNomeJogo = new JLabel("Título: ");
        fillNomeJogo = new JTextField();

        // sessão data de lançamento ****************************************************************************************************************
        nmDataLancamento = new JLabel("Data de lançamento(dd/mm/yy): ");
        try {
            fillDataLancamento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fillDataLancamento.setValue(null);
        fillDataLancamento.setColumns(6);
        
        // sessão tamanho do jogo (hrs) *************************************************************************************************************
        nmTamanhoJogo = new JLabel("Tempo médio de jogo: ");//pensar num nome melhor!!!
        fillTamanhoJogo = new JTextField();

        // sessão desenvolvedor(a) *****************************************************************************************************************
        nmDesenvolvedor = new JLabel("Desenvolvedor(a): ");
        fillDesenvolvedor = new JTextField();

        // painel botões ***************************************************************************************************************************
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            telaInicial.setManipulavel();
            tela.dispose();
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> {
            telaInicial.setManipulavel();
            tela.dispose();
        });
        painelBotoes.add(btnConfirmar);
        painelBotoes.add(btnCancelar);



        // montando o grid *************************************************************************************************************************
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.gridwidth = 1;


        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 25;
        c.ipady = 10;
        tela.add(nmNomeJogo, c);
        
        c.gridx = 1;
        c.ipadx = 400;
        tela.add(fillNomeJogo, c);

        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 25;
        tela.add(nmDesenvolvedor, c);

        c.gridx = 1;
        c.ipadx = 400;
        tela.add(fillDesenvolvedor);

        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 25;
        tela.add(nmDataLancamento, c);

        c.gridx = 1;
        c.ipadx = 0;
        tela.add(fillDataLancamento, c);

        c.gridx = 1;
        c.gridy = 5;
        c.ipadx = 200;
        c.ipady = 25;
        tela.add(painelBotoes, c);

    }
}
