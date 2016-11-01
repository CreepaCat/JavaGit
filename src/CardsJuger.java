import java.util.ArrayList;

/**
 * Created by ghost on 2016/10/31.
 */
public class CardsJuger {
      Card ah;
      Card am;
      Card af;
    Card bh;
    Card bm;
    Card bf;
    CardGame cg=new CardGame();



    public CardsJuger( ArrayList<Card> a,ArrayList<Card> b){
         //权值相等，无需比较花色大小，三张牌
        //一副牌
        this.ah=a.get(0);
        this.am=a.get(1);
        this.af=a.get(2);
        this.bh=b.get(0);
        this.bm=b.get(1);
        this.bf=b.get(2);


    }
    //散牌
     public int SP(){
         int flg=0;
        switch(cg.NumCompare(ah,bh)){
            case 0:
                switch (cg.NumCompare(am,bm)){
                    case 0:
                        switch (cg.NumCompare(af,bf)){
                            case 0:
                                flg=-ah.compareTo(bh);//ah>bh返回-1
                                //决出，不存在平局
                            default:
                                flg=cg.NumCompare(af,bf);break;
                        }
                    default:
                        flg=cg.NumCompare(am,bm);break;
                }
            default:
                flg=cg.NumCompare(ah,bh);break;
        }
         return flg;
    }
    //对子,中间一张必为对子牌，单牌在两头
    public int DZ(){
        int flag=0;
        switch (cg.NumCompare(am,bm)){
            case 0:
                if(am.getNumber().equals(ah.getNumber())) {
                if (bm.getNumber().equals(bf.getNumber())) {
                    //a单牌小于b单牌==》a<b 单牌为af
                    flag = -1;
                }else if(bm.getNumber().equals(bh.getNumber())&&cg.NumCompare(af,bf)<0){
                    flag=-1;
            }else if(bm.getNumber().equals(bh.getNumber())&&cg.NumCompare(af,bf)>0){
                    flag=1;
                }else if (ah.compareTo(bh)<0){
                    flag=1;
                }else {
                    flag=-1;
                }
                }else if(am.getNumber().equals(af.getNumber())){
                    if (bm.getNumber().equals(bh.getNumber())){
                        //a>b 单牌为ah
                        flag=1;
                    }else if(bm.getNumber().equals(bf.getNumber())&&cg.NumCompare(ah,bh)<0){
                        flag=-1;
                    }else if(bm.getNumber().equals(bf.getNumber())&&cg.NumCompare(ah,bh)>0){
                        flag=1;
                    }else if(ah.compareTo(bh)<0){//数字相等
                        flag=1;
                    }else {
                        flag=-1;
                    }
                }
                break;
            default:
                flag=cg.NumCompare(am,bm);break;
        }
        return flag;
    }
    //顺子，只需比较第一张,此处为散顺，花色和数字一起比较
    public int SZ(){
        return -(ah.compareTo(bh));
    }
    //豹
    public int BZ(){
        return -(ah.compareTo(bh));
    }
    public int Other(){
        //int flag;
        return -(ah.compareTo(bh));
    }

}
