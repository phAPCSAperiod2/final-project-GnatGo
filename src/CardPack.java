import java.util.ArrayList;
public class CardPack {
    private ArrayList<Card> cardList;
    private int cost;
    private int cardAmount;

    public CardPack(int newCost, int newAmount){
        cardList = new ArrayList<>();
        cost = newCost;
        cardAmount = newAmount;
    }

    public int getCost(){
        return cost;
    }

    public int getAmount(){
        return cardAmount;
    }

    public void addCard(Card newCard){
        cardList.add(newCard);
    }

    public Card[] openPack(){
        System.out.println("You got: ");
        Card[] returnList = new Card[cardAmount];
        for(int i = 0; i < cardList.size(); i++){
            System.out.println("You pulled " + cardList.get(i).getName() + "!");
            returnList[i] = cardList.get(i);
        }
        return returnList;
    }
}
