package app.classes.personbank;

import java.time.LocalDate;
import java.util.Random;

public class Card {

    private ContBancar _b;
    private String _nameOnCard;
    private String _cardNumber;
    private String _expirationDate;
    private String _securityCode;

    public Card(ContBancar _b){

        this._b = _b;
        Random rad = new Random();
        long n = rad.nextLong(1000000000000000L, 9999999999999999L);
        _cardNumber = String.valueOf(n);

        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        int currentMonth = currentdate.getMonthValue();
        _expirationDate = currentMonth + "/" + ( (currentYear%100) + 5);

        int m = rad.nextInt(100,999);
        _securityCode = String.valueOf(m);

    }


    public double getSold(){
        return _b.getSoldCont();
    }

    public boolean plata(double sum){
        boolean verificare = _b.retragere(sum);
        if(verificare == true)
            return true;
        else
            return false;
    }

    public boolean retragere(double sum){
        boolean verificare = _b.depunere(sum);
        if(verificare == true)
            return true;
        else
            return false;

    }

}
