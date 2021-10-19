package app.classes.games;

import app.interfaces.IGenerateWinner;

import java.util.Random;

public class WinnerTenins implements IGenerateWinner {

    private String _player1;
    private String _player2;
    private int[][] a = new int[2][4];

    public WinnerTenins(String _player1, String _player2){
        this._player1 = _player1;
        this._player2 = _player2;
        generateScore(a);
    }

    protected void generateScore(int[][] a){
        Random r = new Random();

        //set1
       a[0][0] = r.nextInt(0,6);
       a[1][0] = r.nextInt(0,6);

       if(a[0][0] > a[1][0]){
           a[0][0] = 6;
           a[0][3] = 1;
       }else{
           a[1][0] = 6;
           a[1][3] = 1;
       }

       //set2
       a[0][1] = r.nextInt(0,6);
       a[1][1] = r.nextInt(0,6);

        if(a[0][1] > a[1][1]){
            a[0][1] = 6;
            a[0][3]++;
        }else{
            a[1][1] = 6;
            a[1][3]++;
        }

        //set 3
        if(a[0][3] == a[1][3]){
            a[0][2] = r.nextInt(0,6);
            a[1][2] = r.nextInt(0,6);

            if(a[0][2] > a[1][2]){
                a[0][2] = 6;
                a[0][3]++;
            }else{
                a[1][2] = 6;
                a[1][3]++;
            }
        }
    }


    @Override
    public int getWinner(){
        if(a[0][3] > a[1][3])
            return -1;
        else
            return 1;
    }

    @Override
    public String WinnerDetails(){

        if(a[0][3] == 2 && a[1][3] == 1){
            return "Meciul " + _player1 + "-" + _player2 + " a fost castigat de catre " + _player1 +
                    " cu scorul: "+ a[0][0] + "-" +a[1][0] + " " + a[0][1] + "-" + a[1][1] + " "+
                    a[0][2] + "-" + a[1][2];
        }else if(a[0][3] == 1 && a[1][3] == 2){
            return "Meciul " + _player1 + "-" + _player2 + " a fost castigat de catre " + _player2 +
                    " cu scorul: "+ a[0][0] + "-" +a[1][0] + " " + a[0][1] + "-" + a[1][1] + " "+
                    a[0][2] + "-" + a[1][2];
        }else if(a[0][3] == 2 && a[1][3] == 0){
            return "Meciul " + _player1 + "-" + _player2 + " a fost castigat de catre " + _player1 +
                    " cu scorul: "+ a[0][0] + "-" +a[1][0] + " " + a[0][1] + "-" + a[1][1] ;
        }else {
            return "Meciul " + _player1 + "-" + _player2 + " a fost castigat de catre " + _player2 +
                    " cu scorul: "+ a[0][0] + "-" +a[1][0] + " " + a[0][1] + "-" + a[1][1];
        }
    }

}
