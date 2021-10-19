package app.gui;

import app.classes.account.AdminAgency;
import app.classes.personbank.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeadPerson {

    private JPanel _deadPanel;
    private JFrame _frame;
    private JButton _deletePerson, _cancel;
    private JTextField _cnpField;
    private JLabel _cnpLabel;

    public DeadPerson(){
        _deadPanel = new JPanel();
        _deadPanel.setLayout(null);
        _deadPanel.setBackground(Color.BLACK);


         _cnpLabel = new JLabel("CNP");
         _cnpLabel.setBounds(500,200,100,25);
         _cnpLabel.setForeground(Color.RED);
         _deadPanel.add(_cnpLabel);

         _cnpField = new JTextField();
         _cnpField.setBounds(500,220,150,25);
         _cnpField.setForeground(Color.RED);
         _deadPanel.add(_cnpField);

         _cancel = new JButton("Cancel");
         _cancel.setBounds(500,300,100,25);
         _cancel.setBackground(Color.WHITE);
         _cancel.setForeground(Color.BLACK);
         _cancel.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 PersonP p = new PersonP();
                 _frame.dispose();
             }
         });
         _deadPanel.add(_cancel);

        _deletePerson = new JButton("Delete Person");
        _deletePerson.setBounds(620,300,150,25);
        _deletePerson.setBackground(Color.RED);
        _deletePerson.setForeground(Color.WHITE);
        _deletePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 String st = _cnpField.getText();
                 double d = Double.valueOf(st);

                String username = "root";
                String password = "password07";
                String url = "jdbc:mysql://127.0.0.1:3306/?user=root";

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch(ClassNotFoundException ex){
                    ex.printStackTrace();
                }

                try{
                    Connection  conn  = DriverManager.getConnection(url,username,password);

                   String query = "SELECT CNP FROM database.persoana WHERE CNP = ?";
                   PreparedStatement preparedStatement = conn.prepareStatement(query);
                   preparedStatement.setDouble(1,d);

                   ResultSet res = preparedStatement.executeQuery();

                   double rezultat = 0;
                    while(res.next()){

                       rezultat = res.getDouble("CNP");
                    }
                   if(rezultat == d){
                       AdminAgency a = AdminAgency.getInstance();
                       a.deletePerson(d);
                       JOptionPane.showMessageDialog(null,"Persoana stearsa cu succes!");
                   }else{
                       JOptionPane.showMessageDialog(null,"CNP gresit");
                   }

                    conn.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }

            }
        });
        _deadPanel.add( _deletePerson);

        _frame = new JFrame("Admin");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_deadPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);
    }

    public static void main(String[] args) {
        DeadPerson p = new DeadPerson();
    }

}
