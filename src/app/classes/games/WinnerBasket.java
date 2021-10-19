package app.classes.games;

import java.util.Random;

public class WinnerBasket extends WinnerFootball{

    private  String _team1,_team2;
    private  int a[] = new int[2];

    public WinnerBasket(String _team1, String _team2){
       super(_team1, _team2);
    }

    @Override
    protected void generateScore(int[] a){
        Random r = new Random();
        a[0] = r.nextInt(65,145);
        a[1] = r.nextInt(65,145);
    }

    @Override
    public int getWinner(){
       return super.getWinner();
    }


   @Override
    public String WinnerDetails(){
        return super.WinnerDetails();
    }
}
