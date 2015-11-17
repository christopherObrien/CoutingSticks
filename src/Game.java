/**
 * Created by chrisobrien on 11/12/15.
 */
public class Game {

    Frame[] game = new Frame[10];

    public Game(){
        for(int i = 0;i<10;i++){
            game[i] = new Frame(i+1);
        }
    }

    public int getNumShotsInUse(){
        int res = 0;
        for(int i = 0;i<10;++i){
            res += game[i].getNumShotsInUse();
        }
        return res;
    }

    public void scoreFrame(int framenum, int shotnum, int pins, char res){
        this.game[framenum-1].scoreShot(shotnum,pins,res);
    }

    public Shot[] getShotsInUse(){
        Shot[] ary = new Shot[(this.getNumShotsInUse())];
        int aryPos = 0;
        Shot[] tmp;
        for(int i = 0;i<10;++i){
            tmp = game[i].getShotsInUse();
            for(int j=0;j<tmp.length;++j){
                ary[aryPos] = tmp[j];
                ++aryPos;
            }//inner frame loop
        }//outer game for loop
        return ary;
    }

    public void calcScoreForFrame(int fnum){
        fnum = fnum-1;
        if(this.game[fnum].FrameResult == 'o'){
            this.game[fnum].FrameTotal =
                    this.game[fnum].s1.getPins() +
                    this.game[fnum].s2.getPins();
        }//end open
        if(this.game[fnum].FrameResult == 's'){
            this.game[fnum].FrameTotal =
                    this.game[fnum+1].s1.getPins() + 10;
        }//end spare
        if(this.game[fnum].FrameResult == 'x' && fnum != 8 && fnum != 9) {
            if (this.game[fnum + 1].FrameResult == 'x')
                if (this.game[fnum + 2].FrameResult == 'x')
                    this.game[fnum].FrameTotal = 30;
        }//end 3 x not tenth or ninth
        if(this.game[fnum].FrameResult == 'x' && fnum != 8 && fnum != 9) {
            if (this.game[fnum + 1].FrameResult == 'x')
                if (this.game[fnum + 2].FrameResult != 'x')
                    this.game[fnum].FrameTotal =
                            (20 + this.game[fnum+2].s1.getPins());
        }//end 2 x not tenth or ninth
        if(this.game[fnum].FrameResult == 'x' && fnum != 8 && fnum != 9) {
            if (this.game[fnum + 1].FrameResult == 's' || this.game[fnum+1].FrameResult == 'o'){
                this.game[fnum].FrameTotal = 10 +
                        this.game[fnum+1].s1.getPins() +
                        this.game[fnum+1].s2.getPins();
            }
        }//end 1 x not tenth or ninth


    }

    public boolean isNextFrameStrike(int currFrame){
        if(this.game[currFrame].FrameResult == 'x')
            return true;
        else return false;
    }

    public boolean isNextFrameStrike2(int currFrame){
        return (this.isNextFrameStrike(currFrame) && this.isNextFrameStrike(currFrame+1));
    }


    public String ShotsInUseToString(){
        String res = "";
        Shot[] ary = this.getShotsInUse();
        for(int i=0;i<ary.length;++i){
            res += ary[i].toString();
        }
        return res;
    }

    public String toString(){
        String res = "";
        for(int i=0;i<10;++i){
            res += "Frame " + (i+1) + "\n" + game[i].toString();
        }
        return res;
    }

}
