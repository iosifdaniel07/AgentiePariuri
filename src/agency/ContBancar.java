package agency;

import java.util.Random;
import java.time.LocalDate;

public class ContBancar {

    private static double _cont;
    private Person _pers;
    private Card _card;
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

    public static boolean depunere(double sold) {

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

    public static boolean retragere(double sold) {

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

    private static boolean  plataComision(int operatie) {

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

    public void createCard(){

        if(_cont >= 15){

            Random rad = new Random();
            long n = rad.nextLong(1000000000000000L, 9999999999999999L);
            String cardNumber = String.valueOf(n);


            LocalDate currentdate = LocalDate.now();
            int currentYear = currentdate.getYear();
            int currentMonth = currentdate.getMonthValue();
            String expirationDate = currentMonth + "/" + ( (currentYear%100) + 5);

            int m = rad.nextInt(100,999);
            String  securityCode = String.valueOf(m);

            this._card = new Card(_pers.getname(),cardNumber,expirationDate,securityCode);
            _cont -= 15;

            System.out.println("Card creat cu succes!");

        }else{
            System.out.println("Nu aveti suficiente fonduri!");
        }

    }

    public String getIBAN(){
        return IBAN;
    }

    public String toString(){
        return "Detalii cont:\n" + "IBAN" + IBAN + "\n" + "Sold: " + _cont + "\n" + _pers.toString() ;
    }

    public static double getSoldCont(){
        return _cont;
    }

    public Card getCard(){
        return _card;
    }

}
