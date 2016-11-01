

import java.util.ArrayList;

public class Player implements Comparable<Player> {
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
            CardsJuger cj = new CardsJuger(this.getCards(), o.getCards());
            switch (this.getWeight()) {

                case 0:
                    return -cj.SP();
                //break;
                case 5:
                    return -cj.DZ();
                //break;
                case 10:
                    return -cj.SZ();
                //break;
                case 25:
                    return -cj.BZ();
                //break;
                default://同花散，顺,只比较第一张
                    return -cj.Other();
                //break;

                //  break;

            }
        }



       // return 0;
        }

    }



