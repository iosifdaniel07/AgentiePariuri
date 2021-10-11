package agency;

public class Person {

    private String _firstname, _lastname, _cnp, _adress;

    public Person(String _firstname, String _lastname, String _cnp, String _adress) {

        this._firstname = _firstname;
        this._lastname = _lastname;
        this._cnp = _cnp;
        this._adress = _adress;

    }

    public String toString() {
        return "Detalii persoanle: " + _firstname + "; " + _lastname + "; " + _adress + ".";

    }

    public String getname(){
        return _firstname + " " + _lastname;
    }

    public String getfirstname(){
        return _firstname;
    }

    public String getlastname(){
        return _lastname;
    }

    public String get_cnp(){
        return _cnp;
    }

    public String get_adress(){
        return _adress;
    }

}

