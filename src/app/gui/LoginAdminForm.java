package app.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LoginAdminForm {

    private JButton _buttonLoginUser, _buttonLoginAdmin;
    private JPanel _loginPanelAdmin;
    private JLabel _adminLabel, _passAdminLabel;
    private JTextField _getAdminname;
    private JPasswordField _getPasswordAdmin;
    private ImageIcon _image ;
    private  JLabel _imglb;
    private JFrame _frame;

    public LoginAdminForm(){

        _loginPanelAdmin = new JPanel();
        _loginPanelAdmin.setLayout(null);
        _loginPanelAdmin.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/bet1.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(520,100,375,178);
        _loginPanelAdmin.add(_imglb);


        _adminLabel = new JLabel("Admin Username");
        _adminLabel.setBounds(600,300,150,20);
        _adminLabel.setForeground(Color.RED);
        _loginPanelAdmin.add(_adminLabel);

        _getAdminname = new JTextField(15);
        _getAdminname.setBounds(600,319,200,30);
        _loginPanelAdmin.add(_getAdminname);

        _passAdminLabel = new JLabel("Password");
        _passAdminLabel.setBounds(600,347,70,20);
        _passAdminLabel.setForeground(Color.RED);
        _loginPanelAdmin.add( _passAdminLabel);

        _getPasswordAdmin = new JPasswordField(15);
        _getPasswordAdmin.setBounds(600,367,200,30);
        _loginPanelAdmin.add( _getPasswordAdmin);

        _buttonLoginAdmin = new JButton("Login");
        _buttonLoginAdmin.setBounds(600,402,90,25);
        _buttonLoginAdmin.setForeground(Color.WHITE);
        _buttonLoginAdmin.setBackground(Color.RED);
        _buttonLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String admin = _getAdminname.getText();
                String pass = _getPasswordAdmin.getText();
                String adminDataBase = null, passwordDataBase = null;

                String username = "root";
                String password = "password07";
                String url = "jdbc:mysql://127.0.0.1:3306/?user=root";

                Connection conn = null;

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch(ClassNotFoundException ex){
                    ex.printStackTrace();
                }

                try{
                     conn  = DriverManager.getConnection(url,username,password);

                    Statement stmt = conn.createStatement();

                    ResultSet  rs_Admin = stmt.executeQuery("SELECT AdminName FROM database.admin WHERE idAdmin = 0");
                    while(rs_Admin.next()){

                       adminDataBase = rs_Admin.getString("AdminName");
                    }

                    ResultSet rs_Pass = stmt.executeQuery("SELECT Password FROM database.admin WHERE idAdmin = 0");
                    while(rs_Pass.next()){

                        passwordDataBase = rs_Pass.getString("Password");
                    }

                }catch(SQLException ex){
                    ex.printStackTrace();
                }finally {

                    try{
                        if(conn != null){
                            conn.close();
                        }
                    }catch (Exception exx){
                        exx.printStackTrace();
                    }

                }

                if(admin.equals(adminDataBase) && pass.equals(passwordDataBase)){
                   Admin a = new Admin();
                   _frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Username or password incorrect");
                }

            }
        });
        _loginPanelAdmin.add(_buttonLoginAdmin);


        _buttonLoginUser = new JButton("User Login");
        _buttonLoginUser.setBounds(900,500,150,25);
        _buttonLoginUser.setForeground(Color.WHITE);
        _buttonLoginUser.setBackground(Color.BLUE);
        _buttonLoginUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               LoginForm form = new LoginForm();
               _frame.dispose();
            }
        });

        _loginPanelAdmin.add(_buttonLoginUser);

        _frame = new JFrame("Bet");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_loginPanelAdmin);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);
    }

    public static void main(String[] args) {

        LoginAdminForm form = new LoginAdminForm();
    }
}
