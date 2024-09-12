package screens.cadastramentos;

import java.text.ParseException;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import objects.Jogo;
import screens.BaseTela;
import screens.visualizacao_dados.TelaDetalhesJogo;

public class TelaEditarJogo extends BaseTela{
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


    public TelaEditarJogo(TelaDetalhesJogo telaDetalhesJogo, Jogo jogo){
        super("Cadastrar Jogo", 600, 800);
        telaDetalhesJogo.setManipulavel();
        tela.setResizable(false);
        tela.setDefaultCloseOperation(0);
        //sessão nome do jogo *************************************************************************************************************************
        nmNomeJogo = new JLabel("Título: ");
        fillNomeJogo = new JTextField(jogo.getNome());

        // sessão data de lançamento ****************************************************************************************************************
        nmDataLancamento = new JLabel("Data de lançamento(dd/mm/yy): ");
        try {
            fillDataLancamento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fillDataLancamento.setValue(null);
        fillDataLancamento.setColumns(6);
        fillDataLancamento.setHorizontalAlignment(fillDataLancamento.CENTER);
        fillDataLancamento.setText(jogo.getDataLancamento());
        
        // sessão tamanho do jogo (hrs) *************************************************************************************************************
        nmTamanhoJogo = new JLabel("Tempo médio de jogo: ");//pensar num nome melhor!!!
        fillTamanhoJogo = new JTextField(String.valueOf(jogo.getTamanhoJogo()));
        fillTamanhoJogo.setHorizontalAlignment(fillTamanhoJogo.CENTER);

        // sessão desenvolvedor(a) *****************************************************************************************************************
        nmDesenvolvedor = new JLabel("Desenvolvedor(a): ");
        fillDesenvolvedor = new JTextField(jogo.getDesenvolvedor());

        // painel botões ***************************************************************************************************************************
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            if (fillNomeJogo.getText().isBlank()||fillDesenvolvedor.getText().isBlank()||fillDataLancamento.getText().isBlank()||fillTamanhoJogo.getText().isBlank()) {
                JOptionPane.showMessageDialog(tela, "Formulário não preenchido", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                jogo.setNome(fillNomeJogo.getText());
                jogo.setDesenvolvedor(fillDesenvolvedor.getText());
                jogo.setTamanhoJogo(Integer.valueOf(fillTamanhoJogo.getText()));
                jogo.setDataLancamento(fillDataLancamento.getText());
                getObjectController().editJogoLista(jogo);
                salvarArquivo(getObjectController());
                telaDetalhesJogo.setManipulavel();
                tela.dispose();
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> {
            telaDetalhesJogo.setManipulavel();
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
