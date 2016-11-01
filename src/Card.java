/**
 *此游戏是简易扑克牌游戏
 * 规则，比各自手牌上最大牌
 * 锻炼数据结构和排序的运用能力
 * 可判断顺子和同花
 */

public class Card implements Comparable<Card>{
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
            return -1;//this大于o返回-1
        }else
            return 1;
    }
}



