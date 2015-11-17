import java.io.Console;

/**
 * Created by chrisobrien on 11/12/15.
 */

public class Main {

    public static void main(String[] args){

        Game g = new Game();

/*
        g.game[0].s1.setShot(10,'x');
        g.game[1].s1.setShot(10,'x');
        g.game[2].s1.setShot(10,'x');
        g.game[3].s1.setShot(10,'x');
        g.game[4].s1.setShot(10,'x');
        g.game[5].s1.setShot(10,'x');
        g.game[6].s1.setShot(10,'x');
        g.game[7].s1.setShot(10,'x');
        g.game[8].s1.setShot(10,'x');
        g.game[9].s1.setShot(10,'x');
        g.game[9].s2.setShot(10,'x');
        g.game[9].s3.setShot(10,'x');
*/

        g.scoreFrame(1,1,10,'x');
        g.scoreFrame(2,1,10,'x');
        g.scoreFrame(3,1,9,' ');
        g.scoreFrame(3,2,1,'s');
        g.scoreFrame(4,1,10,'x');
        g.scoreFrame(5,1,10,'x');
        g.scoreFrame(6,1,10,'x');
        g.scoreFrame(7,1,10,'x');
        g.scoreFrame(8,1,10,'x');
        g.scoreFrame(9,1,10,'x');
        g.scoreFrame(10,1,10,'x');
        g.scoreFrame(10,2,10,'x');
        g.scoreFrame(10,3,10,'x');

        System.out.println(g.getNumShotsInUse());

        System.out.println(g.ShotsInUseToString());

        System.out.println(g.isNextFrameStrike(1));

        System.out.println(g.isNextFrameStrike2(1));


    }//end main
}
