package app.gui;

import app.classes.account.AdminAgency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePerson {

    private JFrame _frame;
    private JPanel _panelPerson;
    private JButton _createPerson, _cancelCreatePerson;
    private JLabel _firstNameLabel,_lastNameLabel,_cnpLabel,_adressLabel;
    private JTextField _firstNameField,_lastNameField,_cnpField,_adressField;
    private ImageIcon _image ;
    private  JLabel _imglb;

    public CreatePerson(){

        _panelPerson = new JPanel();
        _panelPerson.setLayout(null);
        _panelPerson.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/person.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(520,100,191,216);
        _panelPerson.add(_imglb);

       _firstNameLabel = new JLabel("First Name");
        _firstNameLabel.setBounds(500,360,70,20);
        _firstNameLabel.setForeground(Color.RED);
        _panelPerson.add(_firstNameLabel);

         _firstNameField = new JTextField();
         _firstNameField.setBounds(500,380,150,20);
         _panelPerson.add(_firstNameField);

         _lastNameLabel = new JLabel("Last Name");
         _lastNameLabel.setBounds(500,400,70,20);
         _lastNameLabel.setForeground(Color.RED);
          _panelPerson.add(_lastNameLabel);

          _lastNameField = new JTextField();
          _lastNameField.setBounds(500,420,150,20);
          _panelPerson.add(_lastNameField);

          _cnpLabel = new JLabel("CNP");
          _cnpLabel.setBounds(500,440,70,20);
          _cnpLabel.setForeground(Color.RED);
          _panelPerson.add(_cnpLabel);

          _cnpField = new JTextField();
          _cnpField.setBounds(500,460,150,20);
          _panelPerson.add(_cnpField);

          _adressLabel = new JLabel("Adress");
          _adressLabel.setBounds(500,480,70,20);
          _adressLabel.setForeground(Color.RED);
          _panelPerson.add(_adressLabel);

          _adressField = new JTextField();
          _adressField.setBounds(500,500,150,20);
          _panelPerson.add(_adressField);

          _cancelCreatePerson = new JButton("Cancel");
          _cancelCreatePerson.setBounds(580,540,100,25);
          _cancelCreatePerson.setBackground(Color.RED);
          _cancelCreatePerson.setForeground(Color.WHITE);
          _cancelCreatePerson.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                 PersonP p = new PersonP();
                 _frame.dispose();
              }
          });
          _panelPerson.add(_cancelCreatePerson);

           _createPerson = new JButton("Create");
           _createPerson.setBounds(460,540,110,25);
           _createPerson.setBackground(Color.BLUE);
           _createPerson.setForeground(Color.WHITE);
           _createPerson.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String a = _cnpField.getText();
                   Double d = Double.valueOf(a);
                   AdminAgency.getInstance().addPerson(_firstNameField.getText(),_lastNameField.getText(),d,_adressField.getText());
                   JOptionPane.showMessageDialog(null,"Persona creata cu succes");
               }
           });
           _panelPerson.add(_createPerson);

        _frame = new JFrame("Create Person");
        _frame.setLocation( 200,10);
        _frame.setContentPane(_panelPerson);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);
    }

    public static void main(String[] args) {

        CreatePerson p = new CreatePerson();
    }
}
