package screens.cadastramentos;

import javax.swing.*;
import java.awt.*;
import objects.User;
import screens.BaseTela;


// Tela finalizada!!!!!!
public class TelaCadastroUsuario extends BaseTela{
    private JLabel nmNome;
    private JTextField fillNome;
    private JLabel nmEmail;
    private JLabel nmSenha;
    private JLabel nmRepetirSenha;
    private JTextField fillEmail;
    private JPasswordField fillSenha;
    private JPasswordField fillRepetirSenha;
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JPanel painelCadVol;
    
    public TelaCadastroUsuario(){
        super("register", 600, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sessão Nome
        nmNome = new JLabel("Nome: ");
        fillNome = new JTextField();

        // Sessão Email
        nmEmail = new JLabel("Email: ");
        fillEmail = new JTextField();

        // Sessão senha
        nmSenha = new JLabel("Senha: ");
        fillSenha = new JPasswordField();

        // Sessão repetir senha
        nmRepetirSenha = new JLabel("Repita a senha: ");
        fillRepetirSenha = new JPasswordField();

        // Botão cadastrar
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String senhaPreenchido = new String(fillSenha.getPassword()).trim();
            String repetirSenhaPreenchido = new String(fillRepetirSenha.getPassword()).trim();
            
            if (senhaPreenchido.isBlank()||fillNome.getText().isBlank()||fillEmail.getText().isBlank()) {
                JOptionPane.showMessageDialog(tela, "Formulário não preenchido", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                for (User u : getObjectController().getListaUsers()) {
                    if (fillEmail.getText().equals(u.getEmail())) {
                        JOptionPane.showMessageDialog(tela, "Email já existente", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                if(senhaPreenchido.equals(repetirSenhaPreenchido)){
                    User novoUsuario = new User(fillNome.getText(), fillEmail.getText(), senhaPreenchido);
                    getObjectController().addUsuarioLista(novoUsuario);
                    salvarArquivo(getObjectController());
                    TelaLogin a = new TelaLogin();
                    a.iniciar();
                    tela.dispose();
                } else {

                    JOptionPane.showMessageDialog(tela, "As senhas não são iguais. Tente Novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                
                }
                
            }
        });

        // Botão voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            TelaLogin a = new TelaLogin();
            a.iniciar();
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

        // Titulo email
        c.ipadx = 0;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 1;
        tela.add(nmEmail, c);

        // Preencher email
        c.gridx = GridBagConstraints.CENTER;
        c.ipadx = 400;
        c.ipady = 15;
        tela.add(fillEmail, c);

        // Titulo senha
        c.ipadx = 0;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 2;
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
        c.gridy = 3;
        tela.add(nmRepetirSenha, c);

        // Preencheer repetir senha
        c.gridx = GridBagConstraints.CENTER;
        c.ipadx = 400;
        c.ipady = 15;
        tela.add(fillRepetirSenha, c);

        // Painel de botões cadastro/voltar
        c.gridx = GridBagConstraints.CENTER;
        c.gridy = 4;
        c.ipadx = 0;
        c.ipady = 0;
        tela.add(painelCadVol, c);
        
    }

    
}
