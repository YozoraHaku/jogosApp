package screens.visualizacao_dados;

import objects.Jogo;
import objects.JogoSalvo;
import objects.User;
import screens.BaseTela;
import javax.swing.*;

import java.util.UUID;
import java.awt.*;
import java.awt.event.*;



public class TelaJogosSalvos extends BaseTela{
    private JPanel painelMostrarPaineis;
    private JButton botaoVoltar;


    public TelaJogosSalvos(User generico){
        super(null, 800, 800);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        String[] opcaoFinalizadoNaoFinalizado = {"Finalizado", "Não Finalizado"};


        // lista de painéis
        painelMostrarPaineis = new JPanel(new GridBagLayout());
        painelMostrarPaineis.setBackground(Color.DARK_GRAY);
        GridBagConstraints pConstraints = new GridBagConstraints();
        pConstraints.fill = GridBagConstraints.HORIZONTAL;
        pConstraints.weightx = 1.0;
        pConstraints.insets = new Insets(5, 5, 5, 5);
        pConstraints.gridx = GridBagConstraints.CENTER;

        // for para adicionar os paineis
        for (JogoSalvo jogoSalvo : generico.getListaJogos()) {
            JPanel painelDetalhes = new JPanel();
            painelDetalhes.setBackground(Color.LIGHT_GRAY);
            painelDetalhes.setLayout(new GridLayout(1, 4));

            // nome do jogo (valor fixo)
            JLabel nmNomeJogo = new JLabel(getNomeJogoOrigem(jogoSalvo.getJogoSalvoId()));

            // combo box selecionar jogado ou não jogado
            JComboBox comboBoxFinalizado = new JComboBox<String>(opcaoFinalizadoNaoFinalizado);
            comboBoxFinalizado.setSelectedItem(getStatusJogo(jogoSalvo));
            comboBoxFinalizado.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (!comboBoxFinalizado.getSelectedItem().equals(getStatusJogo(jogoSalvo))) {
                        jogoSalvo.setFinalizado();
                        getObjectController().editUsuarioLista(generico);
                        salvarArquivo(getObjectController());
                    }
                }
            });

            // alterar tempo jogado e confirmar com tecla enter (isso vai ativar pra todos que forem editados)
            JLabel nmTempoJogado = new JLabel("Tempo Jogado(h): ");
            JTextField campoTempoJogado = new JTextField(String.valueOf(jogoSalvo.getTempoJogado()));
            campoTempoJogado.setSize(90, 90);
            campoTempoJogado.addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent evt){
                    try {
                        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
                            if (!String.valueOf(jogoSalvo.getTempoJogado()).equals(campoTempoJogado.getText())) {
                                jogoSalvo.setTempoJogado(Integer.valueOf(campoTempoJogado.getText()));
                                getObjectController().editUsuarioLista(generico);
                                salvarArquivo(getObjectController());
                            }
                            
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(tela, "Valor inválido. Campo 'Tempo Jogado' deve ser preenchido somente por números.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // botão remover da lista
            JButton botaoRemover = new JButton("Remover");
            botaoRemover.setBackground(Color.RED);
            botaoRemover.addActionListener(e -> {
                generico.removeJogo(jogoSalvo.getJogoSalvoId());
                getObjectController().editUsuarioLista(generico);
                salvarArquivo(getObjectController());
                painelMostrarPaineis.remove(painelDetalhes);
                painelMostrarPaineis.revalidate();
                painelMostrarPaineis.repaint();
            });

            // adicionando elementos no painel (nome do jogo/status/tempo jogado/botão remover)
            painelDetalhes.add(nmNomeJogo);
            painelDetalhes.add(comboBoxFinalizado);
            painelDetalhes.add(nmTempoJogado);
            painelDetalhes.add(campoTempoJogado);
            painelDetalhes.add(botaoRemover);

            // salvando painel
            painelMostrarPaineis.add(painelDetalhes, pConstraints);
        }
        

        // Botão voltar
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(e -> {
            TelaInicial telaInicial = new TelaInicial(generico);
            telaInicial.iniciar();
            tela.dispose();
        });

        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 150;
        c.ipady = 600;
        c.gridx = 0;
        c.gridy = 0;
        tela.add(painelMostrarPaineis, c);

        c.ipadx = 25;
        c.ipady = 15;
        c.gridy = 1;
        tela.add(botaoVoltar, c);

    }

    private String getNomeJogoOrigem(UUID jogoSalvoID){
        for (Jogo j : getObjectController().getListaJogos()) {
            if (jogoSalvoID.equals(j.getId())) {
                return j.getNome();
            }
        }
        return null;
    }

    private String getStatusJogo(JogoSalvo jogoSalvo){
        if (jogoSalvo.isFinalizado()) {
            return "Finalizado";
        } else {
            return "Não Finalizado";
        }
    }
    
}
