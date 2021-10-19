package app.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {

    private JButton _buttonLoginUser, _buttonLoginAdmin ,_signUp,_contBancar;
    private JPanel _loginPanel;
    private JLabel _userLabel, _passUserLabel;
    private JTextField _getUsername;
    private JPasswordField _getPasswordUsername;
    private ImageIcon _image ;
    private  JLabel _imglb;
    private JFrame _frame ;

    public LoginForm(){

        _loginPanel = new JPanel();
        _loginPanel.setLayout(null);
        _loginPanel.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/bet1.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(520,100,375,178);
        _loginPanel.add(_imglb);


        _userLabel = new JLabel("Username");
        _userLabel.setBounds(600,300,70,20);
        _userLabel.setForeground(Color.RED);
        _loginPanel.add(_userLabel);

        _getUsername = new JTextField(15);
        _getUsername.setBounds(600,319,200,30);
        _loginPanel.add(_getUsername);

        _passUserLabel = new JLabel("Password");
        _passUserLabel.setBounds(600,347,70,20);
        _passUserLabel.setForeground(Color.RED);
        _loginPanel.add(_passUserLabel);

        _getPasswordUsername = new JPasswordField(15);
         _getPasswordUsername.setBounds(600,367,200,30);
        _loginPanel.add(_getPasswordUsername);

        _buttonLoginUser = new JButton("Login");
        _buttonLoginUser.setBounds(600,402,90,25);
        _buttonLoginUser.setForeground(Color.WHITE);
        _buttonLoginUser.setBackground(Color.RED);
        _buttonLoginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
            }
        });
        _loginPanel.add(_buttonLoginUser);


        _buttonLoginAdmin = new JButton("Admin Login");
        _buttonLoginAdmin.setBounds(900,500,150,25);
        _buttonLoginAdmin.setForeground(Color.WHITE);
        _buttonLoginAdmin.setBackground(Color.BLUE);
        _buttonLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 LoginAdminForm f = new LoginAdminForm();
                _frame.dispose();
            }
        });
        _loginPanel.add(_buttonLoginAdmin);


        _signUp =  new JButton("Sign UP");
        _signUp.setBounds(700,500,150,25);
        _signUp.setForeground(Color.WHITE);
        _signUp.setBackground(Color.ORANGE);
        _signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        _loginPanel.add(_signUp);


        _contBancar = new JButton("Cont Bancar");
        _contBancar.setBounds(500,500,150,25);
        _contBancar.setForeground(Color.WHITE);
        _contBancar.setBackground(Color.GREEN);
        _contBancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Cont Banacar");
            }
        });
        _loginPanel.add(_contBancar);


        _frame = new JFrame("Bet");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_loginPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);

    }


    public static void main(String[] args) {

        LoginForm form = new LoginForm();
    }

}


