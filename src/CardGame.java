/**
 *此游戏是简易扑克牌游戏
 * 规则，比各自手牌上最大牌
 * 锻炼数据结构和排序的运用能力
 * 可判断顺子和同花
 */

//import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
import java.util.ArrayList;
/**
 * Created by ghost on 2016/10/26.
 */
public class CardGame {
    public static int PLAYER_NUM=4;
    public static int CARD_NUM=3;//玩家手牌数
    public static int POKER_NUM=1;//1副牌
    public ArrayList<Card> cards=new ArrayList<Card>();
    //public HashMap<String,Card> hm=new HashMap<String, Card>();
    //public static int CARD_WEIGHT;
    public ArrayList<Player>pl=new ArrayList<Player>();
    public List<Card> testCars=new ArrayList<Card>();

    public static void main(String[] args){
        CardGame that=new CardGame();

        //创建扑克牌(52张，不要大小王)
        System.out.println("========游戏开始，创建扑克牌=========");

            that.CreateCards();
        System.out.println("========扑克牌创建成功！=========");
        Card c0;
       // Collections.sort(that.cards,new SortCards());
        for(int k=0;k<that.cards.size();k++){
            c0=that.cards.get(k);
            //System.out.print(c0.getFlo().name()+c0.getNum().name());
            System.out.print("["+c0.getFlower()+c0.getNumber()+"]");


        }
        System.out.print("\n");

        System.out.println("\n============开始洗牌===========");
        //洗牌
        that.WashCards(that.cards);
        System.out.println("============洗牌结束===========");


        //创建玩家
        System.out.println("=========创建玩家...===========\n");

        that.CreatePlayers();
        // CreatePlayers();
        //发牌(规则：一人一张，顺序发牌)
        that.SendCards(that.pl);

        //判断权值
        //that.CountWeight();


        //比较得出获胜玩家
       // that.GameResult(that.pl);
        Player winner=that.getWinner(that.pl);
        //ArrayList<Card> winCards=winner.getCards();
        int ww=winner.getWeight();
        System.out.println(winner.toString() + "获胜,其手牌为：");
        if(ww!=0&&ww!=5&&ww!=10&&ww!=25) {
            System.out.print("同花");

            switch (winner.getWeight()) {
                case 0:
                    System.out.print("散牌");
                    break;
                case 5:
                    System.out.print("对子");
                    break;
                case 10:
                    System.out.print("顺子");
                    break;
                case 25:
                    System.out.print("豹子");
                    break;

            }
        }else {
            switch (winner.getWeight()) {
                case 0:
                    System.out.print("散牌");
                    break;
                case 5:
                    System.out.print("对子");
                    break;
                case 10:
                    System.out.print("顺子");
                    break;
                case 25:
                    System.out.print("豹子");
                    break;
            }
        }

            System.out.println(winner.cardsToString());

        //System.out.print("\n");

        //测试
        /*

       ArrayList<Card> sz=new ArrayList<Card>();
        ArrayList<Card> _sz=new ArrayList<Card>();
        for (int i = 12; i <13 ; i++) {
            sz.add(that.testCars.get(i));
            sz.add(that.testCars.get(i));
            sz.add(that.testCars.get(i+1));
        }
        for (int i = 12; i <13 ; i++) {
            _sz.add(that.testCars.get(i));
            _sz.add(that.testCars.get(i));
            _sz.add(that.testCars.get(i+2));
        }
        Collections.sort(sz,new SortCards());
        Collections.sort(_sz,new SortCards());
        System.out.print("tp牌为：");
        for(Card c:sz){
            System.out.print(c.getFlower()+c.getNumber()+"|");
        }
        System.out.println("\n");
        System.out.print("_tp牌为:");
        for(Card c:_sz){
            System.out.print(c.getFlower()+c.getNumber()+"|");
        }
        System.out.println("\n");
       // System.out.print("是否有对子:");
        System.out.println("计算权值:");
        Player tp=new Player();
        Player _tp=new Player();
        ArrayList<Player> test=new ArrayList<Player>();
        test.add(tp);
        test.add(_tp);
        tp.setCards(sz);
        _tp.setCards(_sz);
        that.CountWeight(tp);
        that.CountWeight(_tp);
        System.out.println("tp权值：" + tp.getWeight());
        System.out.println("_tp权值：" + _tp.getWeight());
        Collections.sort(test,new SortPlayer());
        Player winner=test.get(0);
        System.out.println("winner is"+winner.getCards().get(2).getFlower()+winner.getCards().get(2).getNumber());*/

    }

