package app.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {

    private JPanel _adminPanel;
    private JFrame _frame;
    private JButton _person, _changePassword, _footbal, _tenis, _basket, _backToUser;
    private ImageIcon _image ;
    private  JLabel _imglb;

    public Admin(){

        _adminPanel = new JPanel();
        _adminPanel.setLayout(null);
        _adminPanel.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/bet1.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(520,100,375,178);
        _adminPanel.add(_imglb);


        _person = new JButton("Person");
        _person.setBounds(400,500,150,25);
        _person.setForeground(Color.WHITE);
        _person.setBackground(Color.BLUE);
        _person.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              PersonP p = new PersonP();
              _frame.dispose();
            }
        });
        _adminPanel.add(_person);

        _footbal = new JButton("Footbal");
        _footbal.setBounds(400,600,150,25);
        _footbal.setForeground(Color.WHITE);
        _footbal.setBackground(Color.GREEN);
        _footbal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              FootballG f = new FootballG();
              _frame.dispose();
            }
        });
        _adminPanel.add(_footbal);

        _tenis = new JButton("Tennis");
        _tenis.setBounds(600,600,150,25);
        _tenis.setForeground(Color.WHITE);
        _tenis.setBackground(Color.magenta);
        _tenis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        _adminPanel.add(_tenis);


        _basket = new JButton("Basket");
        _basket.setBounds(800,600,150,25);
        _basket.setForeground(Color.WHITE);
        _basket.setBackground(Color.ORANGE);
        _basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        _adminPanel.add(_basket);


        _changePassword = new JButton("Change password ");
        _changePassword.setBounds(600,500,150,25);
        _changePassword.setForeground(Color.WHITE);
        _changePassword.setBackground(Color.RED);
        _changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ChangePassword p = new ChangePassword();
              _frame.dispose();
            }
        });
        _adminPanel.add(_changePassword);

        _backToUser = new JButton("Back to user");
        _backToUser.setBounds(800,500,150,25);
        _backToUser.setForeground(Color.WHITE);
        _backToUser.setBackground(Color.PINK);
        _backToUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              LoginForm f = new LoginForm();
              _frame.dispose();
            }
        });
        _adminPanel.add(_backToUser);


        _frame = new JFrame("Admin");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_adminPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);

    }

    public static void main(String[] args) {

        Admin a = new Admin();
    }

}
