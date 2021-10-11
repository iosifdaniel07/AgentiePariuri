package agency;
import java.util.Random;

public class Games {

    private String _team1, _team2;
    private double _coteTeam1, _coteTeam2;


    public Games(String _team1, String _team2, double _coteTeam1, double _coteTeam2){
        this._team1 = _team1;
        this._team2 = _team2;
        this._coteTeam1 = _coteTeam1;
        this._coteTeam2 = _coteTeam2;
    }

    public static int teamWinner(){
        Random r = new Random();
        int n = r.nextInt(1,2);

        if(n == 1)
            return 1;
        else
            return 2;
    }

    public double pariare(double sum, int team){

        if(Games.teamWinner() == team){

            if(team == 1){
                return _coteTeam1 * sum;
            }else{
                return _coteTeam2 * sum;
            }

        }else return 0;
    }

    public String toString() {
        return "Games{" +
                "_team1='" + _team1 + '\'' +
                ", _team2='" + _team2 + '\'' +
                ", _coteTeam1=" + _coteTeam1 +
                ", _coteTeam2=" + _coteTeam2 +
                '}';
    }

}