    public void CreateCards() {
        for (int n = 0; n < POKER_NUM; n++) {
            FlowerEnum flower = null;

            NumberEnum num = null;

            String fc = null;


            for (int i = 0; i < 4; i++) {

                if (i == 0) {
                    fc = "方块";
                    flower = FlowerEnum.FQ;


                }
                if (i == 1) {
                    fc = "梅花";
                    flower = FlowerEnum.MH;
                }
                if (i == 2) {
                    fc = "红桃";
                    flower = FlowerEnum.RE;
                }
                if (i == 3) {
                    fc = "黑桃";
                    flower = FlowerEnum.BL;

                }
                for (int j = 0; j < 13; j++) {
                    String number = null;
                    if (j <= 8) {
                        //整数解析为字符串
                        number = String.valueOf(j + 2);
                        num = NumberEnum.N;


                        // num=Nu
                        // num=
                    } else if (j == 9) {
                        number = "J";
                        num = NumberEnum.J;

                    }
                    if (j == 10) {
                        number = "Q";
                        num = NumberEnum.Q;
                    }
                    if (j == 11) {
                        number = "K";
                        num = NumberEnum.K;

                    }
                    if (j == 12) {
                        number = "A";
                        num = NumberEnum.A;

                    }
                    Card c = new Card();
                    c.setFlower(fc);
                    c.setNumber(number);

                    c.setFlo(flower);
                    c.setNum(num);

                    cards.add(c);
                    //单元测试
                    testCars.add(c);

                }
            }
        }
    }
    public void WashCards(ArrayList<Card> cards) {

        for (int r = 0; r < 100; r++) {


            Collections.shuffle(cards);
        }
    }
    public void CreatePlayers(){
        Scanner input=new Scanner(System.in);
        back1:
        for(int n=0;n<PLAYER_NUM;n++) {
            int pId=n+1;
            Player p = new Player();
            System.out.println("请输入玩家"+pId+"ID:");
            String ID = input.next();

            try {
                int id = Integer.parseInt(ID);
                p.setID(id);
            } catch (Exception e) {
                //  throw Exception("请输入");
                //e.printStackTrace();
                System.out.println("请输入整数型ID");
                n--;
                continue back1;
            }

            System.out.println("请输入玩家"+pId+"名字:");
            String name = input.next();
            p.setName(name);
            pl.add(p);
        }

    }
    public void SendCards(ArrayList<Player> pl){
        //pl.size();

        System.out.println("=========开始拿牌==========");



        for(int n=0;n<PLAYER_NUM;n++){
            Player p=pl.get(n);
            ArrayList<Card> pc = new ArrayList<Card>();
            System.out.print("玩家"+p.getName()+"手牌为:");
            for(int k=0;k<CARD_NUM;k++) {
                Card hc=cards.get(n + k*PLAYER_NUM);
                pc.add(hc);
                // p.setCards(pc);

                System.out.print(hc.getFlower()+hc.getNumber()+"|");

                //pl.get()
            }

            pl.get(n).setCards(pc);
           // Collections.sort(sz);
            CountWeight(pl.get(n));//判断权值
            System.out.print("\n");


        }
        System.out.println("=========拿牌结束==========");

    }
    public void GameResult( ArrayList<Player> pl) {
        ArrayList<Card> Max = new ArrayList<Card>();
        for (int i = 0; i < pl.size(); i++) {
            Card max;
            Player p = pl.get(i);
            //降序排序
            Collections.sort(p.getCards(), new SortCards());
            max = p.getCards().get(0);
            Max.add(max);
            System.out.println("玩家" + p.getName() + "最大牌为:[" + Max.get(i).getFlower() + Max.get(i).getNumber() + "]");

        }
        //Card winCar;
        //winCard=CompareCards(Max.get(0),Max.get(1))?Max.get(0):Max.get(1);
        ArrayList<Card> Result = new ArrayList<Card>();
        for (int i = 0; i <Max.size() ; i++) {
            Result.add(Max.get(i));
        }
        //Result.indexOf()
        Collections.sort(Max, new SortCards());
        Card BigMax = Max.get(0);
        int index = Result.indexOf(BigMax);

        Player winner = pl.get(index);

        System.out.println("玩家" + winner.getName() + "获胜");


    }

