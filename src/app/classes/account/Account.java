package app.classes.account;

import app.classes.personbank.Card;
import app.classes.personbank.ContBancar;
import app.classes.personbank.Person;

public class Account {

    private String _firstname, _lastname, _cnp, _adress, _phone;
    private int _sold = 0;
    private Card _card;
    private String _username, _password, _email;
    private boolean _KYC ; //identity verification
    private Person _CI;
    private Card _cardacc;
    private ContBancar _contbanc;

    public Account(String _username, String _password,String _email, String _firstname, String _lastname,
                   String _cnp, String _adress, String _phone){

        this._username =  _username;
        this._password = _password;
        this._firstname = _firstname;
        this._lastname = _lastname;
        this._cnp = _cnp;
        this._adress = _adress;
        this._phone = _phone;
        _CI = null;
        _KYC = false;
        _contbanc = null;
        _cardacc = null;
    }

    public void addCard(Card _card){
        _cardacc = _card;
    }

    public void addContBancar(ContBancar _contbanc){
        this._contbanc = _contbanc;
    }


    public void depositViaCard(double sum){

        if(_cardacc != null){
            if(sum >= 20){
                if(_cardacc.plata(sum) == true) {
                    _sold += sum;
                    System.out.println("Depunere reusita!");
                }
                else System.out.println("Fonduri insuficiente pentru realizarea depunerii");
            }else{
                System.out.println("Suma minima pentru depunere este de 20 lei!");
            }

        }else{
            System.out.println("Nu aveti un card adaugat");
        }
    }

    public void depositViaContBancar(double sum){

        if(_contbanc != null){
            if(sum >= 20){
                if(_cardacc.retragere(sum)== true) {
                    System.out.println("Depunere reusita!");
                    _sold += sum;
                }
                else System.out.println("Fonduri insuficiente pentru realizarea depunerii");
            }else{
                System.out.println("Suma minima pentru depunere este de 20 lei!");
            }

        }else{
            System.out.println("Nu aveti un cont bancar adaugat");
        }
    }

    public void retragereViaCard(double sum){

        if(_cardacc != null){
            if(sum >= 50){
                if(_cardacc.retragere(sum) == true) {
                    _sold -= sum;
                    System.out.println("Retragere reusita!");
                }
            }else{
                System.out.println("Suma minima pentru retragere este de 50 lei!");
            }

        }else{
            System.out.println("Nu aveti un card adaugat");
        }

    }

    public void retragereViaContBancar(double sum){
        if(_contbanc != null){
            if(sum >= 50){
                if(_contbanc.retragere(sum) == true) {
                    _sold -= sum;
                    System.out.println("Retragere reusita!");
                }
            }else{
                System.out.println("Suma minima pentru retragere este de 50 lei!");
            }

        }else{
            System.out.println("Nu aveti un card adaugat");
        }
    }

    public void changePassword(String newPassword){
        _password = newPassword ;
        System.out.println("Parola schimbata!");
    }

    public void addCI(Person _CI){
        this._CI = _CI;
    }


    public boolean identityVerification(){

        boolean test = false;
        if(_KYC == true) {
            System.out.println("Contul este verificat!");
            return true;

        }else if(_CI == null){
            System.out.println("Nu ati adaugat cartea de identitate!");
            return false;
        }else if(  (_firstname.equals(_CI.getfirstname()) == true) && (_lastname.equals(_CI.getlastname()) == true)
                &&  (_cnp.equals(_CI.get_cnp()) == true)  &&  (_adress.equals(_CI.get_adress()) == true)){
            _KYC = true;
            System.out.println("Verificare realizata cu succes!");
            return true;
        }else{
            return false;
        }
    }

    public void changeEmail(String _email){
        this._email = _email;
        System.out.println("Email schimbat cu succes!");
    }

    public void changePhone(String _phone){
        this._phone = _phone;
        System.out.println("Numarul de telefon a fost schimbat cu succes!");
    }

    public int get_sold(){
        return _sold;
    }

    public void actualizareSoldMinus(double sum){
        _sold -= sum;
    }

    public void actualizareSoldPlus(double sum){
        _sold += sum;
    }

}

