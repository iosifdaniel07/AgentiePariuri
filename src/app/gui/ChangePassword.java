package app.gui;

import app.classes.account.AdminAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword {

    private JPanel _passwordPanel;
    private JFrame _frame;
    private JButton _submit, _cancel;
    private JLabel _newPasswordLabel, _ConfirmPasswordLabel;
    private JPasswordField _newPasswordField, _ConfirmPasswordField;
    private ImageIcon _image ;
    private  JLabel _imglb;

    public ChangePassword(){

        _passwordPanel = new JPanel();
        _passwordPanel.setLayout(null);
        _passwordPanel.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/key.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(620,100,237,219);
        _passwordPanel.add(_imglb);


        _newPasswordLabel = new JLabel("New Password");
        _newPasswordLabel.setBounds(600,400,150,20);
        _newPasswordLabel.setForeground(Color.RED);
        _passwordPanel.add(_newPasswordLabel);

        _newPasswordField = new JPasswordField();
        _newPasswordField.setBounds(600,420,150,20);
        _passwordPanel.add(_newPasswordField);

        _ConfirmPasswordLabel = new JLabel("Confirm Password");
        _ConfirmPasswordLabel.setBounds(600,450,150,20);
        _ConfirmPasswordLabel.setForeground(Color.RED);
        _passwordPanel.add(_ConfirmPasswordLabel);

        _ConfirmPasswordField = new JPasswordField();
        _ConfirmPasswordField.setBounds(600,470,150,20);
        _passwordPanel.add(_ConfirmPasswordField);

        _submit = new JButton("Submit");
        _submit.setBounds(550,520,100,25);
        _submit.setForeground(Color.WHITE);
        _submit.setBackground(Color.BLUE);
        _submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = _newPasswordField.getText();
                String p2 = _ConfirmPasswordField.getText();

                if(p1.equals(p2)){
                    AdminAgency a = AdminAgency.getInstance();
                    a.changePassword(p1);
                    JOptionPane.showMessageDialog(null,"Parola schimbata cu succes");
                }else{
                    JOptionPane.showMessageDialog(null,"Parolele nu corespund","Change Password",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        _passwordPanel.add(_submit);


        _cancel = new JButton("Cancel");
        _cancel.setBounds(700,520,100,25);
        _cancel.setForeground(Color.WHITE);
        _cancel.setBackground(Color.RED);
        _cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin a = new Admin();
                _frame.dispose();
            }
        });
        _passwordPanel.add(_cancel);

        _frame = new JFrame("Admin");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_passwordPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);


    }

    public static void main(String[] args) {
        ChangePassword p = new ChangePassword();
    }

}