    public void CountWeight(Player p){
        //从大到小排序

        ArrayList<Card> handCards=p.getCards();
        Collections.sort(handCards,new SortCards());
        int cardsWeight=0;
        //System.out.print("\n");
        //是否同花

       // System.out.print("是否同花:");
        if(isTH(handCards)){
            switch(handCards.get(0).getFlo()){
                case FQ:
                    cardsWeight+=11;break;
                case MH:
                    cardsWeight+=12;break;
                case RE:
                    cardsWeight+=13;break;
                case BL:
                    cardsWeight+=14;break;
            }
            //cardsWeight+=3;
           // System.out.println("是同花");
        }else {
           // System.out.println("非同花");
        }
        //是否顺子

       //System.out.print("是否是顺子:");
        if(isSZ(handCards)){
            cardsWeight+=10;
           // System.out.println("是顺子");
        }else {
           // System.out.println("非顺子");
            //是否有对子
           // System.out.print("是否有对子:");
            int Weight=isRP(handCards);
            switch(Weight){
                case 0://散牌
                    break;
                case 1://对子
                    cardsWeight+=5;
                    break;
                case 6://豹子
                    cardsWeight+=25;
                    break;
        }

        }
        p.setWeight(cardsWeight);


    }
    public Player getWinner( ArrayList<Player> pl){
        for (int i = 0; i <pl.size() ; i++) {
            CountWeight(pl.get(i));//计算权值
        }
        Collections.sort(pl,new SortPlayer());
        return pl.get(0);

    }
    public boolean isTH(ArrayList<Card> cards){
        boolean flag=true;
        Card c0=cards.get(0);
        for (int i = 0; i <cards.size(); i++) {
            if(!c0.getFlower().equals(cards.get(i).getFlower())){
                flag=false;
            }
        }
        return flag;

    }
    public boolean isSZ(ArrayList<Card> cards){
        boolean flag=true;
        Card h=cards.get(0);
        Card f=cards.get(cards.size()-1);
        //System.out.println("卡牌数"+cards.size());
        if(h.getNum()==NumberEnum.N){
            //全部为数字
           // System.out.println("全部为数字");
            for (int i = 0; i < cards.size(); i++) {
                int ci=Integer.parseInt(cards.get(0).getNumber());
                int ci_1=Integer.parseInt(cards.get(i).getNumber());
                if(ci-ci_1!=i){
                   // System.out.println("比较值" +(ci-ci_1));
                    flag=false;
                }
            }
        }else if(f.getNum()!=NumberEnum.N){
            //全部为花牌
            //System.out.println("全部为花牌");
            for (int i = 0; i < cards.size(); i++) {
                NumberEnum c0=cards.get(0).getNum();
                NumberEnum ci=cards.get(i).getNum();
                if(c0.compareTo(ci)!=i){
                    //System.out.println("全部为花牌");
                   // System.out.println("比较值" + c0.compareTo(ci));
                    flag=false;
                }


            }

        }else {
            //数花都有
           // System.out.println("花数都有");
            ArrayList<Card> nCards=new ArrayList<Card>();
            ArrayList<Card> fCards=new ArrayList<Card>();
            for (int i = 0; i <cards.size() ; i++) {
                if(cards.get(i).getNum()!=NumberEnum.N){
                    //花牌
                    fCards.add(cards.get(i));
                }else{
                    //数牌
                    nCards.add(cards.get(i));
                }
            }
            for (int i = 0; i < fCards.size(); i++) {

                if(((fCards.get(0).getNum().compareTo(fCards.get(i).getNum())))!=i||
                        fCards.get(fCards.size()-1).getNum()!=NumberEnum.J){
                    flag=false;
                }
            }
            for (int i = 0; i < nCards.size(); i++) {
                int c0=Integer.parseInt(nCards.get(0).getNumber());
                int ci=Integer.parseInt(nCards.get(i).getNumber());
                //int fNumber=Integer.parseInt(nCards.get(nCards.size()-1).getNumber());
                if(c0-ci!=i||c0!=10){
                    flag=false;
                }
            }

        }
        return flag;
    }
   public int isRP(ArrayList<Card> cards){
        //按三张牌计算
        //boolean flag=true;
        //int flag=0;
        int Weight=0;
        Card h=cards.get(0);
        Card m=cards.get(1);
        Card f=cards.get(cards.size()-1);
        if(f.getNum()!=NumberEnum.N){
            //全为花牌

                if(h.getNum()!=m.getNum()&&h.getNum()!=f.getNum()&&
                        m.getNum()!=f.getNum()){
                    //散牌
                    Weight=0;
                }else  if(h.getNum()==m.getNum()&&h.getNum()==f.getNum()&&
                        m.getNum()==f.getNum()){
                    //豹子
                    Weight=6;
                }else {
                    //对子
                    Weight=1;
            }
        }else if(h.getNum()==NumberEnum.N){
            //全为数字
            int hn=Integer.parseInt(h.getNumber());
            int mn=Integer.parseInt(m.getNumber());
            int fn=Integer.parseInt(f.getNumber());
            if(hn!=mn&&hn!=fn&&
                    mn!=fn){
                //散牌
                Weight=0;
            }else  if(hn==mn&&hn==fn&&
                    mn==fn){
                //豹子
                Weight=6;
            }else {
                //对子
                Weight=1;
            }

        }else {
            //花数都有,显然不可能是豹子
            if(m.getNum()==NumberEnum.N){
                //两数一花
                int fn=Integer.parseInt(f.getNumber());
                int mn=Integer.parseInt(m.getNumber());
                if(fn==mn){
                    //对子
                    Weight=1;
                }else {
                    Weight=0;
                }
            }else {
                //两花一数
                if(h.getNum()==m.getNum()){
                    //对子
                    Weight=1;
                }else {
                    Weight=0;
                }
            }
        }
       return Weight;

    }



