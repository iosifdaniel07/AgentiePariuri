package app.classes.games;

public class Basketball extends Football {

    private String _team1;
    private String _team2;
    private double _cotaTeam1;
    private double _cotaTeam2;
    private double _cotaEgal;
    private WinnerBasket b;

    public Basketball(String _team1, String _team2, double _cotaTeam1, double _cotaTeam2, double _cotaEgal){
        super(_team1, _team2,_cotaTeam1,  _cotaTeam2, _cotaEgal);
        b = new WinnerBasket(_team1,_team2);
    }

    @Override
    public String getWinner(){
       return super.getWinner();
    }

    @Override
    public void setCote(double _cotaTeam1, double _cotaEgal, double _cotaTeam2){
        super.setCote(_cotaTeam1,_cotaEgal,_cotaTeam2);
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

    @Override
    public double getCoteEgal(){
        return _cotaEgal;
    }

    @Override
    public String detailsGame(){
        return b.WinnerDetails();
    }

}
