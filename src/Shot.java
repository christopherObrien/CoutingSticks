/**
 * Created by chrisobrien on 11/12/15.
 */
import java.lang.String;

public class Shot {

    public int pincount;
    public char outcome = ' ';
    public boolean inuse = false;
    //outcome is set by default to ' '.  If the shot results in a strike,spare,or open outcome will be
    //set to 'x', 's' ,or 'o' accordingly.

    public Shot(){
        pincount = 0;
        outcome = ' ';
        inuse = false;
    }

    public Shot(int pins, char res){
        pincount = pins;
        outcome = res;
        inuse = true;
    }

    public void setShot(int pins, char res){
        pincount = pins;
        outcome = res;
        inuse = true;
    }

    public void setPins(int pins){
        pincount = pins;
        inuse = true;
    }

    public void setOutcome(char res){
        outcome = res;
    }

    public int getPins(){
        return pincount;
    }

    public char getOutcome(){
        return outcome;
    }

    public String toString(){
        return "Pincount: " + pincount + "   Outcome: -" + outcome +"-   Inuse: " + inuse + "\n";
    }

}
