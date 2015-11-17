/**
 * Created by chrisobrien on 11/12/15.
 */
public class Frame {

    boolean isTenthFrame = false;
    Shot s1,s2,s3;
    char FrameResult;
      //strike,open,spare,blank : x,o,s,' '
    int FrameNum;
        //1-10
    int FrameTotal = 0;
    int gameScore = 0;


    public Frame(){
        s1 = new Shot();
        s2 = new Shot();
        s3 = new Shot();
        FrameNum = 0;
        FrameResult = ' ';
    }

    public Frame(int fNum){
        s1 = new Shot();
        s2 = new Shot();
        FrameNum = fNum;
        FrameResult = ' ';
        if(fNum == 10){
            s3 = new Shot();
            isTenthFrame = true;
        }

    }

    public void scoreShot(int shotnum, int pins, char res){
        if(shotnum == 1){
            this.s1.setShot(pins,res);
        }
        if(shotnum == 2){
            this.s2.setShot(pins,res);
        }
        if(shotnum == 3){
            this.s3.setShot(pins,res);
        }
        this.completeFrame(res);
    }

    public void completeFrame(char res){
        FrameResult = res;
    }

    public void completeFrame(){
        FrameResult = this.getShotsInUse()[this.getNumShotsInUse()-1].outcome;
    }

    public int getNumShotsInUse(){
        int inuse = 0;
        if(this.s1.inuse)
            ++inuse;
        if(this.s2.inuse)
            ++inuse;
        if(this.isTenthFrame) {
            if (this.s3.inuse)
                ++inuse;
        }
        return inuse;
    }

    public Shot[] getShotsInUse(){
        Shot[] ary = new Shot[(this.getNumShotsInUse())];
        if(this.s1.inuse)
            ary[0] = s1;
        if(this.s2.inuse)
            ary[1] = s2;
        if(this.isTenthFrame)
            if(this.s3.inuse)
                ary[2] = s3;
        return ary;
    }

    public String toString(){
        String res = "";
        res += s1.toString();
        res += s2.toString();
        if(this.isTenthFrame){
            res += s3.toString();
        }
        res += " Frame Total: " + this.FrameTotal;
        return res;
    }


}
