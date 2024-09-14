package screens.cadastramentos;

import java.text.ParseException;
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;


import objects.Jogo;
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

    
    public TelaCadastrarJogo(TelaInicial telaInicial, User generico) {
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
        fillDataLancamento.setHorizontalAlignment(fillDataLancamento.CENTER);
        
        // sessão tamanho do jogo (hrs) *************************************************************************************************************
        nmTamanhoJogo = new JLabel("Tempo médio de jogo: ");//pensar num nome melhor!!!
        fillTamanhoJogo = new JTextField();
        fillTamanhoJogo.setHorizontalAlignment(fillTamanhoJogo.CENTER);

        // sessão desenvolvedor(a) *****************************************************************************************************************
        nmDesenvolvedor = new JLabel("Desenvolvedor(a): ");
        fillDesenvolvedor = new JTextField();

        // painel botões ***************************************************************************************************************************
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            if (fillNomeJogo.getText().isBlank()||fillDesenvolvedor.getText().isBlank()||fillDataLancamento.getText().isBlank()||fillTamanhoJogo.getText().isBlank()) {
                JOptionPane.showMessageDialog(tela, "Formulário não preenchido", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    getObjectController().addJogoLista(new Jogo(fillNomeJogo.getText(), fillDataLancamento.getText(), Integer.parseInt(fillTamanhoJogo.getText()), fillDesenvolvedor.getText(), generico.getEmail()));
                    salvarArquivo(getObjectController());
                    telaInicial.setManipulavel();
                    telaInicial.updateList();
                    tela.dispose();
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(tela, "Valor inválido. Campo 'Tempo médio de jogo' deve ser preenchido somente por números.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
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

        // nome do jogo
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        tela.add(nmNomeJogo, c);

        c.gridx = 1;
        c.ipadx = 300;
        tela.add(fillNomeJogo, c);

        // desenvolvedor
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 1;
        tela.add(nmDesenvolvedor, c);

        c.gridx = 1;
        c.ipadx = 300;
        tela.add(fillDesenvolvedor, c);

        // tamanho do jogo
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 2;
        tela.add(nmTamanhoJogo, c);

        c.gridx = 1;
        c.ipadx = 50;
        tela.add(fillTamanhoJogo, c);

        // data lançamento
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 3;
        tela.add(nmDataLancamento, c);

        c.gridx = 1;
        c.ipadx = 15;
        tela.add(fillDataLancamento, c);

        // Painel botoes
        c.ipadx = 100;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 4;
        tela.add(painelBotoes, c);

    }
    
}