    public boolean CompareCards(Card a,Card b){
        boolean flag=false;//a>b?
        //三目比较
        int numKey;
        int floKey;
        numKey=a.getNum().compareTo(b.getNum());
        floKey=a.getFlo().compareTo(b.getFlo());
        if(numKey>0){
            numKey=1;
        }else if(numKey<0){
            numKey=-1;
        }else numKey=0;
        if(floKey>0){
            floKey=1;
        }else if(floKey<0){
            floKey=-1;
        }else floKey=0;
        switch (numKey) {
            case -1://a的数字枚举在b之前
                flag=false;break;
            case 1:
                flag=true;break;
            case 0: //a的数字枚举为N或其它与b相等
                switch (a.getNum()){
                    case N://为N
                        int na=Integer.parseInt(a.getNumber());
                        int nb=Integer.parseInt(b.getNumber());
                        if(na>nb){
                            flag=true;break;
                        }
                        if(na<nb){
                            flag=false;break;

                        }
                        if(na==nb){
                            switch (floKey){
                                case -1://a的花色枚举在b之前
                                    flag=false;break;
                                case 1:
                                    flag=true;break;

                            }
                        }
                    default:
                        switch (floKey){
                            case -1://a的花色枚举在b之前
                                flag=false;break;
                            case 1:
                                flag=true;break;
                            // default:
                        }

                }

        }

        return flag;

    }
    public int NumCompare(Card a,Card b){
        NumberEnum an=a.getNum();
        NumberEnum bn=b.getNum();
        int result=0;
        if(an.compareTo(bn)>0){
            //an>bn
            return result=1;
        }else if(an.compareTo(bn)<0){
            //an<bn
            return result=-1;
        }else {
            //枚举相等
            if(an==NumberEnum.N){
                int anum=Integer.parseInt(a.getNumber());
                int bnum=Integer.parseInt(b.getNumber());
                if(anum>bnum){
                    //a>b
                    return result=1;
                }else if(anum<bnum){
                    //a<b
                    return result=-1;
                }else {
                    //a=b
                    return result=0;
                }
            }else {
                //a=b
                return result=0;
            }
        }
    }
    public int FloCompare(Card a,Card b){
        FlowerEnum af=a.getFlo();
        FlowerEnum bf=b.getFlo();
        int result=0;
        if(af.compareTo(bf)>0){
            return result=1;
        }else if(af.compareTo(bf)<0){
            return result=-1;
        }else {
            return result=0;
        }
    }



}
enum FlowerEnum{

