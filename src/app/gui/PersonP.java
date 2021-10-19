package app.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonP {


    private JPanel _personPanel;
    private JFrame _frame;
    private JButton _createPerson, _cancelCreatePerson, _deadPerson;
    private ImageIcon _image ;
    private  JLabel _imglb;

    public PersonP() {

        _personPanel = new JPanel();
        _personPanel.setLayout(null);
        _personPanel.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/person.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(520,100,191,216);
        _personPanel.add(_imglb);


        _createPerson = new JButton("Create Person");
        _createPerson.setBounds(600,500,150,25);
        _createPerson.setForeground(Color.WHITE);
        _createPerson.setBackground(Color.BLACK);
        _createPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             CreatePerson p = new CreatePerson();
             _frame.dispose();
            }
        });
        _personPanel.add(_createPerson);

        _cancelCreatePerson = new JButton("Cancel");
        _cancelCreatePerson.setBounds(400,500,150,25);
        _cancelCreatePerson.setForeground(Color.WHITE);
        _cancelCreatePerson.setBackground(Color.RED);
        _cancelCreatePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Admin a = new Admin();
              _frame.dispose();
            }
        });
        _personPanel.add(_cancelCreatePerson);

        _deadPerson = new JButton("DeadPerson");
        _deadPerson.setBounds(800,500,150,25);
        _deadPerson.setForeground(Color.WHITE);
        _deadPerson.setBackground(Color.GREEN);
        _deadPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              DeadPerson d = new DeadPerson();
              _frame.dispose();
            }
        });
        _personPanel.add(_deadPerson);


        _frame = new JFrame("Admin");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_personPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);

    }

    public static void main(String[] args) {
        PersonP p = new PersonP();
    }

}
