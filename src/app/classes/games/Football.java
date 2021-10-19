package app.classes.games;

import app.interfaces.IGames;

public class Football implements IGames {

    private String _team1;
    private String _team2;
    private double _cotaTeam1;
    private double _cotaTeam2;
    private double _cotaEgal;
    private WinnerFootball f;

    public Football(String _team1, String _team2, double _cotaTeam1, double _cotaTeam2, double _cotaEgal){
        this._team1 = _team1;
        this._team2 = _team2;
        this._cotaTeam1 = _cotaTeam1;
        this._cotaTeam2 = _cotaTeam2;
        this._cotaEgal = _cotaEgal;

        f = new WinnerFootball(_team1,_team2);
    }

    @Override
    public String getWinner() {
        if(f.getWinner() == 0){
            return "egalitate";
        }else if(f.getWinner() == -1){
            return _team1;
        }else{
            return _team2;
        }
    }

    public void setCote(double _cotaTeam1, double _cotaEgal, double _cotaTeam2){
        this._cotaTeam1 = _cotaTeam1;
        this._cotaTeam2 = _cotaTeam2;
        this._cotaEgal =_cotaEgal;
    }

    @Override
    public String getTeam1(){
        return _team1;
    }

    @Override
    public String getTeam2(){
        return _team2;
    }

    @Override
    public double getCoteTeam1(){
        return _cotaTeam1;
    }

    @Override
    public double getCoteTeam2(){
        return _cotaTeam2;
    }

    public double getCoteEgal(){
        return _cotaEgal;
    }

    @Override
    public String detailsGame(){
        return f.WinnerDetails();
    }
}
