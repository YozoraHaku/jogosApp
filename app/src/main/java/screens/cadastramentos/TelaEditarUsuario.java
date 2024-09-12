package screens.cadastramentos;

import objects.User;
import screens.BaseTela;
import screens.visualizacao_dados.TelaInicial;

import javax.swing.*;
import java.awt.*;

public class TelaEditarUsuario extends BaseTela{
    private JLabel nmNome;
    private JTextField fillNome;
    private JLabel nmSenha;
    private JLabel nmRepetirSenha;
    private JPasswordField fillSenha;
    private JPasswordField fillRepetirSenha;
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JPanel painelCadVol;

    public TelaEditarUsuario(User generico, TelaInicial telaInicial){
        super("register", 600, 600);
        tela.setDefaultCloseOperation(tela.DO_NOTHING_ON_CLOSE);
        telaInicial.setManipulavel();

        // Sessão Nome
        nmNome = new JLabel("Nome: ");
        fillNome = new JTextField(generico.getNome());

        // Sessão senha
        nmSenha = new JLabel("Senha nova: ");
        fillSenha = new JPasswordField();

        // Sessão repetir senha
        nmRepetirSenha = new JLabel("Repita a senha: ");
        fillRepetirSenha = new JPasswordField();

        // Botão editar
        btnCadastrar = new JButton("Editar");
        btnCadastrar.addActionListener(e -> {
            String senhaPreenchido = new String(fillSenha.getPassword()).trim();
            String repetirSenhaPreenchido = new String(fillRepetirSenha.getPassword()).trim();
            
            if (senhaPreenchido.isBlank()||fillNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(tela, "Formulário não preenchido", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                if(senhaPreenchido.equals(repetirSenhaPreenchido)){
                    generico.setNome(fillNome.getText());
                    generico.setSenha(senhaPreenchido);
                    getObjectController().editUsuarioLista(generico);
                    salvarArquivo(getObjectController());
                    telaInicial.setManipulavel();
                    tela.dispose();
                } else {
                    JOptionPane.showMessageDialog(tela, "As senhas não são iguais. Tente Novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        // Botão cancelar
        btnVoltar = new JButton("Cancelar");
        btnVoltar.addActionListener(e -> {
            telaInicial.setManipulavel();
            tela.dispose();
        });

        // Montando o layout
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Montando o painel de botões
        painelCadVol = new JPanel();
        painelCadVol.setLayout(new FlowLayout(FlowLayout.RIGHT));
        painelCadVol.add(btnCadastrar);
        painelCadVol.add(btnVoltar);

        // Titulo nome
        c.ipadx = 0;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        tela.add(nmNome, c);

        // Preencher nome
        c.gridx = GridBagConstraints.CENTER;
        c.ipadx = 400;
        c.ipady = 15;
        tela.add(fillNome, c);

        // Titulo senha
        c.ipadx = 0;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 1;
        tela.add(nmSenha, c);

        // Preencher senha
        c.gridx = GridBagConstraints.CENTER;
        c.ipadx = 400;
        c.ipady = 15;
        tela.add(fillSenha, c);

        // Titulo repetir senha
        c.ipadx = 0;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 2;
        tela.add(nmRepetirSenha, c);

        // Preencheer repetir senha
        c.gridx = GridBagConstraints.CENTER;
        c.ipadx = 400;
        c.ipady = 15;
        tela.add(fillRepetirSenha, c);

        // Painel de botões editar/cancelar
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 3;
        c.ipadx = 0;
        c.ipady = 0;
        tela.add(painelCadVol, c);
    }
}
