package app.classes.personbank;

import java.util.Random;

public class ContBancar {

    private  double _cont;
    private Person _pers;
    private String IBAN;

    public ContBancar(Person p) {
        _pers = p;
        _cont = 0;

        java.util.Random  rnd = new java.util.Random();
        int n = rnd.nextInt(100000,999999);
        IBAN = String.valueOf(n);

        if (plataComision(0) == false) {
            _cont -= 50;
        }
    }

    public ContBancar(Person p, double _cont) {
        _pers = p;
        this._cont = _cont;

        java.util.Random  rnd = new java.util.Random();
        int n = rnd.nextInt(100000,999999);
        IBAN = String.valueOf(n);

        if (plataComision(0) == false) {
            _cont -= 50;
        }

    }

    public  boolean depunere(double sold) {

        double cont_tmp = _cont;
        if (sold > 50000)
            return false;

        _cont += sold;

        if (plataComision(1) == false) {
            _cont = cont_tmp;
            return false;
        }

        return true;
    }

    public  boolean retragere(double sold) {

        double cont_tmp = _cont;

        if (sold > 20000) {
            return false;
        }

        if (sold > _cont) {
            return false;
        }

        _cont -= sold;
        if (plataComision(2) == false) {
            _cont = cont_tmp;
            return false;
        }

        return true;

    }

    private  boolean  plataComision(int operatie) {

        if (_cont <= 0) {
            return false;
        }

        switch(operatie) {
            case 0: _cont -= 50; break;
            case 1: _cont -= 1; break;
            case 2: _cont -= 5; break;
            default: return true;
        }

        if (_cont < 0) {
            return false;
        }

        return true;
    }


    public String getIBAN(){
        return IBAN;
    }

    public String toString(){
        return "Detalii cont:\n" + "IBAN" + IBAN + "\n" + "Sold: " + _cont + "\n" + _pers.toString() ;
    }

    public  double getSoldCont(){
        return _cont;
    }


}
