package agency;

public class Card {

    private String _nameOnCard,_cardNumber, _expirationDate, _securityCode;

    public Card(String _nameOnCard, String _cardNumber, String _expirastionDate, String _securityCode){

        this._nameOnCard = _nameOnCard;
        this._cardNumber = _cardNumber;
        this._expirationDate = _expirationDate;
        this._securityCode = _securityCode;
    }

    public double getSold(){
        return ContBancar.getSoldCont();
    }

    public boolean plata(double sum){
        boolean verificare = ContBancar.retragere(sum);
        if(verificare == true)
            return true;
        else
            return false;
    }

    public boolean retragere(double sum){
        boolean verificare = ContBancar.depunere(sum);
        if(verificare == true)
            return true;
        else
            return false;

    }

}
