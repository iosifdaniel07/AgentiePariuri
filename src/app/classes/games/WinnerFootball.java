package app.classes.games;

import app.interfaces.IGenerateWinner;
import java.util.Random;

public class WinnerFootball implements IGenerateWinner {

    private String _team1;
    private String _team2;
    private  int a[] = new int[2];

    public WinnerFootball(String _team1, String _team2){
        this._team1 = _team1;
        this._team2 = _team2;

        generateScore(a);

    }

    protected void generateScore(int[] a){
        Random r = new Random();
        a[0] = r.nextInt(0,5);
        a[1] = r.nextInt(0,5);
    }


    @Override
    public int getWinner(){

        if(a[0] == a[1]){
            return 0;
        }else if(a[0] > a[1]){
            return 1;
        }else{
            return 2;
        }

    }

    @Override
    public String WinnerDetails(){
        if(a[0] == a[1]){
            return "Meciul " + _team1 + "-" + _team2 + " s-a terminat la egalitate: " + a[0] + "-" +a[1];
        }else if(a[0] > a[1]){
            return "Meciul " + _team1 + "-" + _team2 + " a fost castigat de catre " + _team1 + " cu scorul: "+ a[0] + "-" +a[1];
        }else{
            return "Meciul " + _team1 + "-" + _team2 + " a fost castigat de catre " + _team2+ " cu scorul: "+ a[0] + "-" +a[1];
        }
    }

}
