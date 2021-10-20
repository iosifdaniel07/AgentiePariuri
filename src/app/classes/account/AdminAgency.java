package app.classes.account;

import app.classes.personbank.Person;

import javax.swing.*;
import java.sql.*;

public class AdminAgency {

    private static AdminAgency _instance = new AdminAgency();

    private String _username;
    private String _password;

    private AdminAgency(){

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

            ResultSet rs_Admin = stmt.executeQuery("SELECT AdminName FROM database.admin WHERE idAdmin = 0");
            while(rs_Admin.next()){

                _username = rs_Admin.getString("AdminName");
            }

            ResultSet rs_Pass = stmt.executeQuery("SELECT Password FROM database.admin WHERE idAdmin = 0");
            while(rs_Pass.next()){

                _password = rs_Pass.getString("Password");
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

    }


    public static AdminAgency getInstance() {
        return _instance;
    }

    public void changePassword(String newPassword){

        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
           Connection conn  = DriverManager.getConnection(url,username,password);

           String query = "UPDATE database.admin set Password = ? WHERE idAdmin = 0";
           PreparedStatement preparedStatement = conn.prepareStatement(query);
           preparedStatement.setString(1,newPassword);

           preparedStatement.executeUpdate();

            _password = newPassword;

            conn.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void addPerson(String _firstname, String _lastname, double _cnp, String _adress){

        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            Connection conn  = DriverManager.getConnection(url,username,password);

            String query = "INSERT INTO database.persoana (CNP, FirstName, LastName, Adress)" + "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDouble(1,_cnp);
            preparedStatement.setString(2,_firstname);
            preparedStatement.setString(3,_lastname);
            preparedStatement.setString(4,_adress);

            preparedStatement.executeUpdate();

            String cnp = String.valueOf(_cnp);
            Person p = new Person(_firstname,_lastname,cnp,_adress);

            conn.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void deletePerson(double _cnp){

        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            Connection conn  = DriverManager.getConnection(url,username,password);

                String query = "DELETE FROM database.persoana WHERE CNP = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setDouble(1,_cnp);

                preparedStatement.execute();

                conn.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public void addFootbalGame(int key, String Team1, String Team2, double CoteTeam1, double CoteTeam2, double CoteEgal){

        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            Connection conn  = DriverManager.getConnection(url,username,password);

            String query = "INSERT INTO `database`.`fotbal` (`key`, `team1`, `team2`, `cote1`, `cote2`, `cotex`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,key);
            preparedStatement.setString(2,Team1);
            preparedStatement.setString(3,Team2);
            preparedStatement.setDouble(4,CoteTeam1);
            preparedStatement.setDouble(5,CoteTeam2);
            preparedStatement.setDouble(6,CoteEgal);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Meci adaugat cu succes!");

            conn.close();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Meci nu a fost adaugat!");
            ex.printStackTrace();
        }

    }

    public void removeFootbalGame(int key){
        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            Connection conn  = DriverManager.getConnection(url,username,password);

            String query = "DELETE FROM `database`.`fotbal` WHERE `key` = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,key);

            preparedStatement.execute();

            conn.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void modificareCote(int key, double cote1, double cote2, double cotex){
        String username = "root";
        String password = "password07";
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try{
            Connection conn  = DriverManager.getConnection(url,username,password);

            String query = "UPDATE `database`.`fotbal` SET `cote1` = ?, `cote2` = ?, `cotex` = ? WHERE (`key` = ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDouble(1,cote1);
            preparedStatement.setDouble(2,cote2);
            preparedStatement.setDouble(3,cotex);
            preparedStatement.setInt(4,key);

            preparedStatement.executeUpdate();

            conn.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
