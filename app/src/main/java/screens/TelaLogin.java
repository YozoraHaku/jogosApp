package screens;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends BaseTela{
    private JButton btnLogin;

    private JTextField campoEmail;
    private JLabel nmEmail;

    private JPasswordField campoSenha;
    private JLabel nmSenha;

    public TelaLogin(){
        super("login", 200, 600);
        btnLogin = new JButton("Login");

        campoEmail = new JTextField();
        nmEmail = new JLabel("Email: ");
        
        campoSenha = new JPasswordField();
        nmSenha = new JLabel("Senha: ");

        // criando um grid e dimensionando
        tela.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Texto do email
        c.ipadx = 0;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 0;
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

        // Botão de login
        c.ipadx = 25;
        c.ipady = 10;
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 3;
        
        tela.add(btnLogin, c);


    }

}