    FQ,
    MH,
    RE,
    BL



}
enum NumberEnum{
    N,J,Q,K,A

}
/*
class Card implements Comparable<Card>{
    public String getFlower() {
        return flower;

    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    private String flower;


    public FlowerEnum getFlo() {
        return flo;
    }

    public void setFlo(FlowerEnum flo) {
        this.flo = flo;
    }

    private FlowerEnum flo;

    public NumberEnum getNum() {
        return num;
    }

    public void setNum(NumberEnum num) {
        this.num = num;
    }

    private NumberEnum num;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;

    @Override
    public int compareTo(Card o) {
        CardGame cg=new CardGame();

        if(cg.CompareCards(this, o)){
            return -1;
        }else
            return 1;
    }
}
class Player implements Comparable<Player> {
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private int weight;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    private ArrayList<Card> cards;

    @Override
    public int compareTo(Player o) {
        if (this.getWeight() > o.getWeight()) {
            return -1;
        } else if (this.getWeight() < o.getWeight()) {
                return 1;
            } else {
                CardGame cg = new CardGame();
                //权值相同
                ArrayList this_cards = this.getCards();
                ArrayList o_cards = o.getCards();
                Card th = (Card) this_cards.get(0);
                Card tm = (Card) this_cards.get(1);
                Card tf = (Card) this_cards.get(2);

                Card oh = (Card) o_cards.get(0);
                Card om = (Card) o_cards.get(1);
                Card of = (Card) o_cards.get(2);
                switch (this.getWeight()) {
                    case 0://散牌
                        switch (cg.NumCompare(th, oh)) {
                            case -1://小于
                                return 1;
                           // break;
                            case 1://大于
                                return -1;
                            //break;
                            case 0://第一张num相等
                                switch (cg.NumCompare(tm, om)) {
                                    case -1://小于
                                        return 1;
                                    //break;
                                    case 1://大于
                                        return -1;
                                  //  break;
                                    case 0://第二张num相等
                                        switch (cg.NumCompare(tm, om)) {
                                            case -1://小于
                                                return 1;
                                           // break;
                                            case 1://大于
                                                return -1;
                                          //  break;
                                            case 0:
                                                //平局
                                                return 0;
                                           // break;
                                        }
                                }

                        }

                    default://都为顺子，对子，或同花如何比较
                        return 0;
                  //  break;

                }

            }
        }

    }
*/


class SortCards implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        //CardGame cg=new CardGame();
        Card c1=(Card)o1;
        Card c2=(Card)o2;
        return c1.compareTo(c2);
    }
}
class SortPlayer implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Player p1=(Player)o1;
        Player p2=(Player)o2;
        return p1.compareTo(p2);
    }
}
