package screens;

import javax.swing.*;

public class TelaLogin extends BaseTela{
    private JButton btnLogin;

    private JTextField campoEmail;
    private JLabel nmEmail;

    private JPasswordField campoSenha;
    private JLabel nmSenha;

    public TelaLogin(){
        super("login", 800, 800);
        btnLogin = new JButton("Login");

    }

}
