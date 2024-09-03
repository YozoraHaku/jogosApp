package screens.cadastramento;
import javax.swing.*;

import objects.User;
import screens.BaseTela;
import screens.visualizacao_dados.TelaInicial;

import java.awt.*;

public class TelaLogin extends BaseTela{
    private JButton btnLogin;
    private JButton btnCadastro;
    private JPanel painelBotoes;

    private JTextField campoEmail;
    private JLabel nmEmail;

    private JPasswordField campoSenha;
    private JLabel nmSenha;

    public TelaLogin(){
        super("login", 200, 600);
        tela.setResizable(false);

        // Area email
        campoEmail = new JTextField();
        nmEmail = new JLabel("Email: ");
        
        // Area Senha
        campoSenha = new JPasswordField();
        nmSenha = new JLabel("Senha: ");

        // Inicializando o painel de botoes
        painelBotoes = new JPanel();

        // Ações botão de login
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            for (User user : getObjectController().getListaUsers()) {
                if (user.getEmail().equals(campoEmail.getText()) && user.getSenha().equals(String.valueOf(campoSenha.getPassword()))) {
                    TelaInicial telaPrincipal = new TelaInicial(user);
                    telaPrincipal.iniciar();
                    dispose();
                    continue;
                } 
                // else {
                //     // !!!Adicionar excessão para email ou senha incorretos!!!
                // }

            }
        });

        // Ações botão de cadastro
        btnCadastro = new JButton("Cadastrar-se");
        btnCadastro.addActionListener(e -> {
            TelaCadastroUsuario cadastrando = new TelaCadastroUsuario();
            cadastrando.iniciar();
            dispose();
        });

        // criando um grid e dimensionando
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Texto do email
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        tela.add(nmEmail, c);

        // Caixa de texto do email
        c.ipadx = 500;
        c.ipady = 15;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 0;
        tela.add(campoEmail, c);

        // Texto senha
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 2;
        tela.add(nmSenha, c);
        
        // Caixa de texto de senha
        c.ipadx = 500;
        c.ipady = 15;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 2;
        tela.add(campoSenha, c);

        // Painel Login/Cadastro
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(btnLogin);
        painelBotoes.add(btnCadastro);
        c.ipadx = 25;
        c.ipady = 10;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 3;
        tela.add(painelBotoes, c);
        


    }

}
