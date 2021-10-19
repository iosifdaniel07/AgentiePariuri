package app.gui;

import app.classes.account.AdminAgency;
import app.classes.personbank.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FootballG {

    private JPanel _footballPanel;
    private JFrame _frame;
    private JButton _createGame,_modifyCote, _deleteGame, _backToAdmin, _afisareMeciuri;
    private JLabel _team1Label, _team2Label, _team1CoteLabel,_team2CoteLabel, _equalityLabel,_addKeyGameLabel, _deleteKeyLabel, _modificareKeyLabel,_modificareCotaEgalLabel,_modificareCotaTeam1Label, _modificareCotaTeam2Label;
    private JTextField _team1Field,_team2Field,_team1CoteField,_team2CoteField, _equalityField, _addKeyGameField, _deleteKeyField, _modificareKeyTextField,_modificareCotaEgalField,_modificareCotaTeam1Field,_modificareCotaTeam2Field;
    private ImageIcon _image;
    private JLabel _imglb;

    public FootballG(){
        _footballPanel = new JPanel();
        _footballPanel.setLayout(null);
        _footballPanel.setBackground(Color.WHITE);

        try{
            _image = new ImageIcon(this.getClass().getResource("images/football.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        _imglb = new JLabel(_image);
        _imglb.setBounds(620,80,215,233);
        _footballPanel.add(_imglb);

        _team1Label = new JLabel("Echipa 1");
        _team1Label.setBounds(100,150,100,25);
        _team1Label.setForeground(Color.RED);
        _footballPanel.add(_team1Label);

        _team1Field = new JTextField();
        _team1Field.setBounds(100,170,150,25);
        _team1Field.setForeground(Color.RED);
        _footballPanel.add(_team1Field);

        _team2Label = new JLabel("Echipa 2");
        _team2Label.setBounds(100,200,100,25);
        _team2Label.setForeground(Color.RED);
        _footballPanel.add(_team2Label);

        _team2Field = new JTextField();
        _team2Field.setBounds(100,220,150,25);
        _team2Field.setForeground(Color.RED);
        _footballPanel.add(_team2Field);

        _team1CoteLabel = new JLabel("Cota echipa 1");
        _team1CoteLabel.setBounds(100,250,100,25);
        _team1CoteLabel.setForeground(Color.RED);
        _footballPanel.add(_team1CoteLabel);

        _team1CoteField = new JTextField();
        _team1CoteField.setBounds(100,270,150,25);
        _team1CoteField.setForeground(Color.RED);
        _footballPanel.add(_team1CoteField);

        _team2CoteLabel = new JLabel("Cota echipa 2");
        _team2CoteLabel.setBounds(100,300,100,25);
        _team2CoteLabel.setForeground(Color.RED);
        _footballPanel.add(_team2CoteLabel);

        _team2CoteField = new JTextField();
        _team2CoteField.setBounds(100,320,150,25);
        _team2CoteField.setForeground(Color.RED);
        _footballPanel.add(_team2CoteField);

        _equalityLabel = new JLabel("Cota egalitate");
        _equalityLabel.setBounds(100,350,100,25);
        _equalityLabel.setForeground(Color.RED);
        _footballPanel.add(_equalityLabel);

        _equalityField = new JTextField();
        _equalityField.setBounds(100,370,150,25);
        _equalityField.setForeground(Color.RED);
        _footballPanel.add(_equalityField);

        _addKeyGameLabel = new JLabel("Numarul meciului");
        _addKeyGameLabel.setBounds(100,400,100,25);
        _addKeyGameLabel.setForeground(Color.RED);
        _footballPanel.add(_addKeyGameLabel);

        _addKeyGameField = new JTextField();
        _addKeyGameField.setBounds(100,420,150,25);
        _addKeyGameField.setForeground(Color.RED);
        _footballPanel.add(_addKeyGameField);

        _createGame = new JButton("Adaugare meci");
        _createGame.setBounds(100,450, 150,30 );
        _createGame.setBackground(Color.BLUE);
        _createGame.setForeground(Color.WHITE);
        _createGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminAgency a = AdminAgency.getInstance();
                a.addFootbalGame(1,"asddas","dsdaa",1.3,1.6,1.7);
            }
        });
        _footballPanel.add(_createGame);

        _backToAdmin = new JButton("Inapoi la Admin");
        _backToAdmin.setBounds(500,500,150,30);
        _backToAdmin.setBackground(Color.BLACK);
        _backToAdmin.setForeground(Color.WHITE);
        _backToAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin a = new Admin();
                _frame.dispose();
            }
        });
        _footballPanel.add(_backToAdmin);


        _afisareMeciuri = new JButton("Afisare meciuri");
        _afisareMeciuri.setBounds(670,500,150,30);
        _afisareMeciuri.setBackground(Color.YELLOW);
        _afisareMeciuri.setForeground(Color.red);
        _afisareMeciuri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        _footballPanel.add(_afisareMeciuri);

        _deleteKeyLabel = new JLabel("Numarul meciului de sters");
        _deleteKeyLabel.setBounds(950,100,180,25);
        _deleteKeyLabel.setForeground(Color.RED);
        _footballPanel.add( _deleteKeyLabel);

        _deleteKeyField = new JTextField();
        _deleteKeyField.setBounds(950,120,150,25);
        _deleteKeyField.setForeground(Color.RED);
        _footballPanel.add( _deleteKeyField);

        _deleteGame = new JButton("Sterge Meciul");
        _deleteGame.setBounds(950,160,150,30);
        _deleteGame.setBackground(Color.BLUE);
        _deleteGame.setForeground(Color.RED);
        _deleteGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        _footballPanel.add(_deleteGame);

        _modificareCotaEgalLabel = new JLabel("Cota Egal");
        _modificareCotaEgalLabel.setBounds(950,250,150,25);
        _modificareCotaEgalLabel.setForeground(Color.RED);
        _footballPanel.add(_modificareCotaEgalLabel);

        _modificareCotaEgalField = new JTextField();
        _modificareCotaEgalField .setBounds(950,270,100,25);
        _modificareCotaEgalField .setForeground(Color.RED);
        _footballPanel.add(  _modificareCotaEgalField );


        _modificareCotaTeam1Label = new JLabel("Cota Echipa1");
        _modificareCotaTeam1Label.setBounds(950,300,150,25);
        _modificareCotaTeam1Label.setForeground(Color.RED);
        _footballPanel.add(_modificareCotaTeam1Label);

        _modificareCotaTeam1Field = new JTextField();
        _modificareCotaTeam1Field.setBounds(950,320,100,25);
        _modificareCotaTeam1Field.setForeground(Color.RED);
        _footballPanel.add( _modificareCotaTeam1Field);

        _modificareCotaTeam2Label = new JLabel("Cota Echipa2");
        _modificareCotaTeam2Label.setBounds(950,350,150,25);
        _modificareCotaTeam2Label.setForeground(Color.RED);
        _footballPanel.add(_modificareCotaTeam2Label);

        _modificareCotaTeam2Field = new JTextField();
        _modificareCotaTeam2Field.setBounds(950,370,100,25);
        _modificareCotaTeam2Field.setForeground(Color.RED);
        _footballPanel.add( _modificareCotaTeam2Field);

        _modificareKeyLabel = new JLabel("Numarul meciului");
        _modificareKeyLabel.setBounds(950,400,150,25);
        _modificareKeyLabel.setForeground(Color.RED);
        _footballPanel.add(_modificareKeyLabel);

        _modificareKeyTextField = new JTextField();
        _modificareKeyTextField.setBounds(950,420,100,25);
        _modificareKeyTextField.setForeground(Color.RED);
        _footballPanel.add(_modificareKeyTextField);

        _modifyCote = new JButton("Modificare Cote");
        _modifyCote.setBounds(950,450,150,30);
        _modifyCote.setBackground(Color.YELLOW);
        _modifyCote.setForeground(Color.RED);
        _modifyCote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        _footballPanel.add(_modifyCote);

        _frame = new JFrame("Football");
        _frame.setLocation(00,10);
        _frame.setContentPane(_footballPanel);
        _frame.setSize(new Dimension(1200,800));
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);

    }

    public static void main(String[] args) {
        FootballG f = new FootballG();
    }
}
