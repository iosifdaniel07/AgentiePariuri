package app.classes.games;

import app.interfaces.IGames;

public class Tennis implements IGames {

    private String _player1;
    private String _player2;
    private double _cotaPLayer1;
    private double _cotaPlayer2;
    private WinnerTenins t;

    public Tennis(String _player1, String _player2, double _cotaPLayer1, double _cotaPlayer2){
        this._player1 = _player1;
        this._player2 = _player2;
        this._cotaPLayer1 = _cotaPLayer1;
        this._cotaPlayer2 = _cotaPlayer2;
    }

    @Override
    public String getWinner() {
        if(t.getWinner() == -1){
            return _player1;
        }else{
            return _player2;
        }
    }

    public void setCote(double _cotaPLayer1, double cotePlayer2){
        this._cotaPLayer1 = _cotaPLayer1;
        this._cotaPlayer2 = _cotaPlayer2;
    }

    @Override
    public String getTeam1(){
        return _player1;
    }

    @Override
    public String getTeam2(){
        return _player2;
    }

    @Override
    public double getCoteTeam1(){
        return _cotaPLayer1;
    }

    @Override
    public double getCoteTeam2(){
        return _cotaPlayer2;
    }

    @Override
    public String detailsGame(){
        return t.WinnerDetails();
    }

}
